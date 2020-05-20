package model;

public class Vector {
    public double x;
    public double y;
//    public int[][] vector2D = new int[1][1];

    public Vector() {
        this.y = 0;
        this.x = 0;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

//    public Vector clone() {
//        return new Vector(this.x, this.y);
//    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void set(Vector other) {
        this.set(other.x, other.y);
    }



}
