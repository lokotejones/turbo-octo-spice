/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmanager;

/**
 *
 * @author Aaron
 */
public class Travel {
    
    public Travel() {
    }
    
    void Greet() {
        System.out.println("Where would you like to go? ");
    }

    void GoTo(String direction) {
        switch(direction.toLowerCase()) {
            case "n":
            case "north":
                System.out.println("You went north!");
                break;
            case "e":
            case "east":
                System.out.println("You went east!");
                break;
            case "s":
            case "south":
                System.out.println("You went south!");
                break;
            case "w":
            case "west":
                System.out.println("You went west!");
                break;
            default:
                System.out.println("You didn't go anywhere!");
                System.out.println("Try a cardinal direction!");
                break;
        }
    }
}
