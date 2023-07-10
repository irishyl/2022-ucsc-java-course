package Demo;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is solution for Homework#6
 * 
 * All solutions have been put in one place to minimize number of classes
 * 
 * @author hsinyuanlu
 * @version 1.0
 * @since 07-28-2022 Wrote comments, formatted the code
 * 
 */

public class getUserInput {
    //Homework #6.1
    /**
    * @param readInput
    * : Scanner passed from main method
    *
    * A loop is used to continue asking for valid choice. 
    * The nextInt method of scanner is used which throws InputMistatchException if the value is not able to extracted.
    * When the wrong value is entered the input is still in input buffer which is cleared by use of nextLine() & 
    * then the loop starts over requesting user choice. 
    * The valid choice is assigned to intputInt and the new value is returned as the return value from the method
    */
    //// Homework #6.1
    //// Ask users to choose from display menu. Accept only integer and trap errors
    //// Will exit the program only when correct input is successfully entered
    public static void getUserChoice(Scanner readInput) {
        //note 可以不用寫 new Scanner(System.in)
        //// Setup readInput from user
        ////readInput = new Scanner(System.in);
        int choice = 0;
        boolean isCorrectInput = false;

        // display menu and accept input
        System.out.println("Welcome to sorting program" + "\n\n" + "\t1. Title" + "\n" + "\t2. Rank" + "\n"
                + "\t3. Date" + "\n" + "\t4. Stars" + "\n" + "\t5. Likes" + "\n");

        // exit program only when providing correct input
        do {
            // handle non-int inputs. catch invalid input and ask user to re-enter
            System.out.print("Enter your choice between 1 and 5 only: ");
            try {
                choice = readInput.nextInt();

                // if user enters invalid number, ask user to re-enter
                if ((choice >= 1) & (choice <= 5)) {
                    System.out
                            .println("\nYou entered valid choice " + choice + "\nThank you for giving your choice\n\n");
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

    // Homework #6.2
    // Ask users to enter 2 floats. Accept only floats
    // Will exit the program only when correct input is successfully entered
    public static void getTwoFloats(Scanner readInput) {
        //note 可以不用寫 new Scanner(System.in)
        //// Setup readInput from user
        ////readInput = new Scanner(System.in);

        // display menu and accept input
        System.out.println("Welcome to bonus get two floats program" + "\n");

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
                System.out.println("You entered two valid floats: " + value[0] + " and " + value[1]
                        + "\nThank you for giving two floats.\n");
            } catch (InputMismatchException e) {
                System.out.println("You have entered an invalid input. Try again.\n");
                readInput.nextLine(); // clear up old input
                isCorrectInput = false;
            }
        } while (isCorrectInput == false); // Indicate wrong input and would stay in the loop

    }

    // Homework 6.3: combine 6.1 and 6.2
    public static void main(String[] args) {
        Scanner getInput = new Scanner(System.in);
        // Test 6.1
        System.out
                .println("Homework #6.1: Accept only Integers. Ask users to enter again until they enter integers.\n");
        getUserChoice(getInput);

        // Test 6.2
        System.out.println(
                "--------------------------------------------------------------------------------------------");
        System.out
                .println("Homework #5.2: Accept only 2 floats. Ask users to enter again until they enter 2 floats.\n");
        getTwoFloats(getInput);

    }// end of main
}// end of class Homework_6
