package agh.ics.oop;

import java.util.Comparator;

public class ComparatorX implements Comparator<IMapElement> {


    @Override
    public int compare(IMapElement o1, IMapElement o2) {
        if(o1.getPosition().getX()!=o2.getPosition().getX()){
            return Integer.compare(o1.getPosition().getX(),o2.getPosition().getX());
        }
        if(o1.getPosition().getY()!=o2.getPosition().getY()){
            return Integer.compare(o1.getPosition().getY(),o2.getPosition().getY());
        }
        if(o2 instanceof Grass) {
            return 1;
        }
        return 0;
    }
}
