public class TestLetterGrader {
    public static void main(String[] args) {

        // test if there are two vaild args
        // yes, create the LetterGrader object; no, exit
        if (args.length < 2 || args.length > 2) { 
            System.out.println("Usage: java LetterGrader inputFile outputFile." + "\nPlease provide 2 valid file name.");
            System.exit(1);
        }

        // Create LetterGrader Object
        LetterGrader letterGrader = new LetterGrader(args[0], args[1]); // args[0] is input file name, args[1] is output file name
        letterGrader.readScore(); // reads score and stores the data in member variable
        letterGrader.calcLetterGrade(); // determines letter grade and  stores information
        letterGrader.printGrade(); // writes the grade in output file 
        letterGrader.displayAverages(); // displays the averages in console
        letterGrader.doCleanup(); // use it to close files and other resources
    }
}
