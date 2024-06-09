package plants;

import java.time.LocalDate;

public class Plant {
    private String name;
    private LocalDate dateOfPlanted;
    private int dayFrenquencyOfWatering;
    private LocalDate dateOfLastWatering;
    private String description;

    public Plant(String name, LocalDate dateOfPlanted, int dayFrenquencyOfWatering, LocalDate dateOfLastWatering, String description) {
        this.name = name;
        this.dateOfPlanted = dateOfPlanted;
        this.dayFrenquencyOfWatering = dayFrenquencyOfWatering;
        this.dateOfLastWatering = dateOfLastWatering;
        this.description = description;
    }

    public Plant(String name, LocalDate dateOfPlanted, int dayFrenquencyOfWatering) {
        this(name, dateOfPlanted, dayFrenquencyOfWatering, LocalDate.now(), " ");
    }

    public Plant(String name) {
        this(name, LocalDate.now(), 7, LocalDate.now(), " ");
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

    public int getDayFrenquencyOfWatering() {
        return dayFrenquencyOfWatering;
    }

    public void setDayFrenquencyOfWatering(int dayFrenquencyOfWatering) {
        this.dayFrenquencyOfWatering = dayFrenquencyOfWatering;
    }

    public LocalDate getDateOfLastWatering() {
        return dateOfLastWatering;
    }

    public void setDateOfLastWatering(LocalDate dateOfLastWatering) {
        this.dateOfLastWatering = dateOfLastWatering;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



