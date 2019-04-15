package information.dices;

import java.util.Random;
/**
 *
 * @author Leonardo
 */
public class Dice {
    private int value;
    
    public void rollDice(){
        Random rand = new Random();
        value = rand.nextInt(6) + 1;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setValue(int value){
        this.value = value;
    }
}
