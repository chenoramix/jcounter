import java.io.*;
import java.util.*;

public class Main {

    static void processDirectories(String pathToCheck, String endsWith, ArrayList<String> paths) {
        paths.add("test");
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

        ArrayList<String> paths = new ArrayList<String>();
        processDirectories(pathToCheck, endsWith, paths);

        for(int a = 0; a < paths.size(); a++) {
            System.out.println(paths.get(a));
        }
    }
}