package FlowerStore.Items;

public class Tree extends Product {
    private double height;

    public Tree(String name, double price, int quantity, double height) {

        super(name, price, quantity);
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
