package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.collex.commande.Commande;


import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;


public class DnsApp {
    public static void main(String[] args) throws IOException {

        Dns dns = new Dns(Path.of("resources/dns.txt"));
        DnsTUI tui = new DnsTUI(dns);

        while (true) {
            Commande cmd = tui.nextCommande();
            String res = cmd.execute();
            tui.affiche(res);
        }
    }
}