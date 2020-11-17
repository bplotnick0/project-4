package sample;

public class Chicken extends Sandwhich {

    /**
     * returns price of sandwich with extras
     * @return
     */
    @Override
    public double price() {
        return 8.99 + super.PER_EXTRA * (super.extras.size());
    }

    @Override
    public String toString() {
        return "Chicken Sandwhich, Fried Chicken, Spicy Sauce, Pickles, " + super.toString();
    }
}
