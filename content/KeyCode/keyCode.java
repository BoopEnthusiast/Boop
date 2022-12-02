import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.ArrayList;
import java.io.*;

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
            File copy = new File("dictionary.txt");
            for(int i=0;i<6;i++){
                for(String symbol : symbols) {
                    for(String symbol2 : symbols) {
                        for(String symbol3 : symbols) {
                            for(String symbol4 : symbols) {
                                File folder = new File("D:\\Hugo\\Sites\\Boop\\content\\Labyrinth\\"+symbol);
                                File myObj = new File("D:\\Hugo\\Sites\\Boop\\content\\Labyrinth\\"+"README.md");
                                if(i == 1) {
                                    folder = new File("D:\\Hugo\\Sites\\Boop\\content\\Labyrinth\\"+symbol+"\\"+symbol2);
                                    myObj = new File("D:\\Hugo\\Sites\\Boop\\content\\Labyrinth\\"+symbol+"\\"+"README.md");
                                }else if(i == 2) {
                                    folder = new File("D:\\Hugo\\Sites\\Boop\\content\\Labyrinth\\"+symbol+"\\"+symbol2+"\\"+symbol3);
                                    myObj = new File("D:\\Hugo\\Sites\\Boop\\content\\Labyrinth\\"+symbol+"\\"+symbol2+"\\"+"README.md");
                                }else if(i == 3) {
                                    folder = new File("D:\\Hugo\\Sites\\Boop\\content\\Labyrinth\\"+symbol+"\\"+symbol2+"\\"+symbol3+"\\"+symbol4);
                                    myObj = new File("D:\\Hugo\\Sites\\Boop\\content\\Labyrinth\\"+symbol+"\\"+symbol2+"\\"+symbol3+"\\"+"README.md");
                                }else if(i == 4) {
                                    myObj = new File("D:\\Hugo\\Sites\\Boop\\content\\Labyrinth\\"+symbol+"\\"+symbol2+"\\"+symbol3+"\\"+symbol4+"\\"+"README.md");
                                }
                                if (folder.mkdir()) {
                                    System.out.println("File created: " + folder.getName());
                                } else {
                                    System.out.println("File already exists.");
                                }
                                if (myObj.createNewFile()) {
                                    System.out.println("File created: " + myObj.getName());
                                    copyFileUsingStream(copy, myObj);
                                }else {
                                    System.out.println("File already exists.");
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}