import plants.ListPlants;
import plants.Plant;
import plants.PlantException;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ListPlants listPlants = new ListPlants();

           // načtení ze souboru kvetiny.txt:
            try {
                listPlants.importFromFile("resources/kvetiny.txt", "\t");
            } catch (IOException e) {
                System.err.println("Chyba při načtení souboru: " + e.getMessage());
            } catch (PlantException e) {
                System.err.println(e.getMessage());
            }

            // Výpis informací o zálivce:
            listPlants.printWateringInfo();
            System.out.println();

            // Přidání dvou květin:
            Plant newPlant1 = null;
            try {
                  newPlant1 = new Plant( "Bazalka v kuchyni", " ", 3, LocalDate.of(2021, 9, 4),
                                        LocalDate.of(2021, 9,4));
            } catch (PlantException e) {
                System.err.println("Chyba při vložení nové květiny do souboru: " + e.getMessage());
            }

            Plant newPlant2 = null;
            try {
            newPlant2 = new Plant("Růže", "červená", 5, LocalDate.of(2022, 3, 15),
                                  LocalDate.of(2022, 3, 15));
            } catch (PlantException e) {
            System.err.println("Chyba při vložení nové květiny do souboru: " + e.getMessage());
            }

            listPlants.addPlant(newPlant1);
            listPlants.addPlant(newPlant2);
            System.out.println();

            // Odebrání druhé květiny:
            listPlants.removePlant(1);
            System.out.println();

            // Uložení do nového souboru:
            try {
                listPlants.exportToFile("resources/novy_seznam_kvetin.txt", "\t");
            } catch (IOException e) {
                System.err.println("Chyba při exportu souboru: " + e.getMessage());
            } catch (PlantException e) {
                System.err.println(e.getMessage());
            }
            System.out.println();

            // Opětovné načtení vygenerovaného souboru:
            ListPlants newListPlants = new ListPlants();
            try {
                newListPlants.importFromFile("resources/novy_seznam_kvetin.txt", "\t");
            } catch (IOException e) {
                System.err.println("Chyba při opětovném načtení souboru: " + e.getMessage());
            } catch (PlantException e) {
                System.err.println(e.getMessage());
            }
            System.out.println();

            // Řazení podle názvu květiny a výpis:
            Collections.sort(newListPlants.getPlants());
            System.out.println("Seřazeno podle názvu:");
            newListPlants.printWateringInfo();
            System.out.println();

            // Řazení podle data poslední zálivky a výpis:
            newListPlants.getPlants().sort(Plant.compareByLastWateringDate());
            System.out.println("Seřazeno podle data poslední zálivky:");
            newListPlants.printWateringInfo();
        }
}