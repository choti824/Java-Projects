package snakeladder;
import java.util.Scanner;

class App {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of snakes: ");
        int snakes = scanner.nextInt();
        SnakeLadder.snakeArray = new int[snakes][2];
        System.out.print("Enter the number of ladders: ");
        int ladder = scanner.nextInt();
        SnakeLadder.ladderArray = new int[ladder][2];
        for (int i = 0; i < snakes; i++) {
            System.out.printf("Enter values for snakes %d (separated by spaces): ", i + 1);
            for (int j = 0; j < 2; j++) {
                SnakeLadder.snakeArray[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < ladder; i++) {
            System.out.printf("Enter values for ladder %d (separated by spaces): ", i + 1);
            for (int j = 0; j < 2; j++) {
                SnakeLadder.ladderArray[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Please Enter the Number Of players.");
        SnakeLadder.no_of_players = scanner.nextInt();
        Board tmp = Board.getinstance();
        for(int player = 0; player < SnakeLadder.no_of_players; player++){
            String player_name = "Player" + Integer.toString(player+1);
            Player pl = new Player(player_name);
            tmp.players_position.put(player_name, 0);
        }
        System.out.println("Please roll the device");
        Dice dice = new Dice();
        while(!tmp.players_position.containsValue(100)){
            for(int player = 1; player < SnakeLadder.no_of_players+1; player++){
                System.out.println("Please roll the device player" + Integer.toString(player));
                int jump = dice.rolling_dice();
                String player_name = "Player" + Integer.toString(player);
                tmp.updating_players_position(player_name, jump);
            }
        }
        for (String name : tmp.players_position.keySet()){
            int value = tmp.players_position.get(name);
            if(value == 100){
                System.out.println(name + "Wins");
            }
    }
}
}
