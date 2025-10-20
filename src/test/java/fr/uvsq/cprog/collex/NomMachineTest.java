package fr.uvsq.cprog.collex;

import org.junit.Test;

import static org.junit.Assert.*;

public class NomMachineTest {

    @Test
    public void testCreationNomValide() {
        NomMachine nom = new NomMachine("www.uvsq.fr");
        assertEquals("www.uvsq.fr", nom.getNomComplet());
        assertEquals("www", nom.getMachine());
        assertEquals("uvsq.fr", nom.getDomaine());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreationNomInvalide() {
        new NomMachine("uvsq"); // pas de point => doit lever une exception
    }

    @Test
    public void testEgalite() {
        NomMachine n1 = new NomMachine("poste.uvsq.fr");
        NomMachine n2 = new NomMachine("poste.uvsq.fr");
        NomMachine n3 = new NomMachine("www.uvsq.fr");

        assertEquals(n1, n2);
        assertNotEquals(n1, n3);
        assertEquals(n1.hashCode(), n2.hashCode());
    }

    @Test
    public void testToString() {
        NomMachine nom = new NomMachine("ecampus.uvsq.fr");
        assertEquals("ecampus.uvsq.fr", nom.toString());
    }
}