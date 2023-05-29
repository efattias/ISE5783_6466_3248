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

        //TODO: bonus- check also if the point is on the bases
        Point axisRayP0 = axisRay.getP0();
        if (point.distance(axisRayP0) <= radius)    // on the base circle of the cylinder.
            return axisRay.getDir().scale(-1);

        Vector heightVector = axisRay.getDir().scale(height);
        axisRayP0 = axisRayP0.add(heightVector);

        if (point.distance(axisRayP0) <= radius)    // on the second base circle of the cylinder.
            return axisRay.getDir();

        // the regular case we calculate like the normal of the tube
        return super.getNormal(point);
    }

}