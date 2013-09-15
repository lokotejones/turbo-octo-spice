/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmanager;

import java.util.Scanner;

/**
 * My Custom Menu Class
 * @author aaron
 */
public class MenuSystemClass {
    
    /**
     * This starts the Menu
     */
    public MenuSystemClass() {

    }
    
    public void MainMenu(Character newChar) {
        // Set Run Boolean to true
        boolean running = true;
        // We switch the input to lowecase here and compare
        while(running) {
            System.out.println("A: New Char ; V: View ; W: Start Game; S: Save ; D: Delete ; Q: Quit");
            // Initialize the scanner
            Scanner user_input = new Scanner(System.in);
            // Get the user input
            String decision = user_input.next();
            // Conver their decision to lowercase and compare to choices.
            switch (decision.toLowerCase()) {
                // Creates a new Character
                case "a":
                    // Initialize the new Character
                    newChar.createCharacterNew();
                    break;
                // Saves the Character
                case "s":
                    WriteFile newWrite = new WriteFile();
                    newWrite.SaveData();
                    break;
                // Deletes the character
                case "d":
                    System.out.println("This is not yet implemented.");
                    break;
                // Views the character
                case "v":
                    DisplayCharacter newDisplay = new DisplayCharacter(newChar);
                    break;
                // Start the game
                case "w":
                    Game game = new Game(newChar);
                    break;
                // Exit Gracefully
                case "q": 
                    System.exit(0); // Kill the program
                    break;
                // Loop the program until they pick an acceptable answer
                default:
                    System.out.println("You did not select a viable option.");
                    System.out.println("Try again.");
                    break;
            }
        }
    }
}
