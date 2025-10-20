package fr.uvsq.cprog.collex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dns {
    private final Map<AdresseIP, DnsItem> parIp = new HashMap<>();
    private final Map<NomMachine, DnsItem> parNom = new HashMap<>();
    private final Path fichier;

    public Dns(Path fichier) throws IOException {
        this.fichier = fichier;
        charger();
    }

    private void charger() throws IOException {
        List<String> lignes = Files.readAllLines(fichier);
        for (String l : lignes) {
            String[] parts = l.split(" ");
            if (parts.length == 2) {
                NomMachine nom = new NomMachine(parts[0]);
                AdresseIP ip = new AdresseIP(parts[1]);
                DnsItem item = new DnsItem(ip, nom);
                parIp.put(ip, item);
                parNom.put(nom, item);
            }
        }
    }

    private void sauvegarder() throws IOException {
        List<String> lignes = parNom.values().stream()
                .map(i -> i.getNom() + " " + i.getIp())
                .sorted()
                .collect(Collectors.toList());
        Files.write(fichier, lignes);
    }

    public DnsItem getItem(AdresseIP ip) {
        return parIp.get(ip);
    }

    public DnsItem getItem(NomMachine nom) {
        return parNom.get(nom);
    }

    public List<DnsItem> getItems(String domaine, boolean triParIp) {
        Stream<DnsItem> stream = parNom.values().stream()
                .filter(i -> i.getNom().getDomaine().equals(domaine));
        if (triParIp) {
            return stream.sorted(Comparator.comparing(i -> i.getIp().getIp()))
                    .collect(Collectors.toList());
        } else {
            return stream.sorted(Comparator.comparing(i -> i.getNom().getNomComplet()))
                    .collect(Collectors.toList());
        }
    }

    public void addItem(AdresseIP ip, NomMachine nom) throws IOException {
        if (parIp.containsKey(ip)) {
            throw new IllegalArgumentException("ERREUR : L'adresse IP existe déjà !");
        }
        if (parNom.containsKey(nom)) {
            throw new IllegalArgumentException("ERREUR : Le nom de machine existe déjà !");
        }
        DnsItem item = new DnsItem(ip, nom);
        parIp.put(ip, item);
        parNom.put(nom, item);
        sauvegarder();
    }
}