package org.example;

public class Piatto {
    private int id;
    private String nome;
    private String descrizione;
    private double prezzo;
    private double calorie;
    private boolean vegano;

    public Piatto(int id, String nome, String descrizione, double prezzo, double calorie, boolean vegano) {
        this.id = id;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.calorie = calorie;
        this.vegano = vegano;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public double getCalorie() {
        return calorie;
    }

    public boolean isVegano() {
        return vegano;
    }
}