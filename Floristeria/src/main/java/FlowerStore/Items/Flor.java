package FlowerStore.Items;

public class Flor extends Producto {

    private int color;
    public Flor(String name, double price, int quantity, int color) {
        super(name, price, quantity);
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Flor{" +
                "color=" + color +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}

//que te acuestes
