
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ObjetsTest {

    protected IObjets obs1;
	
    @Before
    public void setUp(){
	obs1 = new Objets();
    }

    @Test
    public void testgetNomObjet() {	
	assertEquals("sword", obs1.getNomObjet(obs1.creationObjet("sword")));
    }

    @Test
    public void testsetNomObjet() {
	obs1.setNomObjet(1,"key");
	assertEquals("key", obs1.getNomObjet(1));
    }
	
    @Test
    public void testsupprimerObjet() {
	obs1.supprimerObjet(1);
	assertTrue(obs.size()==0);
    }
	
    @Test
    public void testgetObjets() {
	assertTrue(obs1.getObjets instanceof ArrayList<IObjet>);
    }
}
