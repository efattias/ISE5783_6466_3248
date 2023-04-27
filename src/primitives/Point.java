package primitives;

import java.util.Objects;

public class Point {
    final Double3 xyz;

    public Point(double p1, double p2, double p3) {
        xyz = new Double3(p1, p2, p3);
    }

    Point(Double3 xyz) {
        this.xyz = xyz;
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
     * this fun
     * @param p1
     * @return
     */
    public Vector subtract(Point p1) {
        return new Vector( xyz.subtract(p1.xyz));
    }

    public double distanceSquared(Point p){
        return (xyz.d1-p.xyz.d1)*(xyz.d1-p.xyz.d1)+
                (xyz.d2-p.xyz.d2)*(xyz.d2-p.xyz.d2)+
                (xyz.d3-p.xyz.d3)*(xyz.d3-p.xyz.d3);
    }

    public double distance(Point point){
        return Math.sqrt(this.distanceSquared(point));
    }
}
