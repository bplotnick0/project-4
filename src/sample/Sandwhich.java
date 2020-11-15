package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Iterator;
public abstract class Sandwhich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extra> extras;

    public abstract double price();
    public String toString(){
        String str = "Str";
        return str;
    }

    public Sandwhich(){
        this.extras = new ArrayList<Extra>();
    }


    @Override
    public boolean add(Object obj) {

        for(int i = 0; i < ((ObservableList<Extra>)obj).size(); i++){
            extras.add(((ObservableList<Extra>) obj).get(i));
        }

        return true;
    }

    @Override
    public boolean remove(Object obj) {
        extras.remove((Extra) obj);
        return true;
    }
}
