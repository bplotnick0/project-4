package sample;

public class Fish extends Sandwhich {

    @Override
    public double price() {
        return 12.99 + super.PER_EXTRA * (super.extras.size());
    }
}


