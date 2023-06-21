package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static primitives.Util.isZero;

class VectorTest {

    /**
     * Test method for {@link Vector#Vector(double, double, double)}.
     */
    @Test
    void testConstructor() {
        // ============ Equivalence Partitions Tests ==============

        //TC01: only one regular test to check
        assertDoesNotThrow(() -> new Vector(1, 2, 3), "Does not construct a Vector");

        //=============== Boundary Values Tests ==================

        // TC01: Constructor of (0,0,0) vector throws an exception
        assertThrows(IllegalArgumentException.class, () -> new Vector(0, 0, 0),
                "Constructed (0,0,0) vector");
    }

    /**
     * Test method for {@link Vector#lengthSquared()}.
     */
    @Test
    void lengthSquared() {

        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct calculation of a vectors length
        Vector v = new Vector(3, 3, 3);
        assertEquals(27, v.lengthSquared(), "Vector method lengthSquared is wrong");

        // =============== Boundary Values Tests ==================

    }

    /**
     * Test method for {@link Vector#length()}.
     */
    @Test
    void length() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct calculation of a vectors length
        Vector v = new Vector(0, 0, 3);
        assertEquals(3, v.length(), "Vector method length is wrong");

        // =============== Boundary Values Tests ==================

    }

    /**
     * Test method for {@link Vector#dotProduct(Vector)}.
     */
    @Test
    void dotProduct() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct calculation of dotProduct() of orthogonal vectors
        assertTrue(isZero(new Vector(1, 2, 3).dotProduct(new Vector(0, 3, -2))), "ERROR: dotProduct() for orthogonal vectors is not zero");

        // TC02: Correct calculation of dotProduct() of 2 regular vectors
        assertTrue(isZero(new Vector(1, 2, 3).dotProduct(new Vector(-2, -4, -6)) + 28), "ERROR: dotProduct() wrong value");

        // =============== Boundary Values Tests ==================

    }

    /**
     * Test method for {@link Vector#crossProduct(Vector)}.
     */
    @Test
    void crossProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);
        Vector v3 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v3);


        // ============ Equivalence Partitions Tests ==============

        // TC01: crossProduct() for two parallel vectors throws an exception
        assertThrows(IllegalArgumentException.class, () -> v1.crossProduct(v2),
                "ERROR: crossProduct() for parallel vectors does not throw an exception");

        // TC02: correct crossProduct() length
        assertTrue(isZero(vr.length() - v1.length() * v3.length()), "ERROR: crossProduct() wrong result length");

        // TC03: correct crossProduct() orthogonal to its operands
        assertTrue(isZero(vr.dotProduct(v1)), "ERROR: crossProduct() result is not orthogonal to its operands");

        assertTrue(isZero(vr.dotProduct(v3)), "ERROR: crossProduct() result is not orthogonal to its operands");

        // =============== Boundary Values Tests ==================

    }

    /**
     * Test method for {@link Vector#normalize()}.
     */
    @Test
    void normalize() {
        // ============ Equivalence Partitions Tests ==============
        Vector v = new Vector(1, 2, 3);
        Vector u = v.normalize();

        // TC01: test vector normalization vs vector length and cross-product
        assertTrue(isZero(u.length() - 1), "ERROR: the normalized vector is not a unit vector");

        // TC02: test that the vectors are co-lined
        assertThrows(IllegalArgumentException.class, () -> v.crossProduct(u),
                "ERROR: the normalized vector is not parallel to the original one");

        // TC03: test that the vectors are not in opposite directions
        assertFalse(v.dotProduct(u) < 0, "ERROR: the normalized vector is opposite to the original one");

        // =============== Boundary Values Tests ==================

    }

    /**
     * Test method for {@link Vector#add(Vector)}.
     */
    @Test
    void add() {
        // ============ Equivalence Partitions Tests ==============
        //TC01: Add two regular vector one to another
        Vector v1 = new Vector(0, 0, 3);
        Vector v2 = new Vector(0, 0, 2);
        assertEquals(new Vector(0, 0, 5), v1.add(v2), "Vector method add is wrong");

        // =============== Boundary Values Tests ==================

    }

    /**
     * Test method for {@link Vector#scale(double)}
     */
    @Test
    void scale() {

        // ============ Equivalence Partitions Tests ==============
        //TC02: scale a vector by a regular scalar
        Vector v1 = new Vector(1, 2, 3);
        assertEquals(new Vector(2, 4, 6), v1.scale(2), "Vector method scale is wrong");

        // =============== Boundary Values Tests ==================
        //TC01: scale a vector by 0 throws an exception
        assertThrows(IllegalArgumentException.class, () -> new Vector(1, 3, 6).scale(0),
                "Scale a vector by zero does not throw an exception");
    }
}