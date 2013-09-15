/*
 * 
 * 
 */
package rpgmanager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Aaron
 */
public class Character {
        // The person playing the character
        private String Player_Name;
        // The PCs First Name
        private String First_Name;
        // The PCs Last Name
        private String Last_Name;
        // The PCs Race
        private enum Base_Race {
            Dwarf, Halfling, Elf, Human, Gnome, HalfOrc, HalfElf
        };
        // A Base_Race that holds the Players Race
        private Base_Race Player_Race;
        // This gets all the information for the chosen character class
        private CharacterClass Extended_Class;
        // A choice used for holding the characters pick
        private int Base_Race_Choice = 0;
        // The PCs base class
        private enum Base_Class {
            Barbarian, Bard, Cleric, Druid, Fighter, Monk, 
            Paladin, Ranger, Rogue, Sorcerer, Wizard
        };
        // Holds a base class for player class
        private Base_Class Player_Class;
        // Base Class Choice for switch case
        private int Base_Class_Choice = 0;
        // The PCs Height
        private int Height = 0;
        // The PCs Weight
        private int Weight = 0;
        // The PCs Age
        private int Age = 0;
        // The PCs base level
        private int Base_Level;
        // Player ready boolean
        private boolean Player_Ready;
        // Sets up the scanner for inputs
        Scanner user_input = new Scanner(System.in);
        // Create a Buffered reader for input
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Random random = new Random();
        private int STRENGTH;
        private int DEXTERITY;
        private int CONSTITUTION;
        private int WISDOM;
        private int INTELLIGENCE;
        private int CHARISMA;
        
        // This instantiates a new character
        public Character() {
 
        }
        
        /**
         * Sets the PCs first name
         */
        public void setPlayerName() {
            System.out.print("Players Name: ");
            try {
                Player_Name = reader.readLine(); 
            } catch (IOException ioe) {
                System.out.println("The Player Name input failed to set.");
                System.out.println(ioe);
            }
        }
        
        /**
         * Sets the PCs first name
         */
        public void setFirstName() {
            System.out.print("First Name: ");
            try {
                First_Name = reader.readLine();
            } catch (IOException ioe) {
                System.out.println("The PCs First Name input failed to set.");
                System.out.println(ioe);
            }
        }
        
        /**
         * Sets the PCs last name
         */
        public void setLastName() {
            System.out.print("Last Name: ");
            try {
                Last_Name = reader.readLine();
            } catch (IOException ioe) {
                System.out.println("The PCs Last Name input failed to set.");
                System.out.println(ioe);
            }
        }

        /**
         * Sets the height of the PC
         */
        public void setHeight() {
            do {
                System.out.print("Height (inches): ");
                try {
                    Height = user_input.nextInt();
                    if(Height < 1) {
                        System.out.println("Not a valid number.");
                    }
                } catch(Exception e) {
                    System.out.println("You must use a number greater than 0!");
                    user_input.next();
                }
            } while (Height < 1);
        }
        
        /**
         * Sets the weight of the PC
         */
        public void setWeight() {
            do {
                System.out.print("Weight (pounds): ");
                try {
                    Weight = user_input.nextInt();
                    if (Weight < 1) {
                        System.out.println("Not a valid number.");
                    }
                } catch (Exception e) {
                    System.out.println("You must use a number greater than 0!");
                    user_input.next();
                }
            } while (Weight < 1);
        }
        
        /**
         * Sets the age of the PC
         */
        public void setAge() {
            do {
                System.out.print("Age (whole years): ");
                try {
                    Age = user_input.nextInt();
                    if (Age < 1) {
                        System.out.println("Not a valid number.");
                    }
                } catch (Exception e) {
                    System.out.println("You must use a number greater than 0!");
                    user_input.next();
                }
            } while (Age < 1);
        }
        
        /**
         * Sets the base level of the PC
         */
        public void setBaseLevel() {
            do {
                System.out.print("Starting Level: ");
                try {
                    Base_Level = user_input.nextInt();
                    if (Base_Level < 1 || Base_Level > 25) {
                        System.out.println("Not a valid number.");
                    }
                } catch (Exception e) {
                    System.out.println("You must choose a valid level between 1 and 25!");
                    user_input.next();
                }
            } while (Base_Level < 1 || Base_Level > 25);
        }
        
        /*
         * Sets the Base Race of the PC
         */
        public void setBaseRace() {
            do {
                System.out.println("Available Races: ");
                System.out.println("Please select a cooresponding number for race.");
                int i = 1;
                for(Base_Race value: Base_Race.values()){
                    System.out.println(i+": "+value.name());
                    i++;
                }
                try {
                    System.out.print("Choice: ");
                    Base_Race_Choice = user_input.nextInt();
                    Player_Race = Base_Race.values()[Base_Race_Choice - 1];
                    if (Base_Race_Choice < 1 || Base_Race_Choice > i) {
                        System.out.println("Not a valid number.");
                    }
                } catch (Exception e) {
                    System.out.println("You must choose a valid class. Try numbers.");
                    user_input.next();
                }
            } while (Base_Race_Choice == 0);
        }
        
        /*
         * Sets the Base Class of the PC
         */
        public void setBaseClass() {
            do {
                System.out.println("Available Classes: ");
                System.out.println("Please select a cooresponding number for class.");
                int i = 1;
                for(Base_Class value: Base_Class.values()){
                    System.out.println(i+": "+value.name());
                    i++;
                }
                try {
                    System.out.print("Choice: ");
                    Base_Class_Choice = user_input.nextInt();
                    Player_Class = Base_Class.values()[Base_Class_Choice - 1];
                    try {
                        CharacterClass extendedClass = new CharacterClass(Player_Class);
                        Extended_Class = extendedClass;
                    } catch (Exception e) {
                        System.out.println("Failed to build the character class!");
                    }
                    if (Base_Class_Choice < 1 || Base_Class_Choice > i) {
                        System.out.println("Not a valid number.");
                    }
                } catch (Exception e) {
                    System.out.println("You must choose a valid class. Try numbers.");
                    user_input.next();
                }
            } while (Base_Class_Choice == 0);
        }
        
        /*
         * Checks if the player is good to go.
         */
        public void setReady() {
            do {
                System.out.println("Are you happy with the character you built?");
                System.out.println("Type: Y or N - ");
                try {
                    Player_Ready = user_input.next().equalsIgnoreCase("y");
                    if (Player_Ready != true) {
                        System.out.println("Would you like to make a new character?");
                        boolean new_char = user_input.next().equalsIgnoreCase("y");
                        if (new_char == true) {
                            this.createCharacterNew();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("You should choose Y for Yes or N for No.");
                }
            } while (Player_Ready == false);
        }
        
    /*
     * Sets the users stats
     */
    private void setBaseStats() {
        STRENGTH = (random.nextInt(6) + 5) + Extended_Class.GetStrengthBonus();
        DEXTERITY = (random.nextInt(6) + 5) + Extended_Class.GetDexterityBonus();
        CONSTITUTION = (random.nextInt(6) + 5) + Extended_Class.GetConstitutionBonus();
        WISDOM = (random.nextInt(6) + 5) + Extended_Class.GetWisdomBonus();
        INTELLIGENCE = (random.nextInt(6) + 5) + Extended_Class.GetIntelligenceBonus();
        CHARISMA = (random.nextInt(6) + 5) + Extended_Class.GetCharismaBonus();
    }
        
        /*******************************************************************/
        
        /**
        * Gets the PCs first name
        * @return 
        */
        public String getFirstName() {
            return First_Name;
        }
    
        /**
         * Gets the PCs last name
         * @return 
         */
        public String getLastName() {
            return Last_Name;
        }
        
        /**
         * Gets the PCs height
         * @return 
         */
        public int getHeight() {
            return Height;
        }
        
        /**
         * Gets the PCs age
         * @return 
         */
        public int getAge() {
            return Age;
        }
        
        /**
         * Gets the PCs base level (1-25)
         * @return
         */
        public int getBaseLevel() {
            return Base_Level;
        }
        
        /**
         * Gets the PCs player name
         * @return
         */
        public String getPlayerName() {
            return Player_Name;
        }
        
        /**
         * Gets the players class
         * @return
         */
        public Base_Class getPlayerClass() {
            return Player_Class;
        }
        
        /**
         * Gets the players race
         * @return
         */
        public Base_Race getPlayerRace() {
            return Player_Race;
        }
        
        /*
         * Gets the players choice on if they are ready
         * @return
         */
        public boolean GetReady() {
            return Player_Ready;
        }
        
        /*
         * The chosen character class information
         * @return object
         */
        public CharacterClass getClassInfo() {
            return Extended_Class;
        }
        
        public void getStatsList() {
            System.out.println("Strength : "+STRENGTH);
            System.out.println("Dexterity : "+DEXTERITY);
            System.out.println("Constitution : "+CONSTITUTION);
            System.out.println("Wisdom : "+WISDOM);
            System.out.println("Intelligence : "+INTELLIGENCE);
            System.out.println("Charisma : "+CHARISMA);
        }
        
        public int GetStrength() {
            return STRENGTH;
        }
    
        public int GetDexterity() {
            return DEXTERITY;
        }

        public int GetConstitution() {
            return CONSTITUTION;
        }

        public int GetWisdom() {
            return WISDOM;
        }

        public int GetIntelligence() {
            return INTELLIGENCE;
        }

        public int GetCharisma() {
            return CHARISMA;
        }
        
        /**
         *  Creates a new character
         */
        public void createCharacterNew() {
            this.setPlayerName();
            this.setFirstName();
            this.setLastName();
            this.setHeight();
            this.setWeight();
            this.setAge();
            this.setBaseLevel();
            this.setBaseRace();
            this.setBaseClass();
            this.setBaseStats();
            this.setReady();
        }
}