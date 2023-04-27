package geometries;

/**
 * An abstract RadialGeometry class represents a geometric Shape with a radius
 */
public abstract class RadialGeometry implements Geometry {
    /**
     * the radius of radialGeometry shape.
     */
    protected double radius;

    /**
     * RadialGeometry constructor use radius.
     *
     * @param r the radialGeometry radius.
     */
    public RadialGeometry(double r) {
        radius = r;
    }
}
