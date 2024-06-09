package FlowerStore.Tickets;

import Connections.FlowerShopDDBB;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static FlowerStore.Functions.AuxiliarMethods.numCheck;
import static FlowerStore.Functions.RemoveMethods.updateQuantityStock;
import static FlowerStore.Functions.ShowMethods.*;

public class TicketMethods {
    public static void createTicket(Ticket ticket) throws SQLException {
        try (Connection connection = FlowerShopDDBB.getConnection()){
            String insertInvoiceHeaderQuery = "INSERT INTO invoiceheader (idShopInvoice, dateInvoice) VALUES (?, ?)";
            PreparedStatement insertInvoiceHeaderStmt = connection.prepareStatement(insertInvoiceHeaderQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            insertInvoiceHeaderStmt.setInt(1, ticket.getHeader().getIdShopInvoice());
            insertInvoiceHeaderStmt.setString(2, ticket.getHeader().getDateInvoice());
            insertInvoiceHeaderStmt.executeUpdate();

            int idInvoice;//esto no se lo q es
            try (ResultSet generatedKeys = insertInvoiceHeaderStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idInvoice = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID generado para el encabezado de la factura.");
                }
            }

            // Insertar las líneas de la factura
            String insertInvoiceLineQuery = "INSERT INTO invoiceline (idInvoiceHeader, idProductInvoiceLine, productQuantity, priceInvoiceLine) VALUES (?, ?, ?, ?)";
            PreparedStatement insertInvoiceLineStmt = connection.prepareStatement(insertInvoiceLineQuery);
            for (InvoiceLine line : ticket.getLines()) {
                insertInvoiceLineStmt.setInt(1, idInvoice);
                insertInvoiceLineStmt.setInt(2, line.getIdProductInvoiceLine());
                insertInvoiceLineStmt.setInt(3, line.getProductQuantity());
                insertInvoiceLineStmt.setDouble(4, line.getPriceInvoiceLine());
                insertInvoiceLineStmt.executeUpdate();
            }

            System.out.println("Ticket creado exitosamente.");
        }
    }
    public static void createNewTicket() {//quitar conexion
        try (Connection connection = FlowerShopDDBB.getConnection()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el ID de la tienda de la factura: ");
            int idShopInvoice = numCheck();
            System.out.print("Introduce la fecha (YYYY-MM-DD): ");
            String dateInvoice = scanner.next();
            //como obtener id de la factura? para usarlo en line
            InvoiceHeader header = new InvoiceHeader(idShopInvoice, dateInvoice);

            List<InvoiceLine> lines = new ArrayList<>();
            boolean moreLines = true;

            int idHeader = 0; //deberá de usar idheader que hemos de obtener de una consulta

            while (moreLines) {

                System.out.print("Introduce el ID del producto (1 - Arbol, 2 - Flor, o 3 - Decoracion) (o 0 para salir): ");
                int numProduct = numCheck();
                if (numProduct == 0) {
                    moreLines = false;
                }

                if (moreLines) {
                    switch (numProduct) {
                        case 1:
                            showTree();
                            lines.add(generateLine(idHeader, 1));
                            break;
                        case 2:
                            showFlower();
                            lines.add(generateLine(idHeader, 2));
                            break;
                        case 3:
                            showDecoration();
                            lines.add(generateLine(idHeader, 3));
                            break;
                        default:
                            System.out.println("ID de producto no válido.");
                            break;
                    }
                }
            }
            Ticket ticket = new Ticket(header, lines);
            try {
                createTicket(ticket);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
            try {
                ticket.saveToJsonFile("ticket.json");
                System.out.println("Ticket JSON creado.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static InvoiceLine generateLine(int idHeader, int idCategory){
        System.out.print("Introduce el id del producto: ");
        int idProduct = numCheck();
        float precio = getPrecioProduct(idCategory, idProduct);
        System.out.print("Introduce cantidad: ");
        int productQuantity = numCheck();
        updateQuantityStock(idProduct, idCategory, productQuantity);
        float totalPrice = precio * productQuantity;
        InvoiceLine line = new InvoiceLine(idHeader, idProduct, productQuantity, totalPrice);
        return line;
    }

    public static void showAllTickets(){
        String queryShowTickets = "SELECT * FROM invoiceHeader;";

        try(Connection connection = FlowerShopDDBB.getConnection()) {
            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryShowTickets);
            float totalPrice = 0;

            while (resultSet.next()) {
                 int idInvoice = resultSet.getInt("idInvoice");
                 int idShopInvoice = resultSet.getInt("idShopInvoice");
                 String dateInvoice = String.valueOf(resultSet.getDate("dateInvoice"));
                 System.out.println("Id del ticket: " + idInvoice + " Id de la tienda: " + idShopInvoice + " Fecha: "+ dateInvoice);
                 String queryShowLines = "SELECT * FROM invoiceLine WHERE idInvoiceHeader = " + idInvoice + ";";
                 ResultSet resultSet1 = statement1.executeQuery(queryShowLines);
                 float totalPriceTicket = 0;
                 while (resultSet1.next()){
                    int idInvoiceLine = resultSet1.getInt("idInvoiceLine");
                    int idInvoiceHeader = resultSet1.getInt("idInvoiceHeader");
                    int idProductInvoiceLine = resultSet1.getInt("idProductInvoiceLine");
                    int productQuantity = resultSet1.getInt("productQuantity");
                    float priceInvoiceLine = resultSet1.getFloat("priceInvoiceLine");
                    System.out.println("     Id Ticket: " + idInvoiceHeader + ", Id Linea: " + idInvoiceLine + ", Id Producto: " + idProductInvoiceLine + ", Cantidad: " + productQuantity + ", Precio Total: " + priceInvoiceLine);
                    totalPriceTicket += priceInvoiceLine;
                    totalPrice += priceInvoiceLine;
                }
                System.out.println("     Total ticket: " + totalPriceTicket + "€");
            }
            System.out.println("Total ventas: " + totalPrice + "€");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
