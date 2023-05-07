package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void lengthSquared() {

        // ============ Equivalence Partitions Tests ==============
        Vector v = new Vector(3,3,3);
        assertEquals(27,v.lengthSquared(),"Vector method lengthSquared is wrong");

        // =============== Boundary Values Tests ==================

    }

    @Test
    void length() {

        // ============ Equivalence Partitions Tests ==============
        Vector v = new Vector(0,0,3);
        assertEquals(3,v.length(),"Vector method length is wrong");

        // =============== Boundary Values Tests ==================

    }

    @Test
    void dotProduct() {

        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(0,0,3);
        Vector v2 = new Vector(0,0,2);
        assertEquals(6,v1.dotProduct(v2),"Vector method dotProduct is wrong");

        // =============== Boundary Values Tests ==================

    }

    @Test
    void crossProduct() {

        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1,2,3);
        Vector v2 = new Vector(4,5,6);
        Vector result = v1.crossProduct(v2);
        assertEquals(new Vector(-3,6,-3),result,"Vector method dotProduct is wrong");

        // =============== Boundary Values Tests ==================

    }

    @Test
    void normalize() {

        // ============ Equivalence Partitions Tests ==============
        Vector v = new Vector(0,0,2);
        assertEquals(new Vector(0,0,1),v.normalize(),"Vector method normalize is wrong");

        // =============== Boundary Values Tests ==================

    }

    @Test
    void add() {

        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(0,0,3);
        Vector v2 = new Vector(0,0,2);
        assertEquals(new Vector(0,0,5),v1.add(v2),"Vector method add is wrong");

        // =============== Boundary Values Tests ==================

    }

    @Test
    void scale() {

        // ============ Equivalence Partitions Tests ==============
        Vector v1 = new Vector(1,2,3);
        assertEquals(new Vector(2,4,6),v1.scale(2),"Vector method scale is wrong");

        // =============== Boundary Values Tests ==================

    }
}