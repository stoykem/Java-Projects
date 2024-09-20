//Name: Miguel Stoyke
//Date: August 11th, 2023
//App name: Bilingual App
//App description: Prompts user to choose English or French, then makes a data file storing user inputted name, and program name

//For the GUI
import javax.swing.*;
import java.awt.*;

//Working with files
import java.io.*;
import java.util.Scanner;

/**
 * BilingualApp
 */
public class BilingualApp 
{
    //Widgets
    static JFrame window;
    static JFrame window2;
    static JPanel panel;
    static JPanel panel2;
    static JLabel langLabel;
    static JButton englishButton;
    static JButton frenchButton;
    static GridBagConstraints gridbag;
    static GridBagConstraints gridbag2;

    /**
     * Executed when the load button is pressed
     * Open a file chooser and load a character from a save file
     */
    static void englishButton()
    {
        String englishFile = "English.lang";

        try
        {
            String title = readLineFromFile(englishFile, 1);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    

    /** Main entry point of the app **/
    public static void main(String[] args) 
    {
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());} catch (Exception e) {}

        //Setup the windows
        window = new JFrame("Language Selection | S\u00E9lection de la langue");
        window.setIconImage(new ImageIcon("SaveIcon.png").getImage());
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false); //Can't resize window
        //------------------------------------------------------------------------------------------
        window2 = new JFrame("Lab 5 - Bilingual App - Miguel Stoyke");
        window2.setIconImage(new ImageIcon("SaveIcon.png").getImage());
        window2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window2.setResizable(false); //Can't resize window

        //Panel - Language Screen ------------------------------------------------------------------------------------------
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setPreferredSize(new Dimension(410, panel.getPreferredSize().height));
        panel.setLayout(new GridBagLayout());
        gridbag = new GridBagConstraints();

        //Panel 2 - Register Screen ------------------------------------------------------------------------------------------
        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel2.setLayout(new GridBagLayout());
        gridbag2 = new GridBagConstraints();

        //Language Label ------------------------------------------------------------------------------------------
        langLabel = new JLabel("Please Choose Your Language: | S'il vous plait choisissez votre langue:");

        //English and French Buttons ------------------------------------------------------------------------------------------
        englishButton = new JButton("English");
        englishButton.addActionListener(event -> englishClick()); //Calls a method when clicked
        frenchButton = new JButton("French");
        frenchButton.addActionListener(event -> frenchClick());

        //Add the widgets ------------------------------------------------------------------------------------------
        window.add(panel);

        //Language Label ------------------------------------------------------------------------------------------
        gridbag.gridy = 0;
        gridbag.fill = GridBagConstraints.HORIZONTAL;
        panel.add(langLabel, gridbag); //Add using gridbag!

        //Buttons ------------------------------------------------------------------------------------------
        gridbag.gridy = 1; //Rows
        gridbag.fill = GridBagConstraints.NONE; //Stop using the horizontal space
        gridbag.anchor = GridBagConstraints.WEST; //Left Side
        gridbag.gridx = 0; //Columns
        panel.add(englishButton, gridbag);

        gridbag.gridy = 1; //Rows
        gridbag.anchor = GridBagConstraints.EAST; //Right Side
        panel.add(frenchButton, gridbag);

        //Make the window visible
        window.pack();
        window.setVisible(true);
    }
}
