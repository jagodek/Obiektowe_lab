package agh.ics.oop;
import java.util.*;





public class MapBoundary implements IPositionChangeObserver {
    Comparator comparatorX = new ComparatorX();
    SortedSet<IMapElement> xAxis = new TreeSet(comparatorX);

    Comparator comparatorY = new ComparatorY();
    SortedSet<IMapElement> yAxis = new TreeSet(comparatorY);


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IMapElement i : xAxis) {
            if (i instanceof Animal && i.getPosition().equals(oldPosition)) {
                xAxis.remove(i);
                yAxis.remove(i);
            }
        }
    }

    public void addElement(IMapElement element){
        xAxis.add(element);
        yAxis.add(element);
    }



}
