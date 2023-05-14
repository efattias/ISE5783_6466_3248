package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void getNormal() {

        // ============ Equivalence Partitions Tests ==============
        Sphere sp = new Sphere(5, new Point(0, 0, 0));
        assertEquals(new Vector(0, 0, 1), sp.getNormal(new Point(0, 0, 5)), "Bad normal to triangle");
        // =============== Boundary Values Tests ==================

    }
}