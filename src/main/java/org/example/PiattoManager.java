package org.example;



import java.util.ArrayList;
import java.util.List;

public class PiattoManager {
    private List<Piatto> piatti = new ArrayList<>();

    public PiattoManager() {
        piatti.add(new Piatto(1, "Risotto alla Milanese", "Il piatto di riso tipico milanese", 12.50, 250.0, false));
        piatti.add(new Piatto(2, "Pizza Margherita", "La classica pizza Margherita", 8.00, 200.0, true));
        piatti.add(new Piatto(3, "Insalata di farro", "Insalata di farro con verdure grigliate", 10.00, 150.0, true));
        piatti.add(new Piatto(4, "Tagliatelle al ragù", "Tagliatelle con ragù di carne", 14.50, 400.0, false));
        piatti.add(new Piatto(5, "Insalata Russa", "Insalata con tanta roba dentro", 12, 490, true));
    }

    public List<Piatto> getPiatti() {
        return piatti;
    }

    public List<Piatto> getPiattiVegani() {
        List<Piatto> result = new ArrayList<>();
        for (Piatto p : piatti) {
            if (p.isVegano()) {
                result.add(p);
            }
        }
        return result;
    }

    public Piatto getPiattoConCalorieMaggiori() {
        Piatto piattoConCalorieMaggiori = null;
        double maxCalorie = 0.0;
        for (Piatto piatto : piatti) {
            if (piatto.getCalorie() > maxCalorie) {
                maxCalorie = piatto.getCalorie();
                piattoConCalorieMaggiori = piatto;
            }
        }
        return piattoConCalorieMaggiori;
    }
}