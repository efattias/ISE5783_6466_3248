package geometries;

import primitives.Point;
import primitives.Vector;

public class Plane implements Geometry {

    Point q0;
    Vector normal;

    public Point getQ0() {
        return q0;
    }

    public Vector getNormal() {
        return normal;
    }

    public Plane(Point point1, Point point2, Point point3) {
        q0 = point1;
        Vector v1 = point2.subtract(point1);
        Vector v2 = point3.subtract(point2);
        normal = v1.crossProduct(v2).normalize();

    }

    @Override
    public Vector getNormal(Point point) {
        return normal;
    }
}
