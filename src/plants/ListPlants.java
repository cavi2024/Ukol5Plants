package plants;

import java.util.ArrayList;
import java.util.List;

public class ListPlants {
    private List<Plant> plants;

    // Prázdný seznam rostlin:
    public ListPlants() {
        plants = new ArrayList<>();
    }

    // Přidání nové květiny do seznamu:
    public void addPlant (Plant plant) {
        plants.add(plant);
    }
}
