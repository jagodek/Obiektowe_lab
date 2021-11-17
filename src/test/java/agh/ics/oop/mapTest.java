package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;
import static java.lang.System.out;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class mapTest {
    @Test
    void MapTest(){
        MoveDirection[] directions = new OptionsParser().parse(new String[]{"b","f","r","r","b","f"});
        RectangularMap map = new RectangularMap(3,4);
        IWorldMap map1 = new RectangularMap(6,2);
        if (map1 instanceof RectangularMap)
            out.println("PROSTOKĄT");
        Vector2d[] positions =  { new Vector2d(2,2), new Vector2d(0,0) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        ArrayList<Animal> animals = map.getAnimals();
        Animal a1= animals.get(0);
        Animal a2= animals.get(1);
        assertTrue(map.isOccupied(new Vector2d(2,2)));
        assertFalse(map.canMoveTo(new Vector2d(2,2)));
        assertTrue(map.place(a1));

        engine.run();

        assertEquals(new Vector2d(1,1),a1.getPosition());
        assertEquals(new Vector2d(0,1),a2.getPosition());
        assertEquals(MapDirection.EAST,a1.getDirection());
        assertEquals(MapDirection.EAST,a2.getDirection());
        out.println(map);
    }


}
