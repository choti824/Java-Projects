package stockexchange;

public class Order implements Comparable<Order>{

    String user_id;
    String stock_name;
    Integer quantity;
    Double price;
    public enum Type{
        BID,
        ASK
    }
    private Type type;

    public Type getordertype(){
        return type;
    }
    public void set_order_type(String order_type){
        if(order_type.equalsIgnoreCase("buy")){
            this.type = Type.BID;
        }
        else if(order_type.equalsIgnoreCase("sell")){
            this.type = Type.ASK;
        }
    }
    public static void order_placed_notification(Order order){
        System.out.println("Congratulations, Your order of quantity" + order.quantity + " has been successfully placed.");
    }
    // this is the menthod used when we need to compare instances of the class.
    @Override
    public int compareTo(Order order) {
        return this.price.compareTo(order.price);
    }      
}
