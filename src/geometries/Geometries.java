package geometries;

import primitives.Point;
import primitives.Ray;
import java.util.LinkedList;
import java.util.List;

/**
 * Class provides a list of geometries in the scene
 */
public class Geometries extends Intersectable {
    private final List<Intersectable> geometries = new LinkedList<>();

    public Geometries() {
    }

    /**
     * constructor
     * @param geometries list of geometries for add
     */
    public Geometries(Intersectable... geometries) {
        add(geometries);
    }

    /**
     * add the geometries to list
     * @param geometries list of geometries to add
     */
    public void add(Intersectable... geometries) {
        this.geometries.addAll(List.of(geometries));
    }

    @Override
    protected List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        List<GeoPoint> intersections = null;
        for (Intersectable geometry : geometries) {
            var temp = geometry.findGeoIntersections(ray);
            if (temp != null) {
                if (intersections == null)
                    intersections = new LinkedList<>();
                intersections.addAll(temp);
            }
        }
        return intersections;
    }

}