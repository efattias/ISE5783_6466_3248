package geometries;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Tube extends RadialGeometry{
    Ray axisRay;

    public Tube(double r, Ray ray) {
        super(r);
        axisRay = ray;
    }

    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}
