package geometries;

import primitives.*;
import java.util.List;

/**
 * plane class represents three-dimensional plane.
 */
public class Plane extends Geometry{

    final private Point q0;
    final private Vector normal;

    /**
     * plane constructor use three point.
     *
     * @param point1 the first point to calculate the plane
     * @param point2 the second point to calculate the plane
     * @param point3 the third point to calculate the plane
     */
    public Plane(Point point1, Point point2, Point point3) {
        q0 = point1;
        Vector v1 = point2.subtract(point3);
        Vector v2 = point1.subtract(point2);
        normal = v1.crossProduct(v2).normalize();
    }

    /**
     * plane constructor use point and vector
     * @param point  a point in space to calculate the plane
     * @param vector a direction vector to calculate the plane
     */
    public Plane(Point point, Vector vector){
        q0 = point;
        normal = vector.normalize();
    }

    /**
     * getter to normal
     * @return the plane normal
     */
    public Vector getNormal(){
        return normal;
    }

    /**
     * getter to normal
     * @return the plane normal
     */
    @Override
    public Vector getNormal(Point p0){
        return normal;
    }


    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        Vector u;

        try {
            u = q0.subtract(ray.getP0());
        }catch (IllegalArgumentException ignore) {//if ray starts at reference point of plane return null
            return null;
        }

        double denominator = normal.dotProduct(ray.getDir());
        if (Util.isZero(denominator)) return null; //if ray is parallel to plane return null

        //calculate distance of point from plane
        double t = Util.alignZero(u.dotProduct(normal) / denominator);

        //return null if point is behind start of ray
        return t <= 0 ? null : List.of(new GeoPoint(this, ray.getPoint(t)));    }
}