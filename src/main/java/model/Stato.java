package model;

public enum Stato {
    Approvata, InAttesa, Rifiutata;

    public String inAttesa(){return "InAttesa";}
    public String rifiutata(){return "Rifiutata";}
    public String approvata(){return "Approvata";}
}
