package org.example;

import java.util.List;

public class Answer {
    private final List<Piatto> piatti;

    public Answer(List<Piatto> piatti) {
        this.piatti = piatti;
    }

    public List<Piatto> getPiatti() {
        return piatti;
    }
}