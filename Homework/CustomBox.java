package Homework;
import java.util.Scanner;

/**
 * This is solution for Homework#4
 * 
 * All solutions have been put in one place to minimize number of classes
 * 
 * @author hsinyuanlu
 * @version 1.0
 * @since 07-14-2022 Wrote comments, formatted the code
 * 
 */

public class CustomBox { // meaningful class names
    // Homework #4.1
    // (a) 10 times: i starts from 0 to 9 -> execute 10 times
    // (b) 9 times: i starts from 1 to 9 -> execute 9 times
    // (c) 0 times:
    // i will be 9 after running loop #b. ++i makes i 10 at the beginning of loop
    // #c, therefore would not execute loop #c

    // Homework #4.2
    public static void drawBoxWithWhile() {
        // draw a box using while loop as instructed
        // breaking the program into 3 parts: draw top line, draw middle lines, draw
        // bottom line
        int width = 20;
        int height = 8;

        // draw top line
        int count = 0;
        while (count++ < width) {
            System.out.print("-");
        }
        System.out.println();
        // draw middle lines
        count = 0;
        int count2 = 0;
        while (count2++ < height) {
            System.out.print("|");
            while (count++ < width - 2) {
                System.out.print(" ");
            }
            System.out.println("|");
            count = 0;
        }
        // draw botton line
        count = 0;
        while (count++ < width) {
            System.out.print("-");
        }
        System.out.println();
    }

    // Homework #4.3
    public static void drawBoxWithDoWhile() {
        // draw a box using loop. same as 4.2 but this time use "do-while" loop
        int width = 20;
        int height = 8;

        // draw top line
        int count = 0;
        do {
            System.out.print("-");
        } while (++count < width);
        System.out.println();

        // draw middle lines
        count = 0;
        int count2 = 0;

        do {
            System.out.print("|");
            do {
                System.out.print(" ");
            } while (++count < width - 2);
            System.out.println("|");
            count = 0;
        } while (++count2 < height);

        // draw bottom line
        count = 0;
        do {
            System.out.print("-");
        } while (++count < width);
        System.out.println();

    }

    // Homework #4.4
    public static void drawBoxWithFor() {
        // draw a box using loop. same as 4.2 but this time use "do-while" loop
        int width = 20;
        int height = 8;

        // draw top line
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println();

        // draw middle lines
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < (width - 2); j++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }

        // draw bottom line
        for (int i = 0; i < width; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    // Homework #4.5 & 4.6
    // draw a box, and ask user for inputs(height, width, characters to draw)

    // a method for drawing Horizontal line for the box
    static void drawHline(int h, String hStr) {
        for (int i = 0; i < h; i++) {
            System.out.print(hStr);
        }
    }

    // a method for drawing Vertical line for the box
    static void drawVline(int h, int v, String vStr) {
        for (int i = 0; i < v; i++) {
            System.out.print(vStr);
            drawHline(h - 2, " ");
            System.out.println(vStr);
        }
    }

    // a method for drawing a box combining 'drawHline' and 'drawVline' method
    static void drawBox(int h, int v, String hStr, String vStr) {
        drawHline(h, hStr);
        System.out.println();
        drawVline(h, v, vStr);
        drawHline(h, hStr);
        System.out.println();
    }

    public static void main(String[] args) {
        // Homework #4.2: draw a box using while loop
        drawBoxWithWhile();

        // Homework #4.3: draw a box using do-while loop
        drawBoxWithDoWhile();

        // Homework #4.4: draw a box using for loop
        drawBoxWithFor();

        // Homework #4.5: draw a box, and ask user for inputs(height, width, characters
        // to draw)

        Scanner readInput = new Scanner(System.in);
        System.out.println("Please enter hsize, vsize, hStr, vStr (separate by enter): ");
        int hsize = readInput.nextInt();
        int vsize = readInput.nextInt();
        String hString = readInput.next();
        String vString = readInput.next();
        drawBox(hsize, vsize, hString, vString);

        // Homework #4.6: base on HW4.5, extend this and ask user if they want to
        // continue
        char count;
        do {
            // ask for box's attribute & draw a box
            System.out.println("Please enter hsize, vsize, hStr, vStr (separate by enter): ");
            hsize = readInput.nextInt();
            vsize = readInput.nextInt();
            hString = readInput.next();
            vString = readInput.next();
            drawBox(hsize, vsize, hString, vString);

            // ask if user wants to continue. If enters 'y' then continue, else break
            System.out.println("Press 'y' to continue: ");
            count = readInput.next().charAt(0);
        } while (count == 'y');
        System.out.println("Thank you for using my program");

    }// end of main
}// end of class Homework_4
