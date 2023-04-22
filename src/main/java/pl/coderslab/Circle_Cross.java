package pl.coderslab;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Circle_Cross {
    public static void main (String[] args ) {

        // inicjalizacja tablicy do gry

        System.out.println("Podaj rozmiar planszy (max.30):");
        Scanner scTs = new Scanner(System.in);
        int tableSize = Integer.parseInt(scTs.nextLine());

        System.out.println("Ile znaków w linii wygrywa?");
        Scanner scLs = new Scanner(System.in);
        int signsInLine = Integer.parseInt(scLs.nextLine());

        String[][] tableArray = new String[tableSize][tableSize];
        int index = 0;
        int counter =0;


        //wygenerowanie nowej tablicy

        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                if (tableSize * tableSize < 10) {
                    tableArray[i][j] = Integer.toString(index);
                } if (tableSize * tableSize > 10 && tableSize * tableSize <= 100) {
                    if (index < 10) {
                        tableArray[i][j] = "0" + index;
                    } else {
                        tableArray[i][j] = Integer.toString(index);
                    }
                } else if (tableSize * tableSize > 100 && tableSize * tableSize <= 1000) {
                    if (index < 10) {
                        tableArray[i][j] = "00" + index;
                    } else if (index >= 10 && index < 100) {
                        tableArray[i][j] = "0" +index;
                    } else {
                        tableArray[i][j] = Integer.toString(index);
                    }
                }
                index++;
            }
            System.out.println();
        }

        // wyświetlenie nowej tablicy
        for (int i = 0; i < tableSize; i++) {
            for (int j = 0; j < tableSize; j++) {
                System.out.print(tableArray[i][j] + " ");
            }
            System.out.println();
        }

        int playerIndex = 1;
        int signInLineReach = 0;

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

            if (playerIndex == 1) {
                playerIndex = 2;
            } else {
                playerIndex = 1;
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
                               System.exit(0);
                           }
                       }
                       counter = 1;
                       if (j <= tableArray[i].length-signsInLine) {

                           for (int l = j; l < j + signsInLine-1; l++ ) {
                               if (tableArray[i][j].equals(tableArray[i][l+1])) {
                                   counter = counter + 1;
                               }
                           }
//                           System.out.println(Integer.toString(counter));
                           if (counter == signsInLine) {
                               System.exit(0);
                           }
                       }
//                       counter = 1;
//                       if (i <= tableArray.length-signsInLine && j <= tableArray[i].length-signsInLine) {
//
//                           for (int m = i; m < i + signsInLine-1; m++ ) {
//                               if (tableArray[i][j].equals(tableArray[i][l+1])) {
//                                   counter = counter + 1;
//                               }
//                           }
////                           System.out.println(Integer.toString(counter));
//                           if (counter == signsInLine) {
//                               System.exit(0);
//                           }
//                       }
                   }
                }
            }
        }
    }
}
