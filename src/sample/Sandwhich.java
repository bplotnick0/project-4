/**
 * Sandwich super class
 * @author Ben Plotnick, Michael Sherbine
 */package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Iterator;
public abstract class Sandwhich implements Customizable {
    static final int MAX_EXTRAS = 6;
    static final double PER_EXTRA = 1.99;
    protected ArrayList<Extra> extras;

    public abstract double price();


    @Override
    public String toString() {
        String xtras ="";
        for(int i =0; i < extras.size(); i++){
            xtras = xtras + extras.get(i) + ", ";
        }
        return xtras;
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
