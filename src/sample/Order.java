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
        orderLines.add((OrderLine)obj);
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

    public ArrayList<OrderLine> getOrderLines() {
        return orderLines;
    }
}
