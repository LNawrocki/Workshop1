package pl.coderslab;

public class ListTask {
    static void listTask(String[][] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tasks[i].length; j++) {
                System.out.print(tasks[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
