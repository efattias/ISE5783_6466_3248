package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    /**
     * Test method for {@link primitives.Point#add (primitives.Point) }
     */
    @Test
    void add() {

        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1, 1, 1);
        Point p2 = new Point(2, 2, 2);
        assertEquals(new Point(3, 3, 3), p1.add(new Vector(p2.xyz)), "Point method add is wrong");

        // =============== Boundary Values Tests ==================

    }

    @Test
    void testEquals() {

        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1, 1, 1);
        Point p2 = new Point(1, 1, 1);
        Point p3 = new Point(2, 2, 2);
        assertTrue(p1.equals(p2), "Point method equals is wrong");
        assertFalse(p1.equals(p3), "Point method equals is wrong");

        // =============== Boundary Values Tests ==================

    }

    @Test
    void testToString() {

        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(2.34, 2.34, 2.34);
        assertEquals("point{(2.34,2.34,2.34)}", p1.toString(), "Point method ToString is wrong");
        Point p2 = new Point(1, 1, 1);
        assertEquals("point{(1.0,1.0,1.0)}", p2.toString(), "Point method ToString is wrong");

        // =============== Boundary Values Tests ==================

    }

    @Test
    void subtract() {

        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(3, 3, 3);
        Point p2 = new Point(2, 2, 2);
        assertEquals(new Point(1, 1, 1), p1.subtract(p2), "Point method subtract is wrong");

        // =============== Boundary Values Tests ==================

    }

    @Test
    void distanceSquared() {

        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1, 0, 0);
        Point p2 = new Point(3, 0, 0);
        assertEquals(4, p1.distanceSquared(p2), "Point method distanceSquared wrong");

        // =============== Boundary Values Tests ==================

    }

    @Test
    void distance() {

        // ============ Equivalence Partitions Tests ==============
        Point p1 = new Point(1, 0, 0);
        Point p2 = new Point(3, 0, 0);
        assertEquals(2, p1.distance(p2), "Point method distance wrong");

        // =============== Boundary Values Tests ==================

    }
}