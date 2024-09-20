//Name: Miguel Stoyke
//Date: May 23rd, 2023
//App Name: AstrologicalZodiacSigns
//Description: App that tells the user what their zodiac sign is based on the month and day of their birthday.

//import java libraries
import java.util.Scanner;

public class AstrologicalZodiacSigns 
{
    public static void main(String[] args) {
        //Constants
        final String SET_TITLE = "\033]0;%s\007";
        final String CLEAR_TERMINAL = "\033c";
        final String INPUT_BANNER="""
            ===============================
            == Astrological Zodiac Signs == 
            ===============================
            
            """;
        final String OUTPUT_BANNER="""
            ===============================
            == Astrological Zodiac Signs == 
            ===============================
                
            """;
        
        //User Input
        Scanner scanner = new Scanner(System.in);

       //Variables
       int indexDates = 0;        
       int month = 0;
       int day = 0;
       int date = 0;
       String inputNumber = " ";
       String spaceError = "Error - Not Numeric or Space not placed between month and day.";
       String numericRangeError = "Error - Not Numeric or Out of Range \nMonth must be between 1 and 12, and Day must be between 1 and 31.";
       boolean valid = true;
       boolean error = false;


        //Set the title
        System.out.printf(SET_TITLE, "Lab 1 - Astrological Zodiac Signs - Miguel Stoyke");
        
        //First do-while loop that prints the welcome message and banner, and prompts the user for the month and day of their birthday in one line
        do
        {
        //Welcome Message
        System.out.print(INPUT_BANNER + "\nThis Program Will Tell You Your Zodiac Sign Based On Your Birthday! ");

        //Prompt for the user's birthday in the form (month day), and stores to variable inputNumber
        System.out.print("Enter Your Birthday (month day): ");
        inputNumber = scanner.nextLine();
        
            //Nested do-while loop that finds the numeric value of the month and day entered by the user. Will not continue code if error is found
            do 
            {
                //Searches for the space between the month, and the day of the user input in order to separate the two values
                indexDates = inputNumber.indexOf(' ');

                //If the values entered have no space between them, it will throw the spaceError code and prompt to exit
                if (indexDates == -1) 
                {
                    if (!error) {
                        System.out.println(spaceError);
                        error = true;
                        System.out.println("Press [enter] to exit: ");
                        scanner.nextLine();
                        System.exit(0);
                    }
        
                    valid = false;
                } 

                //If the input passes the space validation and is numeric, it will begin to convert the input to integers
                else 
                {
                    // Finds numeric values and validates the range, and if the inputs are numeric
                    try
                    {
                        //Converts to int, sets valid to true to pass the validator
                        month = Integer.parseInt(inputNumber.substring(0, indexDates));
                        day = Integer.parseInt(inputNumber.substring(indexDates + 1));
                        valid = true;
                    }
                    catch (Exception e)
                    {
                        //Set valid to false to throw an exception
                        valid = false;
                    }
                    
                    //Validation ranges for the month and day inputs
                    valid = valid && (month >= 1 && month <= 12) && (day >= 1 && day <= 31);
                    
                    //If the input is out of range of the allowed numbers for month and day, and/or is not numeric, it will throw the numericRangeError and prompt to exit
                    if (!valid) {
                        if (!error) {
                            System.out.println(numericRangeError);
                            error = true;
                            System.out.println("Press [enter] to exit: ");
                            scanner.nextLine();
                            System.exit(0);
                        }
                        
                        valid = false;
                    }
                }
            } while (!valid); //Repeat when answer is not valid. 
        
        //Makes it here once validation is passed

        //Merges the month and day variables into one variable named date. Does this by multiplying the month by 100, and adding the day.
        date = month * 100 + day;
        
        //Uses the value from the calculated date variable. Goes through each birthday possibility until it finds the user's birthday, and prints what their zodiac sign is
        //Will clear the terminal and print the output banner no matter which option is true
        //Also prints an ASCII art photo for each Zodiac Sign
        if (date>=321 && date<=419)
        {
            System.out.print(CLEAR_TERMINAL + OUTPUT_BANNER + ASCIIart.ARIES);
            System.out.println("Your Astrological Zodiac Sign based on your birthday (" + month + "/" + day + "): Aries");
        } else if (date >= 420 && date <=520){
            System.out.print(CLEAR_TERMINAL + OUTPUT_BANNER + ASCIIart.TAURUS);
            System.out.println("Your Astrological Zodiac Sign based on your birthday (" + month + "/" + day + "): Taurus");
        } else if (date >= 521 && date <=620){
            System.out.print(CLEAR_TERMINAL + OUTPUT_BANNER + ASCIIart.GEMINI);
            System.out.println("Your Astrological Zodiac Sign based on your birthday (" + month + "/" + day + "): Gemini");
        } else if (date >= 621 && date <=722){
            System.out.print(CLEAR_TERMINAL + OUTPUT_BANNER + ASCIIart.CANCER);
            System.out.println("Your Astrological Zodiac Sign based on your birthday (" + month + "/" + day + "): Cancer");
        } else if (date >= 723 && date <=822){
            System.out.print(CLEAR_TERMINAL + OUTPUT_BANNER + ASCIIart.LEO);
            System.out.println("Your Astrological Zodiac Sign based on your birthday (" + month + "/" + day + "): Leo");
        } else if (date >= 823 && date <=922){
            System.out.print(CLEAR_TERMINAL + OUTPUT_BANNER + ASCIIart.VIRGO);
            System.out.println("Your Astrological Zodiac Sign based on your birthday (" + month + "/" + day + "): Virgo");
        } else if (date >= 923 && date <=1022){
            System.out.print(CLEAR_TERMINAL + OUTPUT_BANNER + ASCIIart.LIBRA);
            System.out.println("Your Astrological Zodiac Sign based on your birthday (" + month + "/" + day + "): Libra");
        } else if (date >= 1023 && date <=1121){
            System.out.print(CLEAR_TERMINAL + OUTPUT_BANNER + ASCIIart.SCORPIO);
            System.out.println("Your Astrological Zodiac Sign based on your birthday (" + month + "/" + day + "): Scorpio");
        } else if (date >= 1122 && date <=1221){
            System.out.print(CLEAR_TERMINAL + OUTPUT_BANNER + ASCIIart.SAGITTARIUS);
            System.out.println("Your Astrological Zodiac Sign based on your birthday (" + month + "/" + day + "): Sagittarius");
        } else if (date >= 1222 || date <=119){
            System.out.print(CLEAR_TERMINAL + OUTPUT_BANNER + ASCIIart.CAPRICORN);
            System.out.println("Your Astrological Zodiac Sign based on your birthday (" + month + "/" + day + "): Capricorn");
        } else if (date >= 120 && date <=218){
            System.out.print(CLEAR_TERMINAL + OUTPUT_BANNER + ASCIIart.AQUARIUS);
            System.out.println("Your Astrological Zodiac Sign based on your birthday (" + month + "/" + day + "): Aquarius");
        } else if (date >= 219 && date <=320){
            System.out.print(CLEAR_TERMINAL + OUTPUT_BANNER + ASCIIart.PISCES);
            System.out.println("Your Astrological Zodiac Sign based on your birthday (" + month + "/" + day + "): Pisces");
        }
        
        //Prompts the user to restart the loop when r is entered
        System.out.print("Enter 'r' to restart: ");

        } while(scanner.nextLine().equals("r"));
        
        //Close the application
        scanner.close();
    }    
}
