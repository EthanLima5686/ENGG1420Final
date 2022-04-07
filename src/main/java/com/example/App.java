package com.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import java.lang.Thread;
import java.util.*;
import java.io.IOException;

/**
 * JavaFX App
 * @authors Ethan Lima, Ryan Bertola, and Sashwat Sridhar
 */
public class App extends Application {
    Group root = new Group();

    private static Scene scene;
    private Stage stage;
    public static int FPS = 50; // Default 10, can be altered
    public static int frames = 500; // Default 500, can be altered
    public static List<MasterShape> shapesList = new ArrayList<>();

    /**
     * @param stage The stage for the animation to run on.
     * @Description the AnimationTimer, which will start the animation
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(root, 1000, 500, Color.WHITE);
        stage.setScene(scene);
        stage.show();
        this.stage = stage;
        MyTimer t = new MyTimer();
        t.start();
        
    }
    /**
     * The main function, just exists to satisfy java's needs to be the most annoying
     * language in terms of adding a million and a half keywords to every basic thing.
     * 
     * Ignore that it is 400 lines long, 
     * I could make it a bunch of functions but it's more fun to scroll :)
     * @param args The command line arguments that this code doesn't use
     */
    public static void main(String[] args) {
        ArrayList<String> animationData = new ArrayList<String>();
        /*
        animationData.addAll(Arrays.asList("frames: 1000", "speed: 10fps", "2", " ", "circle", "r: 10", "x: 50", 
        "y: 50", "color: 255,0,0", "effect", "Show", "start: 10", "effect", "Jump", "start: 20", "x: 30", "y: 30", " ", 
        "Rect", "length: 100", "width: 50", "x: 25", "y: 25", "border: 5", "effect", "Hide", "start: 15", "effect", "Show", "start: 30", "effect", "Jump", "start: 50", "x: 200", "y: 200", " "));
        */
       
        animationData = FileHandler.ReadFile("./src/main/java/com/example/input.txt");

        for(String i: animationData){
            if(i.startsWith("frames")){
                String[] strings =  i.split(" ");  // ["frames", "#"]
                int framesCount = Integer.parseInt(strings[1]); // Parses "#" to #
                frames = framesCount;
            }
            if(i.startsWith("speed")){
                String[] strings = i.split(" ");
                String[] strings1 = strings[1].split("f");
                int speed = Integer.parseInt(strings1[0]);
                FPS = speed;
            }
            if (i.isEmpty() || i.startsWith(" ")){
                break;
            }
        }
        int removeUntil = 0;
        for (String i: animationData){
            if (!i.isEmpty() && !i.startsWith(" ")){
                removeUntil++;
            } else {
                break;
            }
        }
        for (int j = removeUntil; j >= 0; j--)
            animationData.remove(j);
        

        while (true){
            ArrayList<String> shapeData = new ArrayList<>();
            removeUntil = 0;
            for (String i: animationData){
                if (!i.isEmpty() && !i.startsWith(" ")){
                    shapeData.add(i);
                    removeUntil++;
                } else {
                    break;
                }
            }

            for (int j = removeUntil; j >= 0; j--){
                if (j != animationData.size())
                    animationData.remove(j);
            }

            int index = 0;
            switch (shapeData.get(0).toLowerCase()) {
                case "circle":
                    int circleX = 0;
                    int circleY = 0;
                    int circleRadius = 0;
                    int circleBorder = 0;
                    Color circleColour = Color.rgb(0, 0, 0);
                    Color circleBorderColour = Color.rgb(0, 0, 0);
                    ArrayList<Effect> circleEffects = new ArrayList<>();
                    for(String i: shapeData){
                        if(i.startsWith("x:") && circleX == 0){
                            String[] strings =  i.split(" ");  // ["x:", "#"]
                            int xPos = Integer.parseInt(strings[1]); // Parses "#" to #
                            circleX = xPos;
                        }
                        if(i.startsWith("y:") && circleY == 0){
                            String[] strings =  i.split(" ");  // ["y:", "#"]
                            int yPos = Integer.parseInt(strings[1]); // Parses "#" to #
                            circleY = yPos;
                        }
                        if(i.startsWith("r:")){
                            String[] strings =  i.split(" ");  // ["r:", "#"]
                            int radius = Integer.parseInt(strings[1]); // Parses "#" to #
                            circleRadius = radius;
                        }
                        if(i.startsWith("border:")){
                            String[] strings = i.split(" ");  // ["border:", "#"]
                            int b = Integer.parseInt(strings[1]); // Parses "#" to #
                            circleBorder = b;
                        }
                        if(i.startsWith("color:")){
                            String[] strings = i.replaceAll("\\s+","").split(":");  // ["color", "#,#,#"]
                            String[] rgb = strings[1].split(",");
                            if (circleColour.getRed() == 0 && circleColour.getBlue() == 0 && circleColour.getGreen() == 0)
                                circleColour = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2])); // Converts to colour variable
                        }
                        if(i.toLowerCase().startsWith("bordercolor:")){
                            String[] strings = i.replaceAll("\\s+","").split(":");  // ["color", "#,#,#"]
                            String[] rgb = strings[1].split(",");
                            if (circleBorderColour.getRed() == 0 && circleBorderColour.getBlue() == 0 && circleBorderColour.getGreen() == 0)
                                circleBorderColour = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2])); // Converts to colour variable
                        }
                        if(i.toLowerCase().startsWith("hide")){
                            String startTime = shapeData.get(index + 1);
                            String[] strings = startTime.split(" ");
                            int start = Integer.parseInt(strings[1]);
                            Hide hideEffect = new Hide(start);
                            circleEffects.add(hideEffect);
                        }
                        if(i.toLowerCase().startsWith("show")){
                            String startTime = shapeData.get(index + 1);
                            String[] strings = startTime.split(" ");
                            int start = Integer.parseInt(strings[1]);
                            Show showEffect = new Show(start);
                            circleEffects.add(showEffect);
                        }
                        if (i.toLowerCase().startsWith("changecolor")){
                            int startTime = 0;
                            Color newColour = Color.rgb(0, 0, 0);
                            String arg1 = shapeData.get(index + 1);
                            String arg2 = shapeData.get(index + 2);
                            if (arg1.toLowerCase().startsWith("start:")){
                                String[] strings = arg1.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            if (arg1.toLowerCase().startsWith("color:")){
                                String[] strings = arg1.replaceAll("\\s+","").split(":");  // ["color", "#,#,#"]
                                String[] rgb = strings[1].split(",");
                                newColour = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
                            }
                            if (arg2.toLowerCase().startsWith("start:")){
                                String[] strings = arg2.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            if (arg2.toLowerCase().startsWith("color:")){
                                String[] strings = arg2.replaceAll("\\s+","").split(":");  // ["color", "#,#,#"]
                                String[] rgb = strings[1].split(",");
                                newColour = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
                            }
                            ChangeColor colorEffect = new ChangeColor(startTime, newColour);
                            circleEffects.add(colorEffect);
                        }
                        if (i.toLowerCase().startsWith("jump")){
                            int startTime = 0;
                            int newX = 0;
                            int newY = 0;
                            String arg1 = shapeData.get(index + 1);
                            String arg2 = shapeData.get(index + 2);
                            String arg3 = shapeData.get(index + 3);
                            if(arg1.startsWith("x:")){
                                String[] strings = arg1.split(" ");
                                newX = Integer.parseInt(strings[1]);
                            }
                            if(arg2.startsWith("x:")){
                                String[] strings = arg2.split(" ");
                                newX = Integer.parseInt(strings[1]);
                            }
                            if(arg3.startsWith("x:")){
                                String[] strings = arg3.split(" ");
                                newX = Integer.parseInt(strings[1]);
                            }
                            if(arg1.startsWith("y:")){
                                String[] strings = arg1.split(" ");
                                newY = Integer.parseInt(strings[1]);
                            }
                            if(arg2.startsWith("y:")){
                                String[] strings = arg2.split(" ");
                                newY = Integer.parseInt(strings[1]);
                            }
                            if(arg3.startsWith("y:")){
                                String[] strings = arg3.split(" ");
                                newY = Integer.parseInt(strings[1]);
                            }
                            if(arg1.startsWith("start:")){
                                String[] strings = arg1.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            if(arg2.startsWith("start:")){
                                String[] strings = arg2.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            if(arg3.startsWith("start:")){
                                String[] strings = arg3.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            Jump jumpEffect = new Jump(startTime, newX, newY);
                            circleEffects.add(jumpEffect);
                        }
                        if (i.isEmpty() || i.startsWith(" ")){
                            break;
                        }
                        index++;
                    }
                    Cir c = new Cir(circleRadius, circleX, circleY, circleBorder, circleEffects);
                    c.r = (int)(circleColour.getRed() * 255);
                    c.g = (int)(circleColour.getGreen() * 255);
                    c.b = (int)(circleColour.getBlue() * 255);
                    c.r_border = (int)(circleBorderColour.getRed() * 255);
                    c.g_border = (int)(circleBorderColour.getGreen() * 255);
                    c.b_border = (int)(circleBorderColour.getBlue() * 255);
                    shapesList.add(c);
                    break;
                case "rect":
                    int rectX = 0;
                    int rectY = 0;
                    int length = 0;
                    int width = 0;
                    int rectBorder = 0;
                    Color rectColour = Color.rgb(0, 0, 0);
                    Color rectBorderColour = Color.rgb(0, 0, 0);
                    ArrayList<Effect> rectEffects = new ArrayList<>();
                    for(String i: shapeData){
                        if(i.startsWith("x:") && rectX == 0){
                            String[] strings =  i.split(" ");  // ["x:", "#"]
                            int xPos = Integer.parseInt(strings[1]); // Parses "#" to #
                            rectX = xPos;
                        }
                        if(i.startsWith("y:") && rectY == 0){
                            String[] strings =  i.split(" ");  // ["y:", "#"]
                            int yPos = Integer.parseInt(strings[1]); // Parses "#" to #
                            rectY = yPos;
                        }
                        if(i.startsWith("length:") && rectY == 0){
                            String[] strings =  i.split(" ");  // ["y:", "#"]
                            int len = Integer.parseInt(strings[1]); // Parses "#" to #
                            length = len;
                        }
                        if(i.startsWith("width:") && rectY == 0){
                            String[] strings =  i.split(" ");  // ["y:", "#"]
                            int wid = Integer.parseInt(strings[1]); // Parses "#" to #
                            width = wid;
                        }
                        if(i.startsWith("border:")){
                            String[] strings = i.split(" ");  // ["border:", "#"]
                            int b = Integer.parseInt(strings[1]); // Parses "#" to #
                            rectBorder = b;
                        }
                        if(i.startsWith("color:")){
                            String[] strings = i.replaceAll("\\s+","").split(":");  // ["color", "#,#,#"]
                            String[] rgb = strings[1].split(",");
                            if (rectColour.getRed() == 0 && rectColour.getBlue() == 0 && rectColour.getGreen() == 0)
                                rectColour = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2])); // Converts to colour variable
                        }
                        if(i.toLowerCase().startsWith("bordercolor:")){
                            String[] strings = i.replaceAll("\\s+","").split(":");  // ["color", "#,#,#"]
                            String[] rgb = strings[1].split(",");
                            if (rectBorderColour.getRed() == 0 && rectBorderColour.getBlue() == 0 && rectBorderColour.getGreen() == 0)
                                rectBorderColour = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2])); // Converts to colour variable
                        }
                        if(i.toLowerCase().startsWith("hide")){
                            String startTime = shapeData.get(index + 1);
                            String[] strings = startTime.split(" ");
                            int start = Integer.parseInt(strings[1]);
                            Hide hideEffect = new Hide(start);
                            rectEffects.add(hideEffect);
                        }
                        if(i.toLowerCase().startsWith("show")){
                            String startTime = shapeData.get(index + 1);
                            String[] strings = startTime.split(" ");
                            int start = Integer.parseInt(strings[1]);
                            Show showEffect = new Show(start);
                            rectEffects.add(showEffect);
                        }
                        if (i.toLowerCase().startsWith("changecolor")){
                            int startTime = 0;
                            Color newColour = Color.rgb(0, 0, 0);
                            String arg1 = shapeData.get(index + 1);
                            String arg2 = shapeData.get(index + 2);
                            if (arg1.toLowerCase().startsWith("start:")){
                                String[] strings = arg1.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            if (arg1.toLowerCase().startsWith("color:")){
                                String[] strings = arg1.replaceAll("\\s+","").split(":");  // ["color", "#,#,#"]
                                String[] rgb = strings[1].split(",");
                                newColour = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
                            }
                            if (arg2.toLowerCase().startsWith("start:")){
                                String[] strings = arg2.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            if (arg2.toLowerCase().startsWith("color:")){
                                String[] strings = arg2.replaceAll("\\s+","").split(":");  // ["color", "#,#,#"]
                                String[] rgb = strings[1].split(",");
                                newColour = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
                            }
                            ChangeColor colorEffect = new ChangeColor(startTime, newColour);
                            rectEffects.add(colorEffect);
                        }
                        if (i.toLowerCase().startsWith("jump")){
                            int startTime = 0;
                            int newX = 0;
                            int newY = 0;
                            String arg1 = shapeData.get(index + 1);
                            String arg2 = shapeData.get(index + 2);
                            String arg3 = shapeData.get(index + 3);
                            if(arg1.startsWith("x:")){
                                String[] strings = arg1.split(" ");
                                newX = Integer.parseInt(strings[1]);
                            }
                            if(arg2.startsWith("x:")){
                                String[] strings = arg2.split(" ");
                                newX = Integer.parseInt(strings[1]);
                            }
                            if(arg3.startsWith("x:")){
                                String[] strings = arg3.split(" ");
                                newX = Integer.parseInt(strings[1]);
                            }
                            if(arg1.startsWith("y:")){
                                String[] strings = arg1.split(" ");
                                newY = Integer.parseInt(strings[1]);
                            }
                            if(arg2.startsWith("y:")){
                                String[] strings = arg2.split(" ");
                                newY = Integer.parseInt(strings[1]);
                            }
                            if(arg3.startsWith("y:")){
                                String[] strings = arg3.split(" ");
                                newY = Integer.parseInt(strings[1]);
                            }
                            if(arg1.startsWith("start:")){
                                String[] strings = arg1.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            if(arg2.startsWith("start:")){
                                String[] strings = arg2.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            if(arg3.startsWith("start:")){
                                String[] strings = arg3.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            Jump jumpEffect = new Jump(startTime, newX, newY);
                            rectEffects.add(jumpEffect);
                        }
                        if (i.isEmpty() || i.startsWith(" ")){
                            break;
                        }
                        index++;
                    }
                    Rect r = new Rect(length, width, rectX, rectY, rectBorder, rectEffects);
                    r.r = (int)(rectColour.getRed() * 255);
                    r.g = (int)(rectColour.getGreen() * 255);
                    r.b = (int)(rectColour.getBlue() * 255);
                    r.red_border = (int)(rectBorderColour.getRed() * 255);
                    r.green_border = (int)(rectBorderColour.getGreen() * 255);
                    r.blue_border = (int)(rectBorderColour.getBlue() * 255);
                    shapesList.add(r);
                    break;
                case "line":
                    int startX = 0;
                    int startY = 0;
                    int endX = 0;
                    int endY = 0;
                    int lineBorder = 0;
                    Color lineColour = Color.rgb(0, 0, 0);
                    Color lineBorderColour = Color.rgb(0, 0, 0);
                    ArrayList<Effect> lineEffects = new ArrayList<>();
                    for(String i: shapeData){
                        if(i.toLowerCase().startsWith("startx:") && startX == 0){
                            String[] strings =  i.split(" "); 
                            int xPos = Integer.parseInt(strings[1]); // Parses "#" to #
                            startX = xPos;
                        }
                        if(i.toLowerCase().startsWith("starty:") && startY == 0){
                            String[] strings =  i.split(" ");  
                            int yPos = Integer.parseInt(strings[1]); // Parses "#" to #
                            startY = yPos;
                        }
                        if(i.toLowerCase().startsWith("endx:") && startX == 0){
                            String[] strings =  i.split(" "); 
                            int xPos = Integer.parseInt(strings[1]); // Parses "#" to #
                            endX = xPos;
                        }
                        if(i.toLowerCase().startsWith("endy:") && startY == 0){
                            String[] strings =  i.split(" ");  
                            int yPos = Integer.parseInt(strings[1]); // Parses "#" to #
                            endY = yPos;
                        }
                        if(i.startsWith("border:")){
                            String[] strings = i.split(" "); 
                            int b = Integer.parseInt(strings[1]); // Parses "#" to #
                            lineBorder = b;
                        }
                        if(i.startsWith("color:")){
                            String[] strings = i.replaceAll("\\s+","").split(":");  // ["color", "#,#,#"]
                            String[] rgb = strings[1].split(",");
                            if (lineColour.getRed() == 0 && lineColour.getBlue() == 0 && lineColour.getGreen() == 0)
                                lineColour = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2])); // Converts to colour variable
                        }
                        if(i.toLowerCase().startsWith("bordercolor:")){
                            String[] strings = i.replaceAll("\\s+","").split(":");  // ["color", "#,#,#"]
                            String[] rgb = strings[1].split(",");
                            if (lineBorderColour.getRed() == 0 && lineBorderColour.getBlue() == 0 && lineBorderColour.getGreen() == 0)
                                lineBorderColour = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2])); // Converts to colour variable
                        }
                        if(i.toLowerCase().startsWith("hide")){
                            String startTime = shapeData.get(index + 1);
                            String[] strings = startTime.split(" ");
                            int start = Integer.parseInt(strings[1]);
                            Hide hideEffect = new Hide(start);
                            lineEffects.add(hideEffect);
                        }
                        if(i.toLowerCase().startsWith("show")){
                            String startTime = shapeData.get(index + 1);
                            String[] strings = startTime.split(" ");
                            int start = Integer.parseInt(strings[1]);
                            Show showEffect = new Show(start);
                            lineEffects.add(showEffect);
                        }
                        if (i.toLowerCase().startsWith("changecolor")){
                            int startTime = 0;
                            Color newColour = Color.rgb(0, 0, 0);
                            String arg1 = shapeData.get(index + 1);
                            String arg2 = shapeData.get(index + 2);
                            if (arg1.toLowerCase().startsWith("start:")){
                                String[] strings = arg1.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            if (arg1.toLowerCase().startsWith("color:")){
                                String[] strings = arg1.replaceAll("\\s+","").split(":");  // ["color", "#,#,#"]
                                String[] rgb = strings[1].split(",");
                                newColour = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
                            }
                            if (arg2.toLowerCase().startsWith("start:")){
                                String[] strings = arg2.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            if (arg2.toLowerCase().startsWith("color:")){
                                String[] strings = arg1.replaceAll("\\s+","").split(":");  // ["color", "#,#,#"]
                                String[] rgb = strings[1].split(",");
                                newColour = Color.rgb(Integer.parseInt(rgb[0]), Integer.parseInt(rgb[1]), Integer.parseInt(rgb[2]));
                            }
                            ChangeColor colorEffect = new ChangeColor(startTime, newColour);
                            lineEffects.add(colorEffect);
                        }
                        if (i.toLowerCase().startsWith("jump")){
                            int startTime = 0;
                            int newX = 0;
                            int newY = 0;
                            String arg1 = shapeData.get(index + 1);
                            String arg2 = shapeData.get(index + 2);
                            String arg3 = shapeData.get(index + 3);
                            if(arg1.startsWith("x:")){
                                String[] strings = arg1.split(" ");
                                newX = Integer.parseInt(strings[1]);
                            }
                            if(arg2.startsWith("x:")){
                                String[] strings = arg2.split(" ");
                                newX = Integer.parseInt(strings[1]);
                            }
                            if(arg3.startsWith("x:")){
                                String[] strings = arg3.split(" ");
                                newX = Integer.parseInt(strings[1]);
                            }
                            if(arg1.startsWith("y:")){
                                String[] strings = arg1.split(" ");
                                newY = Integer.parseInt(strings[1]);
                            }
                            if(arg2.startsWith("y:")){
                                String[] strings = arg2.split(" ");
                                newY = Integer.parseInt(strings[1]);
                            }
                            if(arg3.startsWith("y:")){
                                String[] strings = arg3.split(" ");
                                newY = Integer.parseInt(strings[1]);
                            }
                            if(arg1.startsWith("start:")){
                                String[] strings = arg1.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            if(arg2.startsWith("start:")){
                                String[] strings = arg2.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            if(arg3.startsWith("start:")){
                                String[] strings = arg3.split(" ");
                                startTime = Integer.parseInt(strings[1]);
                            }
                            Jump jumpEffect = new Jump(startTime, newX, newY);
                            lineEffects.add(jumpEffect);
                        }
                        if (i.isEmpty() || i.startsWith(" ")){
                            break;
                        }
                        index++;
                    }
                    Lin l = new Lin(startX, startY, endX, endY, lineBorder, lineEffects);
                    l.r = (int)(lineColour.getRed() * 255);
                    l.g = (int)(lineColour.getGreen() * 255);
                    l.b = (int)(lineColour.getBlue() * 255);
                    shapesList.add(l);
                    break;
                default:
                    System.out.println("Invalid Shape Detected.");
            }
            if (animationData.size() == 0)
                break;
        }
        launch();
    }
    /**
     * The MyTimer class, this handles the animation logic.
     * This is not meant to be used by the public. This is entirely just something for the code.
     * Hence why it's private. Sometimes coding does make sense.
     */
    private class MyTimer extends AnimationTimer {
        int frame = 0;

        public void handle(long now) {
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
                    if (s != null)
                        root.getChildren().add(s);
                } catch (Exception e) {
                    System.out.println(e);
                }
                Shape s = shape.Draw();
                if (s != null){
                    root.getChildren().add(s);
                }
                for (Effect effect: shape.effects) {
                    effect.TestEffect(frame, shape);
                }
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

