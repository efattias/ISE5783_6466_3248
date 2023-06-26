package geometries;

import primitives.*;
import java.util.List;

/**
 * cylinder class represents three-dimensional cylinder
 */
public class Cylinder extends Tube{

    final private double height;

    /**
     * cylinder constructor use radius, ray and height.
     * @param ray The direction ray of the cylinder.
     * @param r the cylinder radius.
     * @param h the height of the cylinder.
     */
    public Cylinder(Ray ray, double r, double h) {
        super(ray, r);
        height = h;
    }

    /**
     * function that returns normal
     * @param p point from which we want to receive normal
     * @return normal
     */
    @Override
    public Vector getNormal(Point p){
        Point axisRayP0 = axisRay.getP0();
        if (p.distance(axisRayP0) <= radius)    // on the base circle of the cylinder.
            return axisRay.getDir().scale(-1);

        Vector heightVector = axisRay.getDir().scale(height);
        axisRayP0 = axisRayP0.add(heightVector);

        if (p.distance(axisRayP0) <= radius)    // on the second base circle of the cylinder.
            return axisRay.getDir();

        // the regular case we calculate like the normal of the tube
        return super.getNormal(p);
    }

    @Override
    public List<Point> findIntersections(Ray ray) {
        return null;
    }
}
