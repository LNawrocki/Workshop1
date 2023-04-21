package pl.coderslab;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ExitTask {
    static void exitTask(String[][] tasks) {

        try (PrintWriter printWriter = new PrintWriter("tasks.csv")){
            for (String[] task : tasks) {
                printWriter.println(String.join(", ", task));
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
