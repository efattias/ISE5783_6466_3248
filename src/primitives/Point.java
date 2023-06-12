package primitives;

import java.util.Objects;

/**
 * this class create types of points with field of type double 3
 * the objects of this class represents points in the 3 dimensional space
 */
public class Point {

    /**
     * double 3 field. contains the 3 values of the point (d1,d2,d3)
     */
    final Double3 xyz;
    //the ZERO vector
    public static final Point ZERO = new Point(0, 0, 0);

    /**
     * constructor to initialize a point. point contains 3 values the constructor get the values and
     * put them in the field xyz
     * @param p1 the first value of the point
     * @param p2 the second value of the point
     * @param p3 the third value of the point
     */
    public Point(double p1, double p2, double p3) {
        xyz = new Double3(p1, p2, p3);
    }

    /**
     * constructor to initialize a point. point contains 3 values the constructor get parameter of type
     * double 3 that contains the 3 values of the point
     * @param d3 a double 3 value to put in the field xyz
     */
    Point(Double3 d3) {
        this.xyz = d3;
    }

    /**
     * this function add vector to point
     * @param vector vector for adding
     * @return returns a point that is the result of the adding
     */
    public Point add(Vector vector) {
        return new Point(xyz.add(vector.xyz));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return (o instanceof Point other)
                && xyz.equals(other.xyz);
    }

    @Override
    public String toString() {
        return "point{" + xyz.toString() + "}";
    }

    /**
     * this function returns the result (vector) of sabtracting the point that it gets as argument
     * from the point that called the function
     * @param p1 the point that the function sabtracts from "this" point
     * @return vector as result of sabtract point from point
     */
    public Vector subtract(Point p1) {
        return new Vector( xyz.subtract(p1.xyz));
    }

    /**
     * this function calculates the squared distance between two points
     * @param p is a point that the function calculate the distance between it and
     *          the point that called the function
     * @return double value - the squared distance between the points
     */
    public double distanceSquared(Point p){
        return (xyz.d1-p.xyz.d1)*(xyz.d1-p.xyz.d1)+
                (xyz.d2-p.xyz.d2)*(xyz.d2-p.xyz.d2)+
                (xyz.d3-p.xyz.d3)*(xyz.d3-p.xyz.d3);
    }

    /**
     * this function calculate the final distance
     * @param point the same as the point in the function distanceSquared
     * @return double value - the final distance
     */
    public double distance(Point point){
        return Math.sqrt(this.distanceSquared(point));
    }

    public double getX() {
        return xyz.d1;
    }

    public double getY() {
        return xyz.d2;
    }

    public double getZ() {
        return xyz.d3;
    }
}
