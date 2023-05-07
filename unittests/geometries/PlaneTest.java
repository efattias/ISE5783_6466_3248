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
        Plane p = new Plane(new Point(1,0,0),new Point(0,1,0),new Point(0,0,1));
        Point p1,p2,p3;
        p1= new Point(1,0,0);
        p2= new Point(0,1,0);
        p3= new Point(0,0,1);

        assertEquals(new Vector(0,0,1),p.getNormal(),"plane method getNormal is wrong");
    }

    @Test
    void testGetNormal() {
    }
}