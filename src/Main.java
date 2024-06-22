import plants.ListPlants;
import plants.Plant;
import plants.PlantException;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ListPlants listPlants = new ListPlants();

        // načtení ze souboru kvetiny.txt:
        try {
            listPlants.importFromFile("kvetiny.txt", "\t");
        } catch (IOException e) {
            System.err.println("Chyba při načtení souboru: " + e.getMessage());
        } catch (PlantException e) {
            System.err.println(e.getMessage());
        }

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

        // Uložení do nového souboru:
        try {
            listPlants.exportToFile("novy_seznam_kvetin.txt", "\t");
        } catch (IOException e) {
            System.err.println("Chyba při exportu souboru: " + e.getMessage());
        } catch (PlantException e) {
            System.err.println(e.getMessage());
        }

        // Opětovné načtení vygenerovaného souboru:
        ListPlants newListPlants = new ListPlants();
        try {
            newListPlants.importFromFile("novy_seznam_kvetin.txt", "\t");
        } catch (IOException e) {
            System.err.println("Chyba při opětovném načtení souboru: " + e.getMessage());
        } catch (PlantException e) {
            System.err.println(e.getMessage());
        }
    }
}