package fr.uvsq.cprog.collex;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;

public class DnsTest {

    private Dns dns;

    @Before
    public void setUp() throws IOException {
        dns = new Dns(Path.of("src/test/resources/dns.txt"));
    }

    @Test
    public void testGetItemParNom() {
        DnsItem item = dns.getItem(new NomMachine("www.uvsq.fr"));
        assertNotNull(item);
        assertEquals("193.51.31.90", item.getIp().getIp());
    }

    @Test
    public void testGetItemParIp() {
        DnsItem item = dns.getItem(new AdresseIP("193.51.31.90"));
        assertNotNull(item);
        assertEquals("www.uvsq.fr", item.getNom().getNomComplet());
    }
}