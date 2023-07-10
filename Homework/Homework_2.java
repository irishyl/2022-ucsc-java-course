package Homework;
import java.util.Scanner;

/**
 * This is solution for Homework#2
 * 
 * All solutions have been put in one place to minimize
 * number of classes
 * 
 * The solution combines what was done in homework #6.1 in separate class
 * In this solution the solutions of homework #6.2 is combined in one class
 * and tested from one main method.
 * 
 * @author bineetsharma
 * @version 1.0
 * @since 03-1-20NN
 * 
 * @version 1.1
 * @since 12-21-20NN
 *        Wrote comments, formatted the code and eliminated need for continue
 *        statement
 * 
 */

public class Homework_2 {
    // exercise# 2.1
    public static void excercise_2_1() {
        int radius = 2;
        double area;
        final double PI = 3.142;

        area = PI * radius * radius;

        System.out.print("The area is: " + area);
    }

    // exercise# 2.2
    public static void excercise_2_2() {
        int radius;
        double PI; // final static constants use ALL_CAPS
        double area;

        Scanner readInput = new Scanner(System.in);
        System.out.println();

        System.out.print("Enter the radius: ");
        radius = readInput.nextInt();
        System.out.print("Enter the pi: ");
        PI = readInput.nextDouble();

        area = PI * radius * radius;

        System.out.println("The area is: " + area);
        readInput.close();
    }

    // exercise# 2.3
    public static void excercise_2_3() {
        Scanner readInput = new Scanner(System.in);
        System.out.print("What is your First Name? ");
        String firstName = readInput.nextLine();

        System.out.print("What is your Last Name? ");
        String lastName = readInput.nextLine();

        System.out.print("Which city do you live? ");
        String City = readInput.nextLine();

        System.out.print("What is the city zip code? ");
        int Zip = readInput.nextInt();

        System.out.println();
        System.out.printf("5185 is fun course.\n\n");
        System.out.printf("First Name \t Last Name \t City \t Zip\n");
        System.out.printf("----------- \t --------- \t --- \t ---\n");
        System.out.print(firstName + "\t" + lastName + "\t" + City + "\t" + Zip);
        System.out.printf("\n");
        System.out.println();
        System.out.printf("How do you print double quotes?\n");
        System.out.printf("Who said\"Test Scores Can Be Used ....\"\n");

        readInput.close();

    }

    public static void main(String[] args) {

        excercise_2_1();
        excercise_2_2();
        excercise_2_3();

    }
}