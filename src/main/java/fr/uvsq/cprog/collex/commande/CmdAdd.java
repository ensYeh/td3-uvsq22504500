package fr.uvsq.cprog.collex.commande;

import fr.uvsq.cprog.collex.AdresseIP;
import fr.uvsq.cprog.collex.Dns;
import fr.uvsq.cprog.collex.NomMachine;

public class CmdAdd implements Commande {
    private final Dns dns;
    private final AdresseIP ip;
    private final NomMachine nom;

    public CmdAdd(Dns dns, AdresseIP ip, NomMachine nom) {
        this.dns = dns;
        this.ip = ip;
        this.nom = nom;
    }

    @Override
    public String execute() {
        try {
            dns.addItem(ip, nom);
            return("Ajout effectué.");
        } catch (Exception e) {
            return ("Erreur : " + e.getMessage());
        }
    }
}