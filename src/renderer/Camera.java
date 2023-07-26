package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;
import java.util.MissingResourceException;
import java.util.stream.IntStream;

/**
 * camera class
 */
public class Camera {
    private Point p0;
    private Vector vTo;
    private Vector vUp;
    private Vector vRight;
    private double distance;
    private double height;
    private double width;
    private ImageWriter imageWriter;
    private RayTracerBase rayTracer;


    /**
     * function that gets the position of the camera
     * @return the position
     * */
    public Point getPosition() {
        return p0;
    }

    /**
     * function that gets the vTo vector
     * @return the vTo vector
     * */
    public Vector getvTo() {
        return vTo;
    }

    /**
     * function that gets the vUp vector
     * @return the vUp vector
     */
    public Vector getvUp() {
        return vUp;
    }

    /**
     * function that gets the vRight vector
     * @return the vRight vector
     */
    public Vector getvRight() {
        return vRight;
    }

    /**
     * function that gets the distance
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    /**
     * function that gets the height
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * function that gets the width
     * @return the width
     */
    public double getWidth() {
        return width;
    }

    /**
     * function that constructs the camera
     * @param p0 the position
     * @param vTo the vTo vector
     * @param vUp the vUp vector
     */
    public Camera(Point p0, Vector vTo, Vector vUp) {
        if (vTo.dotProduct(vUp) != 0)
            throw new IllegalArgumentException("vTo and vUp must be orthogonal");
        this.p0 = p0;
        this.vTo = vTo.normalize();
        this.vUp = vUp.normalize();
        this.vRight = this.vTo.crossProduct(this.vUp).normalize();
    }

    /**
     * function that sets the width and height
     * @return this
     */
    public Camera setVPSize(double width, double height) {
        this.width = width;
        this.height = height;
        return this;
    }

    /**
     * function that sets the distance
     * @return this
     */
    public Camera setVPDistance(double distance) {
        this.distance = distance;
        return this;
    }

    /**
     * function that sets imageWriter
     * @return this
     */
    public Camera setImageWriter(ImageWriter imageWriter) {
        this.imageWriter = imageWriter;
        return this;
    }

    /**
     * function that sets the rayTracer
     * @return this
     */
    public Camera setRayTracer(RayTracerBase rayTracer) {
        this.rayTracer = rayTracer;
        return this;
    }

    /**
     * function that gets the ray from the camera to the point
     * @param nX the x resolution
     * @param nY the y resolution
     * @param i  the x coordinate
     * @param j  the y coordinate
     * @return the ray
     */
    public Ray constructRay(int nX, int nY, int j, int i) {
        Point pC = p0.add(vTo.scale(distance));

        double rY = height / nY;
        double rX = width / nX;

        double yI = -(i - (nY - 1d) / 2) * rY;
        double jX = (j - (nX - 1d) / 2) * rX;
        Point Pij = pC;
        //TODO: use is zero
        if (yI != 0) Pij = Pij.add(vUp.scale(yI));
        if (jX != 0) Pij = Pij.add(vRight.scale(jX));

        return new Ray(p0, Pij.subtract(p0));
    }

    /**
     * function that gets the color of the pixel and renders in to image
     */
    public Camera renderImage() {
        if (p0 == null || vTo == null || vUp == null || vRight == null || distance == 0 || height == 0 || width == 0 || imageWriter == null || rayTracer == null)
            throw new MissingResourceException("", "", "Camera is not initialized");
        int nX = imageWriter.getNx();
        int nY = imageWriter.getNy();

        IntStream.range(0, nY).parallel()
                .forEach(i -> IntStream.range(0, nX).parallel() // for each row:
                        .forEach(j -> {
                            Color color = castRay(nX, nY, i, j);
                            imageWriter.writePixel(j, i, color);
                        }));
//
//        for (int i = 0; i < imageWriter.getNx(); i++) {
//            for (int j = 0; j < imageWriter.getNy(); j++) {
//                Color color = castRay(nX, nY, i, j);
//                imageWriter.writePixel(j, i, color);
//            }
//        }
        return this;
    }

    /**
     * function that prints grid on top of image
     *
     * @param interval of grid
     * @param color    of grid
     */
    public void printGrid(int interval, Color color) {
        if (imageWriter == null)
            throw new MissingResourceException("", "", "Camera is not initialized");
        for (int i = 0; i < imageWriter.getNx(); i++) {
            for (int j = 0; j < imageWriter.getNy(); j++) {
                if ((i % interval == 0) || (j % interval == 0))
                    imageWriter.writePixel(i, j, color);
            }
        }
    }

    /**
     * function that calls write to image function
     */
    public void writeToImage() {
        if (imageWriter == null)
            throw new MissingResourceException("", "", "Camera is not initialized");
        imageWriter.writeToImage();
    }

    /**
     * function that casts ray and returns color
     *
     * @param nX the x resolution
     * @param nY the y resolution
     * @param i  the x coordinate
     * @param j  the y coordinate
     * @return the color
     */
    private Color castRay(int nX, int nY, int i, int j) {
        Ray tempRay = constructRay(nX, nY, j, i);
        return rayTracer.traceRay(tempRay);
    }

    private Color castRays(int nX, int nY, int i, int j) {
        Color color = Color.BLACK;
        List<Ray> rays = constructRays(nX, nY, j, i);
        for (Ray ray:rays) {
            color.add(rayTracer.traceRay(ray));
        }
        return color.reduce(rays.size());
    }

    //TODO: to do
    private List<Ray> constructRays(int nX, int nY, int j, int i) {
        return null;
    }
}