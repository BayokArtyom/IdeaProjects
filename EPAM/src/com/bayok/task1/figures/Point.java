package com.bayok.task1.figures;

public class Point {

    private int x;
    private int y;
    private int z;

    public void Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private int getX() {
        return x;
    }
    private void setX(int x) {
        this.x = x;
    }
    private int getY() {
        return y;
    }
    private void setY(int y) {
        this.y = y;
    }
    private int getZ() {
        return z;
    }
    private void setZ(int z) {
        this.z = z;
    }

    @Override
    private String toString() {
        return "(" + x + ", " + y + ", " + z +")";
    }

}
