package agh.ics.oop.gui;

import static java.lang.System.in;
import static java.lang.System.out;

import agh.ics.oop.World;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import agh.ics.oop.*;

import java.io.FileNotFoundException;
import java.util.List;



public class App extends javafx.application.Application implements IPositionChangeObserver{
    private GridPane grid = new GridPane();
    private GrassField map;
    private Label label = new Label("Zwierzak");
    private String[] instructions;
    private GrassSimulationEngine engine;
    private Stage pS;
    private Scene scene;
    private Thread engineThread;
    private String noweInstrukcje;
    private int size = 40;



    public void init(){
        List<String> args;
        if( !getParameters().getRaw().isEmpty()) {
            args = getParameters().getRaw();
            instructions = new String[args.size()];

            int j =0;

            for(String i:args)
            {
                instructions[j] = i;
                j++;
            }
    }


        MoveDirection[] directions = new OptionsParser().parse(instructions);
        map = new GrassField(1);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        engine = new GrassSimulationEngine(directions, map, positions,this);
        engineThread = new Thread(engine);

    }

    @Override
    public void start(Stage primaryStage){
        this.pS = primaryStage;
        primaryStage.setAlwaysOnTop(true);
        Group root = new Group();
        HBox row = new HBox();
        Button first = new Button("Start");
        TextField instrukcje = new TextField();
        first.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String[] ins = instrukcje.getText().split(" ");
                engine.setDirections(new OptionsParser().parse(ins));
                engineThread = new Thread(engine);
                engineThread.start();
            }
        });
        row.getChildren().addAll(first,instrukcje);
        root.getChildren().add(row);
        root.getChildren().add(grid);
        grid.setLayoutY(30);
        scene = new Scene(root, 600, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
        grid.setGridLinesVisible(true);
        setGrid();
        engineThread.start();
    }


    public void setGrid(){
        Vector2d[] v =  map.corners();
        int x1= v[0].getX();
        int x2 = v[1].getX();
        int y1 = v[0].getY();
        int y2 = v[1].getY();



        grid.add(new Label("y/x"), 0, 0);
        grid.getColumnConstraints().add(new ColumnConstraints(size));
        grid.getRowConstraints().add(new RowConstraints(size));

        for(int i=1;i<=x2-x1+1;i++){
            grid.add(new Label(Integer.toString(i+x1-1)), i, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(size));
        }
        for(int  i=1;i<y2-y1+2;i++)
        {
            grid.add(new Label(Integer.toString(y2+1-i)), 0, i);
            grid.getRowConstraints().add(new RowConstraints(size));
        }

        for(int i=1;i<=x2-x1+1;i++){
            for(int  k=1;k<=y2-y1+1;k++){
                if(map.isOccupied(new Vector2d(x1+i-1,y2-k+1))){
                    try{
                        IMapElement object = (IMapElement) map.objectAt(new Vector2d(x1 + i - 1, y2 - k + 1));
                        grid.add((new GuiElementBox(object).getBox()), i, k);
                    }
                    catch (FileNotFoundException a){
                        grid.add(new Label(map.objectAt(new Vector2d(x1+i-1,y2-k+1)).toString()), i, k);
                    }

                }
            }
        }
    }


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                grid.getChildren().clear();
                setGrid();
                grid.setGridLinesVisible(false);
                grid.setGridLinesVisible(true);
            }
        });

    }
}


//.\gradlew.bat run --args="f b r l f f r r f f f f f f f f"
