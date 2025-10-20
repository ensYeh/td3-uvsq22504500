package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.collex.commande.Commande;


import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;


public class DnsApp {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(DnsApp.class.getResourceAsStream("/config.properties"));
        String fichierDns = prop.getProperty("dns.file");

        Dns dns = new Dns(Path.of(fichierDns));
        DnsTUI tui = new DnsTUI(dns);

        while (true) {
            Commande cmd = tui.nextCommande();
            String res = cmd.execute();
            tui.affiche(res);
        }
    }
}