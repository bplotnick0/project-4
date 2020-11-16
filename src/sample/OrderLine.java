package sample;

public class OrderLine {
    private int lineNumber; //serial number created when new sandwich added to order
    private Sandwhich sandwich;
    private double price;

    public OrderLine(int lineNumber, Sandwhich sandwhich, double price){
        this.lineNumber = lineNumber;
        this.sandwich = sandwhich;
        this.price = price;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public double getPrice() {
        return price;
    }

    public Sandwhich getSandwich() {
        return sandwich;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSandwich(Sandwhich sandwich) {
        this.sandwich = sandwich;
    }

    @Override
    public String toString() {
        return lineNumber + " " + sandwich.toString() + ", " + price;
    }
}
