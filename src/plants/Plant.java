package plants;

import java.time.LocalDate;
import java.util.Comparator;

public class Plant implements Comparable<Plant> {
    private String name;
    private String description;
    private int dayFrequencyOfWatering;
    private LocalDate dateOfLastWatering;
    private LocalDate dateOfPlanted;



    public Plant(String name, String description, int dayFrequencyOfWatering, LocalDate dateOfLastWatering, LocalDate dateOfPlanted) throws PlantException {
        PlantException.validateWateringFrequency(dayFrequencyOfWatering);
        PlantException.validateLastWateringDate(dateOfPlanted, dateOfLastWatering);

        this.name = name;
        this.description = description;
        this.dayFrequencyOfWatering = dayFrequencyOfWatering;
        this.dateOfLastWatering = dateOfLastWatering;
        this.dateOfPlanted = dateOfPlanted;
    }


    public Plant(String name, int dayFrequencyOfWatering, LocalDate dateOfPlanted) throws PlantException {
        this(name, " ", dayFrequencyOfWatering, LocalDate.now(), dateOfPlanted);
    }

    public Plant(String name) throws PlantException {
        this(name, " ", 7, LocalDate.now(), LocalDate.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfPlanted() {
        return dateOfPlanted;
    }

    public void setDateOfPlanted(LocalDate dateOfPlanted) {
        this.dateOfPlanted = dateOfPlanted;
    }

    public int getDayFrequencyOfWatering() {
        return dayFrequencyOfWatering;
    }

    public void setDayFrequencyOfWatering(int dayFrequencyOfWatering) throws PlantException {
        PlantException.validateWateringFrequency(dayFrequencyOfWatering);
        this.dayFrequencyOfWatering = dayFrequencyOfWatering;
    }

    public LocalDate getDateOfLastWatering() {
        return dateOfLastWatering;
    }

    public void setDateOfLastWatering(LocalDate dateOfLastWatering) throws PlantException {
        PlantException.validateLastWateringDate(dateOfPlanted, dateOfLastWatering);
        this.dateOfLastWatering = dateOfLastWatering;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWateringInfo() {
        return String.format("Květina: %s, Poslední zálivka dne: %s, Zalít za: %d dní", name, dateOfLastWatering, dayFrequencyOfWatering);
    }

    // Metoda zalévání ošetřená vyhozením výjimky:
    public void watering() throws PlantException {
        LocalDate today = LocalDate.now();
        if (!today.isAfter(dateOfLastWatering.plusDays(dayFrequencyOfWatering))) {
            throw new PlantException("Rostlina ještě nepotřebuje zálivku.");
        }
        dateOfLastWatering = today;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "Název květiny:'" + name + '\'' +
                ", Poslední zálivka dne:" + dateOfLastWatering +
                ", Zalít za dní:" + dayFrequencyOfWatering +
                '}';
    }

    // Řazení podle názvu květiny - comparaTo:
    @Override
    public int compareTo(Plant other) {
        return this.name.compareTo(other.name);
    }

    // Řazení podle data poslední zálivky:
    public static Comparator<Plant> compareByLastWateringDate() {
        return Comparator.comparing(Plant::getDateOfLastWatering);
    }

}



