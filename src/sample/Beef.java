package sample;

public class Beef extends Sandwhich {

    @Override
    public double price() {

        return 10.99 + super.PER_EXTRA * (super.extras.size());
    }
}


