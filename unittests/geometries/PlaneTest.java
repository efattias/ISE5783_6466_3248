package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

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
        assertEquals(result, p.getNormal(), "plane method getNormal is wrong");

        // =============== Boundary Values Tests ==================

    }


    @Test
    void findIntsersections() {
        Plane plane= new Plane(new Point(1,0,0), new Point(0,1,0), new Point(1,1,0));
    }
}