package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Connor Johnsons part: File handling: File -> arraylist -> displayment;data for animations
 */

public class InputFiles {

    static ArrayList<String> ReadFile(String fileName) throws IOException{
        ArrayList<String> animations = new ArrayList<String>();
        BufferedReader input = null;
        
        try {
            input = new BufferedReader(new FileReader(fileName));
            Scanner sc = new Scanner(input);
        if(input.readLine() != null) {
           while (sc.hasNextLine()) {
            animations.add(sc.nextLine());
           }
        }
        sc.close();
    } catch (Exception e) {
        System.out.println(e);
        } finally {
            if(input!=null) input.close();
        }
        display(animations);
        return animations; 
    }

    private static void display(ArrayList<String> animations) {
        System.out.println("The following animations will occur on the screen: ");
        System.out.println(animations);
    }
}
