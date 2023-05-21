package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    @Test
    void getNormal() {

        // ============ Equivalence Partitions Tests ==============
        Point point = new Point(0, 0, 2);
        Vector vector = new Vector(0, 0, 1);
        Ray ray = new Ray(point, vector);
        Cylinder cylinder = new Cylinder(2, ray, 2);

        // TC01: Test that the normal of the cylinder is proper, the point is on the cylinder.
        assertEquals(new Vector(1, 0, 0), cylinder.getNormal(new Point(2, 0, 3)), "Cylinder method getNormal is wrong");

        // TC02: Test that the normal of the cylinder is proper, the point is on the base of the cylinder.
        assertEquals(new Vector(1, 0, 0), cylinder.getNormal(new Point(1, 0, 2)), "Cylinder method getNormal is wrong");

        // TC03: Test that the normal of the cylinder is proper, the point is on the base of the cylinder.
        assertEquals(new Vector(1, 0, 0), cylinder.getNormal(new Point(1, 0, 4)), "Cylinder method getNormal is wrong");

        // =============== Boundary Values Tests ==================

        // TC04: Test that when the point is not on the cylinder, the method returns null
        assertEquals(null, cylinder.getNormal(new Point(3, 0, 3)), "Cylinder method getNormal is wrong");

        // TC05: Test that when the point is not on the cylinder, the method returns null
        assertEquals(null, cylinder.getNormal(new Point(5, 0, 0)), "Cylinder method getNormal is wrong");

        // TC04: Test the case when o and p are the same point. ((p - p0) is orthogonal to v - the ray direction)
        assertEquals(new Vector(1, 0, 0), cylinder.getNormal(new Point(2, 0, 2)), "Cylinder method getNormal is wrong");

    }
}