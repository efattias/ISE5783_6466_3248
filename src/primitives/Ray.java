package primitives;

public class Ray {
    private Point p0;
    private Vector dir;

    public Ray(Point point, Vector vector){
        p0=point;
        dir = vector.normalize();
    }
}
