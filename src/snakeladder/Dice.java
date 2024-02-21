package snakeladder;

import java.util.Random;

public class Dice{
    int number;
    String turn;
    // LinkedList<String> order=new LinkedList<String>();

    public int rolling_dice(){
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
