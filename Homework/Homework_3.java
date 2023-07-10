package Homework;
import java.util.Scanner;

/**
 * This is solution for Homework#3
 * 
 * All solutions have been put in one place to minimize number of classes
 * 
 * @author hsinyuanlu
 * @version 1.0
 * @since 06-29-2022 Wrote comments, formatted the code
 * 
 */

public class Homework_3 { // 建議改成 UserInputs
    // Homework #3.1
    public static void getTeenager() {
        // categorize users input(age) to kid(<13), teenager(13<=age<=19) or adult(>19)
        int yourAge;
        Scanner readInput = new Scanner(System.in);
        System.out.printf("How old are you?: ");
        yourAge = readInput.nextInt();

        if (yourAge > 19) {
            System.out.println("You are an adult.");
        } else if (yourAge >= 13) {
            System.out.println("You are a teenager.");
        } else {
            System.out.println("You are a kid");
        }
    }

    // Homework #3.2
    public static void doCalculation() {
        // perform a calculator program which accepts user inputs in decimal.
        // user can continuosly run the program until they want to stop.

        double firstN;
        double secondN;
        char operator;
        char checkProgramStop;

        Scanner readInput = new Scanner(System.in);
        do {
            System.out.printf("Type a number, operator, number --" + "separated by a space: ");

            firstN = readInput.nextDouble();
            operator = readInput.next().charAt(0);
            secondN = readInput.nextDouble();

            if (operator == '+') {
                System.out.printf("%f + %f = %f", firstN, secondN, firstN + secondN);
            } else if (operator == '-') {
                System.out.printf("%f - %f = %f", firstN, secondN, firstN - secondN);
            } else if (operator == '*') {
                System.out.printf("%f * %f = %f", firstN, secondN, firstN * secondN);
            } else if (operator == '/') {
                System.out.printf("%f / %f = %f", firstN, secondN, firstN / secondN);
            } else if (operator == '%') {
                System.out.printf("%f %% %f = %f", firstN, secondN, firstN % secondN);
            } else {
                System.out.printf("Unknown operator");
            }

            // always good to flush the buffer, which still has '\n' character due to
            // pressing enter
            readInput.nextLine();

            System.out.println("\n");
            System.out.printf("Do you want to continue?(Y/N) ");
            checkProgramStop = readInput.next().charAt(0);

        } while (checkProgramStop == 'Y' || checkProgramStop == 'y');

    }

    // Homework #3.3
    public static void findMaxNumber() {
        // find the max of three numbers
        // users can input values and continuosly run the program until they want to
        // stop.
        int a;
        int b;
        int c;
        int max;
        char checkProgramStop;

        Scanner readInput = new Scanner(System.in);

        do {
            System.out.println("Enter three integer numbers to find the max of them--separated by a space: ");
            a = readInput.nextInt();
            b = readInput.nextInt();
            c = readInput.nextInt();

            if (a > b) {
                max = a;
                if (max > c) {
                    System.out.println("The Max is: " + max);
                } else {
                    max = c;
                    System.out.println("The Max is: " + max);
                }
            } else {
                max = b;
                if (max > c) {
                    System.out.println("The Max is: " + max);
                } else {
                    max = c;
                    System.out.println("The Max is: " + max);
                }
            }

            // Alternative way
            // max = (firstN > secondN) ? (firstN > thirdN) ? firstN : thirdN
            // : (secondN > thirdN) ? secondN : thirdN;

            System.out.print("\nContinue? Type 'y' for yes: ");
            checkProgramStop = readInput.next().charAt(0);
        } while (checkProgramStop == 'y');

        System.out.println("Thank you for using my max program.");
    }

    public static void main(String[] args) {
        getTeenager();
        doCalculation();
        findMaxNumber();
    }// end of main
} // end of class Homework_3