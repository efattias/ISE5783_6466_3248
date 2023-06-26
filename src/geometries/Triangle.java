package geometries;

import primitives.*;
import java.util.List;
import static primitives.Util.alignZero;

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

    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        List<GeoPoint> result = this.plane.findGeoIntersections(ray);
        if (result == null) return null;

        Point p0 = this.vertices.get(0);
        Point p1 = this.vertices.get(1);
        Point p2 = this.vertices.get(2);
        Point p = result.get(0).point;

        try {
            Vector n1 = p1.subtract(p0).crossProduct(p0.subtract(p));
            Vector n2 = p2.subtract(p1).crossProduct(p1.subtract(p));
            Vector n3 = p0.subtract(p2).crossProduct(p2.subtract(p));

            double n1n2 = alignZero(n1.dotProduct(n2));
            if (n1n2 == 0) return null;

            double n2n3 = alignZero(n2.dotProduct(n3));
            if (n1n2 * n2n3 <= 0) return null; // must have same sign

            double n3n1 = alignZero(n3.dotProduct(n1));
            if (n1n2 * n3n1 <= 0) return null; // must have same sign

            return List.of(new GeoPoint(this, result.get(0).point));

        } catch (IllegalArgumentException ignore) {
            return null;
        }
    }
}