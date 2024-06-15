package plants;

import java.time.LocalDate;

public class PlantException extends Exception{
    public PlantException(String message) {
    super(message);
    }

    // Metoda, která kontroluje, zda je frekvence zálivky kladné číslo:
    public static void validateWateringFrequency(int dayFrequencyOfWatering) throws PlantException {
        if (dayFrequencyOfWatering <= 0) {
            throw new PlantException("Frekvence zálivky musí být kladné číslo.");
        }
    }

    // Metoda, která kontroluje, zda datum poslední zálivky není starší než datum zasazení rostliny:
    public static void validateLastWateringDate(LocalDate dateOfPlanted, LocalDate dateOfLastWatering) throws PlantException {
        if (dateOfLastWatering.isBefore(dateOfPlanted)) {
            throw new PlantException("Datum poslední zálivky nesmí být starší než datum zasazení rostliny.");
        }
    }
}
