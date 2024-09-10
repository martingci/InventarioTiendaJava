import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventarioTest {

    private Object[][] productos;

    @BeforeEach
    public void setUp() {
        productos = new Object[10][3];
    }

    @Test
    public void testAnadirAlInventario() {
        Inventario.addInventoryManager(productos, 1, "Producto1", 10);
        assertEquals(1, productos[0][0]);
        assertEquals("Producto1", productos[0][1]);
        assertEquals(10, productos[0][2]);
        Inventario.addInventoryManager(productos, 1, "Producto1", -20);
        assertEquals(1, productos[0][0]);
        assertEquals("Producto1", productos[0][1]);
        assertEquals(10, productos[0][2]);        
        Inventario.addInventoryManager(productos, 1, "Producto2", 10);
        assertEquals(1, productos[0][0]);
        assertEquals("Producto1", productos[0][1]);
        assertEquals(20, productos[0][2]);   
    }

    @Test
    public void testSubtractInventoryDatos_ProductoExistente() {
        Inventario.addToInventory(productos, 1, "Producto1", 10, 0);
        Inventario.subtractInventoryDatos(productos, 1, 5);
        assertEquals(1, productos[0][0]);
        assertEquals("Producto1", productos[0][1]);
        assertEquals(5, productos[0][2]);
    }

    @Test
    public void testSubtractInventoryDatos_CantidadSolicitadaMayorALaExistente() {
        Inventario.addToInventory(productos, 1, "Producto1", 10, 0);
        Inventario.subtractInventoryDatos(productos, 1, 15);
        assertEquals(1, productos[0][0]);
        assertEquals("Producto1", productos[0][1]);
        assertEquals(10, productos[0][2]);
    }

    @Test
    public void testSearchProduct_ProductoExistente() {
        Inventario.addToInventory(productos, 1, "Producto1", 10, 0);
        String result = Inventario.searchProduct(productos, 1);
        assertEquals("ID: 1 Nombre: Producto1 Cantidad: 10", result);
    }

    @Test
    public void testSearchProduct_ProductoNoExistente() {
        String result = Inventario.searchProduct(productos, 1);
        assertEquals("El producto no existe", result);
    }
}
































































