package com.bayok.task1.file;

import com.bayok.task1.figures.Plane;
import com.bayok.task1.figures.Point;

import java.util.Arrays;
import java.util.List;

public class DataParser {

    public static int checkIfInt;
    private static int currentRow = 0;
    private static boolean isCorrectRow;
    private static final int EXPEXTEDPARAMETERCOUNT = 9;
    private static String[] currentArray = new String[8];

    public static void parseArray(){
        FileParser fp = new FileParser();
        List<String> list = fp.getList();
        System.out.println(list);


        for (String s : list) {
            System.out.println("-------------------");
            currentRow ++;
            isCorrectRow = true;
            try {
                currentArray = s.split(" ",9);
            }
            catch (Exception e){
                System.out.println("Split failed at " + currentRow + ": " + Arrays.toString(currentArray));
                isCorrectRow = false;
                e.printStackTrace();
            }

            System.out.println(Arrays.toString(currentArray));
            int i = 0;
            while (i<EXPEXTEDPARAMETERCOUNT){
                try {
                    checkIfInt = Integer.parseInt(currentArray[i]);
                }
                catch(NumberFormatException nx){
                    System.out.println( "Not a number or wrong count of parameters provided at row "
                            + currentRow + ": " + Arrays.toString(currentArray)
                            + " value of '" + currentArray[i] + "'");
                    isCorrectRow = false;
                    break;

                }
                catch(ArrayIndexOutOfBoundsException ax){
                    System.out.println( "Invalid count of parameters provided at row "
                            + currentRow + ": " + Arrays.toString(currentArray)
                            + " Please ensure that there are 9 parameters passed");
                    isCorrectRow = false;
                    break;
                }
                i++;
            }
            Point point1 = new Point();
            Point point2 = new Point();
            Point point3 = new Point();
            Plane plane = new Plane();
            if (isCorrectRow){
                point1.setX(Integer.parseInt(currentArray[0]));
                point1.setY(Integer.parseInt(currentArray[1]));
                point1.setZ(Integer.parseInt(currentArray[2]));
                plane.setPointA(point1);
                point2.setX(Integer.parseInt(currentArray[3]));
                point2.setY(Integer.parseInt(currentArray[4]));
                point2.setZ(Integer.parseInt(currentArray[5]));
                plane.setPointB(point2);
                point3.setX(Integer.parseInt(currentArray[6]));
                point3.setY(Integer.parseInt(currentArray[7]));
                point3.setZ(Integer.parseInt(currentArray[8]));
                plane.setPointC(point3);
                System.out.println(plane.getPointA());
                System.out.println(plane.getPointB());
                System.out.println(plane.getPointC());
            }
        }
    }
}
