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
        Point point = new Point(1, 0, 0);
        Vector vector = new Vector(0, 0, 3);
        Ray ray = new Ray(point, vector);
        Tube tube = new Tube(1, ray);

        // TC01: Test that the normal of the tube is proper
        assertEquals(new Vector(1, 0, 0),
                tube.getNormal(new Point(3, 0, 0)), "Tube method getNormal is wrong");

        // =============== Boundary Values Tests ==================

    }
}