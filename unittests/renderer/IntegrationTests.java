package renderer;

import geometries.*;
import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {

    //create ray from 3*3 pixels and count all the integration with specific shape
    int countIntegrationsPoint(Geometry geometry, Camera camera) throws IllegalAccessException {
        int countIntegration = 0;
        List<Ray> rayList = new LinkedList<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                rayList.add(camera.constructRay(3, 3, i, j));
        for (Ray r : rayList)
            if (geometry.findIntersections(r) != null)
                countIntegration += geometry.findIntersections(r).size();
        return countIntegration;
    }

    @Test
    void CameraSphereIntersections() throws IllegalAccessException {
        Camera camera1 = new Camera(Point.ZERO, new Vector(0, 0, -1), new Vector(0, -1, 0)).setVPDistance(1).setVPSize(3, 3);
        //TC01: the sphere small then the view plan so just the middle pixel integration two times
        Sphere sphere1 = new Sphere(1, new Point(0, 0, -3));
        assertEquals(2, countIntegrationsPoint(sphere1, camera1), "good");

        Camera camera2 = new Camera(new Point(0, 0, 0.5), new Vector(0, 0, -1), new Vector(0, -1, 0)).setVPDistance(1).setVPSize(3, 3);

        //TC02: the sphere bigger then the view plan so each ray from the view plan integrate two time
        Sphere sphere2 = new Sphere(2.5, new Point(0, 0, -2.5));
        assertEquals(18, countIntegrationsPoint(sphere2, camera2), "good");

        //TC03: the sphere small then the view plan so just the middle pixel and the size pixel are integration two time
        Sphere sphere3 = new Sphere(2, new Point(0, 0, -2));
        assertEquals(10,countIntegrationsPoint(sphere3, camera2),  "good");

        //TC04:the sphere bigger, and the view plane start in the middle the sphere
        Sphere sphere4 = new Sphere(4, new Point(0, 0, -1));
        assertEquals(9, countIntegrationsPoint(sphere4, camera1), "good");

        //TC05: the sphere before the camera
        Sphere sphere5 = new Sphere(0.5, new Point(0, 0, 1));
        assertEquals(0,countIntegrationsPoint(sphere5, camera1),  "bad");
    }

    @Test
    void CameraPlaneIntersections() throws IllegalAccessException {
        Camera camera1 = new Camera(new Point(0, 0, 0), new Vector(0, 0, -1), new Vector(0, -1, 0)).setVPDistance(1).setVPSize(3, 3);

        //TC01: the plane are parallel to the view plane
        Plane plane1 = new Plane(new Point(0, 0, -5), new Vector(0, 0, 1));
        assertEquals(9,countIntegrationsPoint(plane1, camera1),  "good");

        //TC02: the plane approaching to the vie plan
        Plane plane2 = new Plane(new Point(0, 0, -5), new Vector(0, 1, 2));
        assertEquals(9,countIntegrationsPoint(plane1, camera1),  "good");

        //TC03: the plane slowly approaching to the vie plan and don't touch the ray of the third pixel
        Plane plane3 = new Plane(new Point(0, 0, -5), new Vector(0, 1, 1));
        assertEquals(6,countIntegrationsPoint(plane3, camera1),  "good");
    }

    @Test
    void CameraTriangleIntersections() throws IllegalAccessException {
        Camera camera1 = new Camera(new Point(0, 0, 0), new Vector(0, 0, -1), new Vector(0, -1, 0)).setVPDistance(1).setVPSize(3, 3);

        //TC01: the triangle small and just the ray from the middle pixel integrate
        Triangle triangle1 = new Triangle(new Point(1, 1, -2), new Point(-1, 1, -2), new Point(0, -1, -2));
        assertEquals(1,countIntegrationsPoint(triangle1, camera1),  "good");

        //TC02: the triangle start across the middle pixel and continue to the top pixel
        Triangle triangle2 = new Triangle(new Point(1, 1, -2), new Point(-1, 1, -2), new Point(0, -20, -2));
        assertEquals(2,countIntegrationsPoint(triangle2, camera1),  "good");
    }
}
