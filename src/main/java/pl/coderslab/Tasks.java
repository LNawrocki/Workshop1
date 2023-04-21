package pl.coderslab;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Tasks {
    static  String[][] tasks() {

        Path path = Paths.get("tasks.csv");

        String[][] tasks = new String[1][];

        try{
           Scanner tasksScanner = new Scanner(path);
        while (tasksScanner.hasNextLine()) {
            String str = tasksScanner.nextLine();
            tasks[tasks.length-1] = str.split(",");
            tasks = Arrays.copyOf(tasks,tasks.length+1);
        }
        } catch (IOException ex){
            ex.printStackTrace();
        }
        tasks = Arrays.copyOf(tasks,tasks.length-1);
        return  tasks;
    }
}

