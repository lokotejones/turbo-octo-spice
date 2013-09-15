/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmanager;

import java.util.Scanner;

/**
 *
 * @author aaron
 */
public final class Game {
    
    // Create an object to hold the player character
    private Character Player;
    
    /***********************************************************************/
    
    // Instantiates the game
    public Game(Character newChar) {
        try {
            Player = newChar;
            if (newChar.GetReady() == false) {
                System.out.println("There is no character in existance.");
                System.out.println("Please create a character in order to start the game");
            } else {
                System.out.println("The character has been loaded.");
                GameMenu();
            }
        } catch (Exception e) {
            System.out.println("Failed to start the game.");
            System.out.println(e);
        }
    }
    
    public void GameMenu() {
        // Set Run Boolean to true
        boolean run = true;
        // We switch the input to lowecase here and compare
        while(run) {
            System.out.println("I: Inventory ; F: Fight ; T: Travel ; Q: Quit");
            // Initialize the scanner
            Scanner user_input = new Scanner(System.in);
            // Get the user input
            String decision = user_input.next();
            Travel goingPlaces = new Travel();
            // Convert their decision to lowercase and compare to choices.
            switch (decision.toLowerCase()) {
                case "i":
                    break;
                case "f":
                    break;
                case "t":
                    goingPlaces.Greet();
                    String direction = user_input.next();
                    goingPlaces.GoTo(direction);
                    break;
                case "q":
                    System.out.println("Do you want to quit the game?");
                    System.out.print("Please type the word quit to confirm: ");
                    String quit = user_input.next();
                    // Sanity check - Really quit game?
                    if ("quit".equals(quit.toLowerCase())) {
                        run = false;
                    }
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
