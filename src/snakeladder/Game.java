package snakeladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
   
    int no_of_players;
    // private Board board;
    ArrayList<Player> players_array = new ArrayList<>();
    HashMap<String, Player> name_objectMap = new HashMap<>(this.no_of_players);
    Scanner scanner = new Scanner(System.in);

    public void startgame(){
  
            System.out.println("Welcome to snake and ladder Game");
            Board board = Board.getInstance();
            System.out.print("lets's set the Board.\n"+
                    "Please Enter the size of Board: ");
            Board.size = scanner.nextInt();

            System.out.print("Enter the number of snakes: ");
            int snakes = scanner.nextInt();
            board.adding_snakes_to_board(snakes);

            System.out.print("Enter the number of ladders: ");
            int ladder = scanner.nextInt();
            board.adding_ladders_to_board(ladder);

            System.out.println("Please Enter the Number Of players.");
            this.no_of_players = scanner.nextInt();
            this.adding_players_to_game(this.no_of_players);

            System.out.println("please enter the no of sides on dice");
            Integer sides =  scanner.nextInt();
            Dice dice = new Dice(sides);
            
            System.out.println("Please roll the device");
            
            while(!this.is_over())
            {
                for(int num = 0; num < this.no_of_players; num++){
                    Player player = players_array.get(num);
                    int jump = dice.rolling_dice();
                    this.checking_for_ladders_or_snakes(player, jump);
                }
            }
            
        }

    public Boolean is_over(){
        for(int idx = 0; idx < players_array.size(); idx++){
            if(players_array.get(idx).current_position == Board.size*Board.size){
                return Boolean.TRUE;
            }
        }
            return Boolean.FALSE;
        }

    public void checking_for_ladders_or_snakes(Player player, int jump){

        int current_position = player.current_position;
        int next_position = current_position + jump;

        int type = 0;
        if(Board.snakeMap.containsKey(next_position)){
                int fall = Board.snakeMap.get(next_position);
                next_position = fall;
                type = -1;
        }
        if(Board.ladderMap.containsKey(next_position)){
                int climb = Board.ladderMap.get(next_position);
                next_position = climb;
                type = 1;
        }
        // other_players_position_check.
        this.check_for_other_players(player.name, current_position);

        player.updating_player_position(player, jump, next_position, type);
    }

    public void check_for_other_players(String name, int position){
        for(int num = 0; num < players_array.size(); num++){
            Player player = players_array.get(num);
            if((player.name != name) && player.current_position == position){
                player.updating_player_position(player, 0, 1, -10);
            }
        }
    }

    public void adding_players_to_game(int no_players){
        scanner.nextLine();
        for(int player = 0; player < no_of_players; player++){
            System.out.println("Please Enter the player name: ");
            String name = scanner.nextLine();
            Player p = new Player(name);
            this.players_array.add(p);
            this.name_objectMap.put(name, p);
        }
        System.out.println("Setting up of Players is done.");
    }
}
