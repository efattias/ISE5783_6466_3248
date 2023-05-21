package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 * Triangle class represents two-dimensional triangle in 3D Cartesian coordinate
 */
public class Triangle extends Polygon {

    /**
     * Triangle constructor use three points.
     *
     * @param point1 the first point to calculate the triangle.
     * @param point2 the second point to calculate the triangle.
     * @param point3 the third point to calculate the triangle.
     */
    public Triangle(Point point1, Point point2, Point point3) {
        super(point1, point2, point3);
    }

    @Override
    public Vector getNormal(Point point) {
        return super.getNormal(point);
    }

    @Override
    public List<Point> findIntsersections(Ray ray) {
        return null;
    }
}
