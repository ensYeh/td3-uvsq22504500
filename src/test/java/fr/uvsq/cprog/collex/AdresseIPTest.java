package fr.uvsq.cprog.collex;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdresseIPTest {

    @Test
    public void testCreationAdresseValide() {
        AdresseIP ip = new AdresseIP("192.168.0.1");
        assertEquals("192.168.0.1", ip.getIp());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationAdresseInvalide() {
        new AdresseIP("999.999.999.999"); // devrait lever une exception
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