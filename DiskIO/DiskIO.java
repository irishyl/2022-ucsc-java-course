import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This is solution for Homework#9
 * 
 * All solutions have been put in one place to minimize number of classes
 * 
 * @author hsinyuanlu
 * @version 1.0
 * @since 09-07-2022 Wrote comments, formatted the code
 * 
 */

public class DiskIO {
    // HW 9.1
    // (1) if command args contains less than two strings -> Usage: java DiskIO
    // inputFile outputFile
    // (2) If the arguments contains input and output file names -> Input will be
    // read from: input_final.txt // Output will be written into: output_final.txt
    public static void processCLArguments(String[] args) {
        if (args.length < 2 || args.length > 2) { // test the length of args
            System.out.println("Usage: java DiskIO inputFile outputFile");
        } else {
            System.out.println("Input will be read from: " + args[0]);
            System.out.println("Output will be written into: " + args[1]);
        }
    } // end of processCLArguments

    // HW 9.2
    public static void processInputOutputFiles(String[] args) {
        // note: need to handle if file does not exsits
        // call method to process command line arguments
        File inputFile = new File(args[0]);
        if (!inputFile.exists()) {
            System.out.println("Input file " + args[0] + " does not exist");
            System.exit(2);
        }

        BufferedReader bufferedReader = null;
        PrintWriter textPrintStream = null;
        String outfileName = args[1];

        try {
            String sCurrentLine;
            int studentCount = 1;
            bufferedReader = new BufferedReader(new FileReader(args[0]));

            textPrintStream = new PrintWriter(new FileOutputStream(outfileName));

            // Process Input
            // Read each line at a time, and display it in console
            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                System.out.printf("Student #: %d %s\n", studentCount, sCurrentLine);

                // Write Output
                // Write into outfileName each line at a time
                StringTokenizer parseUserInput = new StringTokenizer(sCurrentLine, ",");

                int lineCount = 0;
                while (parseUserInput.hasMoreTokens()) {
                    if (lineCount == 0) {
                        textPrintStream.print("Student #" + studentCount + " is: \"" + parseUserInput.nextToken()
                                + "\" whose raw scores are:");
                    } else {
                        textPrintStream.print(parseUserInput.nextToken() + ":");
                    } // end of if-else

                    lineCount++;
                } // end of while

                textPrintStream.println(); // to the second line
                studentCount++;
            } // end of while

        } catch (FileNotFoundException e) {
            e.getMessage();
        } // end of catch
        catch (IOException e) {
            e.getMessage();
        } // end of catch
        catch (Exception e) { // catch all exception
            System.out.println(e);
        } // end of catch
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close(); // close bufferedReader and filereader
                }
            } catch (IOException ex) {
                ex.getMessage();
            }
        }

        textPrintStream.close();// close outputstream

    } // end of processInputOutputFiles

    public static void processInputOutputFiles_ans(String[] args) {
        // call method to process command line arguments
        File inputFile = new File(args[0]);
        if (!inputFile.exists()) {
            System.out.println("Input file " + args[0] + " does not exist");
            System.exit(0);
        }

        // Output file
        // ! Can create a file for you!!!
        File outputFile = new File(args[1]);
        try {
            // Create input and output files
            Scanner input = new Scanner(inputFile);
            PrintWriter output = new PrintWriter(outputFile);
            int i = 1;

            while (input.hasNextLine()) {
                String line = input.nextLine();
                // display the whole line on screen
                System.out.println("Student #: " + i + " " + line);
                // this line has one students data,
                // use split
                String[] studentInfo = line.split(",");

                // write the data in output file
                output.print("Student #" + i++ + " is: \"" + studentInfo[0] + "\" whose raw scores are: ");
                for (int j = 1; j < studentInfo.length; j++) {
                    output.print(studentInfo[j] + ": ");
                }

                output.println(); // one student done
                // give a line feed
            } // end of while

            input.close(); // done with them, close it
            output.close(); // done with them, close it
        } catch (IOException e) {
            System.out.println("Error reading from input file: " + args[0]);
        }
    }

    public static void main(String[] args) {
        processCLArguments(args);
        // processInputOutputFiles(args);
        processInputOutputFiles_ans(args);
    } // end of main
} // end of HW 9

/*
 * HW 9.3
 * a) How do you supply these arguments to your program, and
 * Ans: supply arguments by typing directly in console or set it up in Eclipse
 * as you showed us in the demo video
 * 
 * b) How do you process these arguments in your program
 * Ans: by calling args array. because args is a String array
 */