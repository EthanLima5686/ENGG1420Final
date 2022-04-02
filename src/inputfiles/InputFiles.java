
package inputfiles;
import java.io.*;
import java.util.*;
public class InputFiles {
   

    public static void main(String[] args)throws IOException {
        BufferedReader input = null;
        List<String> animations = new ArrayList<String>();
       
        // Reads the lines of text into Array list
        try{
            input = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\Classes Winter 2022\\Object-Oriented Programming\\names.txt"));
            String animationText;
            while((animationText = input.readLine()) != null) { //check whether file can be read
                animations.add(animationText); //Add the line of text to the array list
                }
        }finally{
                if(input!=null) input.close();
              }
        
        display(animations);
        System.out.println();  
        
    }
    public static void display(Collection<String> L1) {
            for(String x: L1)
                System.out.println(x);
        }
        
}
