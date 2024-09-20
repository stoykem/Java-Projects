//Name: Miguel Stoyke
//Date: July 11th, 2023
//App name: Horse Race (HorseRace.java)
//Description: This app simulates the system of an animal shelter and which allows us to register 3 animals

import java.util.Scanner;
import java.lang.Thread;

/** 
 * Main Class
 **/
public class HorseRace 
{
    //Constants
    public static final int HALF_SECOND = 500; //milliseconds
    public static final int FINISH_LINE = 20;
    static final String SET_TITLE = "\033]0;%s\007";
    static final String CLEAR_TERMINAL = "\033c";
    static final String BANNER = """
    ~~~~~~~~~~~~~~~~~~~~
    |||| Horse Race ||||
    ~~~~~~~~~~~~~~~~~~~~      
    """;

    //User Input
    static Scanner scanner = new Scanner(System.in);

    /** Main Running Method **/
    public static void main(String[] args) 
    {
        //Set the title
        System.out.printf(SET_TITLE, "Horse Race - Miguel Stoyke");

        //Print the Banner
        System.out.println(BANNER);

        //Local Variables
        boolean racing = true;

        //Creates an array of horse objects with the size of 5, and assigns default names to each one
        Horse[] racingHorses = new Horse[5];
            racingHorses[0] = new Horse("Butterscotch");
            racingHorses[1] = new Horse("Carrot");
            racingHorses[2] = new Horse("Shadow");
            racingHorses[3] = new Horse("Champ");
            racingHorses[4] = new Horse("Spots");

        //Will keep running as long as the horses meet the racing conditions 
        while (racing)
        {
            //Clears terminal to update race
            System.out.println(CLEAR_TERMINAL + BANNER);

            //Calls drawDistanceLine from a for loop to ensure it iterates up to 20 times
            for (int index = 0; index < FINISH_LINE; index++)
            {
                drawDistanceLine(racingHorses);
            }

            //Race completion validation
            //Ensures that the code will continue to run until at least one horse reaches the finish line

            //Runs through horse object indexes
            for(int index2 = 0; index2 < racingHorses.length; index2++)
            {
                //Temporary horse object to iterate through the race
                Horse racingHorse = racingHorses[index2];

                //Checks to see if a horse finished the race
                if (racingHorse.getDistanceCovered() >= FINISH_LINE)
                {
                    //Stops the race, prints the winner
                    racing = false;
                    System.out.println(racingHorses[index2].getName() + " is the winner!");
                    break;
                }
            }
        }

        //Exit Prompt
        System.out.println("Press [Enter] to exit: ");
        scanner.nextLine();
        scanner.close();
    }
    /** Stops the code temporarily in 500 millisecond intervals
     * stops code execution for half a second
    **/
    public static void waitHalfSecond()
    {
        try
        {
            Thread.sleep(HALF_SECOND);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /** Receives Horse object as a parameter, and draws line of '.' characters to represent the race
     * @return an array of Horse objects in a race
    **/
    public static void drawDistanceLine(Horse[] racingHorses) 
    {
        //Resets the terminal through each iteration of the race and prints a border
        System.out.print(CLEAR_TERMINAL + BANNER);
        System.out.println("========================");

        //Calls the run method to assign random racing speeds
        for (int index3 = 0; index3 < racingHorses.length; index3++) 
        {
            racingHorses[index3].run();
        }

        //Matches the distance covered by printing a "." as each distanceCovered is updated
        for (int index4 = 0; index4 < racingHorses.length; index4++) 
        {
            //Calls getDistanceCovered to retrieve a value, starts printing race progress based on the random values
            String raceProgress = "";
            int distanceCovered = racingHorses[index4].getDistanceCovered();
            for (int index5 = 0; index5 < distanceCovered; index5++) 
            {
                raceProgress += ".";
            }
        //Prints the race progress with the horse's name following
        System.out.println(raceProgress + racingHorses[index4].getName());
        }
    
    //Bottom of the border
    System.out.println("========================");
    //Calls waitHalfSecond for a 500 millis delay between the race progress iterations
    waitHalfSecond();

    }
}
