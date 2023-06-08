package geometries;

import primitives.Double3;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * plane class represents three-dimensional plane.
 */
public class Plane implements Geometry {
    /**
     * by q0 we calculate the plane
     */
    Point q0;
    /**
     * By the normal we calculate the plane
     */
    Vector normal;

    /**
     * plane constructor use three point.
     *
     * @param point1 the first point to calculate the plane
     * @param point2 the second point to calculate the plane
     * @param point3 the third point to calculate the plane
     */
    public Plane(Point point1, Point point2, Point point3) {
        q0 = point1;
        Vector v1 = point2.subtract(point1);
        Vector v2 = point3.subtract(point2);
        normal = v1.crossProduct(v2).normalize();

    }

    /**
     * plane constructor use point and vector
     *
     * @param point  a point in space to calculate the plane
     * @param vector a direction vector to calculate the plane
     */
    public Plane(Point point, Vector vector) {
        q0 = point;
        normal = vector.normalize();
    }

    /**
     * getter to q0
     *
     * @return the plane q0
     */
    public Point getQ0() {
        return q0;
    }

    /**
     * getter to normal
     *
     * @return the plane normal
     */
    public Vector getNormal() {
        return normal;
    }

    @Override
    public Vector getNormal(Point point) {
        return normal;
    }


    @Override
    public List<Point> findIntsersections(Ray ray) {

        Point p0 = ray.getP0();
        Vector v = ray.getDir();
        Vector p0_Q0 = q0.subtract(ray.getP0());
        double nv = alignZero(normal.dotProduct(v));
        double nQ0P0 = alignZero(normal.dotProduct(p0_Q0));

        if(q0.equals(p0))
            return  null;

        // numerator
        if(isZero(nQ0P0))
            return  null;

        // denominator
        if(isZero(nv))
            return  null;

        double t = alignZero(nQ0P0 / nv);

        if(t <= 0)
            return null;

        Point p = ray.getPoint(t);

        return List.of(p);

    }
}
