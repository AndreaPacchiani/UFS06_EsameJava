package org.example;

import java.util.List;

public class Answer {
    private List<Piatto> piatti;

    public Answer(List<Piatto> piatti) {
        this.piatti = piatti;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Piatto p : piatti) {
            sb.append(p.getId()).append(" - ").append(p.getNome()).append(": ").append(p.getDescrizione()).append("\n");
        }
        return sb.toString();
    }
}