package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class TubeTest {

    /**
     * Test method for {@link  geometries.Tube#getNormal(primitives.Point)}.
     */
    @Test
    void getNormal() {

        // ============ Equivalence Partitions Tests ==============
        Point point = new Point(0, 0, 2);
        Vector vector = new Vector(0, 0, 1);
        Ray ray = new Ray(point, vector);
        Tube tube = new Tube(2, ray);

        // TC01: Test that the normal of the tube is proper, a regular case.
        assertEquals(new Vector(1, 0, 0), tube.getNormal(new Point(2, 0, 3)), "Tube method getNormal is wrong");

        // =============== Boundary Values Tests ==================

        // TC02: Test that when the point is not on the tube, the method returns null
        assertEquals(null, tube.getNormal(new Point(3, 0, 3)), "Tube method getNormal is wrong");

        // TC03: Test the case when o and p are the same point. ((p - p0) is orthogonal to v - the ray direction)
        assertEquals(new Vector(1, 0, 0), tube.getNormal(new Point(2, 0, 2)), "Tube method getNormal is wrong");
    }

    @Test
    void findIntersections() {
    }
}