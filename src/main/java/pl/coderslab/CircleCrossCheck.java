package pl.coderslab;


public class CircleCrossCheck {
    public static boolean CcCheckResult(int tableSize, String[][] tableArray, int signsInLine, int playerIndex, boolean loopContinue ) {
                for (int i = 0; i < tableSize; i++) {
        for (int j = 0; j < tableSize; j++) {

            int counter = 1;
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
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        loopContinue = false;
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
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        loopContinue = false;
                    }
                }
                //sprawdzanie po skosie w dół
                counter = 1;
                if (i <= tableArray.length-signsInLine && j <= tableArray[i].length-signsInLine) {

                    for (int m = 1; m < signsInLine; m++ ) {
                        if (tableArray[i][j].equals(tableArray[i+m][j+m])) {
                            counter = counter + 1;
                        }
                    }

                    if (counter == signsInLine) {
                        System.out.println("The winner is Gracz: " + playerIndex + " ( " + signToCheck + " ) ");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        loopContinue = false;
                    }
                }

                //sprawdzanie po skosie w dół

                if (i >= tableArray.length-signsInLine && j <= tableArray[i].length-signsInLine) {

                    for (int m = 1; m < signsInLine; m++ ) {
                        if (tableArray[i][j].equals(tableArray[i-m][j+m])) {
                            counter = counter + 1;
                        }
                    }

                    if (counter == signsInLine) {
                        System.out.println("The winner is Gracz: " + playerIndex + " ( " + signToCheck + " ) ");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        loopContinue = false;
                    }
                }
            }
        }
    }
                return loopContinue;

    }
}
