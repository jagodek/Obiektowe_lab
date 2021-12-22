package agh.ics.oop;
import javafx.util.Pair;

import java.util.*;


public class MapBoundary implements IPositionChangeObserver {
    private Comparator<Pair<Vector2d,Class>> comparatorX = new ComparatorX();
    private SortedSet<Pair<Vector2d,Class>> xAxis = new TreeSet(comparatorX);

    private Comparator<Pair<Vector2d,Class>> comparatorY = new ComparatorY();
    private SortedSet<Pair<Vector2d,Class>> yAxis = new TreeSet(comparatorY);

    private GrassField map;

    public MapBoundary(GrassField grassField) {
        this.map = grassField;
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animalNow = map.animals.get(newPosition);
        removeElement(oldPosition);
        addElement(animalNow);

    }

    public void addElement(IMapElement element){
        xAxis.add(new Pair(element.getPosition(),element.getClass()));
        yAxis.add(new Pair(element.getPosition(),element.getClass()));
    }

    public void removeElement(Vector2d key){
        Pair<Vector2d,Class> p= new Pair<>(key,Animal.class);
        xAxis.remove(p);
        yAxis.remove(p);
    }


    public Vector2d[] getCorners(){
        Vector2d lowerLeft = new Vector2d(xAxis.first().getKey().getX(),yAxis.first().getKey().getY());
        Vector2d upperRight = new Vector2d(xAxis.last().getKey().getX(),yAxis.last().getKey().getY());
        Vector2d[] output = {lowerLeft,upperRight};
        return output;
    }




}
