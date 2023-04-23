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




        //wygenerowanie nowej tablicy i wyświetlenie nowej planszy
        CircleCrossTableInit.tabInit(tableArray, tableSize);

        int playerIndex = 1;
        boolean loopContinue = true;

        while (loopContinue) {
            System.out.println();
            Scanner sc = new Scanner(System.in);
            System.out.println("Gracz " + playerIndex + " - podaj numer pola?");
            String selectedIndex = sc.nextLine();

            System.out.println();

            if (selectedIndex.equals("exit")) {
                System.out.println("Game interrupted by GAMER");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            } else {
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

                for (int i = 0; i <= 147; i++){
                    System.out.print("W");
                }
                System.out.println();
                for (int i = 0; i < tableSize; i++) {
                    for (int j = 0; j < tableSize; j++) {
                        if (tableArray[i][j].equals("X") || tableArray[i][j].equals("O")) {
                            if (tableArray[i][j].equals("X")) {
                                System.out.print(ConsoleColors.RED_BOLD + " " + tableArray[i][j] + " " + ConsoleColors.RESET);
                            } else if (tableArray[i][j].equals("O")) {
                                System.out.print(ConsoleColors.GREEN_BOLD + " " + tableArray[i][j] + " " + ConsoleColors.RESET);
                            }
                        } else {
                            System.out.print(" _ ");
                        }
                    }
                    System.out.println();
                }

               loopContinue = CircleCrossCheck.CcCheckResult(tableSize, tableArray, signsInLine, playerIndex, loopContinue);

                if (playerIndex == 1) {
                    playerIndex = 2;
                } else {
                    playerIndex = 1;
                }
            }
        }
    }
}
