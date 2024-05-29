public class Decoracion extends Producto{

    public Decoracion(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Decoracion{" +
                "name='" + name + '\'' +
                '}';
    }
}
