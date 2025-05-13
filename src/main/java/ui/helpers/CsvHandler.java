package ui.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvHandler {

    public static String[][] readCsv(String path) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            ArrayList<String[]> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null){
                lines.add(line.split(","));
            }
            return lines.toArray(new String[0][0]);
        }
    }
}
