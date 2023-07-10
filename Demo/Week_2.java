package Demo;

import java.util.Scanner;

public class Week_2 {
    /*
     * (1)Input From User, Formatted Output to the User
     * (2)Primitive Data Types, Usage
     * (3)Assignment, Arithmetic, Relational, Logical
     */

    public static void week_2_1() {
        /*
         * Example 1: fixed input
         */
        int radius = 3;
        double area;
        final double pi = 3.142; // final means the variable -pi- cannot be overwrite. Meaning you cannot assign
                                 // a new value (e.g 3.2) to "pi"

        area = pi * radius * radius;
        System.out.print("The area is: ");
        System.out.println(area);
    }

    public static void week_2_2() {
        /*
         * Example 2: user enters input package (util.Scanner)
         */
        double area;
        final double pi = 3.142;

        Scanner readInput = new Scanner(System.in);

        System.out.print("Please enter the radius ");
        int radius = readInput.nextInt();

        area = pi * radius * radius;
        System.out.print("The area of your radius is: ");
        System.out.println(area);

        readInput.close();
    }

    public static void week_2_3() {
        /*
         * Learning Objectives: formatting in printf
         */
        double area;
        final double pi = 3.142;

        Scanner readInput = new Scanner(System.in);

        System.out.print("Please enter the radius ");
        int radius = readInput.nextInt();

        area = pi * radius * radius;
        System.out.printf("The area of radius %d is: %5.3f \nI am done", radius, area);
        readInput.close();
    }

    public static void main(String[] args) {
        week_2_1();
        week_2_2();
        week_2_3();

    }
}
