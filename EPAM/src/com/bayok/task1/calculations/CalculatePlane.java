package com.bayok.task1.calculations;

import com.bayok.task1.figures.Plane;

import java.util.ArrayList;
import java.util.List;

public class CalculatePlane {
    public  List<Integer> calculatePlane(List<Plane> listOfPlanes) {
        List<Integer> angleArray = new ArrayList<Integer>();
        int equationOfPlane;
        int x;
        int y;
        int z;
        int mas11;
        int mas12;
        int mas13;
        int mas21;
        int mas22;
        int mas23;
        int mas31;
        int mas32;
        int mas33;

        for (Plane p : listOfPlanes) {
            mas11 = p.pointA.x;
            mas12 = p.pointB.x - p.pointA.x;
            mas13 = p.pointC.x - p.pointA.x;

            mas21 = p.pointA.y;
            mas22 = p.pointB.y - p.pointA.y;
            mas23 = p.pointC.y - p.pointA.y;

            mas31 = p.pointA.z;
            mas32 = p.pointB.z - p.pointA.z;
            mas33 = p.pointC.z - p.pointA.z;

            x = mas11 * (mas22 * mas33 - mas23 * mas32);
            y = mas21 * (mas12 * mas33 - mas13 * mas32) * (-1);
            z = mas31 * (mas12 * mas23 - mas13 * mas22);

            equationOfPlane = x + y + z;
            angleArray.add(equationOfPlane);
        }
        return angleArray;
    }
}
