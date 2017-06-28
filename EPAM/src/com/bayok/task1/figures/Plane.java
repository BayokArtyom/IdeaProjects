package com.bayok.task1.figures;

public class Plane {

    private Point pointA;
    private Point pointB;
    private Point pointC;

    public void Plane(Point pointA, Point pointB, Point pointC) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
    }


    private Point getPointA() {
        return pointA;
    }
    private void setPointA(Point pointA) {
        this.pointA = pointA;
    }
    private Point getPointB() {
        return pointB;
    }
    private void setPointB(Point pointB) {
        this.pointB = pointB;
    }
    private Point getPointC() {
        return pointC;
    }
    private void setPointC(Point pointC) {
        this.pointC = pointC;
    }
    @Override
    private String toString() {
        return "(" + pointA + ", " + pointB + ", " + pointC +")";
    }

}
