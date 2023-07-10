package Homework;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the solution for Midterm Calculator
 * 
 * Everything has been put into one place to class - Calculator - as instructed.
 * 
 * @author hsinyuanlu
 * @version 1.0
 * @since 08-03-2022 Wrote comments, formatted the code
 * 
 */

public class Calculator {
    /**
     * @param getInput: Scanner passed from main method
     * 
     *                  A loop is used to continue asking for valid menu choice. The
     *                  nextInt method of scanner is used which throws
     *                  InputMistatchException if the value is not able to
     *                  extracted. If user enters beyond 1-5, if/else statement will
     *                  handle and ask user to re-enter When captured error, use
     *                  nextLine() to clear up the input buffer and then the loop
     *                  starts over requesting user choice. The valid menu choice is
     *                  assigned to intputInt and the new value is returned as the
     *                  return value from the method
     */
    public static int getUserChoice(Scanner getInput) {
        int inputInt = 0; // Assign user's input to variable.
        boolean isCorrectInput = false;

        do { // Loop until we have correct input.
            try {
                inputInt = getInput.nextInt(); // Waits for user input.

                // Verify if user enters a valid number.
                if ((inputInt >= 1) && (inputInt <= 5)) {
                    isCorrectInput = true; // Right input. Exit the loop.
                } else {
                    System.out.print("You have not entered a number between 1 and 5, please re-enter your choice: ");
                    isCorrectInput = false; // Wrong input. Continue in loop and ask for re-enter.
                }
            } catch (InputMismatchException e) {// Cannot extract user input, capture error and ask for re-enter.
                System.out.print("You have entered an invalid choice, please re-enter your choice: ");
                getInput.nextLine(); // clear up old input
                isCorrectInput = false; // Wrong input. Continue in loop and ask for re-enter.
            }
        } while (isCorrectInput != true);
        return inputInt;
    }// end of getUserChoice

    /**
     * @param getInput:   Scanner passed from main method
     * @param menuChoice: Scanner passed from main method
     * 
     *                    A loop is used to continue asking for valid calculation
     *                    choice. The nextInt method of scanner is used which throws
     *                    InputMistatchException if the value is not able to
     *                    extracted. If user choose '4' - devision- for menuChoice
     *                    and enter '0' for second input, display 'Divide by Zero'
     *                    message and ask user to re-enter. When captured error, use
     *                    nextLine() to clear up the input buffer and then the loop
     *                    starts over requesting user choice. The valid menu choice
     *                    is assigned to float[]value and the new value is returned
     *                    as the return value from the method
     */
    public static float[] getUserCalInput(Scanner getInput, int menuChoice) {
        float[] value = new float[2]; // Assign user's input to variable.
        boolean isCorrectInput = false;

        // Based on different menChoice, display different calculation message
        switch (menuChoice) {
            case 1:
                System.out.print("\nPlease enter two floats to add, separarte by a space: ");
                break;
            case 2:
                System.out.print("\nPlease enter two floats to substract, separarte by a space: ");
                break;
            case 3:
                System.out.print("\nPlease enter two floats to multiply, separarte by a space: ");
                break;
            case 4:
                System.out.print("\nPlease enter two floats to divide, separarte by a space: ");
                break;
        }

        // Verify if user enters valid input, continue in loop until we have correct
        // input.
        do {
            try {
                for (int i = 0; i < 2; i++) {
                    value[i] = getInput.nextFloat(); // Waits for user input.
                }

                // User cannot divide by zero. Ask for re-enter
                if (menuChoice == 4 && value[1] == 0.0) {
                    System.out.print("You can't divide by zero, please re-enter both floats: ");
                    getInput.nextLine(); // clear up old input
                } else {
                    isCorrectInput = true; // Right input. Exit the loop.
                }

            } catch (InputMismatchException e) {// Cannot extract user input, capture error and ask user to re-enter.
                System.out.print("You have entered invalid floats, please re-enter: ");
                getInput.nextLine(); // clear up old input
                isCorrectInput = false; // Wrong input. Continue in loop and ask for re-enter.
            }
        } while (isCorrectInput == false);

        return value;
    }// end of getUserCalInput




    public static void main(String[] args) {
        // Declare Scanner here and passed where it is needed
        Scanner readInput = new Scanner(System.in);

        boolean isExitChoice = false;

        // Start of the Calculator. Continue in calculation loop until user wants to
        // exit (enters 5)
        do {
            // Print Welcome Message
            System.out.printf("%s\n\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\n%s", "Welcome to Hsin-Yuan's Handy Calculator",
                    "1. Addition", "2. Substraction", "3. Multiplication", "4. Division", "5. Exit",
                    "What would you like to do? ");

            // Get user to choose which calculation they want to enter. Valid inputs are
            // from 1 to 5; otherwise will ask user to re-enter.
            int menuChoice = getUserChoice(readInput);

            // Start Calculator
            if (menuChoice != 5) { // if user enters 5 - exit - then will exit the program; otherwise continue to
                                   // do calculation.

                // User enters numbers to calculate. Valid inputs are integers/floats; otherwise
                // will ask user to re-enter.
                float[] calInput = getUserCalInput(readInput, menuChoice);
                float calFloat1 = calInput[0];
                float calFloat2 = calInput[1];
                float result;

                // display calculation result
                switch (menuChoice) {
                    case 1: // addition
                        result = calFloat1 + calFloat2;
                        System.out.printf("Results of adding %5.2f and %5.2f is %5.2f \n", calFloat1, calFloat2,
                                result);
                        break;
                    case 2: // substraction
                        result = calFloat1 - calFloat2;
                        System.out.printf("Results of substracting %5.2f and %5.2f is %5.2f \n", calFloat1, calFloat2,
                                result);
                        break;
                    case 3: // multiplication
                        result = calFloat1 * calFloat2;
                        System.out.printf("Results of multiplying %5.2f and %5.2f is %5.2f \n", calFloat1, calFloat2,
                                result);
                        break;
                    case 4: // division
                        result = calFloat1 / calFloat2;
                        System.out.printf("Results of dividing %5.2f and %5.2f is %5.2f \n", calFloat1, calFloat2,
                                result);
                        break;
                }
                System.out.println("\nPress enter key to continue...");
                readInput.nextLine(); // clear old input
                readInput.nextLine(); // this will wait for user to press enter if they type something before
                                        // pressing enter that is fine

            } else { // if menu choice = 5, exit the program
                System.out.println("\nThank you for using Hsin-Yuan's Handy Calculator.\n");
                isExitChoice = true;
            }

        } while (isExitChoice == false);

        readInput.close(); // we are done with scanner, now we can safely close it.
    }// end of main
}// end of Calculator
