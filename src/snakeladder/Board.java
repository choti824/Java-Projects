package snakeladder;

import java.util.HashMap;

public class Board{
    int start_point = 0;
    int end_point = 100;
    HashMap<String, Integer> players_position = new HashMap<>(SnakeLadder.no_of_players);

    private static Board board = new Board();
    private Board(){}
    public static Board getinstance(){
        return board;
    }
    
    public int updating_players_position(String name, int jump){
        if(players_position.containsKey(name)){
            players_position.put(name, players_position.get(name) + jump);
        }
        for(int idx = 0; idx < SnakeLadder.ladderArray.length; idx++){
            if(SnakeLadder.ladderArray[idx][0] == players_position.get(name)){
                players_position.put(name, SnakeLadder.ladderArray[idx][1]);
            }
        }
        for(int idx = 0; idx < SnakeLadder.snakeArray.length; idx++){
            if(SnakeLadder.snakeArray[idx][0] == players_position.get(name)){
                players_position.put(name, SnakeLadder.snakeArray[idx][1]);
            }
        }
        return players_position.get(name);
        }    
    }
