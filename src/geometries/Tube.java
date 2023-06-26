package geometries;

import primitives.*;
import java.util.List;

/**
 * tube class represents three-dimensional tube
 */
public class Tube extends Geometry {

    /**
     * the direction ray of the tube
     */
    final protected Ray axisRay;
    final protected double radius;

    /**
     * Tube constructor use radius and ray.
     * @param ray the ray to calculate the tube.
     * @param r   the radius to calculate the tube.
     */
    public Tube(Ray ray, double r) {
        this.axisRay = ray;
        this.radius = r;
    }

    /**
     * getter for axisRay
     */
    public Ray getAxisRay() {
        return axisRay;
    }

    /**
     * getter for radius
     */
    public double getRadius() {
        return radius;
    }

    @Override
    public Vector getNormal(Point p) {
        double t = p.subtract(axisRay.getP0()).dotProduct(axisRay.getDir());
        Point o = axisRay.getPoint(t);
        return p.subtract(o).normalize();
    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        return null;
    }

    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        return null;
    }
}