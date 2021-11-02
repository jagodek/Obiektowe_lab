package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Vectro2dTest {
    @Test
    public void equalsTest(){
        Vector2d v1 = new Vector2d(1,6);
        Vector2d v2 = new Vector2d(-2,-2);
        assertFalse(v1.equals(v2));
        v2 = new Vector2d(1,6);
        assertTrue(v1.equals(v2));
    }
    @Test
    public void toStringTest() {
        Vector2d a = new Vector2d(1, 2);
        String s = a.toString();
        Object s2 = (Object) s;
        assertEquals(s,s2.toString());
        assertEquals(s,"(" + a.x+","+a.y+")");

    }

    @Test
    public void addTest(){
        Vector2d v1 = new Vector2d(1,6);
        Vector2d v2 = new Vector2d(-2,-2);
        Vector2d v3 = v1.add(v2);
        assertEquals(v3,new Vector2d(v1.x+v2.x,v1.y+v2.y));
    }
    @Test
    public void subtract(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        assertEquals(v1.subtract(v2),new Vector2d(0,0));
        v1 = new Vector2d(3,4);
        v2 = new Vector2d(1,1);
        Vector2d v3 = v1.subtract(v2);
        assertEquals(v3, new Vector2d(v1.x-v2.x,v1.y-v2.y));
    }
    @Test
    public void testFollows(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(0,0);
        Vector2d v3 = new Vector2d(0,2);
        Vector2d v4 = new Vector2d(2,0);
        Vector2d v5 = new Vector2d(2,2);
        assertTrue(v1.follows(v2));
        assertFalse(v1.follows(v3));
        assertFalse(v1.follows(v4));
        assertFalse(v1.follows(v5));
    }
    @Test
    public void testPrecedes(){
        Vector2d v1 = new Vector2d(1,1);
        Vector2d v2 = new Vector2d(0,0);
        Vector2d v3 = new Vector2d(0,2);
        Vector2d v4 = new Vector2d(2,0);
        Vector2d v5 = new Vector2d(2,2);
        assertFalse(v1.precedes(v2));
        assertFalse(v1.precedes(v3));
        assertFalse(v1.precedes(v4));
        assertTrue(v1.precedes(v5));
    }
    @Test
    public void upperRightTest(){
        Vector2d v1 = new Vector2d(2,2);
        Vector2d v2 = new Vector2d(1,6);
        Vector2d v3 = new Vector2d(6,8);
        Vector2d v4 = new Vector2d(1,0);
        Vector2d v5 = new Vector2d(8,0);
        assertEquals(v1.upperRight(v2),new Vector2d(2,6));
        assertEquals(v1.upperRight(v3),new Vector2d(6,8));
        assertEquals(v1.upperRight(v4),new Vector2d(2,2));
        assertEquals(v1.upperRight(v5),new Vector2d(8,2));
    }

    @Test
    public void lowerLeftTest(){
        Vector2d v1 = new Vector2d(2,2);
        Vector2d v2 = new Vector2d(1,6);
        Vector2d v3 = new Vector2d(6,8);
        Vector2d v4 = new Vector2d(1,0);
        Vector2d v5 = new Vector2d(8,0);
        assertEquals(v1.lowerLeft(v2),new Vector2d(1,2));
        assertEquals(v1.lowerLeft(v3),new Vector2d(2,2));
        assertEquals(v1.lowerLeft(v4),new Vector2d(1,0));
        assertEquals(v1.lowerLeft(v5),new Vector2d(2,0));
    }
    @Test
    public void oppositeTest(){
        Vector2d v1 = new Vector2d(3,3);
        assertEquals(v1.opposite(),new Vector2d(-3,-3));
        v1 = new Vector2d(-1,-65);
        assertEquals(v1.opposite(),new Vector2d(1,65));
    }

}
