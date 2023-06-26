package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;

/**
 * Triangle class represents two-dimensional triangle in 3D Cartesian coordinate
 */
public class Triangle extends Polygon {

    /**
     * Triangle constructor use three points.
     *
     * @param point1 the first point to calculate the triangle.
     * @param point2 the second point to calculate the triangle.
     * @param point3 the third point to calculate the triangle.
     */
    public Triangle(Point point1, Point point2, Point point3) {
        super(point1, point2, point3);
    }

    @Override
    public Vector getNormal(Point point) {
        return super.getNormal(point);
    }

    @Override
    public List<Point> findIntersections(Ray ray) {

        if (plane.findIntersections(ray) == null)
            return null;

        /**
         * we arrive here if there is intersection point between the plane and the ray.
         * now we check if that point is in the triangle
         * check if all the result of the dot products of v*n1,v*n2,v*n3 have the same sign (+/-)
         * in that case - the intersection point is in the triangle
         */


        Vector v = ray.getDir();
        Vector v1 = vertices.get(0).subtract(ray.getP0());
        Vector v2 = vertices.get(1).subtract(ray.getP0());
        Vector v3 = vertices.get(2).subtract(ray.getP0());

        Vector n1 = v1.crossProduct(v2).normalize();
        Vector n2 = v2.crossProduct(v3).normalize();
        Vector n3 = v3.crossProduct(v1).normalize();

        double check1 = alignZero(v.dotProduct(n1));
        double check2 = alignZero(v.dotProduct(n2));
        double check3 = alignZero(v.dotProduct(n3));

        if(((check1 > 0) && (check2 > 0) && (check3 > 0)) ||
                ((check1 < 0) && (check2 < 0) && (check3 < 0)))
            return plane.findIntersections(ray);

        return null;

    }
}
