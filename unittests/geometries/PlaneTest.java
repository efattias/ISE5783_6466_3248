package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

import static org.junit.jupiter.api.Assertions.*;

class PlaneTest {

    @Test
    void getQ0() {
    }

    @Test
    void getNormal() {
        Plane p = new Plane(new Point(1,0,0),new Point(0,1,0),new Point(0,0,));

        assertEquals(new Vector(1,1,1),p.getNormal(),"plane getNormal wrong");
    }

    @Test
    void testGetNormal() {
    }
}