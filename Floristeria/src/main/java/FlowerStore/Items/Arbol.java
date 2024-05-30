package FlowerStore.Items;

public class Arbol extends Producto {
    private double height;

    public Arbol(String name, double price, double height) {

        super(name, price);
        this.height = height;
    }
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return "Name :" + name + ", price " + price + " , height " + this.height;
    }
}
