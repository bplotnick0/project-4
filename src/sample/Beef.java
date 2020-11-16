package sample;

public class Beef extends Sandwhich {

    @Override
    public double price() {
        return 10.99 + super.PER_EXTRA * (super.extras.size());
    }

    @Override
    public String toString() {
        return "Beef, Roast Beef, Provolone Cheese, Mustard " + super.toString();
    }
}


