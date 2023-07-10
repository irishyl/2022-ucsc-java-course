import java.util.Scanner;

/**
 * This is solution for Homework#8
 * 
 * All solutions have been put in one place to minimize number of classes
 * 
 * @author hsinyuanlu
 * @version 1.0
 * @since 09-03-2022 Wrote comments, formatted the code
 * 
 */

public class CodeModification {
    /*
     * Homework 8.1
     * Modify the weekly temperature code and break it into multiple methods.
     */

    static Scanner readInput = new Scanner(System.in);
    static int weeklyTemp[] = new int[7];
    static int max = 0, min = 0;
    static float total = 0, average;

    // ask user to enter temperatures and store them in weeklyTemp array
    public static void getTemperatures() {
        System.out.print("Please enter 7 temperatures for the week (integer only, separate by space): ");
        for (int i = 0; i < 7; i++) {
            weeklyTemp[i] = readInput.nextInt();
        }
    }// end of getTemperatures

    // print temperatures
    public static void printTemperatures() {
        int day = 0;
        for (int dayTemp : weeklyTemp) {
            System.out.printf("\nThe temperature on day %d " + "was %d ", ++day,
                    dayTemp);
        }
    }// end of printTemperatures

    // find the max temperature
    public static void getMax() {
        for (int i = 0; i < 7; i++) {
            if (i == 0)
                max = weeklyTemp[i];
            if (weeklyTemp[i] > max)
                max = weeklyTemp[i];
        }
    }// end of getMax

    // find the min temperature
    public static void getMin() {
        for (int i = 0; i < 7; i++) {
            if (i == 0)
                min = weeklyTemp[i];
            if (weeklyTemp[i] < min)
                min = weeklyTemp[i];
        }
    }// end of getMin

    // get the average temperature
    public static void getAverage() {
        for (int i = 0; i < 7; i++) {
            total += weeklyTemp[i];
            average = total / weeklyTemp.length;
        }
    }

    // print all calculated statistics
    public static void printStatistics() {
        System.out.println();
        System.out.printf("The Minimum temperature is: %d\n", min);
        System.out.printf("The Maximum temperature is: %d\n", max);
        System.out.println("The average temperage for the week is:" + average);
    }// end of printStatistics

    /*
     * Homework 8.2
     * Modify the drawBox code and break it into multiple methods.
     */
    static int x, y;
    static char hChar1, vChar1;
    static int ht1, wd1;
    static char answer = 'y';
    static Scanner input1 = new Scanner(System.in);

    // get user to input the width and the character used to draw horizontal lines
    public static void drawHorizontalLine() {
        System.out.print("\nPlease enter width of a box: ");
        wd1 = input1.nextInt();
        input1.nextLine(); // clean the buffer

        System.out.print("\nPlease enter the horizontal charcters to draw box: ");
        hChar1 = input1.nextLine().charAt(0);
    }// end of drawHorizontalLine

    // get user to input the width and the character used to draw vertical line
    public static void drawVerticalLine() {
        System.out.print("\nPlease enter height of a box: ");
        ht1 = input1.nextInt();
        input1.nextLine(); // clean the buffer

        System.out.print("\nPlease enter the vertical charcters to draw box: ");
        vChar1 = input1.nextLine().charAt(0);
    }// end of drawVerticalLine

    // combine drawHorizontalLine() & drawVerticalLine() together and draw a box
    public static void drawBox() {
        do {
            drawHorizontalLine();
            drawVerticalLine();

            for (x = 1; x <= wd1; x++) {
                System.out.print("" + hChar1);
            }
            System.out.print("\n");

            for (x = 1; x <= ht1 - 2; x++) {
                System.out.print("" + vChar1);
                for (y = 1; y <= wd1 - 2; y++) {
                    System.out.print(" ");
                }
                System.out.print("" + vChar1 + "\n");
            }

            for (x = 1; x <= wd1; x++) {
                System.out.print(hChar1);
            }

            System.out.print("\n\n");

            System.out.print("Continue? Type 'y' for yes:");
            answer = input1.nextLine().charAt(0);
        } while (answer == 'y');
        System.out.println("\n\nThank you for using my drawbox program");
    }// end of drawBox

    public static void main(String[] args) {
        // Homework #8.1
        getTemperatures();
        printTemperatures();
        getMax();
        getMin();
        getAverage();
        printStatistics();

        // Homework #8.2
        CodeModification.drawBox();

    }// end of main
}// end of class Homework_8
