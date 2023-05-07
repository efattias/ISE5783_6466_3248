package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * tube class represents three-dimensional tube
 */
public class Tube extends RadialGeometry {

    /**
     * the direction ray of the tube
     */
    Ray axisRay;

    /**
     * Tube constructor use radius and ray.
     *
     * @param r   the radius to calculate the tube.
     * @param ray the ray to calculate the tube.
     */
    public Tube(double r, Ray ray) {
        super(r);
        axisRay = ray;
    }

    @Override
    public Vector getNormal(Point point) {
        double t = axisRay.getDir().dotProduct(point.subtract(axisRay.getP0()));
        Point o = axisRay.getP0().add(axisRay.getDir().scale(t));
        return point.subtract(o);
    }
}