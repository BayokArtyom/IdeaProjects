package com.bayok.task1.file;

import com.bayok.task1.exceptions.FileIsMissingException;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    //private static final Logger LOGGER = LogManager.getLogger();
    private static final String FILENAME = "./src/com/bayok/task1/file/input.txt";
    private static List<String> aLine;

    public static void readFile()  throws FileIsMissingException {
        File f = new File(FILENAME);
        if (f.exists() && !f.isDirectory()&& f.isFile()) {
            try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
                aLine = new ArrayList<>();
                String currentLine;
                while ((currentLine = br.readLine()) != null) {
                    aLine.add(currentLine);
                }
                br.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            //finally {
           //     br.close();
           // }
        }
        else  {
            throw new FileIsMissingException(FILENAME);
        }
    }
    public static List<String> getList() {
        return aLine;
    }
}
