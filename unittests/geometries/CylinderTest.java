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
        Point point = new Point(1,0,0);
        Vector vector = new Vector(0,3,0);
        Ray ray = new Ray(point,vector);
        Cylinder cylinder= new Cylinder(1,ray,1);
        assertEquals(new Vector(0,1,0), cylinder.getNormal(point), "Cylinder method getNormal is wrong");

        // =============== Boundary Values Tests ==================
    }
}