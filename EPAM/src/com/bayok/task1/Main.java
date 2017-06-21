package com.bayok.task1;

import com.bayok.task1.calculations.CalculatePlane;
import com.bayok.task1.exceptions.FileIsMissingException;
import com.bayok.task1.file.DataParser;
import com.bayok.task1.file.FileParser;

public class Main {
    public static void main(String args[])throws FileIsMissingException {
        FileParser class1 = new FileParser();
        DataParser class2 = new DataParser();
        CalculatePlane class3 = new CalculatePlane();
        class1.readFile();
        class2.parseArray();
        class3.calculatePlane();

    }

}
