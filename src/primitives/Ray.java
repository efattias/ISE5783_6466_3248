package primitives;

import geometries.Intersectable.GeoPoint;
import java.util.List;
import static primitives.Util.isZero;

/**
 * The class Ray Is sets type of objects that contain a vector (direction) and also a point.
 */
public class Ray {

    final private Point p0;
    final private Vector dir;

    /**
     * constructor to initialize a ray. ray contains 2 fields. the constructor get 2 parameters of  the types
     * of the field - vector and point and put them in the fields "dir" and "p0"
     * @param point
     * @param vector
     */
    public Ray(Point point, Vector vector) {
        this.p0 = point;
        this.dir = vector.normalize();
    }

    /**
     * A getter method
     * @return the point of the ray
     */
    public Point getP0() {
        return p0;
    }

    /**
     * A getter method
     * @return the direction of the ray (a vector value)
     */
    public Vector getDir() {
        return dir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return (o instanceof Ray other)
                && this.p0.equals(other.p0)
                && this.dir.equals(other.dir);
    }

    @Override
    public String toString() {
        return "Ray{" +
                "p0=" + p0 +
                ", dir=" + dir +
                '}';
    }

    /**
     * Getter for point at a given distance from ray origin
     *
     * @param t distance from ray origin
     * @return point
     */
    public Point getPoint(double t) {
        return isZero(t) ? p0 : p0.add(dir.scale(t));
    }

    /**
     * Calculate the closest point in list of intersections
     * @param points list of points
     * @return closest point
     */
    public Point findClosestPoint(List<Point> points) {
        if (points == null || points.isEmpty())
            return null;
        Point closest = null;
        double minDistance = Double.MAX_VALUE;
        for (Point p : points) {
            double distance = p.distance(p0);
            if (distance < minDistance) {
                closest = p;
                minDistance = distance;
            }
        }
        return closest;
    }

    /**
     * Find closest GeoPoint
     * @param points list of GeoPoints
     * @return closest GeoPoint
     */
    public GeoPoint findClosestGeoPoint(List<GeoPoint> points) {
        if (points == null || points.isEmpty())
            return null;
        GeoPoint closest = null;
        double minDistance = Double.MAX_VALUE;
        for (GeoPoint p : points) {
            double distance = p.point.distance(p0);
            if (distance < minDistance) {
                closest = p;
                minDistance = distance;
            }
        }
        return closest;
    }
}



