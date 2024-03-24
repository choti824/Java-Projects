package snakeladder;

import java.util.HashMap;
import java.util.Scanner;

public class Board{

    private Board(){}

    public static int size;

    private static Board board = new Board();
    public static Board getInstance(){
        return board;
    }

    Dice dice;

    public static HashMap<Integer, Integer> snakeMap = new HashMap<>();// keys will be head and values will be tail(bottom)
    public static HashMap<Integer, Integer> ladderMap = new HashMap<>();// keys will be start point and value will be top point
    Scanner scanner = new Scanner(System.in);   


    public void set_snakesMap(HashMap<Integer, Integer> snakesMap){
        Board.snakeMap = snakesMap;
    }

    public void set_ladderMap(HashMap<Integer, Integer> ladderMap){
        Board.ladderMap = ladderMap;
    }

    public void adding_snakes_to_board(int no_of_snakes){
        HashMap<Integer, Integer> snakeMap = new HashMap<>();
        for(int snake = 0; snake < no_of_snakes; snake++){
                System.out.printf("Enter values for snakes %d (separated by spaces): ", snake + 1);
                int head = scanner.nextInt();
                int tail = scanner.nextInt();
                System.out.println(Board.size);
                if(!this.board_validations(head, tail, -1)){
                    this.adding_snakes_to_board(no_of_snakes);
                }
                snakeMap.put(head, tail);
        }
        System.err.println("Great job, Snakes are added to the board.");
        Board.snakeMap = snakeMap;
    }

    public void adding_ladders_to_board(int no_of_ladders){
        HashMap<Integer, Integer> ladderMap = new HashMap<>();
        for(int ladder = 0; ladder < no_of_ladders; ladder++){
                System.out.printf("Enter values for ladder %d (separated by spaces): ", ladder + 1);
                int bottom = scanner.nextInt();
                int top = scanner.nextInt();
                if(!this.board_validations(bottom, top, 1)){
                    this.adding_ladders_to_board(no_of_ladders);
                }
                ladderMap.put(bottom, top);
        }
        System.err.println("Great job, Ladders are added to the board.");
        Board.ladderMap = ladderMap;
    }

    public Boolean board_validations(int pos1, int pos2, int type){
        if(pos1 > (Board.size*Board.size) || (pos2 > Board.size*Board.size) || (pos2 <= 0 && pos1 <=0)){
            System.out.println("Positions for snake or ladder are out of bounds"); 
            return Boolean.FALSE;
        }
        if((type == 1 && pos1 >= pos2) || (type == -1 && pos1 <= pos2)){
            System.out.println("Invalid order of values.");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }




    
}
