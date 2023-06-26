package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @Test
    void getNormal() {

        // ============ Equivalence Partitions Tests ==============
        Triangle tr = new Triangle(new Point(0, 0, 1), new Point(1, 0, 0), new Point(0, 1, 0));
        double sqrt3 = Math.sqrt(1d / 3);
        //assertEquals(new Vector(sqrt3, sqrt3, sqrt3), tr.getNormal(new Point(0, 0, 1)), "Bad normal to triangle");
        // =============== Boundary Values Tests ==================

    }

    @Test
    void findIntersections() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: ray that isn't orthogonal to the plane of the triangle,the ray has
        // intersection point with the triangle
        Point p0 = new Point(0, 0, 1);
        Vector dir = new Vector(2.5, 2.9, -1);
        Ray ray = new Ray(p0, dir);
        Triangle triangle = new Triangle(new Point(3, 3, 0), new Point(3, 0, 0), new Point(0, 3, 0));
        assertEquals(List.of(new Point(2.5, 2.9, 0)), triangle.findIntersections(ray), "triangle's method findIntersections is wrong");

        // TC02: ray that isn't orthogonal to the plane of the triangle,the ray has
        // intersection point with the plane but no intersection point with the triangle. the intersection point is against an edge.
        Vector dir2 = new Vector(2, 4, -1);
        Ray ray2 = new Ray(p0, dir2);

        assertEquals(null, triangle.findIntersections(ray2), "triangle's method findIntersections is wrong");

        // TC03: ray that isn't orthogonal to the plane of the triangle,the ray has
        // intersection point with the plane but no intersection point with the triangle. the intersection point is against a vertex
        Vector dir3 = new Vector(4, 4, -1);
        Ray ray3 = new Ray(p0, dir3);
        assertEquals(null, triangle.findIntersections(ray3), "triangle's method findIntersections is wrong");

        // =============== Boundary Values Tests ==================
        // TC04: ray that isn't orthogonal to the plane of the triangle,the ray has
        // an intersection point with the triangle on an edge.
        Vector dir4 = new Vector(2, 3, -1);
        Ray ray4 = new Ray(p0, dir4);
        assertEquals(null, triangle.findIntersections(ray4), "triangle's method findIntersections is wrong");

        // TC05: ray that isn't orthogonal to the plane of the triangle,the ray has
        // an intersection point with the triangle on a vertex.
        Vector dir5 = new Vector(3, 0, -1);
        Ray ray5 = new Ray(p0, dir5);
        assertEquals(null, triangle.findIntersections(ray5), "triangle's method findIntersections is wrong");

        // TC06: ray that isn't orthogonal to the plane of the triangle,the ray has
        // an intersection point with the triangle on a vertex.
        Vector dir6 = new Vector(3, 4, -1);
        Ray ray6 = new Ray(p0, dir6);
        assertEquals(null, triangle.findIntersections(ray6), "triangle's method findIntersections is wrong");
    }
}