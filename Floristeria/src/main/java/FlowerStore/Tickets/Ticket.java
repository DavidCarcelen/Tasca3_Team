<<<<<<< HEAD
package FlowerStore.Tickets;

import Connections.FlowerShopDDBB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ticket {
    private InvoiceHeader header;
    private List<InvoiceLine> lines;

    public Ticket(InvoiceHeader header, List<InvoiceLine> lines) {
        this.header = header;
        this.lines = lines;
    }

    public InvoiceHeader getHeader() {
        return header;
    }

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void setHeader(InvoiceHeader header) {
        this.header = header;
    }

    public void setLines(List<InvoiceLine> lines) {
        this.lines = lines;
    }

    public static void createTicket(Ticket ticket) throws SQLException {
        try (Connection connection = FlowerShopDDBB.getConnection(){
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
    public static void createNewTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el ID de la tienda de la factura: ");
        int idShopInvoice = scanner.nextInt();
        System.out.print("Introduce la fecha (YYYY-MM-DD): ");
        String dateInvoice = scanner.next();
        InvoiceHeader header = new InvoiceHeader(idShopInvoice, dateInvoice);

        List<InvoiceLine> lines = new ArrayList<>();
        boolean moreLines = true;
        while (moreLines) {
            System.out.print("Introduce el ID del producto (Flower, Tree, o Decoracion) (o -1 para terminar): ");
            int idProduct = scanner.nextInt();
            if (idProduct == -1) {
                moreLines = false;
                break;
            }

            double price = 0.0;

            if (idProduct == 1) {
                System.out.print("Introduce la cantidad de flores: ");
            } else if (idProduct == 2) {
                System.out.print("Introduce la cantidad de árboles: ");
            } else if (idProduct == 3) {
                System.out.print("Introduce la cantidad de elementos de decoración: ");
            } else {
                System.out.println("ID de producto no válido.");
                continue;
            }

            int productQuantity = scanner.nextInt();
            double totalPrice = price * productQuantity;
            InvoiceLine line = new InvoiceLine(idProduct, productQuantity, totalPrice);
            lines.add(line);

            Ticket ticket = new Ticket(header,lines);
            try {
                ticket.createTicket(ticket);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }

    }
}
=======
package FlowerStore.Tickets;

import java.util.List;

public class Ticket {
    private InvoiceHeader header;
    private List<InvoiceLine> lines;

    public Ticket(InvoiceHeader header, List<InvoiceLine> lines) {
        this.header = header;
        this.lines = lines;
    }

    public InvoiceHeader getHeader() {
        return header;
    }

    public List<InvoiceLine> getLines() {
        return lines;
    }

    public void setHeader(InvoiceHeader header) {
        this.header = header;
    }

    public void setLines(List<InvoiceLine> lines) {
        this.lines = lines;
    }

}
>>>>>>> 6e0fad50ad831040e40d0c99d65a6699e93e09d1
