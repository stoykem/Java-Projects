import java.util.Scanner;

public class Grade 
{
    /** 
     * Validate user inputted grade percentage using a recursive method
     * @param scanner Reads the user input directly from the scanner
     * @return getPercentage(scanner) - recursive call when error found, percentage - user's validated grade 
     * **/
    static float getPercentage(Scanner scanner)
    {
        //Variables
        float percentage; 

        //Validates if input is numeric, and if input is within range - between 0 and 100 percent
        try
        {
            //Sets user input to a string variable
            String percentageString = scanner.nextLine();
            //Attempts to parse the user input as a float value
            percentage = Float.parseFloat(percentageString);

            //Checks if the percentage entered is within range, and returns its value if it passes validation
            if (percentage >=0 && percentage <= 100)
            {
                return percentage;
            }
            //If value does not pass range validation, the code spits an error code, and calls the method again with a prompt
            else 
            {
                System.out.println("Error - Grade percentage must be between 0 and 100 percent!\n");
                //Re-prints the prompt
                System.out.print("\nEnter your grade percentage: ");
                return getPercentage(scanner);
            }
        }
        //If value does not pass numeric validation, the code spits an error code, and calls the method again with a prompt 
        catch (Exception e)
        {
            System.out.println("Error - Grade percentage must be numeric!\n");
            //Re-prints the prompt
            System.out.print("\nEnter your grade percentage: ");
            return getPercentage(scanner);
        }
        
    }

    /** 
     * Assigns a letter grade value to the user inputted grade
     * @param percentage takes in the user inputted percentage to determine letter grade
     * @return corresponding letter grade
     * **/
    static String getLetter (float percentage)
    {
        //Searches through all percentage possibilities to determine the right letter grade
        if (percentage >= 90 && percentage <= 100)
            return "A+";
        else if (percentage >= 85 && percentage <= 89)
            return "A";
        else if (percentage >= 80 && percentage <= 84)
            return "A-";
        else if (percentage >= 75 && percentage <= 79)
            return "B+";
        else if (percentage >= 70 && percentage <= 74)
            return "B";
        else if (percentage >= 65 && percentage <= 69)
            return "B-";
        else if (percentage >= 60 && percentage <= 64)
            return "C";
        else if (percentage >= 55 && percentage <= 59)
            return "D+";
        else if (percentage >= 50 && percentage <= 54)
            return "D-";
        //If the input validates and does not meet any of the above conditions, it means the grade is a fail
        else 
            return "F";
    }

    /** 
     * Assigns the respective feedback message based on the letter grade the program selected
     * @param letterGrade uses the letter grade to determine its corresponding message
     * @return letter grade feedback
     * **/
    static String getFeedback (String letterGrade)
    {
        //Iterates through each letter grade possibility, and displays the corresponding message when it finds its match
        switch (letterGrade)
        {
            case "A+":
                return "Outstanding";
            case "A":
                return "Exemplary";
            case "A-":
                return "Excellent";
            case "B+":
                return "Very Good";
            case "B":
                return "Good";
            case "B-":
                return "Satisfactory";
            case "C":
                return "Acceptable";
            case "D+":
                return "Conditional Pass";
            case "D-":
                return "Conditional Pass";
            //If the input validates and does not meet any of the above conditions, it means the grade is a fail
            default:
                return "Fail";
        }
    }
}
