package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

public class RemoveTask {
    static String[][] removeTask(String[][] tasks) throws IndexOutOfBoundsException {

        System.out.print(ConsoleColors.RED + "PLease select number to remove: " + ConsoleColors.RESET);

        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.next());

        if (input >= tasks.length){
            throw new IndexOutOfBoundsException();
        } else {
            return ArrayUtils.remove(tasks,input);
        }
    }
}
