package pl.coderslab;

import java.util.Arrays;
import java.util.Scanner;

public class AddTask {
    static String[][] addTask(String[][] tasks) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please add task description:");
        String newTask = scanner.nextLine() + ", ";
        System.out.println("Please add task due time:");
        newTask += scanner.nextLine() + ", ";
        System.out.println("Is your task important: true/false");
        newTask += scanner.nextLine();

        tasks = Arrays.copyOf(tasks,tasks.length+1);
        tasks[tasks.length-1] = newTask.split(",");

        return tasks;
    }
}
