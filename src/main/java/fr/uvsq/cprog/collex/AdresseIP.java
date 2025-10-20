package fr.uvsq.cprog.collex;

import java.util.Objects;
import java.util.regex.Pattern;


public class AdresseIP {
    private final String ip;
    private static final Pattern IP_PATTERN =
            Pattern.compile("^(\\d{1,3}\\.){3}\\d{1,3}$");

    public AdresseIP(String ip) {
        if (!IP_PATTERN.matcher(ip).matches()) {
            throw new IllegalArgumentException("Adresse IP invalide : " + ip);
        }
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String toString() {
        return ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdresseIP)) return false;
        AdresseIP that = (AdresseIP) o;
        return ip.equals(that.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }
}