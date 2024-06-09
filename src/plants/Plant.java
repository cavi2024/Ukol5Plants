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
}



