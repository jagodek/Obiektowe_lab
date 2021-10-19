package agh.ics.oop;

public class Direction {
    enum Directions {
        FORWARD(1),
        BACKWARD(2),
        RIGHT(3),
        LEFT(4);

        private int w;
        private Directions(int w){
            this.w = w;
        }

        public int getDirection(){
            return w;
        }

    }
}
