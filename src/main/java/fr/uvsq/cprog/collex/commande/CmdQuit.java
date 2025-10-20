package fr.uvsq.cprog.collex.commande;


public class CmdQuit implements Commande {
    @Override
    public String execute() {
        System.exit(0);
        return "";
    }
}