package FlowerStore.Tickets;

public class InvoiceHeader {
    private int idShopInvoice;
    private String dateInvoice;

    public InvoiceHeader(int idShopInvoice, String dateInvoice) {
        this.idShopInvoice = idShopInvoice;
        this.dateInvoice = dateInvoice;
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
                ", idShopInvoice=" + idShopInvoice +
                ", dateInvoice='" + dateInvoice + '\'' +
                '}';
    }
}

