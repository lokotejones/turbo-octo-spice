/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpgmanager;

/**
 *
 * @author aaron
 */
public class CharacterClass {
    private int StrengthBonus = 0;
    private int DexterityBonus = 0;
    private int ConstitutionBonus = 0;
    private int IntelligenceBonus = 0;
    private int WisdomBonus = 0;
    private int CharismaBonus = 0;
    /**
     *
     */
    public CharacterClass(Enum Player_Class) {
        System.out.println("You are a handsome "+ Player_Class);
        Enum playerClass = Player_Class;
        switch(playerClass.name()) {
            case "Barbarian":
                System.out.println("You are beefy!");
                ConstitutionBonus = 1;
                break;
            default:
                System.out.println("You don't get anything special!");
        }
    }
    
    public int GetStrengthBonus(){
        return StrengthBonus;
    }
    
    public int GetDexterityBonus(){
        return DexterityBonus;
    }
    
    public int GetConstitutionBonus(){
        return ConstitutionBonus;
    }
    
    public int GetIntelligenceBonus(){
        return IntelligenceBonus;
    }
    
    public int GetWisdomBonus(){
        return WisdomBonus;
    }
    
    public int GetCharismaBonus(){
        return CharismaBonus;
    }
}
