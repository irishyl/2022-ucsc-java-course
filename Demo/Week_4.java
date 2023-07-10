package Demo;
import java.util.Scanner;

public class Week_4 {
    /*
     * (1) Arrays
     */
    public static void findTemperature() {
        /*
         * Learning objectives: arrays
         */
        int temperature[];
        temperature = new int[7];
        Scanner readInput = new Scanner(System.in);
        int maxTemperature;
        int minTemperature;
        float sumTemperature = 0;
        float avgTemperature;

        // store input
        System.out.println(temperature.length);
        for (int i = 0; i < temperature.length; i++) {
            System.out.print("Enter the temp: ");
            temperature[i] = readInput.nextInt();
        }

        // find min
        minTemperature = temperature[0];
        for (int j = 0; j < temperature.length; j++) {
            if (temperature[j] < minTemperature) {
                minTemperature = temperature[j];
            }
        }

        // find max
        maxTemperature = temperature[0];
        for (int k = 0; k < temperature.length; k++) {
            if (temperature[k] > maxTemperature)
                maxTemperature = temperature[k];
        }
        // find avg
        for (int l = 0; l < temperature.length; l++) {
            sumTemperature += temperature[l];
        }
        avgTemperature = sumTemperature / temperature.length;

        for (int m = 0; m < temperature.length; m++) {
            System.out.printf("The temperature on day %d was %d\n", m + 1, temperature[m]);
            // System.out.println("The temperature on day " + (m+1) + " was " +
            // temperature[m]);
        }
        System.out.println();
        System.out.println("The Minimum temperature is: " + minTemperature);
        System.out.println("The Maximum temperature is: " + maxTemperature);
        System.out.printf("The average of weekly temperature is: %5.2f", avgTemperature);

    }

    public static void demoString() {
        // Character manipulation is also availale (methods)
        // Character class as static methods
        // isDigit
        char c = 'a';
        if (Character.isDigit(c)) {
            System.out.printf("%c is a digit\n", c);
        } else {
            System.out.printf("%c is not a digit\n", c);
        }

        // String Method
        String myString = "  My name is Iris  ";
        String yourString = "Hello Iris";
        String herString = "hello iris";

        // length(), charAt(), indexOf(), substring
        System.out.printf("My String is as big as %d\n", myString.length());
        System.out.printf("The character at position %d is %c\n", 6, myString.charAt(6));
        System.out.printf("The first occurence of character %c is at %d position\n", ' ', myString.indexOf(' '));
        System.out.printf("The part of the string starting at index %d is: %s\n", 5, myString.substring(5));

        // toUppercase, toLowervase
        System.out.printf("The uppercase of \"%s\" is: %s\n", myString, myString.toUpperCase());
        System.out.printf("The Lowercase of \"%s\" is: %s\n", myString, myString.toLowerCase());

        // trim()
        System.out.printf("The trimmed version of \"%s\" is: %s\n", myString, myString.trim());

        // compare string -- should not use '==', strings are pointing at references
        if (herString.equals(yourString))
            System.out.println("They are equal");
        else
            System.out.println("They are not equal");

        if (herString.equalsIgnoreCase(yourString))
            System.out.println("They are equal");
        else
            System.out.println("They are not equal");

        // compare string: compare to -- 0:equal / 1:bigger / -1:smaller (in ASCII
        // table)
        if (herString.compareTo(yourString) > 0)
            System.out.println("Her String is greater");
        else if (herString.compareTo(yourString) < 0)
            System.out.println("Her String is smaller");
        else
            System.out.println("They are equal");
    }

    /*
     * (2) Method
     */
    public static void myMethod(String fname) { 
        System.out.println(fname + " Refsnes");
    }

    // find temperature using method
    public static void getTemperature(int temparray[]) {
        Scanner readInput = new Scanner(System.in);
        for(int day = 0; day < temparray.length; day++){
            System.out.printf("Enter the temperature: ");
            temparray[day] = readInput.nextInt();
        }
        readInput.close();
    }
    // print temp
    public static void printTemperature(int temparray[]){
        for(int day=0; day<temparray.length; day++) {
            System.out.printf("The temperature on day %d was %d\n", day + 1, temparray[day]);
        }
    }
    // find min
    public static int getMinimum(int [] temparray){
        int min = temparray[0];
        for (int day=0; day<temparray.length; day++) {
            if (temparray[day] < min) {
                min = temparray[day];
            }
        }
        return min;
    }
    // find max
    public static int getMaxium(int [] temparray){
        int max = temparray[0];
        for (int day=0; day<temparray.length; day++){
            if(max < temparray[day]){
                max = temparray[day];
            }
        }
        return max;
    }
    // find total
    public static int getTotal(int [] temparray){
        int sum = 0;
        for(int day=0; day<temparray.length; day++){
            sum += (double) temparray[day];
        }
        return sum;
    }

    /*
     * (3) DrawBox
     */
    static void drawHline(int h, String hStr){
        for(int i=0; i<h; i++){
            System.out.print(hStr);
        }
    }

    static void drawVline(int h, int v, String vStr, String fStr){
        for(int i=0; i<v; i++){
            System.out.print(vStr);
            drawHline(h-2, fStr);
            System.out.println(vStr);
        }
    }

    static void drawBox(int h, int v, String hStr, String vStr, String fStr){
        drawHline(h, hStr);
        System.out.println();
        drawVline(h, v, fStr, vStr);
        drawHline(h, hStr);
        System.out.println();
    }

    public static void main(String[] args) {

        // findTemperature();
        // demoString();
        // myMethod("Iris");
        
        // findTemperature using methods
        /* 
        int weeklytemp[] = new int[7];
        getTemperature(weeklytemp);
        printTemperature(weeklytemp);
        System.out.println("The Minimum temperature is: " + getMinimum(weeklytemp));
        System.out.println("The Maximum temperature is: " + getMaxium(weeklytemp));
        System.out.printf("The average of weekly temperature is: %5.2f", getTotal(weeklytemp)/7.0);
        */

        
        // Drawbox
        Scanner readInput = new Scanner(System.in);
        System.out.println("Please enter hsize, vsize, hStr, vStr, hStr2 (separate by enter): ");
        int hsize = readInput.nextInt();
        int vsize = readInput.nextInt();
        String hString = readInput.next();
        String vString = readInput.next();
        String fillerStr = readInput.next();
        //System.out.printf("%d %d %s %s", hsize,vsize, hString,vString);

        drawBox(hsize, vsize, hString, vString, fillerStr);
        
        
        // week_4_4();
        


    }
}
