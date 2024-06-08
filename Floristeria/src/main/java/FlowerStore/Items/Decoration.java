package FlowerStore.Items;

public class Decoration extends Product {

    private int materialType;
    public Decoration(String name, double price, int quantity, int materialType) {

        super(name, price,quantity);
        this.materialType = materialType;
    }

    public int getMaterialType() {
        return materialType;
    }

    public void setMaterialType(int materialType) {
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return "Name :" + name + ", price " + price + " , height " + this.materialType;
    }
}
