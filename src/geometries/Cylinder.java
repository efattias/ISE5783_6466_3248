package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * cylinder class represents three-dimensional cylinder
 */
public class Cylinder extends Tube {
    private double height;

    /**
     * cylinder constructor use radius, ray and height.
     *
     * @param r   the cylinder radius.
     * @param ray The direction ray of the cylinder.
     * @param h   the height of the cylinder.
     */
    public Cylinder(double r, Ray ray, double h) {
        super(r, ray);
        height = h;
    }

    @Override
    public Vector getNormal(Point point) {
        //TODO: bonus- do the good if
        double t = axisRay.getDir().dotProduct(point.subtract(axisRay.getP0()));

        //TODO: bonus- check also if the point is on the bases
        // if the point is not on the cylinder
        if (
                (super.getNormal(point) == null) || t > height)
            return null;

        // if the point is on the base of the cylinder
        if(t == 0 || t == height) {
            return axisRay.getDir().normalize();
        }

        // the regular case we calculate like the normal of the tube
        return super.getNormal(point);
    }

}