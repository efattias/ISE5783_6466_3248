package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import java.util.List;
import static java.lang.Math.sqrt;
import static primitives.Util.alignZero;

/**
 * Sphere class represents three-dimensional Sphere
 */
public class Sphere extends Geometry {

    final private Point center;
    final private double radius;
    final private double radiusSquared;

    /**
     * sphere constructor use radius and point.
     * @param r the sphere radius to calculate the sphere.
     * @param point the sphere point to calculate the sphere.
     */
    public Sphere(Point point, double r) {
        this.center = point;
        this.radius = r;
        this.radiusSquared = r * r;
    }

    /**
     * getter for center
     * @return center
     */
    public Point getCenter() {
        return center;
    }

    /**
     * getter for radius
     * @return radius
     */
    public double getRadius() {
        return radius;
    }

    @Override
    public Vector getNormal(Point point) {
        return point.subtract(center).normalize();
    }


    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        Vector pointToCenter;

        try {
            pointToCenter = center.subtract(ray.getP0());
        } catch (IllegalArgumentException ignore) {
            return List.of(new GeoPoint(this, ray.getPoint(radius)));
        }

        double tm = pointToCenter.dotProduct(ray.getDir());
        double distanceFromCenterSquared = pointToCenter.dotProduct(pointToCenter) - tm * tm;
        double thSquared = radiusSquared - distanceFromCenterSquared;

        //if ray not cross the sphere return null
        if (alignZero(thSquared) <= 0) return null;

        double th = sqrt(thSquared);
        double secondDistance = tm + th;

        if (alignZero(secondDistance) <= 0) return null;
        double firstDistance = tm - th;

        return firstDistance <= 0 ? List.of(new GeoPoint(this, ray.getPoint(secondDistance))) //
                : List.of(new GeoPoint(this, ray.getPoint(firstDistance)), new GeoPoint(this, ray.getPoint(secondDistance)));
    }
}