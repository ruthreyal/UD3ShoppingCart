package es.iessoterohernandes.es.TestShoppingCart;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class CarroTest 
{
	
private static ShoppingCart carro;
private static Product item;  

	@BeforeEach
	public void init() {	
	item = new Product("Pan",2.5);	
	carro = new ShoppingCart();
	}
	
	//Cuando se crea, el carro tiene 0 elementos.
	@Test
	public void creaCarroVacio() {
	ShoppingCart carro1 = new ShoppingCart();
		assertEquals (0, carro1.getItemCount());
	}
	
	
	//Cuando está vacío, el carro tiene 0 elementos.
	@Test
	public void comprobarCarroVacio() {
	assertEquals (carro.getItemCount(),0);	
	}
	
	//Cuando se añade un producto, el número de elementos debe incrementarse.
	@Test
	public void añadeProducto() {
		carro.addItem(item);
		assertEquals(1, carro.getItemCount());
	}
	
	//Cuando se añade un producto, el balance nuevo debe ser la suma del balance anterior y el precio del producto añadido.
	 @Test
	public void sumaBalance() {
		carro.addItem(item);
		assertEquals(2, carro.getBalance());
	}
	
	//Cuando se elimina un producto, el número de elementos debe decrementarse.
	@Test
	public void eliminaProduct ()  {
		carro.addItem(item);
		try {
			carro.removeItem(item);
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(0,carro.getItemCount());
		
	}
	
	/*Cuando se intenta eliminar un producto que no está en el carro, se debe lanzar una excepción 
	 * ProductNotFoundException. Pista: inserta la llamada en un bloque try y pon un método fail()
	 *  después de la llamada a removeItem().
	 */
	public void eliminaProductError (Product p)  {
		try {
			carro.removeItem(item);
			fail("No se ha lanzado la excepcion");
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
