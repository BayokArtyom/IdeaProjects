package com.bayok.task1.file;

import com.bayok.task1.figures.Plane;
import com.bayok.task1.figures.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataParser {

    private static final int EXPECTED_PARAMETER_COUNT = 9;
    private static final Logger LOGGER = LogManager.getLogger();

    public static List<Plane> parseArray(List<String> listOfLines) {

        List<Plane> listOfPlanes = new ArrayList<Plane>();
        String[] currentArray = new String[8];
        boolean isCorrectRow;
        int currentRow = 0;
        int currentParameterNumber;

        for (String s : listOfLines) {
            currentRow ++;
            isCorrectRow = true;
            currentParameterNumber = 0;
            try {
                currentArray = s.split("\\s",9);
            }
            catch (Exception e){
                LOGGER.error("Split failed at " + currentRow + ": " + Arrays.toString(currentArray));
                isCorrectRow = false;

            }
            while (currentParameterNumber<EXPECTED_PARAMETER_COUNT){
                try {
                    Integer.parseInt(currentArray[currentParameterNumber]);
                }
                catch(NumberFormatException nx){
                    LOGGER.error( "Not a number or wrong count of parameters provided at row "
                            + currentRow + ": " + Arrays.toString(currentArray)
                            + " value of '" + currentArray[currentParameterNumber] + "'");
                    isCorrectRow = false;
                    break;
                }
                catch(ArrayIndexOutOfBoundsException ax){
                    LOGGER.error( "Invalid count of parameters provided at row "
                            + currentRow + ": " + Arrays.toString(currentArray)
                            + " Please ensure that there are 9 parameters passed");
                    isCorrectRow = false;
                    break;
                }
                currentParameterNumber++;
            }
            if (isCorrectRow){
                Point pointA = new Point();
                Point pointB = new Point();
                Point pointC = new Point();
                Plane plane = new Plane();
                pointA.setX(Integer.parseInt(currentArray[0]));
                pointA.setY(Integer.parseInt(currentArray[1]));
                pointA.setZ(Integer.parseInt(currentArray[2]));
                plane.setPointA(pointA);
                pointB.setX(Integer.parseInt(currentArray[3]));
                pointB.setY(Integer.parseInt(currentArray[4]));
                pointB.setZ(Integer.parseInt(currentArray[5]));
                plane.setPointB(pointB);
                pointC.setX(Integer.parseInt(currentArray[6]));
                pointC.setY(Integer.parseInt(currentArray[7]));
                pointC.setZ(Integer.parseInt(currentArray[8]));
                plane.setPointC(pointC);
                listOfPlanes.add(plane);
            }
        }
        return listOfPlanes;
    }
}
