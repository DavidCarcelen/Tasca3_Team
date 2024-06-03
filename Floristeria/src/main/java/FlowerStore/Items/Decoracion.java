package FlowerStore.Items;

public class Decoracion extends Producto {

    private String materialType;
    public Decoracion(String name, double price,int quantity, String materialType) {

        super(name, price,quantity);
        this.materialType = materialType;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return "Name :" + name + ", price " + price + " , height " + this.materialType;
    }
}
