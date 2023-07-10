import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * This is solution for Final
 * 
 * All solutions have been put in one place to minimize number of classes
 * 
 * @author hsinyuanlu
 * @version 1.0
 * @since 09-10-2022 Wrote comments, formatted the code
 * 
 */

public class LetterGrader {
    // Member(Class) Variables
    private String infileName;
    private String outfileName;
    private ArrayList<ArrayList<String>> inputInfoList = new ArrayList<>();
    private ArrayList<ArrayList<String>> calcGradeList = new ArrayList<>();
    private double ttlQ1 = 0;
    private double ttlQ2 = 0;
    private double ttlQ3 = 0;
    private double ttlQ4 = 0;
    private double ttlMid1 = 0;
    private double ttlMid2 = 0;
    private double ttlFinal = 0;
    private double averageQ1;
    private double averageQ2;
    private double averageQ3;
    private double averageQ4;
    private double averageMid1;
    private double averageMid2;
    private double averageFinal;
    private int minQ1 = 999;
    private int minQ2 = 999;
    private int minQ3 = 999;
    private int minQ4 = 999;
    private int minMid1 = 999;
    private int minMid2 = 999;
    private int minFinal = 999;
    private int maxQ1 = 0;
    private int maxQ2 = 0;
    private int maxQ3 = 0;
    private int maxQ4 = 0;
    private int maxMid1 = 0;
    private int maxMid2 = 0;
    private int maxFinal = 0;
    private Scanner readInput = new Scanner(System.in);

    // Constructors
    // get inputFileName and outputFileName from user
    public LetterGrader(String infileName, String outfileName) {
        this.infileName = infileName;
        this.outfileName = outfileName;
    }// end of LetterGrader constructor

    // Method
    // read input file scores and stores the data in member variables
    public void readScore() {
        /*
         * 1 - check if inputfile name passed by user exists.
         * yes - program continues to read inputs; no - program exits
         */
        File inputFile = new File(infileName);
        if (!inputFile.exists()) {
            System.out.println("Input file " + infileName + " does not exist");
            System.exit(0);
        }
        /*
         * 2 - Process Input
         * Read each line at a time, parse each line by delimiter, and clear spaces
         * before scores
         * Stores each line in an arraylist (var: studentInfoList).
         * Store all lines(var: studentInfoList) into a 2D arraylist (var:
         * inputInfoList)
         */
        try {
            Scanner input = new Scanner(inputFile);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] studentInfo = line.split(",");
                ArrayList<String> studentInfoList = new ArrayList<>();

                // parse and store each elements of a line
                for (int i = 0; i < studentInfo.length; i++) {
                    if (i == 0) {
                        studentInfoList.add(studentInfo[i]);
                    } else { // clear spaces before scores
                        studentInfoList.add(studentInfo[i].replaceAll("\\s+", ""));
                    }
                } // end of for loop

                // Store all lines into a 2D arraylist(var: inputInfoList)
                // [[Name1, Score1, Score2,..], [Name2, Score1, Score2,..]... ]
                inputInfoList.add(studentInfoList);

            } // end of while

            input.close(); // done with them, close it
        } catch (IOException e) {
            e.getMessage();
        } // end of catch
        catch (Exception e) { // catch all exception
            System.out.println(e);
        } // end of catch
    }// end of readScore

    // determines and stores letter grade, max, min, avg
    public void calcLetterGrade() {

        for (int i = 0; i < inputInfoList.size(); i++) {
            // temporarly stores and cast scores
            int tmpQ1 = Integer.parseInt(inputInfoList.get(i).get(1));
            int tmpQ2 = Integer.parseInt(inputInfoList.get(i).get(2));
            int tmpQ3 = Integer.parseInt(inputInfoList.get(i).get(3));
            int tmpQ4 = Integer.parseInt(inputInfoList.get(i).get(4));
            int tmpMid1 = Integer.parseInt(inputInfoList.get(i).get(5));
            int tmpMid2 = Integer.parseInt(inputInfoList.get(i).get(6));
            int tmpFin = Integer.parseInt(inputInfoList.get(i).get(7));

            // 1-calculate letter grade and stores in calcGradeList
            double finalScore;
            String letterGrade = null;
            ArrayList<String> studentGradeList = new ArrayList<>();
            // calculate letter grade
            finalScore = tmpQ1 * 0.1 + tmpQ2 * 0.1 + tmpQ3 * 0.1 + tmpQ4 * 0.1 + tmpMid1 * 0.2 + tmpMid2 * 0.15
                    + tmpFin * 0.25;
            if (finalScore >= 90)
                letterGrade = "A";
            else if (finalScore >= 80 && finalScore < 90)
                letterGrade = "B";
            else if (finalScore >= 70 && finalScore < 80)
                letterGrade = "C";
            else if (finalScore >= 60 && finalScore < 70)
                letterGrade = "D";
            else if (finalScore <= 59)
                letterGrade = "F";
            // add student name & leter grade to calcGradeList
            // calcGradeList = [[Name1, LetterGrade], [Name2, LetterGrade]...]
            studentGradeList.add(inputInfoList.get(i).get(0));
            studentGradeList.add(letterGrade);
            calcGradeList.add(studentGradeList);

            // 2-calculate max
            if (maxQ1 < tmpQ1)
                maxQ1 = tmpQ1;
            if (maxQ2 < tmpQ2)
                maxQ2 = tmpQ2;
            if (maxQ3 < tmpQ3)
                maxQ3 = tmpQ3;
            if (maxQ4 < tmpQ4)
                maxQ4 = tmpQ4;
            if (maxMid1 < tmpMid1)
                maxMid1 = tmpMid1;
            if (maxMid2 < tmpMid2)
                maxMid2 = tmpMid2;
            if (maxFinal < tmpFin)
                maxFinal = tmpFin;

            // 3-calculate min
            if (minQ1 > tmpQ1)
                minQ1 = tmpQ1;
            if (minQ2 > tmpQ2)
                minQ2 = tmpQ2;
            if (minQ3 > tmpQ3)
                minQ3 = tmpQ3;
            if (minQ4 > tmpQ4)
                minQ4 = tmpQ4;
            if (minMid1 > tmpMid1)
                minMid1 = tmpMid1;
            if (minMid2 > tmpMid2)
                minMid2 = tmpMid2;
            if (minFinal > tmpFin)
                minFinal = tmpFin;

            // 4-calculate total
            ttlQ1 += tmpQ1;
            ttlQ2 += tmpQ2;
            ttlQ3 += tmpQ3;
            ttlQ4 += tmpQ4;
            ttlMid1 += tmpMid1;
            ttlMid2 += tmpMid2;
            ttlFinal += tmpFin;

        } // end of for-loop

        // 5-calculate avg
        averageQ1 = ttlQ1 / inputInfoList.size();
        averageQ2 = ttlQ2 / inputInfoList.size();
        averageQ3 = ttlQ3 / inputInfoList.size();
        averageQ4 = ttlQ4 / inputInfoList.size();
        averageMid1 = ttlMid1 / inputInfoList.size();
        averageMid2 = ttlMid2 / inputInfoList.size();
        averageFinal = ttlFinal / inputInfoList.size();
    }// end of calcLetterGrade

    // writes the grade in output file
    public void printGrade() {
        // Sort letter grade by name
        Collections.sort(calcGradeList, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> o1, ArrayList<String> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        // Creare output file
        File outputFile = new File(outfileName);
        try {
            PrintWriter output = new PrintWriter(outputFile);

            // write the data in output file
            output.println(
                    "Letter grade for " + calcGradeList.size() + " students given in " + infileName + " file is: \n");
            for (int i = 0; i < calcGradeList.size(); i++) {
                output.printf("%-40s %s\n", calcGradeList.get(i).get(0) + ":", calcGradeList.get(i).get(1));
            }

            output.close(); // done with them, close it
        } catch (IOException e) {
            e.getMessage();
        } // end of catch
        catch (Exception e) { // catch all exception
            System.out.println(e);
        } // end of catch
    }// end of printGrade

    // displays the averages in console
    public void displayAverages() {
        System.out.println("Letter grade has been calculated for students listed in input file " + infileName
                + " and written to output file " + outfileName);
        System.out.println();
        System.out.println("Here's the class averages:");
        System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s\n", " ", "Q1", "Q2", "Q3", "Q4", "MidI", "MidII",
                "Final");
        System.out.printf("%10s %10.2f %10.2f %10.2f %10.2f %10.2f %10.2f %10.2f \n", "Average:", averageQ1, averageQ2,
                averageQ3, averageQ4, averageMid1, averageMid2, averageFinal);
        System.out.printf("%10s %10d %10d %10d %10d %10d %10d %10d \n", "Minimum:", minQ1, minQ2, minQ3, minQ4, minMid1,
                minMid2, minFinal);
        System.out.printf("%10s %10d %10d %10d %10d %10d %10d %10d \n", "Maximum:", maxQ1, maxQ2, maxQ3, maxQ4, maxMid1,
                maxMid2, maxFinal);
        System.out.println();
        System.out.print("Press ENTER to continue...");
        readInput.nextLine();

    }// end of displayAverages

    // use it to close files and other resources
    public void doCleanup() {
        readInput.close();
    }// end of doCleanup

}// end of LetterGrader
