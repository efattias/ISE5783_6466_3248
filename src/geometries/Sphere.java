package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import java.util.ArrayList;
import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

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

    @Override
    public List<Point> findIntsersections(Ray ray) {
        List<Point> intersectionsArr = new ArrayList<>();
        Vector u;

        try {
            u = center.subtract(ray.getP0());
        }
        catch (IllegalArgumentException exception){//if p0 is the center of the point- u will the zero vector-should be an error
            intersectionsArr.add(ray.getP0().add(ray.getDir().scale(radius)));
            return intersectionsArr;
        }

        double tm= u.dotProduct(ray.getDir());
        double d= Math.sqrt(u.lengthSquared()-tm*tm);

        if (alignZero(d - radius) >= 0)         // ray crosses outside the sphere
            return null;

        double th= alignZero(Math.sqrt((radius*radius)-(d*d)));
        double t1= tm+th;
        double t2= tm-th;

        if (alignZero(t1)<=0 && alignZero(t2)<=0)//one intersection
            return null;

        if(t1>0)
            intersectionsArr.add(ray.getP0().add(ray.getDir().scale(t1)));
        if(t2>0)
            intersectionsArr.add(ray.getP0().add(ray.getDir().scale(t2)));
        return intersectionsArr;

    }
}
