package XML_Json.Json;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileWorker {

    public static String FILEPATH = "./src/main/resources/output/";
    public static String FILENAME = "rate.txt";

    public static void fileWriter(Map<String, Double> rates) throws IOException {
        if (!rates.isEmpty()) {
            FileWriter fileWriter = new FileWriter(FILEPATH + FILENAME);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Map.Entry<String, Double> entry : rates.entrySet()) {
                printWriter.println(entry.getKey()+'\u0009'+entry.getValue());
            }
            printWriter.close();
        }
    }

    public static Map<String, Double> fileReader() throws IOException {
        Map<String, Double> rates = new HashMap<>();

        Files.lines(Paths.get(FILEPATH+FILENAME)).forEach(
                line->rates.put(line.substring(0,line.indexOf('\u0009')),
                        Double.valueOf(line.substring(line.indexOf('\u0009')+1,line.length()))));
        return rates;
    }

}
