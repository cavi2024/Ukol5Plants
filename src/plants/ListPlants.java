package plants;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
    public void exportToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(plants);
        }
    }

    // Načtení/import květin ze souboru i s výjimkou, pokud soubor nebude nalezen:
    public void importFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            plants = (List<Plant>) ois.readObject();
        }
    }

    // Seznam květin:
    public List<Plant> getPlants() {
        return plants;
    }

    @Override
    public String toString() {
        return "ListPlants{" +
                "plants=" + plants +
                '}';
    }
}


















