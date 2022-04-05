package com.example;

import java.util.*;
import java.io.*;

public class FileHandler {

    /**
     * The function to load a file into the code, giving it all of the commands that you want it to run.
     * @param fileName The path to the file of the animation commands
     * @return ArrayList<String> of animation commands listed in the specified file
     */
    static ArrayList<String> ReadFile(String fileName){
        ArrayList<String> animations = new ArrayList<String>();

        try{
            File myInput = new File(fileName);
            Scanner myScanner = new Scanner(myInput);
            while (myScanner.hasNextLine()){
                animations.add(myScanner.nextLine());
            }
            myScanner.close();
            return animations;
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
