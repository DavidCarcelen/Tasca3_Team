package FlowerStore.Tickets;

public class InvoiceLine {
    private int idInvoiceLine;
    private int idInvoiceHeader;
    private int idProductInvoiceLine;
    private int productQuantity;
    private float priceInvoiceLine;

    public InvoiceLine( int idInvoiceHeader, int idProductInvoiceLine, int productQuantity, float priceInvoiceLine) {
        this.idInvoiceHeader = idInvoiceHeader;
        this.idProductInvoiceLine = idProductInvoiceLine;
        this.priceInvoiceLine = priceInvoiceLine;
        this.productQuantity = productQuantity;
    }

    public int getIdInvoiceLine() {
        return idInvoiceLine;
    }

    public void setIdInvoiceLine(int idInvoiceLine) {
        this.idInvoiceLine = idInvoiceLine;
    }

    public int getIdInvoiceHeader() {
        return idInvoiceHeader;
    }

    public void setIdInvoiceHeader(int idInvoiceHeader) {
        this.idInvoiceHeader = idInvoiceHeader;
    }

    public int getIdProductInvoiceLine() {
        return idProductInvoiceLine;
    }

    public void setIdProductInvoiceLine(int idProductInvoiceLine) {
        this.idProductInvoiceLine = idProductInvoiceLine;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public float getPriceInvoiceLine() {
        return priceInvoiceLine;
    }

    public void setPriceInvoiceLine(float priceInvoiceLine) {
        this.priceInvoiceLine = priceInvoiceLine;
    }


    @Override
    public String toString() {
        return "InvoiceLine{" +
                "idInvoiceLine=" + idInvoiceLine +
                ", idInvoiceHeader=" + idInvoiceHeader +
                ", idProductInvoiceLine=" + idProductInvoiceLine +
                ", productQuantity=" + productQuantity +
                ", priceInvoiceLine=" + priceInvoiceLine +
                '}';
    }
}

