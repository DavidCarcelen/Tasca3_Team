package FlowerStore.Tickets;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ticket Header:\n");
        sb.append("ID Shop Invoice: ").append(header.getIdShopInvoice()).append("\n");
        sb.append("Date Invoice: ").append(header.getDateInvoice()).append("\n");

        sb.append("Invoice Lines:\n");
        for (InvoiceLine line : lines) {
            sb.append("ID Invoice Line: ").append(line.getIdInvoiceLine()).append("\n");
            sb.append("ID Product Invoice Line: ").append(line.getIdProductInvoiceLine()).append("\n");
            sb.append("Product Quantity: ").append(line.getProductQuantity()).append("\n");
            sb.append("Price Invoice Line: ").append(line.getPriceInvoiceLine()).append("\n");
            sb.append("--------------------\n");
        }

        return sb.toString();
    }
    public String toJson() {
        JSONObject json = new JSONObject();
        JSONObject headerJson = new JSONObject();
        headerJson.put("idShopInvoice", header.getIdShopInvoice());
        headerJson.put("dateInvoice", header.getDateInvoice());

        json.put("header", headerJson);

        JSONArray linesJson = new JSONArray();
        for (InvoiceLine line : lines) {
            JSONObject lineJson = new JSONObject();
            lineJson.put("idInvoiceLine", line.getIdInvoiceLine());
            lineJson.put("idInvoiceHeader", line.getIdInvoiceHeader());
            lineJson.put("idProductInvoiceLine", line.getIdProductInvoiceLine());
            lineJson.put("productQuantity", line.getProductQuantity());
            lineJson.put("priceInvoiceLine", line.getPriceInvoiceLine());
            linesJson.put(lineJson);
        }

        json.put("lines", linesJson);

        return json.toString();
    }
    public void saveToJsonFile(String filePath) throws IOException {
        String json = this.toJson();
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(json);
        }
    }

}