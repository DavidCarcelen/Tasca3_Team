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