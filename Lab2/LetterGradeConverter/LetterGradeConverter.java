//Name: Miguel Stoyke
//Date: June 13th, 2023
//App Name: Lab 2 - Letter Grade Converter (LetterGradeConverter.java, Grade.java)
//Description: Takes a grade percentage, converts to respective letter grade, and gives feedback

import java.util.Scanner;

/** 
 * main class, the one we compile
 * **/
public class LetterGradeConverter
{
    //Constants
    static Scanner scanner = new Scanner(System.in);
    static final String SET_TITLE = "\033]0;%s\007";
    static final String CLEAR_TERMINAL = "\033c";
    static final String BANNER = """
    +-+-+-+-+-+-+-+-+-+-+-+-+-
    | Letter Grade Converter |
    +-+-+-+-+-+-+-+-+-+-+-+-+-
    """;


    /** The entry point of the Java app, the app starts and ends here. **/
    public static void main(String[] args) 
    {
        //Variables
        float percentage;
        String restart="";
        String letterGrade="";

        //Set the title
        System.out.printf(SET_TITLE, "Letter Grade Converter - Miguel Stoyke");

        System.out.println(CLEAR_TERMINAL + BANNER);

        //Main loop - runs at least once, restarts when prompted for the user to press 'r'
        do
        {
            /*Input Screen -------------------------------------------------------------------------------------------------------------------------------------------*/

            //Prompts user for their grade percentage
            System.out.print("\nEnter your grade percentage: ");

            //Calls getPercentage() and getLetter() and sets their values to a variable
            percentage = Grade.getPercentage(scanner);
            letterGrade = Grade.getLetter(percentage);

            /*Output Screen -------------------------------------------------------------------------------------------------------------------------------------------*/

            //Clears terminal, and prints banner
            System.out.println(CLEAR_TERMINAL + BANNER);
            //After validation is passed and methods are called, the percentage, letter grade, and feedback are printed for the user
            System.out.println("A grade of " + percentage + "% " + "is equivalent to " + letterGrade + " which is considered " + Grade.getFeedback(letterGrade) + "!");

            //Prompts the user to restart the app
            System.out.print("\nPress [r] to restart : ");
            restart = scanner.next();
            scanner.nextLine(); 
        } while(restart.equals("r"));

        scanner.close();

    }

}
