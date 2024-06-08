package FlowerStore.Tickets;

public class InvoiceHeader {
    private int idInvoice;
    private int idShopInvoice;
    private String dateInvoice;

    public InvoiceHeader(int idInvoice, int idShopInvoice, String dateInvoice) {
        this.idInvoice = idInvoice;
        this.idShopInvoice = idShopInvoice;
        this.dateInvoice = dateInvoice;
    }

    public InvoiceHeader(int idShopInvoice, String dateInvoice) {
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public int getIdShopInvoice() {
        return idShopInvoice;
    }

    public void setIdShopInvoice(int idShopInvoice) {
        this.idShopInvoice = idShopInvoice;
    }

    public String getDateInvoice() {
        return dateInvoice;
    }

    public void setDateInvoice(String dateInvoice) {
        this.dateInvoice = dateInvoice;
    }

    @Override
    public String toString() {
        return "InvoiceHeader{" +
                "idInvoice=" + idInvoice +
                ", idShopInvoice=" + idShopInvoice +
                ", dateInvoice='" + dateInvoice + '\'' +
                '}';
    }
}

