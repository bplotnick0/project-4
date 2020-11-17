package sample;

public class Fish extends Sandwhich {

    /**
     * returns price of sandwich with extras
     * @return
     */
    @Override
    public double price() {
        return 12.99 + super.PER_EXTRA * (super.extras.size());
    }

    @Override
    public String toString() {
        return "Fish Sandwich, Grilled Snapper, Cilantro, Lime " + super.toString();
    }
}




