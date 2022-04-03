package com.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    Group root = new Group();

    private static Scene scene;
    private Stage stage;
    public int FPS = 50; // Default 10, can be altered

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(root, 1000, 500, Color.WHITE);
        stage.setScene(scene);
        stage.show();
        this.stage = stage;
        MyTimer t = new MyTimer();
        t.start();
        
    }

    public static void main(String[] args) {
        launch();
    }

    private class MyTimer extends AnimationTimer {
        int frame = 0;
        int frames = 1000;
        Rect rect = new Rect(300, 300, 50, 50, 10);
        Cir circ = new Cir(100, 225, 225, 20);
        Lin line = new Lin(200, 200, 500, 300, 2);
        List<MasterShape> shapesList = new ArrayList<>();

        public void handle(long now) {
            shapesList.add(rect);
            shapesList.add(circ);
            shapesList.add(line);
            frame++;
            if (frame > frames){
                stop();
                System.exit(0);
            }
            Group root = new Group();
            root.getChildren().clear();
            for (MasterShape shape : shapesList){
                try {
                    Shape s = shape.DrawBorder();
                    root.getChildren().add(s);
                } catch (Exception e) {
                    System.out.println(e);
                }
                Shape s = shape.Draw();
                root.getChildren().add(s);
            }

            scene = new Scene(root, 1000, 500, Color.WHITE);
            stage.setScene(scene);
            stage.show();
            try {
                Thread.sleep(1000 / FPS);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

