package pl.coderslab;

import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[][] tasks = Tasks.tasks();
        // control print on beginning
        for (String[] task : tasks) {
            System.out.println(Arrays.toString(task));
        }

        while (true) {
            System.out.println();
            System.out.println(ConsoleColors.BLUE + "Please select an option:" + ConsoleColors.RESET);
            System.out.println("add");
            System.out.println("remove");
            System.out.println("list");
            System.out.println("exit");
            System.out.println();
            System.out.print("Type your choice: ");
            String input = scanner.nextLine();


            switch (input) {
                case "add" -> tasks = AddTask.addTask(tasks);
                case "remove" -> {
                    try {
                        tasks = RemoveTask.removeTask(tasks);
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Selected value out table range, select right value.");
                    } catch (NumberFormatException ex) {
                        System.out.println("Required number value.");
                    }
                }
                case "list" -> ListTask.listTask(tasks);
                case "exit" -> {
                    ExitTask.exitTask(tasks);
                    System.out.println(ConsoleColors.RED_BOLD_BRIGHT + "See you next time!" + ConsoleColors.RESET);
                    System.exit(0);
                }
                default -> {
                    System.out.println("Please select a correct option.");
                    System.out.println();
                }
            }
        }
    }
}