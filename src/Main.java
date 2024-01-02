import java.io.*;
import java.util.*;

public class Main {

    // recursively looks for file based on endsWith extension
    static void processDirectories(String pathToCheck, String endsWith, ArrayList<String> paths) {
        File currentDir = new File(pathToCheck);
        File[] listFiles = currentDir.listFiles();

        if(listFiles == null) {
            return;
        }

        for(File f : listFiles) {
            if(f.isDirectory()) {
                processDirectories(f.getPath(), endsWith, paths);
            } else if(f.isFile()) {
                if(f.getName().endsWith(endsWith)) {
                    paths.add(f.getAbsoluteFile().toString());
                }
            }
        }
    }

    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Jcounter v1.0 JAVA Edition\n");
            System.out.println("Usage:");
            System.out.println("java -jar jcounter.jar path endswith");
            return;
        }

        String pathToCheck = args[0];
        String endsWith = args[1];

        File pathTest = new File(pathToCheck);
        if(!pathTest.exists()) {
            System.out.println("Directory doesn't exist");
            return;
        }

        ArrayList<String> paths = new ArrayList<>();
        processDirectories(pathToCheck, endsWith, paths);

        int linesCount = 0;

        for(String fileName : paths) {
            try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                while(br.readLine() != null) {
                    linesCount++;
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("Counted lines: " + linesCount);
    }
}