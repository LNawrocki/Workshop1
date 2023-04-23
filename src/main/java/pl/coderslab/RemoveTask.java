package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

public class RemoveTask {
    static String[][] removeTask(String[][] tasks) throws IndexOutOfBoundsException, IllegalArgumentException {

        System.out.print(ConsoleColors.RED + "PLease select number to remove: " + ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);
        int input;
        try {
            input = Integer.parseInt(scanner.next());
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            System.out.println("Required number value.");
        }

        input = tasks.length;
        if (input >= tasks.length){
            throw new IndexOutOfBoundsException();
        } else if (input < 0) {
            throw new IllegalArgumentException();
        } else
            return tasks = ArrayUtils.remove(tasks,input);
    }
}

