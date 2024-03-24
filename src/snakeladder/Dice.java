package snakeladder;

import java.util.Random;

public class Dice{
    
    int sides;
    
    Dice(Integer sides){
        this.sides = sides;    
    }

    public int rolling_dice(){
        Random random = new Random();
        return random.nextInt(this.sides) + 1;
    }
}
