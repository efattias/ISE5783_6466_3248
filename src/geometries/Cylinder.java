package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * cylinder class represents three-dimensional cylinder
 */
public class Cylinder extends Tube {
    private double height;

    /**
     * cylinder constructor use radius, ray and height.
     *
     * @param r   the cylinder radius.
     * @param ray The direction ray of the cylinder.
     * @param h   the height of the cylinder.
     */
    public Cylinder(double r, Ray ray, double h) {
        super(r, ray);
        height = h;
    }

    @Override
    public Vector getNormal(Point point) {
        return axisRay.getDir().normalize();
    }

}