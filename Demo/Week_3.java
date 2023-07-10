package Demo;
import java.util.Scanner;

public class Week_3 {
    /*
     * (1) Compound Assignment, Increment/Decrement, Operator Precedence
     * (2) Control Statement: if, if/else, switch, conditional, while, do..while,
     * for loops
     */
    public static void week_3_1() {
        /*
         * Learning objectives: compound assign operators
         */
        int N1, N2;
        N1 = 10;
        N2 = 3;
        N1 = N1 + N2;
        N1 += N2; // add N2 to the old value of N2 then assign it to N1
        N1 *= N2 + 5; // N1 = N1*(N2+5) -> operator precedence
        System.out.println(N1);
    }

    public static void week_3_2() {
        /*
         * Learning objectives: (1)increment operator (2)position affect (3)how it is
         * used in a function
         */
        int N1, N2;
        N1 = 9;
        System.out.printf("%d\n", N1++); // 9 (post increment operator)
        System.out.printf("%d\n\n", N1); // 10

        N2 = 9;
        System.out.printf("%d\n", ++N2); // 10 (pre increment operator)
        System.out.printf("%d\n\n", N2); // 10
    }

    public static void week_3_3() {
        /*
         * Learning objectives: (1)increment operator (2)position affect (3)how it is
         * used in a function
         */
        int loop = 8, count = 15, Num;
        Num = +loop++;
        System.out.printf("Num = %d, loop = %d, count = %d\n", Num, loop, count); // Num=8, loop=9,count=15
        Num = ++Num;
        System.out.printf("Num = %d, loop = %d, count = %d\n", Num, loop, count); // Num=9, loop=9,count=15
        Num = count++ + loop;
        System.out.printf("Num = %d, loop = %d, count = %d\n", Num, loop, count); // Num=24, loop=9, count=16
        Num = --count + --loop;
        System.out.printf("Num = %d, loop = %d, count = %d\n", Num, loop, count); // Num=23, loop=8, count=15
        Num = loop + -Num;
        System.out.printf("Num = %d, loop = %d, count = %d\n", Num, loop, count); // Num=-15, loop=8, count=15

    }

    public static void week_3_4() {
        /*
         * Learning objectives: operator precedence & Associativity
         */
        int n1 = 3, n2 = 2, n3 = 2;
        if (n1 * 5 * 3 - 4 * n2 * n3 - 14 * 2 >= 0) // ()3*5*3)-(4*2*2)-(14*2)=45-16-28=1
            System.out.printf("It is true\n");
        else
            System.out.printf("It is false\n");
    }

    // Control Statement
    // nested if
    public static void week_3_5() {
        // given an age, determine if the person is a teenager (20>age>12)
        int age;
        Scanner getInput = new Scanner(System.in);
        System.out.print("Please enter your age: ");
        age = getInput.nextInt();

        // check if user is a teenager
        if (age > 12) { // alternative: if(age > 12 && age <20)
            if (age < 20) {
                System.out.println("You are a teenager.");
            } else {
                System.out.println("You are an adult.");
            }
        } else {
            System.out.println("You are a child");
        }
        getInput.close();
    }

    // if-elseif ladder
    public static void week_3_6() {
        // given a score to find out if the student go A, B, C, D or F Grade
        // depending upon sliding scale of +90 A, 80-89 B, 70-79 C, 60-60 D, <59 F
        // ! cannot use 'Switch' bc it's not int or char, it's ranges
        int score;
        Scanner getInput = new Scanner(System.in);
        System.out.print("Enter your score: ");
        score = getInput.nextInt();

        // start checking score using if-elseif ladder
        if (score >= 90) {
            System.out.println("Your grade is 'A'");
        } else if (score >= 80) { // no need to write if(score >= 80 && score < 90) 因為到 else if 的時候就已經排除 90 了
            System.out.println("Your grade is 'B'");
        } else if (score >= 70) {
            System.out.println("Your grade is 'C'");
        } else if (score >= 60) {
            System.out.println("Your grade is 'D'");
        } else {
            System.out.println("Your grade is 'F'");
        }
        getInput.close();
    }

    // switch
    public static void week_3_7() {
        // performs arithmetic calculation
        float firstN;
        float secondN;
        char op;

        Scanner getInput = new Scanner(System.in);
        System.out.print("Type a number, operator, number -- Separate by a space: ");
        firstN = getInput.nextFloat();
        op = getInput.next().charAt(0);
        secondN = getInput.nextFloat();

        switch (op) {
            case '+':
                System.out.printf("%5.2f + %5.2f = %5.2f ", firstN, secondN, firstN + secondN);
                break;
            case '-':
                System.out.printf("%5.2f - %5.2f = %5.2f", firstN, secondN, firstN - secondN);
                break;
            case '*':
                System.out.printf("%5.2f * %5.2f  = %5.2f", firstN, secondN, firstN * secondN);
                break;
            case '/':
                System.out.printf("%5.2f / %5.2f = %5.2f", firstN, secondN, firstN / secondN);
                break;
            case '%':
                System.out.printf("%5.2f %% %5.2f = %5.2f", firstN, secondN, firstN % secondN);
                break;
            default:
                System.out.println("Unknown operator.");
        }
        getInput.close();

    }

    // use switch in ranges: teenager case
    public static void week_3_8() {
        // 20 > teenager >= 12
        int age;
        Scanner getInput = new Scanner(System.in);
        System.out.print("Please Enter your age: ");
        age = getInput.nextInt();

        switch (age) {
            case 13: // 如果沒有 break 就會一直往下執行，值到遇到 break 才停止。=> 運用 break 的特性讓 input = 13~19 都會產出 19 的
                     // output
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                System.out.println("You are a teenager.");
                break;
            default:
                System.out.println("You are not a teenager");
        }

        getInput.close();
    }

    // ternary operator: conditional
    public static void week_3_9() {
        // 用 ternary 取代 if/else
        int max;
        int firstN;
        int secondN;
        Scanner getInput = new Scanner(System.in);
        firstN = getInput.nextInt();
        secondN = getInput.nextInt();

        max = (firstN > secondN) ? firstN : secondN; // if expression is true, execute "firstN", else execute "secondN"
        System.out.println("The max number of the two is: " + max);

        getInput.close();
    }

    // while
    public static void week_3_10() {
        /*
         * Let us write a program to create a box
         * of 20 columns width and 10 columns height
         * using while loop. Use ‘_’ and ‘|’ for line.
         */

        int i = 0; // for _
        int x = 0; // for |

        while (i++ < 20) {
            System.out.print("_");
        }
        System.out.println();
        while (x++ < 10) {
            System.out.printf("%18s%s", "|", "|\n");
            // %18s = 總共要是18個字，如果string內容只有"|"(一個字)，其他用空白補。先填空白再填string
            // %-18s = 同上，先填string再填空白
            // 如果要讓 user 自行定義輸出箱子的大小，把18寫進去不易改變
        }
        i = 0;
        while (i++ < 20) {
            System.out.print("_");
        }
    }

    public static void main(String[] args) {

        // week_3_1();
        // week_3_2();
        // week_3_3();
        // week_3_4();
        // week_3_5();
        // week_3_6();
        // week_3_7();
        // week_3_8();
        // week_3_9();
        week_3_10();

    }
}