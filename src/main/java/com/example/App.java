package com.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import java.lang.Thread;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {
    Group root = new Group();

    private static Scene scene;
    private Stage stage;
    public int FPS = 10; // Default 10, can be altered

    @Override
    public void start(Stage stage) throws IOException {
        Rectangle r = new Rectangle(25,25,250,250);
        r.setFill(Color.BLUE);
        root.getChildren().add(r);
        
        Line l = new Line(0, 0, 100, 100);
        l.setStroke(Color.RED);
        root.getChildren().add(l);
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
        int x = 0;
        public void handle(long now) {
            frame++;
            if (frame > 500){
                stop();
                System.exit(0);
            }
            Group root = new Group();
            root.getChildren().clear();
            Rectangle r = new Rectangle(x,25,250,250);
            r.setFill(Color.BLUE);
            root.getChildren().add(r);
            x++;
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

