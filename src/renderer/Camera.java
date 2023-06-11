package renderer;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

public class Camera {
    private Point p0;
    private Vector Vup;
    private Vector Vto;
    private  Vector Vright;
    private double width;
    private double height;
    private double distance;

    public Camera(Point p,Vector to, Vector up)throws IllegalAccessException {
        Vup=up.normalize();
        Vto=to.normalize();

        if(to.dotProduct(up)!=0){
            throw new IllegalAccessException("Non-vertical vectors");
        }

        Vright=to.crossProduct(up).normalize();
        p0=p;
    }

    public Camera setVPSize(double width, double height) {
        width=width;
        height=height;
        return this;
    }

    public Camera setVPDistance(double distance) {
        this.distance=distance;
        return this;
    }

    public Ray constructRay(int nX, int nY, int j, int i){
        return null;
    }
}
