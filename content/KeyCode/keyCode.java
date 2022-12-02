import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;

public class keyCode {
    public static void main(String[] args) {
        try {
            ArrayList<String> symbols = new ArrayList<String>();
            symbols.add("^");
            symbols.add("v");
            symbols.add("7");
            symbols.add("c");
            symbols.add("A");
            symbols.add("B");
            symbols.add("L");
            symbols.add("R");
            symbols.add("Select");
            symbols.add("Start");
            for(int i=0;i<5;
            for(String symbol : symbols) {
                File folder = new File(symbol);
                File myObj = new File("README.md");
                if (folder.mkdir()) {
                    System.out.println("File created: " + folder.getName());
                } else {
                    System.out.println("File already exists.");
                }
                
            }
            if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}