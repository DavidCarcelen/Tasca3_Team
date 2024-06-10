package FlowerStore.Tickets;

import Connections.FlowerShopDDBB;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static FlowerStore.Functions.AuxiliarMethods.numCheck;
import static FlowerStore.Functions.RemoveMethods.updateQuantityStock;
import static FlowerStore.Functions.ShowMethods.*;

public class TicketMethods {
    private static FlowerShopDDBB flowerShopDDBB = FlowerShopDDBB.getInstance();
    public static void createTicket(Ticket ticket) throws SQLException {
        try (Connection connection = flowerShopDDBB.getConnection2()) {
            String insertInvoiceHeaderQuery = "INSERT INTO invoiceheader (idShopInvoice, dateInvoice) VALUES (?, ?)";
            PreparedStatement insertInvoiceHeaderStmt = connection.prepareStatement(insertInvoiceHeaderQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            insertInvoiceHeaderStmt.setInt(1, ticket.getHeader().getIdShopInvoice());
            insertInvoiceHeaderStmt.setString(2, ticket.getHeader().getDateInvoice());
            insertInvoiceHeaderStmt.executeUpdate();

            int idInvoice;
            try (ResultSet generatedKeys = insertInvoiceHeaderStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idInvoice = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID generado para el encabezado de la factura.");
                }
            }

            String insertInvoiceLineQuery = "INSERT INTO invoiceline (idInvoiceHeader, idProductInvoiceLine, productQuantity, priceInvoiceLine) VALUES (?, ?, ?, ?)";
            PreparedStatement insertInvoiceLineStmt = connection.prepareStatement(insertInvoiceLineQuery);
            for (InvoiceLine line : ticket.getLines()) {
                insertInvoiceLineStmt.setInt(1, idInvoice);
                insertInvoiceLineStmt.setInt(2, line.getIdProductInvoiceLine());
                insertInvoiceLineStmt.setInt(3, line.getProductQuantity());
                insertInvoiceLineStmt.setDouble(4, line.getPriceInvoiceLine());
                insertInvoiceLineStmt.executeUpdate();
            }

            System.out.println("TICKET CREADO EXITOSAMENTE.");
        }
    }

    public static void createNewTicket() {

        LocalDate currentDate = LocalDate.now();
        String dateInvoice = currentDate.toString();

        InvoiceHeader header = new InvoiceHeader(1, dateInvoice);

        List<InvoiceLine> lines = new ArrayList<>();
        boolean moreLines = true;
        int idHeader = 0;

        while (moreLines) {

            System.out.print("ELIJE TIPO DE PRODUCTO:\n" + " 1 Arbol, 2 Flor, 3 Decoracion o 0 para salir: ");
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
                        System.err.println("OPCIÓN NO VÁLIDA");
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
        int numTicket = showLastTicket();

        try {
            ticket.saveToJsonFile("ticket." + numTicket + ".json");
            System.out.println("TICKER JSON CREADO");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static InvoiceLine generateLine(int idHeader, int idCategory) {
        System.out.print("INTRODUCE EL ID DEL PRODUCTO: ");
        int idProduct = numCheck();
        float precio = getPrecioProduct(idCategory, idProduct);
        System.out.print("INTRODUCE CANTIDAD: ");
        int productQuantity = numCheck();
        updateQuantityStock(idProduct, idCategory, productQuantity);
        float totalPrice = precio * productQuantity;
        InvoiceLine line = new InvoiceLine(idHeader, idProduct, productQuantity, totalPrice);
        return line;
    }

    public static void showAllTickets() {
        String queryShowTickets = "SELECT * FROM invoiceHeader;";

        try (Connection connection = flowerShopDDBB.getConnection2()) {
            Statement statement = connection.createStatement();
            Statement statement1 = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryShowTickets);
            float totalPrice = 0;

            while (resultSet.next()) {
                int idInvoice = resultSet.getInt("idInvoice");
                int idShopInvoice = resultSet.getInt("idShopInvoice");
                String dateInvoice = String.valueOf(resultSet.getDate("dateInvoice"));
                System.out.println("Id del ticket: " + idInvoice + " Id de la tienda: " + idShopInvoice + " Fecha: " + dateInvoice);
                String queryShowLines = "SELECT * FROM invoiceLine WHERE idInvoiceHeader = " + idInvoice + ";";
                ResultSet resultSet1 = statement1.executeQuery(queryShowLines);
                float totalPriceTicket = 0;
                while (resultSet1.next()) {
                    int idInvoiceLine = resultSet1.getInt("idInvoiceLine");
                    int idInvoiceHeader = resultSet1.getInt("idInvoiceHeader");
                    int idProductInvoiceLine = resultSet1.getInt("idProductInvoiceLine");
                    int productQuantity = resultSet1.getInt("productQuantity");
                    float priceInvoiceLine = resultSet1.getFloat("priceInvoiceLine");
                    System.out.println("     Id Ticket: " + idInvoiceHeader + ", Id Linea: " + idInvoiceLine + ", Id Producto: " + idProductInvoiceLine + ", Cantidad: " + productQuantity + ", Precio Total: " + priceInvoiceLine);
                    totalPriceTicket += priceInvoiceLine;
                    totalPrice += priceInvoiceLine;
                }
                System.out.println("     TOTAL TICKET: " + totalPriceTicket + "€");
            }
            System.out.println(STR."\{String.format("TOTAL VENTAS: %.2f ", totalPrice)}€");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static int showLastTicket() {
        String queryGetLastTicketId = "Select idInvoice from InvoiceHeader order by idInvoice desc limit 1;";
        int idTicket = 0;
        try (Connection connection = flowerShopDDBB.getConnection2()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryGetLastTicketId);
            if (resultSet.next()) {
                idTicket = resultSet.getInt("idInvoice");
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return idTicket;
    }

}
