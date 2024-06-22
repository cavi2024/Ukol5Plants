import plants.ListPlants;

public class Main {
    public static void main(String[] args) {
        ListPlants listPlants = new ListPlants();
        try {
           // načtení ze souboru kvetiny.txt:
           listPlants.importFromFile("kvetiny.txt");

           // Výpis informací o zálivce:
           listPlants.printWateringInfo();
        }
    }
}