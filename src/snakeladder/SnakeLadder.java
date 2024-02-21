package snakeladder;

public class SnakeLadder {

    public static  int[][] snakeArray = new int[2][];
    public static  int[][] ladderArray = new int[2][];
    public static int no_of_players;

    public int[][] get_snakesArray(){
        return snakeArray;
    }
    public void set_snakesArray(int[][] snakesArray){
        SnakeLadder.snakeArray = snakesArray;
    }

    public int[][] get_ladderArray(){
        return ladderArray;
    }
    public void set_ladderArray(int[][] ladderArray){
        SnakeLadder.ladderArray = ladderArray;
    }
}
