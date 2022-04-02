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
        Rect rect = new Rect(300, 300, 50, 50, 10);
        Cir circ = new Cir(100, 225, 225, 20);
        Lin line = new Lin(200, 200, 500, 300, 50);
        public void handle(long now) {
            frame++;
            if (frame > 500){
                stop();
                System.exit(0);
            }
            Group root = new Group();
            root.getChildren().clear();
            try{
                Rectangle r_border = rect.DrawBorder();
                root.getChildren().add(r_border);
            } catch (Exception e){
                System.out.println(e);
            }
            Rectangle r = rect.Draw();
            root.getChildren().add(r);
            try{
                Circle c_border = circ.DrawBorder();
                root.getChildren().add(c_border);
            } catch (Exception e){
                System.out.println(e);
            }
            Circle c = circ.Draw();
            root.getChildren().add(c);
            try{
                Shape l_border = line.DrawBorder();
                root.getChildren().add(l_border);
            } catch (Exception e){
                System.out.println(e);
            }
            Line l = line.Draw();
            root.getChildren().add(l);

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

