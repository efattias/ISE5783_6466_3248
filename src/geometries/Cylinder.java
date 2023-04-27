package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Cylinder extends Tube{
    private double height;

    public Cylinder(double r, Ray ray, double h) {
        super(r, ray);
        height = h;
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}
