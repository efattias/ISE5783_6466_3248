package renderer;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import static primitives.Util.isZero;

public class Camera {
    private Point p0;
    private Vector vUp;
    private Vector vTo;
    private  Vector vRight;
    private double width;
    private double height;
    private double distance;

    public Point getP0() {
        return p0;
    }

    public Vector getvUp() {
        return vUp;
    }

    public Vector getvTo() {
        return vTo;
    }

    public Vector getvRight() {
        return vRight;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDistance() {
        return distance;
    }

    public Camera(Point p, Vector to, Vector up)throws IllegalAccessException {
        vUp =up.normalize();
        vTo =to.normalize();

        if(to.dotProduct(up)!=0){
            throw new IllegalAccessException("Non-vertical vectors");
        }

        vRight=to.crossProduct(up).normalize();
        p0=p;
    }

    public Camera setVPSize(double w, double h) {
        width=w;
        height=h;
        return this;
    }

    public Camera setVPDistance(double distance) {
        this.distance=distance;
        return this;
    }


    public Ray constructRay(int nX, int nY, int j, int i){

        Point planeCenter = p0.add(vTo.scale(distance));

        double rX = width / nX;
        double rY = height / nY;

        Point pij = planeCenter;

        double xJ = (j - (nX-1) / 2d) *rX;
        double yI = -(i - (nY-1) / 2d) * rY;

        if(! isZero(xJ)){
            pij =pij.add(vRight.scale(xJ));
        }

        if(!isZero(yI)){
            pij = pij.add(vUp.scale(yI));
        }

        Vector vij = pij.subtract(p0);
        return new Ray(p0, vij);
    }


    public Camera setImageWriter(ImageWriter baseRenderTest) {
        
        return this;
    }
}
