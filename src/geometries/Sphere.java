package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * Sphere class represents three-dimensional Sphere
 */
public class Sphere extends RadialGeometry {
    final Point center;

    /**
     * sphere constructor use radius and point.
     *
     * @param r     the sphere radius to calculate the sphere.
     * @param point the sphere point to calculate the sphere.
     */
    public Sphere(double r, Point point) {
        super(r);
        center = point;
    }

    @Override
    public Vector getNormal(Point point) {
        return point.subtract(center).normalize();
    }
}
