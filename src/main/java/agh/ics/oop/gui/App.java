package agh.ics.oop.gui;

import agh.ics.oop.World;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import agh.ics.oop.*;
import java.util.List;



public class App extends javafx.application.Application{



    @Override
    public void start(Stage primaryStage) {
        primaryStage.show();
        Label label = new Label("Zwierzak");
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        Scene scene = new Scene(grid, 400, 400);




        List<String> args = getParameters().getRaw();
        String[] instructions = new String[args.size()];
        int j =0;
        for(String i:args)
        {
            instructions[j] = i;
            j++;
        }

        MoveDirection[] directions = new OptionsParser().parse(instructions);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        GrassField mapa = (GrassField) map;
        System.out.println(mapa);
        Vector2d[] v =  mapa.corners();
        int x1= v[0].getX();
        int x2 = v[1].getX();
        int y1 = v[0].getY();
        int y2 = v[1].getY();

        grid.add(new Label("y/x"), 0, 0);
        grid.getColumnConstraints().add(new ColumnConstraints(x2-x1));
        grid.getRowConstraints().add(new RowConstraints(y2-y1));
        GridPane.setHalignment(label, HPos.CENTER);

        for(int i=1;i<=x2-x1+1;i++){
            grid.add(new Label(Integer.toString(i+x1-1)), i, 0);

        }

        for(int  i=1;i<y2-y1+2;i++)
        {
            grid.add(new Label(Integer.toString(y2+1-i)), 0, i);

        }
        for(int i=1;i<=x2-x1+1;i++){
            for(int  k=1;k<=y2-y1+1;k++){
                if(mapa.isOccupied(new Vector2d(x1+i-1,y2-k+1))){
                    grid.add(new Label(mapa.objectAt(new Vector2d(x1+i-1,y2-k+1)).toString()), i, k);
                    grid.getColumnConstraints().add(new ColumnConstraints(20));
                    grid.getRowConstraints().add(new RowConstraints(20));
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }



        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
