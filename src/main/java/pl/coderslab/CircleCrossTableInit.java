package pl.coderslab;

public class CircleCrossTableInit {
    static void tabInit(String[][] tableArray, int tableSize) {
        int index = 0;

        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                if (tableSize * tableSize < 10) {
                    tableArray[i][j] = Integer.toString(index);
                }
                if (tableSize * tableSize > 10 && tableSize * tableSize <= 100) {
                    if (index < 10) {
                        tableArray[i][j] = "0" + index;
                    } else {
                        tableArray[i][j] = Integer.toString(index);
                    }
                } else if (tableSize * tableSize > 100 && tableSize * tableSize <= 1000) {
                    if (index < 10) {
                        tableArray[i][j] = "00" + index;
                    } else if (index >= 10 && index < 100) {
                        tableArray[i][j] = "0" + index;
                    } else {
                        tableArray[i][j] = Integer.toString(index);
                    }
                }
                index++;
            }
            System.out.println();
        }
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                System.out.print(ConsoleColors.YELLOW_BOLD + tableArray[i][j] + " " + ConsoleColors.RESET);
            }
            System.out.println();
        }
    }
}