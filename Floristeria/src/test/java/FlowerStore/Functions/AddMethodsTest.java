package FlowerStore.Functions;

import FlowerStore.Items.Tree;
import FlowerStore.Items.Decoration;
import FlowerStore.Items.Flower;
import org.junit.Test;
import org.junit.jupiter.api.*;

public class AddMethodsTest {
    @Test
    @DisplayName("Creando objeto flor")
    public void testAddFlowerToDatabase(){
        Flower flower = new Flower("Rosa", 1, 10,2 );
        Assertions.assertEquals("Rosa", flower.getName());
        Assertions.assertEquals(1, flower.getPrice());
        Assertions.assertEquals(10, flower.getQuantity());
        Assertions.assertEquals(2, flower.getColor());
    }
    @Test
    @DisplayName("Creando objeto arbol")
    public void testAddTreeToDatabase(){
        Tree tree = new Tree("Pino",3.4,58,4.8);
        Assertions.assertEquals("Pino", tree.getName());
        Assertions.assertEquals(3.4, tree.getPrice());
        Assertions.assertEquals(58, tree.getQuantity());
        Assertions.assertEquals(4.8, tree.getHeight());
    }
    @Test
    @DisplayName("Creando objeto decoracion")
    public void testAddDecorationToDatabase(){
        Decoration decoration = new Decoration("Halloween",4.99,8,2);
        Assertions.assertEquals("Halloween", decoration.getName());
        Assertions.assertEquals(4.99, decoration.getPrice());
        Assertions.assertEquals(8, decoration.getQuantity());
        Assertions.assertEquals(2, decoration.getMaterialType());
    }
}
