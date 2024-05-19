import java.util.ArrayList;
import java.util.Scanner;

public class Util {

    public Util() {

    }

    public static String getStringInput(Scanner scan, String prompt) {
        System.out.println(prompt);
        return scan.nextLine();
    }

    public static int getIntInput(Scanner scan, String prompt) {
        int input = 0;
        boolean isValid = false;

        do {
            System.out.println(prompt);
            try {
                input = Integer.parseInt(scan.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("indtast venligst et heltal.");
                System.out.println();
            }
        } while (!isValid);
        return input;
    }

    public static double getDoubleInput(Scanner scan, String prompt) {
        double input = 0.0;
        boolean isValid = false;

        do {
            System.out.println(prompt);
            try {
                input = Double.parseDouble(scan.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Indtast venligst et decimaltal.");
                System.out.println();
            }
        } while (!isValid);
        return input;
    }

    public static boolean getBooleanInput(Scanner scan, String prompt) {
        boolean input = false;
        boolean isValid = false;
        do {
            System.out.println(prompt);
            String userInput = scan.nextLine().toLowerCase();
            if (userInput.equals("ja")) {
                input = true;
                isValid = true;
            } else if (userInput.equals("nej")) {
                input = false;
                isValid = true;
            } else {
                System.out.println("Forkert indtastning. prøv med ja/nej");
                System.out.println();
            }
        } while (!isValid);
        return input;
    }

    public static <T> void printArraylist(ArrayList<T> list) {
        for (T element : list) {
            System.out.println(element);
        }

    }
}
