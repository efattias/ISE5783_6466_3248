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
    void testGetNormal() {

        // ============ Equivalence Partitions Tests ==============
        Plane p = new Plane(new Point(1,0,0),new Point(0,1,0),new Point(0,0,1));
        Point p1,p2,p3;
        p1= new Point(1,0,0);
        p2= new Point(0,1,0);
        p3= new Point(0,0,1);
        Vector v1,v2,result;
        v1 = p2.subtract(p1);
        v2 = p3.subtract(p2);
        result = v1.crossProduct(v2).normalize();
        assertEquals(result, p.getNormal(),"plane method getNormal is wrong");

        // =============== Boundary Values Tests ==================

    }


}