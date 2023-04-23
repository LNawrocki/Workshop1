package pl.coderslab;

import java.util.Scanner;

public class CircleCross {
    static void CircleCross() {

        // inicjalizacja tablicy do gry

        System.out.println("Podaj rozmiar planszy (max.30):");
        Scanner scTs = new Scanner(System.in);
        int tableSize = Integer.parseInt(scTs.nextLine());

        System.out.println("Ile znaków w linii wygrywa?");
        Scanner scLs = new Scanner(System.in);
        int signsInLine = Integer.parseInt(scLs.nextLine());

        String[][] tableArray = new String[tableSize][tableSize];

        int counter =0;


        //wygenerowanie nowej tablicy i wyświetlenie nowej planszy
        CircleCrossTableInit.tabInit(tableArray, tableSize);

        int playerIndex = 1;
        while (true) {
            System.out.println();
            Scanner sc = new Scanner(System.in);
            System.out.println("Gracz " + playerIndex + " - podaj numer pola?");
            String selectedIndex = sc.nextLine();

            System.out.println();

            // Wstawienie znaku gracza do tablicy
            for (int i = 0; i < tableSize; i++) {
                for (int j = 0; j < tableSize; j++) {
                    if (selectedIndex.equals(tableArray[i][j])) {
                        if (playerIndex == 1) {
                            tableArray[i][j] = "X";
                        } else {
                            tableArray[i][j] = "O";
                        }
                    }
                }
            }

            for (int i = 0; i < tableSize; i++) {
                for (int j = 0; j < tableSize; j++) {
                    if (tableArray[i][j].equals("X") || tableArray[i][j].equals("O")) {
                        if (tableSize * tableSize < 1000 && tableSize * tableSize > 100) {
                            System.out.print(" " + tableArray[i][j] + "   ");
                        } else if (tableSize * tableSize <= 100 && tableSize * tableSize > 10) {
                            System.out.print(" " + tableArray[i][j] + "  ");
                        } else {
                            System.out.print(tableArray[i][j] + "  ");
                        }
                    } else {
                        System.out.print(tableArray[i][j] + "  ");
                    }
                }
                System.out.println();
            }

                System.out.println("----------------------------------");

                for (int i = 0; i < tableSize; i++) {
                    for (int j = 0; j < tableSize; j++) {
                        if (tableArray[i][j].equals("X") || tableArray[i][j].equals("O")) {
                            System.out.print(" " + tableArray[i][j] + " ");
                        } else {
                            System.out.print(" _ ");
                        }
                    }
                    System.out.println();
                }

                int maxInLine = 0;
                boolean test = true;
            for (int i = 0; i < tableSize; i++) {
                for (int j = 0; j < tableSize; j++) {
                    counter = 1;
                   if (tableArray[i][j].equals("X") || tableArray[i][j].equals("O")) {
                       String signToCheck = tableArray[i][j];
// sprawdzanie pionowo
                       if (i <= tableArray.length-signsInLine) {

                           for (int k = i; k < i + signsInLine-1; k++ ) {
                               if (tableArray[i][j].equals(tableArray[k+1][j])) {
                                   counter = counter + 1;
                               }
                           }
//                           System.out.println(Integer.toString(counter));
                           if (counter == signsInLine) {
                               System.out.println("The winner is Gracz: " + playerIndex + " ( " + signToCheck + " ) ");
                               System.exit(0);
                           }
                       }
                           //sprawdzanie poziomo
                       counter = 1;
                       if (j <= tableArray[i].length-signsInLine) {

                           for (int l = j; l < j + signsInLine-1; l++ ) {
                               if (tableArray[i][j].equals(tableArray[i][l+1])) {
                                   counter = counter + 1;
                               }
                           }

                           if (counter == signsInLine) {
                               System.out.println("The winner is Gracz: " + playerIndex + " ( " + signToCheck + " ) ");
                               System.exit(0);
                           }
                       }
                       //sprawdzanie po skosie
                       counter = 1;
                       if (i <= tableArray.length-signsInLine && j <= tableArray[i].length-signsInLine) {

                           for (int m = 1; m < signsInLine; m++ ) {
                               if (tableArray[i][j].equals(tableArray[i+m][j+m])) {
                                   counter = counter + 1;
                               }
                           }

                           if (counter == signsInLine) {
                               System.out.println("The winner is Gracz: " + playerIndex + " ( " + signToCheck + " ) ");
                               System.exit(0);
                           }
                       }
                   }
                }
            }
            if (playerIndex == 1) {
                playerIndex = 2;
            } else {
                playerIndex = 1;
            }
        }
    }
}
