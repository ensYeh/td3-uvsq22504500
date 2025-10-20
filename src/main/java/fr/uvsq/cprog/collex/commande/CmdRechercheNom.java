package fr.uvsq.cprog.collex.commande;

import fr.uvsq.cprog.collex.AdresseIP;
import fr.uvsq.cprog.collex.Dns;
import fr.uvsq.cprog.collex.DnsItem;

public class CmdRechercheNom implements Commande {
    private final Dns dns;
    private final AdresseIP ip;

    public CmdRechercheNom(Dns dns, AdresseIP ip) {
        this.dns = dns;
        this.ip = ip;
    }

    @Override
    public String execute() {
        DnsItem item = dns.getItem(ip);
        return (item != null) ? item.getNom().toString() : "ERREUR : IP inconnue";
    }
}