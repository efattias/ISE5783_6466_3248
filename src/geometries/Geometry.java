package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * A Geometry interface represents a geometric Shape
 */
public abstract class Geometry extends Intersectable{

    /**
     * this function calculate and return the shape normal.
     *
     * @param point A point to calculate normal
     * @return the shape normal
     */
    public Vector getNormal(Point point);
}
