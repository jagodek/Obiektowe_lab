package agh.ics.oop;

public class Vector2d {
    public final int x;
    public final int y;
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
        if((other.x<=this.x)&&(other.y>=this.y)){
            return new Vector2d(this.x,other.y);
        }
        if((other.x>=this.x)&&(other.y<=this.y)) {
            return new Vector2d(other.x, this.y);
        }
            return this;
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
    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x-other.x,this.y-other.y);
    }
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d that = (Vector2d) other;
        if (that.x == this.x && that.y == this.y) {
            return true;
        }
        return false;
    }

    public int hashCode(){
        final int r = 2147483647;
        return this.x*r^2 + this.y*r;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Vector2d opposite(){
        return new Vector2d(this.x*(-1),this.y*(-1));
    }
}
