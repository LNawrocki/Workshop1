package pl.coderslab;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            tasks();
            mainMenu();


    }


//    static void selectOption() {
//        Scanner input = new Scanner(System.in);
//
//        switch (input) {
//            case "add":
//                addTask;
//                break;
//            case "remove":
//                removeTask;
//                break;
//            case "list":
//                listTask;
//                break;
//            default:
//                System.out.println("Please select a correct option.");
//        }
//    }

    static void mainMenu() {
        String[] options = new String[]{"add", "remove", "list", "exit" };
        System.out.println(ConsoleColors.BLUE + "Please select an options:" + ConsoleColors.RESET);

        for (String option : options) {
            System.out.println(option);
        }

        System.out.print("Your choice: ");
    }


    static void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add task description:");
        scanner.next();

        System.out.println("Please add task due time:");
        scanner.next();

        System.out.println("Is your task important: true/false");
        scanner.next();

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
            tasks[tasks.length-1] = tasksScanner.nextLine().split(",");
//            System.out.println(Arrays.deepToString(tasks));
        }
        return  tasks;
    }




}