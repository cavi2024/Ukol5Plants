import plants.ListPlants;
import plants.Plant;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ListPlants listPlants = new ListPlants();
        try {
            // načtení ze souboru kvetiny.txt:
            listPlants.importFromFile("kvetiny.txt");

            // Výpis informací o zálivce:
            listPlants.printWateringInfo();

            // Přidání dvou květin:
            Plant newPlant1 = new Plant("Bazalka v kuchyni", LocalDate.of(2021, 9, 4),
                    3, LocalDate.of(2021, 9, 4), " ");
            Plant newPlant2 = new Plant("Růže", LocalDate.of(2022, 3, 15),
                    5, LocalDate.of(2022, 3, 10), "červená");
            listPlants.addPlant(newPlant1);
            listPlants.addPlant(newPlant2);

            // Odebrání druhé květiny:
            listPlants.removePlant(1);

        }
    }
}