package plants;

import java.io.*;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListPlants {
    private List<Plant> plants;

    // Prázdný seznam květin:
    public ListPlants() {
        plants = new ArrayList<>();
    }

    // Přidání nové květiny do seznamu:
    public void addPlant (Plant plant) {
        plants.add(plant);
    }

    // Získání květiny na zadaném indexu (index je mimo platný rozsah, když je menší než 0 a nebo
    // větší či roven počtu položek v seznamu:
    public Plant getPlant(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= plants.size()) {
            throw new IndexOutOfBoundsException("Neplatný index: " + index);
        }
        return plants.get(index);
    }

    // Odebrání květiny ze seznamu na daném indexu:
    public void removePlant(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= plants.size()) {
            throw new IndexOutOfBoundsException("Neplatný index: " + index);
        }
        plants.remove(index);
    }

    // Exportování květin do souboru:
    public void exportToFile(String fileName, String delimiter) throws IOException, PlantException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            for (Plant plant : plants) {
                writer.println(
                       plant.getName() + delimiter
                        + plant.getDescription() + delimiter
                        + plant.getDateOfPlanted() + delimiter
                        + plant.getDayFrequencyOfWatering() + delimiter
                        + plant.getDateOfLastWatering());

            }
        } catch (IOException e) {
            throw  new PlantException("Chyba při zápisu do souboru " + fileName + " " + e.getMessage());
        }
    }

    // Načtení/import květin ze souboru i s výjimkou, pokud soubor nebude nalezen:
    public void importFromFile(String fileName, String delimiter) throws IOException, PlantException  {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split("\t");
                String name = parts[0];
                String description = parts[1].isEmpty() ? " " : parts[1];
                LocalDate dateOfPlanted = LocalDate.parse(parts[2]);
                int dayFrequencyOfWatering = Integer.parseInt(parts[3]);
                LocalDate dateOfLastWatering = LocalDate.parse(parts[4]);
                Plant plant = new Plant(name, dateOfPlanted, dayFrequencyOfWatering, dateOfLastWatering, description);
                addPlant(plant);
            }
        } catch (FileNotFoundException e) {
            throw new PlantException("Soubor nebyl nalezen: " + e.getMessage());
        }
    }

    // Seznam květin - vrátí celý seznam květin:
    public List<Plant> getPlants() {
        return plants;
    }

    // Metoda pro výpis informací o zálivce:
    public void printWateringInfo() {
        for (Plant plant : plants) {
            System.out.println(plant.getWateringInfo());
        }
    }

    @Override
    public String toString() {
        return "ListPlants{" +
                "květiny=" + plants +
                '}';
    }
}


















