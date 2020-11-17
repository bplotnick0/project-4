import sample.Chicken;
import sample.Order;
import sample.OrderLine;
import sample.Sandwhich;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    /**
     * Tests that adding an Orderline object returns true
     */
    @org.junit.jupiter.api.Test
    void testAddTrue(){
        Sandwhich sandwhich = new Chicken();
        Order ord = new Order();
        OrderLine order = new OrderLine(1,sandwhich,8.99);
        assertTrue(ord.add(order));
    }

    /**
     * Tests that adding an object that is not an OrderLine returns false
     */
    @org.junit.jupiter.api.Test
    void testAddFalse(){
        String notASandwich = "notASandwich";
        Order ord = new Order();
        assertFalse(ord.add(notASandwich));
    }

    /**
     * Tests that removing an OrderLine that has been added returns true
     */
    @org.junit.jupiter.api.Test
    void testRemoveTrue(){
        Sandwhich sandwhich = new Chicken();
        Order ord = new Order();
        OrderLine order = new OrderLine(1,sandwhich,8.99);
        ord.add(order);
        assertTrue(ord.remove(order));
    }

    /**
     * Tests that removing an OrderLine that has not been added returns false
     */
    @org.junit.jupiter.api.Test
    void testRemoveFalse(){
        Sandwhich sandwhich = new Chicken();
        Order ord = new Order();
        OrderLine order = new OrderLine(1,sandwhich,8.99);
        OrderLine order1 = new OrderLine(1,sandwhich,8.99);
        ord.add(order);
        assertFalse(ord.remove(order1));
    }

    /**
     * Tests that removing an object that is not an OrderLine returns false
     */
    @org.junit.jupiter.api.Test
    void testRemoveFalse1(){
        String notASandwich = "notASandwich";
        Order ord = new Order();
        assertFalse(ord.remove(notASandwich));
    }


}
