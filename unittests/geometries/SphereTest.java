package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    @Test
    void getNormal() {

        // ============ Equivalence Partitions Tests ==============
        Sphere sp = new Sphere(new Point(0, 0, 0),5);
        assertEquals(new Vector(0, 0, 1), sp.getNormal(new Point(0, 0, 5)), "Bad normal to triangle");
        // =============== Boundary Values Tests ==================

    }

    @Test
    void findIntersections() {
        Sphere sphere = new Sphere(new Point(1, 0, 0),1d);
        Point point1;
        Point point2;
        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray is outside the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(-1,0,0),new Vector(1,1,0))),"Ray is outside the sphere");

        // TC02: Ray starts before and crosses the sphere (2 points)

        point1 = new Point(0.0651530771650466, 0.355051025721682, 0);
        point2 = new Point(1.53484692283495, 0.844948974278318, 0);
        List<Point> result = sphere.findIntersections(new Ray(new Point(-1, 0, 0), new Vector(3, 1, 0)));

        assertEquals( 2, result.size(), "Wrong number of points");

        if (result.get(0).getX() > result.get(1).getX())
            result = List.of(result.get(1), result.get(0));

        assertEquals(List.of(point1, point2), result, "Ray crosses sphere");

        // TC03: Ray starts inside the sphere (1 point)
        Point point = new Point(0.5, -0.5 , 0.7071067811865475);
        result = sphere.findIntersections(new Ray(new Point(0.5, -0.5, 0), new Vector(0,0,0.7)));

        assertEquals(1, result.size(), "Ray starts inside the sphere- wrong number of points");
        assertEquals(point,result.get(0), "Ray starts inside the sphere- wrong point");

        // TC04: Ray starts after the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(-0.2, 0.2,0), new Vector(-0.8, -0.2, 0) )), "Ray starts after the sphere- didn't return null");

        // =============== Boundary Values Tests ==================

        // **** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        result = sphere.findIntersections(new Ray(new Point(0.2, 0,0.6), new Vector(0.8, 0,0.4)));
        point = new Point(1,0,1);

        assertEquals(1,result.size(), "Ray starts at sphere and goes inside- wrong amount of points" );
        assertEquals(point,result.get(0), "Ray starts at sphere and goes inside- wrong point");

        // TC12: Ray starts at sphere and goes outside (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(0.2, 0,0.6), new Vector(-0.7, 0,-0.6))),"Ray starts at sphere and goes outside- didn't return null" );

        // **** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        point1 = new Point(1,1, 0);
        point2 = new Point(1,-1, 0);
        result = sphere.findIntersections(new Ray(new Point(1, 1.5, 0), new Vector(0,-1,0)));

        assertEquals( 2, result.size(), "Ray starts before the sphere- wrong number of points");

        if (result.get(0).getY() < result.get(1).getY())
            result = List.of(result.get(1), result.get(0));

        assertEquals(List.of(point1, point2), result, "Ray starts before the sphere- wrong points");

        // TC14: Ray starts at sphere and goes inside (1 points)
        result = sphere.findIntersections(new Ray(new Point(1,-1,0), new Vector(0,1,0)));
        point = new Point(1,1,0);

        assertEquals(1, result.size(), "Ray starts at sphere and goes inside- wrong amount of points" );
        assertEquals(point, result.get(0), "Ray starts at sphere and goes inside- wrong point");

        // TC15: Ray starts inside (1 points)
        result = sphere.findIntersections(new Ray(new Point(1,0.5,0), new Vector(0,-1,0)));
        point = new Point(1,-1,0);

        assertEquals(1, result.size(), "Ray starts inside- wrong amount of points" );
        assertEquals(point, result.get(0), "Ray starts inside- wrong point");

        // TC16: Ray starts at the center (1 points)
        result = sphere.findIntersections(new Ray(new Point(1,0,0), new Vector(0,1,0)));
        point = new Point(1,1,0);
        assertEquals(1, result.size(), "Ray starts at center- wrong amount of points" );
        assertEquals(point, result.get(0), "Ray starts at center- wrong point");

        // TC17: Ray starts at sphere and goes outside (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(1,-1,0), new Vector(0,-1,0))),"Ray starts at sphere and goes outside- didn't return null" );

        // TC18: Ray starts after sphere (0 points)
        assertNull(sphere.findIntersections(new Ray(new Point(1,1.5,0), new Vector(0,1,0))),"Ray starts after sphere- didn't return null" );

        // **** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        assertNull(sphere.findIntersections(new Ray(new Point(1,-2,1), new Vector(0,1,0))),"Ray starts before the tangent point- didn't return null" );

        // TC20: Ray starts at the tangent point
        assertNull(sphere.findIntersections(new Ray(new Point(1,0,1), new Vector(1,3,0))),"Ray starts at the tangent point- didn't return null" );

        // TC21: Ray starts after the tangent point
        assertNull(sphere.findIntersections(new Ray(new Point(1,2,1), new Vector(0,1,0))),"Ray starts at the tangent point- didn't return null" );

        // **** Group: Special cases
        // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's center line
        assertNull(sphere.findIntersections(new Ray(new Point(-1,0,0), new Vector(0,0,1))),"Ray's line is outside, ray is orthogonal to ray start to sphere's center line- didn't return null" );
    }
}