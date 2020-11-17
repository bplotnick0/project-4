package sample;

public class Beef extends Sandwhich {

    /**
     * returns price of sandwich with extras
     * @return
     */
    @Override
    public double price() {
        return 10.99 + super.PER_EXTRA * (super.extras.size());
    }

    @Override
    public String toString() {
        return "Beef Sandwich, Roast Beef, Provolone Cheese, Mustard " + super.toString();
    }
}


