package FlowerStore.Items;

public class Flor extends Producto {

    private String color;
    public Flor(String name, double price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Name :" + name + ", price " + price + " , height " + this.color;
    }
}

//que te acuestes
