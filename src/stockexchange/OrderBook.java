package stockexchange;

import java.util.ArrayList;
import java.util.Collections;

public class OrderBook {

    static ArrayList<Order> askArray = new ArrayList<>();
    // should be in an increasing order.
    static ArrayList<Order> bidArray = new ArrayList<>();
    // should be in an decreasing order.
    static Order[] depth;

    public static void add_order_to_bidArray(Order order){
        bidArray.add(order);
        Collections.sort(bidArray);
    }
    public static void add_order_to_askArray(Order order){
        askArray.add(order);
        Collections.sort(askArray);
    }

    public static void place_order(Order order){
        // if it is a bid order. User wants to buy.
        if(order.getordertype() == Order.Type.BID){
            Double order_price = order.price;
            int order_quantity = order.quantity;
            if(askArray.size() == 0){
                add_order_to_bidArray(order);
            }
            for(int no = 0; no < OrderBook.askArray.size(); no++){
                if(askArray.get(no).price > order_price){
                    bidArray.add(order);
                    break;
                }
                else{
                    if(askArray.get(no).quantity < order_quantity){
                        int remaining_quantity = order_quantity - askArray.get(no).quantity;
                        order.quantity = remaining_quantity;
                        add_order_to_bidArray(order);
                        askArray.remove(no);
                        Order.order_placed_notification(order);
                    }
                    else{
                        Order sell_order = askArray.get(no);
                        sell_order.quantity = sell_order.quantity - order.quantity;
                        Order.order_placed_notification(order);
                    }
                    User.update_balance(order);
                }
            }
        }
        else if ((order.getordertype() == Order.Type.ASK)) {
            // if it is a sell order.
            Double order_price = order.price;
            int order_quantity = order.quantity;
            if(bidArray.size() == 0){
                add_order_to_askArray(order);
            }
            for(int no = 0; no < OrderBook.bidArray.size(); no++){
                if(askArray.get(no).price > order_price){
                    break;
                }
                else{
                    if(askArray.get(no).quantity < order_quantity){
                        int remaining_quantity = order_quantity - askArray.get(no).quantity;
                        order.quantity = remaining_quantity;
                        add_order_to_askArray(order);
                        bidArray.remove(no);
                        Order.order_placed_notification(order);
                    }
                    else{
                        Order sell_order = askArray.get(no);
                        sell_order.quantity = sell_order.quantity - order.quantity;
                        Order.order_placed_notification(order);
                    }
                    User.update_balance(order);
                }
            }
            
        }
    }
    
}
