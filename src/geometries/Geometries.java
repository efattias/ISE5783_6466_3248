package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable{
    List<Intersectable> geometries;

    public Geometries() {
        geometries = new LinkedList<Intersectable>();
    }

    public Geometries(Intersectable... geometries) {
        this.geometries = new LinkedList<Intersectable>();
        this.add(geometries);
    }

    public void add(Intersectable... geometries){
        for(Intersectable geom:geometries){
            this.geometries.add(geom);
        }
    }

    @Override
    public List<Point> findIntsersections(Ray ray) {
        List<Point> Intersection = new LinkedList<>();

        //go threw all the geometries and add their intersections
        for (Intersectable intersectable: geometries) {
            List<Point> currentIntersection = intersectable.findIntsersections(ray);
            if(currentIntersection != null) //no intersection was found
                Intersection.addAll(currentIntersection);
        }

        if(Intersection.size() == 0)
            return null;
        return Intersection;
    }
}
