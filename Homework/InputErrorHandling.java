package Homework;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is solution for Homework#5
 * 
 * All solutions have been put in one place to minimize number of classes
 * 
 * @author hsinyuanlu
 * @version 1.0
 * @since 07-20-2022 Wrote comments, formatted the code
 * 
 */

public class InputErrorHandling {
    // Homework #5.1
    // Ask users to choose from display menu. Accept only integer and trap errors
    // Will exit the program only when correct input is successfully entered
    public static void captureIntegerOnly() {
        // Setup readInput from user
        Scanner readInput = new Scanner(System.in);
        int choice = 0;
        boolean isCorrectInput = false;

        // display menu and accept input
        System.out.println("Welcome to sorting program" + "\n\n" + "\t1. Title" + "\n" + "\t2. Rank" + "\n" + "\t3. Date"
                + "\n" + "\t4. Stars" + "\n" + "\t5. Likes" + "\n");

        // exit program only when providing correct input
        do {
            // handle non-int inputs. catch invalid input and ask user to re-enter
            //note: 寫在外面就可以
            System.out.print("Enter your choice between 1 and 5 only: ");
            try {
                //// System.out.print("Enter your choice between 1 and 5 only: "); 
                choice = readInput.nextInt();

                // if user enters invalid number, ask user to re-enter
                if ((choice >= 1) & (choice <= 5)) {
                    System.out.println("\nYou entered valid choice " + choice + "\nThank you for giving your choice");
                    isCorrectInput = true; // Indicate right input and would exit the loop
                } else {
                    System.out.println("You have not entered a number between 1 and 5. Try again.\n");
                    isCorrectInput = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("You have entered an invalid choice. Try again.\n");
                readInput.nextLine(); // clear up old input
                isCorrectInput = false; // Indicate wrong input and would stay in the loop
            }

        } while (isCorrectInput == false);

    }

    // Homework #5.2
    // Ask users to enter 2 floats. Accept only floats
    // Will exit the program only when correct input is successfully entered
    public static void captureFloatsOnly() {
        // Setup readInput from user
        Scanner readInput = new Scanner(System.in);

        // display menu and accept input
        System.out.println("Welcome to two floats program" + "\n\n");

        // handle non-int inputs. catch invalid input and ask user to re-enter
        float[] value = new float[2];
        int i;
        boolean isCorrectInput;
        do {
            System.out.print("Enter two floats separarte by a space: ");
            try {
                for (i = 0; i < 2; i++) {
                    value[i] = readInput.nextFloat();
                }
                isCorrectInput = true; // Indicate right input and would exit the loop
                System.out.println("\nYou entered two valid floats: " + value[0] + " and " + value[1]
                        + "\nThank you for giving two floats.\n");
            } catch (InputMismatchException e) {
                System.out.println("\nYou have entered an invalid input. Try again.\n");
                readInput.nextLine(); // clear up old input
                isCorrectInput = false;
            }
        } while (isCorrectInput == false); // Indicate wrong input and would stay in the loop

    }

    // Homework #5.3
    // Print our weekly temperature and the min/max/average temperature of the week
    public static void calculateWeather() {
        int weeklyTemp[] = { 69, 70, 71, 68, 66, 71, 70 };
        int max = 0, min = 0;
        float total = 0, average;

        // find min temperature
        min = weeklyTemp[0];
        for (int i = 0; i < weeklyTemp.length; i++) {
            if (weeklyTemp[i] < min) {
                min = weeklyTemp[i];
            }
        }

        // find max temperature
        max = weeklyTemp[0];
        for (int j = 0; j < weeklyTemp.length; j++) {
            if (weeklyTemp[j] > max)
                max = weeklyTemp[j];
        }
        // find avg temperature
        for (int k = 0; k < weeklyTemp.length; k++) {
            total += weeklyTemp[k];
        }
        average = total / weeklyTemp.length;

        // Print output
        for (int l = 0; l < weeklyTemp.length; l++) {
            System.out.printf("The temperature on day %d was %d\n", l + 1, weeklyTemp[l]);
        }
        System.out.println();
        System.out.println("The Minimum temperature is: " + min);
        System.out.println("The Maximum temperature is: " + max);
        System.out.printf("The average temperature for the week is: %7.5f", average);
        System.out.println("\n\nThank you for using my homework #5 solution");
    }

    public static void main(String[] args) {
        // Homework #5.1
        System.out
                .println("Homework #5.1: Accept only Integers. Ask users to enter again until they enter integers.\n");
        captureIntegerOnly();

        // Homework #5.2
        System.out.println(
                "--------------------------------------------------------------------------------------------");
        System.out
                .println("Homework #5.2: Accept only 2 floats. Ask users to enter again until they enter 2 floats.\n");
        captureFloatsOnly();

        // Homework #5.3
        System.out.println(
                "--------------------------------------------------------------------------------------------");
        System.out.println("Homework #5.3: Print our weekly temperature and the min/max/average temperature");
        calculateWeather();

    }// end of main
}// end of class Homework_5
