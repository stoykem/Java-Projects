import java.util.ArrayList;

/** Template to create PrestoCard objects **/
public class PrestoCard 
{
    //Private Variables
    private double balance;
    private String name;
    private String type;

    //History ArrayList
    private ArrayList<Double> balanceHistory = new ArrayList<>();
    //private ArrayList<String> balanceHistoryType;
    

    /** Constructor 
     * @param name owner's name of the card
     * @param balance on the user's card
     * @return Constructed PrestoCard object
     * **/
    public PrestoCard(double balance, String name)
    {
        this.name = name;
        this.balance = balance;
        balanceHistory.add(balance);
    }

    /** @return the name on the card **/
    String getName()
    {
        return name;
    }

    /** @return the balance on the card **/
    double getBalance()
    {
        return balance;
    }


    /**
     * @param fare to be deducted from a given Presto Card
     * @return true if balance is available
     * @return false if balance is not available (insufficient funds)
     */
    public boolean tap(double fare)
    {
        if (balance >= Machine.FARE)
        {
            balance -= Machine.FARE;
            balanceHistory.add(balance);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * @param funds added to the user's current balance
     * The user's account is topped up with the new funds
     */
    public void topUp(double funds)
    {
        balance += funds;
        balanceHistory.add(balance);
    }


    /**
     * Print the user's top up and tap history
     */
    public void printHistory()
    {
        System.out.println("\n" + name + "'s " + "Balance History: " + "\n");
        System.out.println("-------------------");
        //Iterate through all transactions in the history array
        for (int i = 0; i < balanceHistory.size(); i++)
        {
            double history = balanceHistory.get(i);
            
            //If the index is even, the transaction was a topup
            if (i / 2 == 0)
            {
                type = "topup";
            }
            //Otherwise, the transaction was a tap 
            else
            {
                type = "tap";
            }

            //Format a printout of the user's history
            System.out.printf("%s - $%.2f\n", type, history);
            System.out.println("-------------------");
        }
    }
}
