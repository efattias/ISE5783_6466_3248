package geometries;

import primitives.*;

/**
 * A Geometry interface represents a geometric Shape
 */
public abstract class Geometry extends Intersectable {
    protected Color emission = Color.BLACK;
    private Material material = new Material();

    /**
     * this function calculate and return the shape normal.
     *
     * @param p0 A point to calculate normal
     * @return the shape normal
     */
    public abstract Vector getNormal(Point p0);

    /**
     * return the geometry's color
     *
     * @return the geometry's color
     */
    public Color getEmission() {
        return emission;
    }

    /**
     * return the geometry's material
     *
     * @return the material of the geometry
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * set the color of the geometry- (emission)
     */
    public Geometry setEmission(Color emission) {
        this.emission = emission;
        return this;
    }

    /**
     * set the material of the geometry
     */
    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;
    }
}
