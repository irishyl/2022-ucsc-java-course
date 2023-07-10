
/**
* The OPPCalculator class has two number fields and one string field. It also has methods to
* fill in the two number, get operation, perform an operation on the numbers, and say goodbye
* @author Todd Law
*
*/
import java.util.Scanner;
import java.util.InputMismatchException;

//Change name of your .java file to OOPCalculator.java (otherwise this will not compile as
//class name and file name not matchine. I named file so that it is easy for you to spot it is
//solutio of your homework#9
public class OOPCalculator_answer {
    // ! Scaneer 放 global
    // ! OOP instance 要放 private
    private Scanner readInput = new Scanner(System.in);
    private float num1 = 0.0f; // First Number
    private float num2 = 0.0f; // Second Number
    private String ops = ""; // Possible values will be "Adding", "Subtracting",
    // "Multiplying", "Dividing", and "Exit"
    
    // constructor - does nothing
    public OOPCalculator_answer() {
    }

    // start of method to ask for operation
    public int askCalcChoice(){
        char userInput;
        int choice_number = 0;
        boolean loop = true;

        do { // Loop until we have valid operation input
            System.out.println("Welcome to Todd Law's Handy Calculator\n");
            System.out.println("1. (A)ddition\n2. (S)ubtraction\n3. (M)ultiplication\n4.(D)ivision\n5. E(x)it\n");
            System.out.print("What would you like to do? ");
            try {
                userInput = readInput.next().charAt(0); // Reads in user input
                switch (userInput){
                    case '1':
                    case 'A':
                    case 'a':
                        ops = "Adding";
                        choice_number = 1;
                        loop = false;
                        break;
                    case '2':
                    case 'S':
                    case 's':
                        ops = "Subtracting";
                        choice_number = 2;
                        loop = false;
                        break;
                    case '3':
                    case 'M':
                    case 'm':
                        ops = "Multiplying";
                        choice_number = 3;
                        loop = false;
                        break;
                    case '4':
                    case 'D':
                    case 'd':
                        ops = "Dividing";
                        choice_number = 4;
                        loop = false;
                        break;
                    case '5':
                    case 'X':
                    case 'x':
                        ops = "Exit";
                        choice_number = 5;
                        loop = false;
                        break;
                    default:
                        loop = true;
                        System.out.println("You have not entered a number between 1 and 5 or (A, S, M, D, X) . Try again.");
                        break;
                } // end of switch
            } catch (final InputMismatchException e) { // catch exception for invalid entry
                System.out.println("You have entered an invalid input. Try again.");
                readInput.next(); // discard invalid input
                continue; // keep looping until you found right one
            } // end of try
        } while (loop);
        return choice_number;
    } // end of method askCalcChoice()
        // Method to prompt for number and read into array

    public void askTwoValues() {
        float inputFloat1, inputFloat2; // local temporary float variables
        int successful_numbers_read;
        // number of successful reads. Used to determine number of reads needed

        do { // Loop until we have correct input
            successful_numbers_read = 0;
            System.out.printf("Please enter two numbers, you are %s,", ops);
            System.out.print(" separated by space: ");

            try {
                inputFloat1 = readInput.nextFloat(); // reads in first number
                successful_numbers_read += 1;
                inputFloat2 = readInput.nextFloat(); // reads in second number

                if (inputFloat2 != 0) {
                    break; // Got two valid numbers, breaking out of loop
                } else if (ops == "Dividing") { // catch for dividing by zero
                    System.out.println("You can't divide by zero. Try again.");
                    continue; // continue looping due to divide by zero issue
                }
            } catch (final InputMismatchException e) {
                System.out.println("You have entered an invalid input. Try again.");
                readInput.next(); // discard non-float input
                if (successful_numbers_read == 0) {
                    // if statement for the case when the first input is invalid
                    readInput.next(); // discards second number
                }
                continue; // keep looping until you you get valid inputs
            }
        } while (true); // end of do-while loop
        num1 = inputFloat1;
        num2 = inputFloat2;
    } // end of askTwoValues() method
      // Method to perform operation given operator and values

    public void displayResults() {
        float results = 0.0f;
        System.out.printf("Results of %s ", ops);
        // switch to print the proper operation and results
        switch (ops) {
            case "Adding":
                results = num1 + num2;
                break;
            case "Subtracting":
                results = num1 - num2;
                break;
            case "Multiplying":
                results = num1 * num2;
                break;
            case "Dividing":
                results = num1 / num2;
                break;
            default: // this should never happen since the number has already been
                // verified but put in just as a precaution
                break;
        } // end of switch

        System.out.printf(" %.2f and %.2f is %.2f\n", num1, num2, results);
        // Print results with two digits after the decimal point

        readInput.nextLine(); // reads in line before prompting to hit enter
        System.out.println("Press Enter to continue ..");
        while (!readInput.nextLine().equals("")); // loops until enter is hit
    } // end of method displayResults()
      // Method to display goodbye

    public void displayBye() {
        readInput.nextLine(); // reads in line before prompting to hit enter
        System.out.println("Thanks for using Todd Law's Calculator, press enter to end");
        while (!readInput.nextLine().equals("")); // loops until only enter is hit
    } // end of displayBye Method
      // this is the main to test the OOPCalculator. This code can be used from any
      // other file

    public static void main(String args[]) {
        OOPCalculator_answer calc = new OOPCalculator_answer();
        while (calc.askCalcChoice() != 5) { // it will set choice
            calc.askTwoValues(); // it will set two values
            calc.displayResults(); // do calc, display result
            // and wait on press enter key
        }
        calc.displayBye(); // thanks the user for using and waits for press enter key
    }
} // end of class OOPCalculator
