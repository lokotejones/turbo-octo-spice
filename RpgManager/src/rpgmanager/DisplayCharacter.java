/*
 * 
 * 
 * 
 */
package rpgmanager;

/**
 *
 * @author Aaron
 */
public class DisplayCharacter {
   
    /**
     * Prints out the information collected about the character
     */
    public DisplayCharacter(Character newChar) {
        try {
            System.out.println("Hello there " + newChar.getPlayerName()+".");
            System.out.println("Your character looks thusly :");
            System.out.println();
            System.out.print("First Name: ");
            System.out.println(newChar.getFirstName());
            System.out.print("Last Name: ");
            System.out.println(newChar.getLastName());
            System.out.print("Height (inches): ");
            System.out.println(newChar.getHeight());
            System.out.print("Age: ");
            System.out.println(newChar.getAge());
            System.out.print("Base Class: ");
            System.out.println(newChar.getPlayerClass());
            System.out.print("Base Race: ");
            System.out.println(newChar.getPlayerRace());
        } catch(Exception e) {
            System.out.println("You have an exception - ");
            System.out.println(e);
        }
    }
}
