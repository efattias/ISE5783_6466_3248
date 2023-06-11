package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import java.util.List;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void testConstructor() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct construction of a plane with different Points
        try {
            Plane p = new Plane(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0));
            assertEquals(p.getNormal().length(), 1, "dir vector constructed is not normalized");
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct plane");
        }

        // =============== Boundary Values Tests ==================

        // TC02: Points generate the same direction vector
        assertThrows(IllegalArgumentException.class,
                () -> new Plane(new Point(0, 0, 1), new Point(0, 0, 5), new Point(0, 0, 2)),
                "Constructed a plane with two parallel vectors");

        // TC03: Co-located Points cannot generate s plane
        assertThrows(IllegalArgumentException.class,
                () -> new Plane(new Point(3, 2, 1), new Point(3, 2, 1), new Point(3, 2, 1)),
                "Constructed a plane with two parallel vectors");

    }

    @Test
    void testGetNormal() {

        // ============ Equivalence Partitions Tests ==============
        Plane p = new Plane(new Point(1, 0, 0), new Point(0, 1, 0), new Point(0, 0, 1));
        Point p1, p2, p3;
        p1 = new Point(1, 0, 0);
        p2 = new Point(0, 1, 0);
        p3 = new Point(0, 0, 1);
        Vector v1, v2, result;
        v1 = p2.subtract(p1);
        v2 = p3.subtract(p2);
        result = v1.crossProduct(v2).normalize();
        assertEquals(result, p.getNormal(), "plane's method getNormal is wrong");

        // =============== Boundary Values Tests ==================

    }


    @Test
    void findIntersections() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: ray that isn't orthogonal to the plane,is not on the plane. the ray has
        // intersection point with the ray
        Point p0 = new Point(1.5,0,1);
        Vector dir = new Vector(3,0,2);
        Ray ray = new Ray(p0, dir);
        Plane plane= new Plane(new Point(3,1,0), new Point(3,0,0), new Point(3,0,1));
        assertEquals(List.of(new Point(3,0,2)), plane.findIntersections(ray), "plane's method findIntersections is wrong");

        // TC02: ray that isn't orthogonal to the plane,is not on the plane. the ray don't have
        // intersection point with the ray
        Vector dir2 = new Vector(-3,0,-2);
        Ray ray2 = new Ray(p0, dir2);
        assertEquals(null, plane.findIntersections(ray2), "plane's method findIntersections is wrong");

        // =============== Boundary Values Tests ==================
        // TC03: ray that isn't orthogonal to the plane,is not on the plane. the ray is
        // parallel to the plain
        Point p3 = new Point(0,0,1);
        Vector dir3 = new Vector(0,0,2);
        Ray ray3 = new Ray(p3, dir3);
        assertEquals(null, plane.findIntersections(ray3), "plane's method findIntersections is wrong");

        // TC04: ray that isn't orthogonal to the plane, the ray is on the plane. (merges with the plain)
        Point p4 = new Point(3,0,0);
        Vector dir4 = new Vector(3,0,5);
        Ray ray4 = new Ray(p4, dir4);
        assertEquals(null, plane.findIntersections(ray4), "plane's method findIntersections is wrong");

        // TC05: ray that is orthogonal to the plane, starts before the plain
        Point p5 = new Point(1,0,2);
        Vector dir5 = new Vector(1,0,0);
        Ray ray5 = new Ray(p5, dir5);
        assertEquals(List.of(new Point(3,0,2)), plane.findIntersections(ray5), "plane's method findIntersections is wrong");

        // TC06: ray that is orthogonal to the plane, starts on the plain
        Point p6 = new Point(3,0,0);
        Ray ray6 = new Ray(p6, dir5);
        assertEquals(null, plane.findIntersections(ray6), "plane's method findIntersections is wrong");

        // TC07: ray that is orthogonal to the plane, starts after the plain
        Point p7 = new Point(4,0,0);
        Ray ray7 = new Ray(p7, dir5);
        assertEquals(null, plane.findIntersections(ray7), "plane's method findIntersections is wrong");

        // TC08: ray that is orthogonal to the plane, starts after the plain
        Point p8 = new Point(3,0,0);
        Vector dir8 = new Vector(0,1,1);
        Ray ray8 = new Ray(p8, dir8);
        assertEquals(null, plane.findIntersections(ray8), "plane's method findIntersections is wrong");

        // TC09: ray that is orthogonal to the plane, starts after the plain
        Point p9 = new Point(3,1,0);
        Ray ray9 = new Ray(p9, dir8);
        assertEquals(null, plane.findIntersections(ray9), "plane's method findIntersections is wrong");

    }
}