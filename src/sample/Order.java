package sample;

import java.util.ArrayList;

public class Order implements Customizable {
    public static int lineNumber; //reset for each new order;
    private ArrayList<OrderLine> orderLines;



    public Order(){
        lineNumber = 1;
        orderLines = new ArrayList<OrderLine>();
    }
    @Override
    public boolean add(Object obj) {
        if(!(obj instanceof OrderLine)){
            return false;
        }
        return orderLines.add((OrderLine)obj);

    }

    @Override
    public boolean remove(Object obj) {
        if(!(obj instanceof OrderLine)){
            return false;
        }
        return orderLines.remove((OrderLine)obj);

    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }
}
