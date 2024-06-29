package plants;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileOfPlants {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("kvetiny.txt"))) {
            writer.println("Fialka\tPopis_fialky_-_je_fialová_a_hezká\t3\t2021-05-12\t2021-01-01");
            writer.println("Bazalka_v_kuchyni\tbez_poznámky\t3\t2021-9-4\t2021-9-4");
            writer.println("Růže\tčervená\t5\t2022-3-15\t2022-3-15");
        } catch (IOException e) {
            System.err.println("Došlo k chybě při zápisu do souboru: " + e.getMessage());
        }
    }
}
