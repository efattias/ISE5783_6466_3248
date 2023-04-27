package geometries;

import primitives.Point;
import primitives.Vector;

public class Sphere extends RadialGeometry {
    private Point center;

    public Sphere(double r, Point point) {
        super(r);
        center = point;
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}
