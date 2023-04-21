package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = "";
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
                input = scanner.nextLine();


                switch (input) {
                    case "add":
                        tasks = addTask(tasks);
                        break;
                    case "remove":
                        try{
                            tasks = removeTask(tasks);
                        } catch (IndexOutOfBoundsException ex) {
                            System.out.println("Selected value out table range, select right value.");
                        } catch (NumberFormatException ex) {
                            System.out.println("Required number value.");
                        }
                        break;
                    case "list":
                        listTask(tasks);
                        break;
                    case "exit":
                        exitTask(tasks);
                        System.exit(0);
                        break;
                    default:
                    System.out.println("Please select a correct option.");
                    System.out.println();;
            }
        }
    }

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

    static void exitTask(String[][] tasks) {

        try (PrintWriter printWriter = new PrintWriter("tasks.csv")){
            for (int i = 0; i < tasks.length; i++) {
                printWriter.println(String.join(", ", tasks[i]));
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    static void listTask(String[][] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tasks[i].length; j++) {
                System.out.print(tasks[i][j] + ", ");
            }
            System.out.println();
        }
    }

    static String[][] addTask(String[][] tasks) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please add task description:");
        String newTask = scanner.next() + ", ";
        System.out.println("Please add task due time:");
        newTask += scanner.next() + ", ";
        System.out.println("Is your task important: true/false");
        newTask += scanner.next();

        tasks = Arrays.copyOf(tasks,tasks.length+1);
        tasks[tasks.length-1] = newTask.split(",");

        return tasks;
    }



    static  String[][] tasks() {

        Path path = Paths.get("tasks.csv");
        Scanner tasksScanner = null;
        String[][] tasks = new String[1][];
        try{
            tasksScanner = new Scanner(path);
        } catch (IOException ex){
            ex.printStackTrace();
        }
        while (tasksScanner.hasNextLine()) {
            String str = tasksScanner.nextLine();
            tasks[tasks.length-1] = str.split(",");
            tasks = Arrays.copyOf(tasks,tasks.length+1);
        }
        tasks = Arrays.copyOf(tasks,tasks.length-1);
        return  tasks;
    }
}