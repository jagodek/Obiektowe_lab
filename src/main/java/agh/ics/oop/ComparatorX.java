package agh.ics.oop;

import javafx.util.Pair;

import java.util.Comparator;

public class ComparatorX implements Comparator<Pair<Vector2d,Class>> {
    @Override
    public int compare(Pair<Vector2d,Class> o1, Pair<Vector2d,Class> o2) {
        if(o1.getKey().getX()!=o2.getKey().getX()){
            return Integer.compare(o1.getKey().getX(),o2.getKey().getX());
        }
        if(o1.getKey().getY()!=o2.getKey().getY()){
            return Integer.compare(o1.getKey().getY(),o2.getKey().getY());
        }
        if((o1.getValue()==Animal.class)&&(o2.getValue()==Grass.class)){
            return 1;
        }
        if((o1.getValue()==Grass.class)&&(o2.getValue()==Animal.class)){
            return -1;
        }
        return 0;
    }


}
