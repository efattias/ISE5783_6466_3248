package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeometriesTest {

    @Test
    void add() {
    }

    /**
     * Test method for {@link Geometries#findIntersections(Ray)}.
     */
    @Test
    void findIntersections() {
        Sphere sphere = new Sphere(2, new Point(2,0,0));
        Plane plane = new Plane(new Point(1,1,0.5), new Vector(0, 0, 1));
        Triangle triangle = new Triangle(new Point(0, 1, 0), new Point(0, -1, 0), new Point(3,0,0));
        Geometries geometries = new Geometries(sphere, plane, triangle);

        // ============ Equivalence Partitions Tests ==============

        // TC04: Ray intersects only a few shape (3 points)
        Ray ray = new Ray(new Point(1,1,-2), new Vector(0,0,1));
        assertEquals(3, geometries.findIntersections(ray).size(), "Ray intersects only sphere and plane (3 points)- wrong points of intersection");


        // =============== Boundary Values Tests ==================

        // TC01: Empty collection of geometries
        geometries = new Geometries();
        assertNull(geometries.findIntersections(ray), "Empty collection of geometries - found an intersection");

        // TC02: Ray doesn't intersect any geometries (0 points)
        ray = new Ray(new Point(2.5,-5.5,-2), new Vector(6.5,10.5,-3));
        assertNull(geometries.findIntersections(ray),
                "Ray doesn't intersect any geometries (0 points) - found a point of intersection");

        // TC03: Ray intersects one the geometries (1 point)
        ray = new Ray(new Point(5, 0, -2), new Vector(0, 0, 1));
        assertEquals(1, geometries.findIntersections(ray).size(), "Ray intersects one the geometries (1 points) - wrong points of intersection");

        // TC05: Ray intersects all the geometries (4 points)
        ray = new Ray(new Point(0.5, 0.5, -2), new Vector(0, 0, 1));
        assertEquals(4, geometries.findIntersections(ray).size(), "Ray intersects all the geometries (4 points) - wrong points of intersection");







    }
}