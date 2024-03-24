package snakeladder;

public class Player{
    String name;
    int current_position;

    public Player(String name){
        this.name = name;
        this.current_position = 1;
    }

    public void updating_player_position(Player player, int jump, int next_position, int type){
        if(!this.position_check(next_position)){
            next_position = player.current_position;
        }
        int initial_position = player.current_position;
        String name = player.name;
        switch (type) {
            case -10:
                System.out.println(name + " goti has been cut at " + current_position +" and moved to starting position " + next_position);
                break;
            case -1:
                int snake_head = initial_position + jump;
                System.out.println(name + "rolled a " + jump + " and bitten by snake at " + snake_head + "and moved from " + snake_head + "to" + next_position);
                break;
            case 0:
                System.out.println(name + "rolled a " + jump + "and moved from " + initial_position + "to" + next_position);
                break;
            case 1:
                int ladder_start = current_position + jump;
                System.out.println(name + "rolled a " + jump + "and climbed a ladder at " + ladder_start + "and moved from " + ladder_start + "to" + next_position);
        }
        player.current_position = next_position;
    }
    public Boolean position_check(int next_position){
        if(next_position > Board.size*Board.size){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}