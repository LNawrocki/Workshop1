package pl.coderslab;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {



//        static void actionList() {
//            switch (input) {
//                case "add":
//                    addTask();
//                    break;
//                case "remove":
//                    addRemove();
//                    break;
//                case "list":
//                    addList();
//                    break;
//                case "exit":
//                    addExit();
//                    break;
//            }
//        }
        tasks();
    }

    static void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add task description:");
        scanner.next();

        System.out.println("Please add task due time:");
        System.out.println("Is your task important: true/false");

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