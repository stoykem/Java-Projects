import java.util.Random;

public class Horse 
{
    //Private Variables
    private String name;
    private int distanceCovered = 0;
    
    //Generates a new Random object
    static private Random random = new Random();

    /** 
     * Constructor - Create horse as an object
     * @param name (Name of a horse in the race)
    */
    Horse(String name)
    {
        this.name = name;
    }

    /**
     * Getter method that returns the name of a specified horse
     * @return The horse's name
    */
    public String getName()
    {
        return name;
    }

    /**
     * Getter method that returns the distance covered by the specified horse
     * @return The distance the horse covered
    */
    public int getDistanceCovered()
    {
        return distanceCovered;
    }


    /**
     * Sets a 50/50 chance of the horse moving one space in the race
     * Random is only used in this method
     */
    public void run()
    {
        //Assigns a random value between 0 and 1 to a variable
        int randomNum = random.nextInt(1);

        //Checks if the random value is a 0 or a 1 (true or false) AND that it is less than the finish line
        //Adds 1 to distanceCovered if passes
        if (random.nextBoolean() && distanceCovered < HorseRace.FINISH_LINE)
        {
            distanceCovered += 1;
        }

        //Adds the random generated number to distanceCovered
        distanceCovered += randomNum;
    }

    /**
     * Setter method that updates the horse's name with their race progress
     * @param newName (Horse's name with given amount of "." characters)
     */
    public void updateRace(String newName) 
    {
        this.name = newName;
    }
}

