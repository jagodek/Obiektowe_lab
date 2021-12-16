package agh.ics.oop;
import java.util.*;
import static java.lang.System.out;




public class MapBoundary implements IPositionChangeObserver {
    private Comparator comparatorX = new ComparatorX();
    private SortedSet<IMapElement> xAxis = new TreeSet(comparatorX);

    private Comparator comparatorY = new ComparatorY();
    private SortedSet<IMapElement> yAxis = new TreeSet(comparatorY);

    private GrassField map;

    public MapBoundary(GrassField grassField) {
        this.map = grassField;
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
            Animal animal = map.animals.get(newPosition);
                xAxis.remove(animal);
                yAxis.remove(animal);
                addElement(animal);



    }

    public void addElement(IMapElement element){

        xAxis.add(element);
        yAxis.add(element);
    }


    public Vector2d[] getCorners(){
        Vector2d lowerLeft = new Vector2d(xAxis.first().getPosition().getX(),yAxis.first().getPosition().getY());
        Vector2d upperRight = new Vector2d(xAxis.last().getPosition().getX(),yAxis.last().getPosition().getY());
        Vector2d[] output = {lowerLeft,upperRight};
        return output;
    }




}
