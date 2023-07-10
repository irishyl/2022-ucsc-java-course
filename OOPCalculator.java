import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the solution for Homework#7
 * 
 * Everything has been put into one place to class - OOPCalculator - as
 * instructed.
 * 
 * @author hsinyuanlu
 * @version 1.0
 * @since 08-028-2022 Wrote comments, formatted the code
 * 
 */

public class OOPCalculator {
    // ! instance variables need to remain private.
    // ! Scanner 放 class attribute
    private Scanner getInput = new Scanner(System.in);
    private char menuChoice;
    private float[] value = new float[2]; // Assign user's input to variable.

    // ! 養成寫 constructor 的習慣
    // constructor, does nothing
    public OOPCalculator() {
    }

    /**
     * @param: not used
     *             A loop is used to continue asking for valid menu choice.
     *             First check the length of user's input to avoid the situation of
     *             user enters wrong input but first char accidentally matches.
     *             Valid inputs are from 1 to 5 or ‘A’, ‘a’, ‘S’, ‘s’, ‘M’, ‘m’,
     *             ‘D’,
     *             ‘d’, ‘X’, ‘x’
     *             If otherwise, ask user to re-enter.
     *             When captured error, use nextLine() to clear up the input buffer
     *             and
     *             then the loop starts over requesting user choice.
     *             The valid menu choice is assigned to menuChoice (class variable)
     */
    // note: 要怎麼不用 parse 的方式拿所有 menu choice? -- 用 char, + switch -> 見 answer
    // note: Scanner 要是 class variable 嗎? when to close Scanner?
    public char askCalcChoice() {
        // Scanner getInput = new Scanner(System.in);
        boolean isCorrectInput = false;

        // Print Welcome Message
        System.out.printf("%s\n\n\t%s\n\t%s\n\t%s\n\t%s\n\t%s\n\n%s", "Welcome to Hsin-Yuan's Handy Calculator",
                "1. Addition", "2. Substraction", "3. Multiplication", "4. Division", "5. Exit",
                "What would you like to do? ");

        // Get user to choose which calculation they want to enter.
        // Valid inputs are from 1 to 5 or ‘A’, ‘a’, ‘S’, ‘s’, ‘M’, ‘m’, ‘D’, ‘d’, ‘X’,
        // ‘x’
        // If otherwise, ask user to re-enter.
        do { // Loop until we have correct input.
            String userInput = getInput.next(); // Waits for user input.

            // 1st check: check if user enters length = 1 input.
            // Because I'm parsing String for the first char, it is possible the parsed
            // first char would be a valid inputs while user didn't enter correctly.
            if (userInput.length() > 1) {
                System.out.print("You have entered an invalid choice, please re-enter your choice: ");
                getInput.nextLine(); // clear up old input
                isCorrectInput = false; // Wrong input. Continue in loop and ask for re-enter.
            } else {
                // 2nd Check if user enter's valid inputs
                menuChoice = userInput.charAt(0);

                if ((menuChoice == '1' || menuChoice == '2' || menuChoice == '3' || menuChoice == '4'
                        || menuChoice == '5' || menuChoice == 'A' || menuChoice == 'a' || menuChoice == 'S'
                        || menuChoice == 's' || menuChoice == 'M' || menuChoice == 'm' || menuChoice == 'D'
                        || menuChoice == 'd' || menuChoice == 'X' || menuChoice == 'x')) {
                    isCorrectInput = true; // Right input. Exit the loop.
                } else {
                    System.out.print("You have entered an invalid choice, please re-enter your choice: ");
                    getInput.nextLine(); // clear up old input
                    isCorrectInput = false; // Wrong input. Continue in loop and ask for re-enter.
                }
            }
        } while (isCorrectInput != true);

        return menuChoice;
    }// end of askCalcChoice

    /**
     * @param: not used
     *             A loop is used to continue asking for valid calculation
     *             choice.
     *             The nextInt method of scanner is used which throws
     *             InputMistatchException if the value is not able to
     *             extracted.
     *             If user choose '4'/'D'/'d' - division- for menuChoice
     *             and enter '0' for second input, display 'Divide by Zero'
     *             message and ask user to re-enter.
     *             When captured error, use
     *             nextLine() to clear up the input buffer and then the loop
     *             starts over requesting user choice.
     *             The valid menu choice
     *             is assigned to float[]value and the new value is returned
     *             as the return value from the method
     */
    public float[] askTwoValues() {
        // Scanner getInput = new Scanner(System.in);
        boolean isCorrectInput = false;

        // Based on different menChoice, display different calculation message
        if (menuChoice == '1' || menuChoice == 'A' || menuChoice == 'a') {
            System.out.print("\nPlease enter two floats to add, separarte by a space: ");
        } else if (menuChoice == '2' || menuChoice == 'S' || menuChoice == 's') {
            System.out.print("\nPlease enter two floats to substract, separarte by a space: ");
        } else if (menuChoice == '3' || menuChoice == 'M' || menuChoice == 'm') {
            System.out.print("\nPlease enter two floats to multiply, separarte by a space: ");
        } else if (menuChoice == '4' || menuChoice == 'D' || menuChoice == 'd') {
            System.out.print("\nPlease enter two floats to divide, separarte by a space: ");
        }

        // Verify if user enters valid input, continue in loop until we have correct
        // input.
        do {
            try {
                for (int i = 0; i < 2; i++) {
                    value[i] = getInput.nextFloat(); // Waits for user input.
                }

                // User cannot divide by zero. Ask for re-enter
                if ((menuChoice == '4' || menuChoice == 'D' || menuChoice == 'd') && value[1] == 0.0) {
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
    }// end of askTwoValues

    /**
     * @param: not used
     *             calculate the results of values
     */
    public void displayResults() {
        // Scanner getInput = new Scanner(System.in);

        float firstFloat = value[0];
        float secondFloat = value[1];
        float result = 0;

        // display calculation result
        if (menuChoice == '1' || menuChoice == 'A' || menuChoice == 'a') {
            result = firstFloat + secondFloat;
            System.out.printf("Results of adding %5.2f and %5.2f is %5.2f \n", firstFloat, secondFloat, result);
        } else if (menuChoice == '2' || menuChoice == 'S' || menuChoice == 's') {
            result = firstFloat - secondFloat;
            System.out.printf("Results of substracting %5.2f and %5.2f is %5.2f \n", firstFloat, secondFloat, result);
        } else if (menuChoice == '3' || menuChoice == 'M' || menuChoice == 'm') {
            result = firstFloat * secondFloat;
            System.out.printf("Results of multiplying %5.2f and %5.2f is %5.2f \n", firstFloat, secondFloat, result);
        } else if (menuChoice == '4' || menuChoice == 'D' || menuChoice == 'd') {
            result = firstFloat / secondFloat;
            System.out.printf("Results of dividing %5.2f and %5.2f is %5.2f \n", firstFloat, secondFloat, result);
        }

        System.out.println("\nPress enter key to continue...");
        getInput.nextLine(); // this will wait for user to press enter if they type something before pressing
                             // enter that is fine
    }

    public void displayBye() {
        System.out.println("\nThank you for using Hsin-Yuan's Handy Calculator.\n");
    }

    public static void main(String[] args) {
        // ! the best OOP are those where you create the object first by providing all
        // the inputs it needs in through constructors (pass the parameters in the
        // constructors).

        OOPCalculator calc = new OOPCalculator();
        while (calc.askCalcChoice() != '5') { // it will set choice
            calc.askTwoValues(); // it will set two values
            calc.displayResults(); // do calc, display result
            // and wait on press enter key
        }
        calc.displayBye(); // thanks the user for using and waits for press enter key
    }// end of main
}// end of Calculator
