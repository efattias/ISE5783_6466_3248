package geometries;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * A Geometry interface represents a geometric Shape
 */
public abstract class Geometry implements Intersectable{

    protected Color emission = Color.BLACK;

    /**
     * getter for emission
     * @return this emission
     */
    public Color getEmission() {
        return emission;
    }

    /**
     * setter for emission
     * @param emission new emission to put in this emission
     * @return this geometry
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }

    /**
     * this function calculate and return the shape normal.
     *
     * @param point A point to calculate normal
     * @return the shape normal
     */
    public abstract Vector getNormal(Point point);
}
