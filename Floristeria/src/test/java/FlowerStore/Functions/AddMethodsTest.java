package FlowerStore.Functions;

import FlowerStore.Items.Arbol;
import FlowerStore.Items.Decoracion;
import FlowerStore.Items.Flor;
import FlowerStore.Items.Producto;
import org.junit.Test;
import org.junit.jupiter.api.*;

public class AddMethodsTest {
    @Test
    @DisplayName("Creando objeto flor")
    public void testAddFlowerToDatabase(){
        Flor flor = new Flor("Rosa", 1, 10,2 );
        Assertions.assertEquals("Rosa", flor.getName());
        Assertions.assertEquals(1, flor.getPrice());
        Assertions.assertEquals(10, flor.getQuantity());
        Assertions.assertEquals(2, flor.getColor());
    }
    @Test
    @DisplayName("Creando objeto arbol")
    public void testAddTreeToDatabase(){
        Arbol arbol = new Arbol("Pino",3.4,58,4.8);
        Assertions.assertEquals("Pino", arbol.getName());
        Assertions.assertEquals(3.4, arbol.getPrice());
        Assertions.assertEquals(58, arbol.getQuantity());
        Assertions.assertEquals(4.8, arbol.getHeight());
    }
    @Test
    @DisplayName("Creando objeto decoracion")
    public void testAddDecorationToDatabase(){
        Decoracion decoracion = new Decoracion("Halloween",4.99,8,2);
        Assertions.assertEquals("Halloween", decoracion.getName());
        Assertions.assertEquals(4.99, decoracion.getPrice());
        Assertions.assertEquals(8, decoracion.getQuantity());
        Assertions.assertEquals(2, decoracion.getMaterialType());
    }
}
