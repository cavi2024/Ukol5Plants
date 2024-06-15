package plants;

import java.time.LocalDate;

public class PlantException extends Exception{
    public PlantException(String message) {
    super(message);
    }

    public static void validateWateringFrequency(int dayFrequencyOfWatering) throws PlantException {
        if (dayFrequencyOfWatering <= 0) {
            throw new PlantException("Frekvence zálivky musí být kladné číslo.");
        }
    }
}
