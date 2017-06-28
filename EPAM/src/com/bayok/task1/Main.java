package com.bayok.task1;

import com.bayok.task1.calculations.CalculatePlane;
import com.bayok.task1.exceptions.FileIsMissingException;
import com.bayok.task1.file.DataParser;
import com.bayok.task1.file.FileParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final String FILE_NAME = "input.txt";
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String args[])throws FileIsMissingException {

        FileParser fp = new FileParser();
        DataParser dp = new DataParser();
        CalculatePlane cp = new CalculatePlane();

        printResult(cp.calculatePlane(dp.parseArray(fp.readFile(FILE_NAME))));
    }
    public static void printResult(List<Integer> angleArray){

        for (int s : angleArray) {
            LOGGER.info( "Angle is: " + s);
        }
    }

}
