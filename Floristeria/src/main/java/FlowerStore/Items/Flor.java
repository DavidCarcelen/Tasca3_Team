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
        return "Flor{\n" +
                "  color='" + color + '\'' + ",\n" +
                "  name='" + name + '\'' + ",\n" +
                "  price=" + price + ",\n" +
                "  quantity=" + quantity + "\n" +
                '}';
    }
}

//que te acuestes
