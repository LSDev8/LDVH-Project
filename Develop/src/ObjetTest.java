
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ObjetTest {

	protected IObjet ob;
	protected String nom = new String("sword"); 
	
    @Before
	public void setUp(){
		ob = new Objet(1,"sword");
	}
	
	@Test
	public void testgetId() {
		assertTrue(ob.getId()==1);
	}
	
	@Test
	public void testgetNom() {
		assertEquals(nom,ob.getNom());
	}
	
	@Test
	public void testsetId() {
		ob.setId(2);
		assertTrue(ob.getId()==2);
	}
	
	@Test
	public void testsetNom() {
		ob.setNom("key");
		assertEquals("key",ob.getNom());
	}
}
