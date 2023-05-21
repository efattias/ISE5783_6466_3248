package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 * tube class represents three-dimensional tube
 */
public class Tube extends RadialGeometry {

    /**
     * the direction ray of the tube
     */
    Ray axisRay;

    /**
     * Tube constructor use radius and ray.
     *
     * @param r   the radius to calculate the tube.
     * @param ray the ray to calculate the tube.
     */
    public Tube(double r, Ray ray) {
        super(r);
        axisRay = ray;
    }

    @Override
    public Vector getNormal(Point point) {
        //TODO: check if the get point is on the tube or in else space
        double t = axisRay.getDir().dotProduct(point.subtract(axisRay.getP0()));
        Point o;
        if(t!=0){
            o = axisRay.getP0().add(axisRay.getDir().scale(t));
        }
        else{
            o = axisRay.getP0();
        }

        Vector normal = point.subtract(o);

        if(normal.lengthSquared() != (radius * radius ))
            return null;

        return point.subtract(o).normalize();
    }

    @Override
    public List<Point> findIntsersections(Ray ray) {
        return null;
    }
}