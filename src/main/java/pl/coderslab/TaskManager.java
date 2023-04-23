package pl.coderslab;

import java.util.Arrays;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {

        menuListing.printMenu();
        Scanner scanner = new Scanner(System.in);

        String[][] tasks = Tasks.tasks();
        // control print on beginning
        for (String[] task : tasks) {
            System.out.println(Arrays.toString(task));
        }

        while (true) {
           menuListing.printMenu();
           String input = scanner.nextLine();
           switch (input) {
                case "add" -> tasks = AddTask.addTask(tasks);
                case "remove" -> {
                    try {
                        tasks = RemoveTask.removeTask(tasks);
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("Selected value out table range, select right value.");
                    }

                }
                case "list" -> ListTask.listTask(tasks);
                case "play" -> CircleCross.CircleCross();
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