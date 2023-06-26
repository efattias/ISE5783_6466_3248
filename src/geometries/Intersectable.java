package geometries;

import primitives.*;
import java.util.List;
import java.util.Objects;

/**
 * abstract class defines the intersection method for all the geometries in the scene
 */
public abstract class Intersectable {
    /**
     * return a list of all intersections of ray with geometry
     *
     * @param ray the ray to check the intersection
     * @return list of all intersections points
     */
    public List<Point> findIntersections(Ray ray) {
        var geoList = findGeoIntersections(ray);
        return geoList == null ? null
                : geoList.stream().map(gp -> gp.point).toList();
    }

    public List<GeoPoint> findGeoIntersections(Ray ray) {
        return findGeoIntersectionsHelper(ray);
    }

    protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray ray);

    /**
     * helper class to connect between point to Geometry
     */
    public static class GeoPoint {
        public Geometry geometry;
        public Point point;

        /**
         * constructor with two params
         */
        public GeoPoint(Geometry geometry, Point point) {
            this.geometry = geometry;
            this.point = point;
        }

        /**
         * equals method
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return Objects.equals(geometry, geoPoint.geometry) && Objects.equals(point, geoPoint.point);
        }

        /**
         * toString method
         */
        @Override
        public String toString() {
            return "GeoPoint{" +
                    "geometry=" + geometry +
                    ", point=" + point +
                    '}';
        }
    }
}