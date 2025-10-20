package fr.uvsq.cprog.collex.commande;

import java.util.stream.Collectors;

import fr.uvsq.cprog.collex.Dns.*;

public class CmdListeDomaine implements Commande {
    private final Dns dns;
    private final String domaine;
    private final boolean triParIp;

    public CmdListeDomaine(Dns dns, String domaine, boolean triParIp) {
        this.dns = dns;
        this.domaine = domaine;
        this.triParIp = triParIp;
    }

    @Override
    public String execute() {
        return dns.getItems(domaine, triParIp).stream()
                .map(DnsItem::toString)
                .collect(Collectors.joining("\n"));
    }
}