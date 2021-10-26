package agh.ics.oop;
import java.util.*;
import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


public class MapDirectionTest {

    @Test
    public void Test(){
        assertTrue(true);
        MapDirection a = MapDirection.NORTH;
        MapDirection f = a.next();
        assertEquals(MapDirection.EAST,f);
        a = MapDirection.EAST;
        f = a.next();
        assertEquals(MapDirection.SOUTH, f);
        a = MapDirection.SOUTH;
        f = a.next();
        assertEquals(MapDirection.WEST, f);
        a = MapDirection.WEST;
        f = a.next();
        assertEquals(MapDirection.NORTH, f);


    }

    //assert.equals ?
    //wszystkie parametry
    //bledne parametry np. null int tam gdzie nie powinny być
}
