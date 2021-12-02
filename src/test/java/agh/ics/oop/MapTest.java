package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MapTest {
    @Test
    void rectangularTest(){

        MoveDirection[] directions = new OptionsParser().parse(new String[]{"b","f","r","r","b","f","b","b"});
        IWorldMap map = new RectangularMap(3,4);
        Vector2d[] positions =  { new Vector2d(2,2), new Vector2d(0,0) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        engine.run();
        assertTrue(map.isOccupied(new Vector2d(1,1)));
        assertTrue(map.objectAt(new Vector2d(1,1)) instanceof Animal);
        assertTrue(map.isOccupied(new Vector2d(0,1)));
        assertFalse(map.canMoveTo(new Vector2d(1,1)));

        try{
            directions = new OptionsParser().parse(new String[]{"b","f","aaaaaaa","r","b","f","b","b"});
            assertTrue(false);
        }
        catch (IllegalArgumentException i){
            assertTrue(true);
        }
        try{
            directions = new OptionsParser().parse(new String[]{"b","f","f","r","b","f","b","b"});
            map = new RectangularMap(3,4);
            Vector2d[] positions3 =  { new Vector2d(2,2), new Vector2d(2,2) };
            engine = new SimulationEngine(directions, map, positions);
            assertTrue(false);
        }
        catch (IllegalArgumentException i){
            assertTrue(true);
        }

    }

    @Test
    void grassTest(){
            MoveDirection[] directions = new OptionsParser().parse(new String[]{"b", "f", "r", "r", "b", "f", "b", "b"});
            IWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(0, 0)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            assertTrue(map.isOccupied(new Vector2d(2, 2)));
            assertFalse(map.canMoveTo(new Vector2d(2, 2)));
            engine.run();
            assertTrue(map.objectAt(new Vector2d(1, 1)) instanceof Animal);
            Animal animal = (Animal) map.objectAt(new Vector2d(1, 1));
            assertEquals(MapDirection.EAST, animal.getDirection());
            assertTrue(map.objectAt(new Vector2d(-1, 1)) instanceof Animal);


    }


}
