package fr.uvsq.cprog.collex;

import fr.uvsq.cprog.collex.commande.Commande;

import java.util.Scanner;

public class DnsTUI {
    private final Scanner scanner = new Scanner(System.in);
    private final Dns dns;

    public DnsTUI(Dns dns) {
        this.dns = dns;
    }

    public Commande nextCommande() {
        System.out.print("> ");
        String ligne = scanner.nextLine();
        String[] parts = ligne.split(" ");

        if (ligne.equalsIgnoreCase("quit")) {
            return new CmdQuit();
        } else if (parts.length == 1 && parts[0].matches("(\\d{1,3}\\.){3}\\d{1,3}")) {
            return new CmdRechercheNom(dns, new AdresseIP(parts[0]));
        } else if (parts.length == 1) {
            return new CmdRechercheIP(dns, new NomMachine(parts[0]));
        } else if (parts[0].equals("ls")) {
            boolean triParIp = parts.length == 3 && parts[1].equals("-a");
            String domaine = triParIp ? parts[2] : parts[1];
            return new CmdListeDomaine(dns, domaine, triParIp);
        } else if (parts[0].equals("add") && parts.length == 3) {
            return new CmdAdd(dns, new AdresseIP(parts[1]), new NomMachine(parts[2]));
        }
        return () -> "Commande inconnue";
    }

    public void affiche(String resultat) {
        if (resultat != null && !resultat.isEmpty()) {
            System.out.println(resultat);
        }
    }
}