package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

public class AnimalTest {
    @Test
    public void theTest(){
        Animal cat = new Animal();
        assertEquals(new Vector2d(2,2),cat.getPosition());
        assertEquals(MapDirection.NORTH,cat.getDirection());
        cat.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST,cat.getDirection());
        assertEquals(new Vector2d(2,2),cat.getPosition());
        cat.move(MoveDirection.RIGHT);
        cat.move(MoveDirection.FORWARD);
        cat.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,0),cat.getPosition());
        assertEquals(MapDirection.SOUTH,cat.getDirection());
        for(int i =0; i<5;i++)
            cat.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,0),cat.getPosition());
        assertEquals(MapDirection.SOUTH,cat.getDirection());
        for(int i =0; i<7;i++)
            cat.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(2,4),cat.getPosition());
        assertEquals(MapDirection.SOUTH,cat.getDirection());
        cat.move(MoveDirection.LEFT);
        for(int i =0; i<7;i++)
            cat.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(0,4),cat.getPosition());
        assertEquals(MapDirection.EAST,cat.getDirection());
        for(int i =0; i<5;i++)
            cat.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4,4),cat.getPosition());
        assertEquals(MapDirection.EAST,cat.getDirection());
    }
}
