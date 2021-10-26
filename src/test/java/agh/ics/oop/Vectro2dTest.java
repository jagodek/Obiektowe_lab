package agh.ics.oop;
import java.util.Random;
import java.lang.Object.*;
import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

public class Vectro2dTest {
    @Test
    public void equalsTest(){
        assertTrue(true);
        Random rand = new Random();
        Vector2d v1 = new Vector2d(0,0);
        Vector2d v2 = new Vector2d(0,0);
        int a,b;
        String s;

        for(int i=0;i<100;i++){
            a = rand.nextInt(3);
            b = rand.nextInt(3);
            v1 = new Vector2d(a,a);
            v2 = new Vector2d(b,b);
            Object v3 = (Object) v1;
            Object v4 = (Object) v2;
            assertEquals(v1.equals(v2),v3.equals(v4));
        }


    }
    @Test
    public void toStringTest() {
        Vector2d a = new Vector2d(1, 2);
        String s = a.toString();
        Object s2 = (Object) s;
        assertEquals(s,s2.toString());
    }

    @Test
    public void addTest(){

    }
}
