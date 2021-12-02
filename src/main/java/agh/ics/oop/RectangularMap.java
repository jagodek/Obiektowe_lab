package agh.ics.oop;
import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap implements IWorldMap,IPositionChangeObserver{


    public RectangularMap(int width,int height){
        this.width = width-1;
        this.height = height-1;
    }

    /**public String toString(){
        MapVisualizer mapa = new MapVisualizer(this);
        String draw = mapa.draw(new Vector2d(0,0),new Vector2d(width,height));
        return draw;
    }*/
    @Override
    public Vector2d[] corners(){
        MapVisualizer mapaR = new MapVisualizer(this);
        Vector2d ld = new Vector2d(0,0);
        Vector2d pg = new Vector2d(width,height);
        Vector2d[] ret = {ld,pg};
        return ret;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.follows(new Vector2d(0,0))&&position.precedes(new Vector2d(width,height))&&!isOccupied(position)){
            return true;
        }
        return false;
    }




}
