package com.bayok.task1.file;

import com.bayok.task1.exceptions.FileIsMissingException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {
    private static final Logger LOGGER = LogManager.getLogger();
    public List<String> readFile(String fileName)  throws FileIsMissingException {

        List<String> listOfLines = null;
        File f = new File(fileName);
        if (f.exists() &&  f.isFile()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(fileName));
                listOfLines = new ArrayList<>();
                String currentLine;
                while ((currentLine = br.readLine()) != null) {
                    listOfLines.add(currentLine);
                }
            }
            catch (IOException e) {
                LOGGER.fatal("Error during file read");

            }
            finally {
                try {
                    br.close();
                } catch (IOException e) {
                    LOGGER.log(Level.ERROR,"Cannot close buffered reader");
                }
            }
        }
        else  {
            throw new FileIsMissingException(fileName);
        }
        return listOfLines;
    }
}
