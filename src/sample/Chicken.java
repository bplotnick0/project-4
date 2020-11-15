package sample;

public class Chicken extends Sandwhich {




    @Override
    public double price() {
        return 8.99 + super.PER_EXTRA * (super.extras.size());
    }
}
