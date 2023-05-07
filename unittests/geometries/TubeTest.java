package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class TubeTest {

    @Test
    void getNormal() {

        // ============ Equivalence Partitions Tests ==============
        Point point = new Point(1,0,0);
        Vector vector = new Vector(0,3,0);
        Ray ray = new Ray(point,vector);
        Tube tube = new Tube(1,ray);
        assertEquals(new Vector(0,1,0), tube.getNormal(point), "Tube method getNormal is wrong");

        // =============== Boundary Values Tests ==================
    }
}