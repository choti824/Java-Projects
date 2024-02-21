package stockexchange;

public class User {
    static String userId;
    static Double balance;
    
    public static Double getbalance(){
        return User.balance;
    }
    public static void set_balance(double amount){
        User.balance = amount;
    }
    public static void update_balance(Order order){
        User.balance = User.balance - order.price*order.quantity;
    }
}
