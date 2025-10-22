package fr.uvsq.cprog.collex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AdresseIPTest {

    @Test
    public void testCreationAdresseValide() {
        AdresseIP ip = new AdresseIP("192.168.0.1");
        assertEquals("192.168.0.1", ip.getIp());
    }

   @Test(expected = IllegalArgumentException.class)
public void testCreationAdresseInvalide1() {
    new AdresseIP("999.999.999.999");
}

    @Test(expected = IllegalArgumentException.class)
    public void testCreationAdresseInvalide2() {
        new AdresseIP("abc.def.ghi.jkl");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationAdresseInvalide3() {
        new AdresseIP("192.168.-1.1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationAdresseInvalide4() {
        new AdresseIP("256.0.0.1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationAdresseInvalide5() {
        new AdresseIP("192.168.1");
    }   
    @Test
    public void testEgalite() {
        AdresseIP ip1 = new AdresseIP("10.0.0.1");
        AdresseIP ip2 = new AdresseIP("10.0.0.1");
        AdresseIP ip3 = new AdresseIP("10.0.0.2");

        assertEquals(ip1, ip2);
        assertNotEquals(ip1, ip3);
        assertEquals(ip1.hashCode(), ip2.hashCode());
    }

    @Test
    public void testToString() {
        AdresseIP ip = new AdresseIP("127.0.0.1");
        assertEquals("127.0.0.1", ip.toString());
    }
}