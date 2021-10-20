package agh.ics.oop;
import java.util.Map;

import static java.lang.System.out;

public class World {

    enum MoveDirection{
        FORWARD,
        BACKWARD,
        RIGHT,
        LEFT;
    }


    public static class Vector2d{
        public int x;
        public int y;
        public Vector2d(int x ,int y){
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "(" + x +","+y + ')';
        }
        public boolean precedes(Vector2d other){
            return (other.x>=this.x)&&(other.y>=this.y);
        }
        public boolean follows(Vector2d other){
            return (other.x<=this.x)&&(other.y<=this.y);
        }
        public Vector2d upperRight(Vector2d other){
            if((other.x>=this.x)&&(other.y>=this.y)){
                return other;
            }
            else if((other.x<=this.x)&&(other.y>=this.y)){
                return new Vector2d(this.x,other.y);
            }
            else if((other.x>=this.x)&&(other.y<=this.y)) {
                return new Vector2d(other.x, this.y);
            }
            else{
                return this;
            }
        }
        public Vector2d lowerLeft(Vector2d other){
            if((other.x<=this.x)&&(other.y<=this.y)){
                return other;
            }
            else if((other.x<=this.x)&&(other.y>=this.y)){
                return new Vector2d(other.x,this.y);
            }
            else if((other.x>=this.x)&&(other.y<=this.y)) {
                return new Vector2d(this.x, other.y);
            }
            else{
                return this;
            }
        }
        public Vector2d add(Vector2d other){
            return new Vector2d(this.x+other.x,this.y+other.y);
        }
        public Vector2d substract(Vector2d other){
            return new Vector2d(this.x-other.x,this.y-other.y);
        }
        public boolean equals(Object other){
            if (this == other) {
                return true;
            }
            else {
                return false;
            }
        }
        public Vector2d opposite(){
            return new Vector2d(this.x*(-1),this.y*(-1));
        }
    }

    public static void run(Direction.Directions[] instrukcje) {
        out.println("Zwierzak idzie do przodu");
        for (Direction.Directions argument : instrukcje) {
            if (argument == Direction.Directions.FORWARD) {
                out.println("Do przodu");
            }
            else if (argument ==Direction.Directions.BACKWARD) {
                out.println("Do tyłu");
            }
            else if (argument == Direction.Directions.LEFT) {
                out.println("W lewo");
            }
            else if (argument == Direction.Directions.RIGHT) {
                out.println("W prawo");
            }
        }
    }

    public static void main(String[] args) {
        out.println("Start");
        Direction.Directions[] i = {Direction.Directions.BACKWARD, Direction.Directions.FORWARD};
        run(i);
        out.println("Stop");
        Vector2d position1 = new Vector2d(1,2);
        out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        out.println(position2);
        out.println(position1.add(position2));
        MapDirection.MapDirection a = MapDirection.MapDirection.NORTH;
        out.println(a.next());
        out.println(a.previous());
        out.println(a.toUnitVector());
        out.println(a.toString());
    }
}


