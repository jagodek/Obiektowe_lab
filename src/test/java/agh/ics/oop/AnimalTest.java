package agh.ics.oop;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

public class AnimalTest {
    @Test
    public void theTest(){
        Animal cat = new Animal();
        assertEquals(cat.toString(),"(2,2,Północ)");
        cat.move(MoveDirection.RIGHT);
        assertEquals(cat.toString(),"(2,2,Wschód)");
        cat.move(MoveDirection.RIGHT);
        cat.move(MoveDirection.FORWARD);
        cat.move(MoveDirection.FORWARD);
        assertEquals(cat.toString(),"(2,0,Południe)");
        for(int i =0; i<5;i++)
            cat.move(MoveDirection.FORWARD);
        assertEquals(cat.toString(),"(2,0,Południe)");
        for(int i =0; i<7;i++)
            cat.move(MoveDirection.BACKWARD);
        assertEquals(cat.toString(),"(2,4,Południe)");
        cat.move(MoveDirection.LEFT);
        for(int i =0; i<7;i++)
            cat.move(MoveDirection.BACKWARD);
        assertEquals(cat.toString(),"(0,4,Wschód)");
        for(int i =0; i<5;i++)
            cat.move(MoveDirection.FORWARD);
        assertEquals(cat.toString(),"(4,4,Wschód)");

    }

}
