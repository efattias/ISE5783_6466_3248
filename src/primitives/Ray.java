package primitives;

import java.util.Objects;

import static primitives.Util.isZero;

/**
 * The class Ray Is sets type of objects that contain a vector (direction) and also a point.
 */
public class Ray {
    private final Point p0;
    private final Vector dir;

    /**
     * constructor to initialize a ray. ray contains 2 fields. the constructor get 2 parameters of  the types
     * of the field - vector and point and put them in the fields "dir" and "p0"
     * @param point
     * @param vector
     */
    public Ray(Point point, Vector vector){
        p0 = point;
        dir = vector.normalize();
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

    public Point getPoint(double t) {
        if(isZero(t))
            return p0;
        Point p = p0.add(dir.scale(t));
        return p;

    }
}
