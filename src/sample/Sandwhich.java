package sample;

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


    @Override
    public boolean add(Object obj) {
        extras.add((Extra) obj);
        return true;
    }

    @Override
    public boolean remove(Object obj) {
        Iterator itr = extras.iterator();
        Extra x = (Extra) obj;
        while(itr.hasNext()){
            Extra next = (Extra)itr.next();
            if (next.getName().equals(x.getName())){
                itr.remove();
                return true;
            }
        }
        return false;
    }
}
