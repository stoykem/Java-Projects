//Name: Miguel Stoyke
//Date: July 18th, 2023
//App name: Presto Card Simulator
//Description: This app is a basic simulation of a "Presto Card" feature as seen in transit stations

import java.util.ArrayList;
import java.util.Scanner;

public class Machine 
{
    //Constants
    static final double FARE = 2.50; //Fixed amount deduction
    static final String SET_TITLE = "\033]0;%s\007";
    static final String CLEAR_TERMINAL = "\033c";
    static final String ERROR_TEXT_RED = "\u001B[31m"; //Researched quick ANSI code for modifying text colour
    static final String TEXT_GREEN = "\u001B[32m";
    static final String TEXT_RESET = "\u001B[0m";
    static final String BANNER = """
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
    .-/__|_|______________________| |___|||||___|O|____|_|__\\---.   
    |    |-|PRESTO CARD         | | | |         |_|    |-|      |     
    |  __|-|____________________|_| |_|_________|_|____|-|__.   |
    |_/<_>=<_>\\_________/<_>=<_>\\_|=|_|<_>=<_>|_____|<_>=<_>|___|
=======================================================================
    """;
 
    //User Input
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) 
    {
        //Variables
        boolean running = true;
        boolean numeric = true;
        boolean cardTapped = false;
        String command = "";
        String newUser = "";
        double newBalance = 0;
        int cardID = 0;
        double topUpValue = 0;

        //Generate an empty ArrayList of Presto Cards
        ArrayList<PrestoCard> cards = new ArrayList<PrestoCard>();

        //To modify the balance when a card is tapped/topped up
        PrestoCard tempCard;

        //Add PrestoCard objects to the ArrayList created
        cards.add(new PrestoCard(5.00, "Miguel"));
        cards.add(new PrestoCard(12.00, "John"));
        cards.add(new PrestoCard(3.00, "Alex"));

        //Main CLI loop - will stop when the user enters "quit"
        do
        {
            //Clear the Terminal
            System.out.print(CLEAR_TERMINAL);

            //Set the title
            System.out.printf(SET_TITLE, "Presto Card - Miguel Stoyke");

            //Print the Banner
            System.out.print(TEXT_GREEN + BANNER + TEXT_RESET);
            System.out.print("Program That Simulates"); 
            System.out.print(TEXT_GREEN + " Presto Cards\n\n" + TEXT_RESET);
 
            //How many cards
            System.out.print("We currently have ");
            System.out.print(TEXT_GREEN + cards.size() + TEXT_RESET);
            System.out.print(" cards!\n");
 
            //Print all cards
            for (int index = 0; index < cards.size(); index++)
            {
                //1 - Name - Balance: $1.00
                //%d - digits(int), %s - string, %f - float
                System.out.printf("%d - %s - Balance: $%.2f \n", index+1, cards.get(index).getName(), cards.get(index).getBalance());
            }

            //Spacing
            System.out.println();

            //Prompt user for a command
            System.out.print(TEXT_GREEN + "Enter Command: " + TEXT_RESET);
            command = scanner.next();

            //Check if the command is quit
            if(command.equalsIgnoreCase("quit"))
            {
                running = false;
            }

            //Check if the command is to add a new card and initial balance
            else if (command.equalsIgnoreCase("add"))
            {
                //Get the name and initial balance to create a new Presto Card
                newUser = scanner.next();

                try
                {
                    newBalance = scanner.nextDouble();
                    //Balance is numeric
                    numeric = true;
                }
                catch(Exception e)
                {
                    numeric = false;
                }

                //Make sure the balance is valid before adding the new card
                //The lowest balance can be 0.01 (1 cent)
                if(numeric && newBalance >= 0.01)
                {
                    cards.add(new PrestoCard(newBalance, newUser));
                    System.out.println("Welcome " + newUser);

                    waitASecond();
                    waitASecond();
                }
                else
                {
                    System.out.println(ERROR_TEXT_RED + "Error - Invalid Initial Balance" + TEXT_RESET);
                }
            }
            //Checks if the command is del
            else if(command.equalsIgnoreCase("del"))
            {
                try
                {
                    cardID = scanner.nextInt();
                    numeric = true;
                }
                catch(Exception e)
                {
                    numeric = false;
                }

                //Error if the card ID is not in the valid range
                if(!numeric || cardID > cards.size() || cardID < 1)
                {
                    System.out.println(ERROR_TEXT_RED + "Error - Enter a valid ID" + TEXT_RESET);
                }
                //Deletes the card if the ID is validated
                else
                {
                    //ID = index
                    cards.remove(cardID - 1); 
                }
            }

            //Checks if the command is tap
            else if(command.equalsIgnoreCase("tap"))
            {
                try
                {
                    cardID = scanner.nextInt();
                    numeric = true;
                }
                catch (Exception e)
                {
                    numeric = false;
                }

                //Error if the card ID is not in the valid range
                if(!numeric || cardID > cards.size() || cardID < 1)
                {
                    System.out.println(ERROR_TEXT_RED + "Error - Enter a valid ID" + TEXT_RESET);
                }
                //Taps the card and deducts the fare if the ID is validated
                else
                {
                    //Sets the temporary object to the index of the selected card
                    tempCard = cards.get(cardID - 1);
                    //cardTapped is true when tap(FARE) is true
                    cardTapped = tempCard.tap(FARE);

                    //Tells the user the tap was successful as long as there is an available balance, 
                    //and gives them an update on their balance
                    if(cardTapped)
                    {
                        System.out.printf("Payment Successful \nNew Balance: $%.2f", tempCard.getBalance());
                    }
                    else
                    {
                        System.out.printf(ERROR_TEXT_RED + "Insufficient Funds Available" + TEXT_RESET);
                    }
                }

            }
            else if (command.equalsIgnoreCase("topup"))
            {
                try
                {
                    cardID = scanner.nextInt();
                    numeric = true;
                }
                catch(Exception e)
                {
                    numeric = false;
                }

                //Error if the card ID is not in the valid range
                if(!numeric || cardID > cards.size() || cardID < 1)
                {
                    System.out.println(ERROR_TEXT_RED + "Error - Enter a valid ID" + TEXT_RESET);
                }

                else
                {
                    //Sets the temporary object to the index of the selected card
                    tempCard = cards.get(cardID - 1);

                    //Tests if the topUpValue is numeric 
                    try
                    {
                        //Assigns the amount typed in to the balance added to the account
                        topUpValue = scanner.nextDouble();
                        tempCard.topUp(topUpValue);
                        numeric = true;

                        //Checks to make sure the user is topping up at least one cent, otherwise prints an error
                        if (topUpValue < 0.01)
                        {
                            System.out.println(ERROR_TEXT_RED + "Error - Top up must be $0.01 or higher" + TEXT_RESET);
                        }
                        else
                        {
                            System.out.printf("Balance Updated Successfully \nNew Balance: $%.2f", tempCard.getBalance());
                        }
                    }
                    catch (Exception e)
                    {
                        System.out.println(ERROR_TEXT_RED + "Error - Invalid Value" + TEXT_RESET);
                        numeric = false;
                    }
                }
            }
            else if (command.equalsIgnoreCase("history"))
            {
                try
                {
                    cardID = scanner.nextInt();
                    numeric = true;
                }
                catch(Exception e)
                {
                    numeric = false;
                }

                //Error if the card ID is not in the valid range
                if(!numeric || cardID > cards.size() || cardID < 1)
                {
                    System.out.println(ERROR_TEXT_RED + "Error - Enter a valid ID" + TEXT_RESET);
                }
                else
                {
                    //Sets the temporary object to the index of the selected card
                    tempCard = cards.get(cardID - 1);

                    //Prints the user's transaction history
                    tempCard.printHistory();

                    //Gives user some time to read balance before terminal clears
                    waitASecond();
                    waitASecond();
                    waitASecond();
                    waitASecond();
                    waitASecond();
                    waitASecond();
                    waitASecond();
                    waitASecond();
                }
            }

            //Allow time so messages can be viewed
            waitASecond();

        }while(running);

        //Close the app
        scanner.close();
    }
    
    
    /** Stops the code temporarily in 1000 millisecond intervals
    * stops code execution for a second
    **/
    public static void waitASecond()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}