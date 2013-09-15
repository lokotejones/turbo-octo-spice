/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmanager;

/**
 *
 * @author Aaron
 */
public class RpgManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // "Splash Screen here"
        System.out.println("RPG Game.");
        // Initialize the new Character
        Character newChar = new Character();
        // Start the Menu Class
        MenuSystemClass menu = new MenuSystemClass();
        // Create the main menu
        menu.MainMenu(newChar);
    }
}