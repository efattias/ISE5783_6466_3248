package primitives;


public class Vector extends Point {
    public Vector(double p1, double p2, double p3) {
        super(p1, p2, p3);
    }

    public Vector(Double3 xyz) {
        super(xyz);
    }

    public double lengthSquared() {
        return (xyz.d1 * xyz.d1) +
                (xyz.d2 * xyz.d2) +
                (xyz.d3 * xyz.d3);
    }

    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    public double dotProduct(Vector v) {
        return (xyz.d1 * v.xyz.d1) +
                (xyz.d2 * v.xyz.d2) +
                (xyz.d3 * v.xyz.d3);
    }

    public Vector crossProduct(Vector v) {
        return new Vector((xyz.d2 * v.xyz.d3) - (xyz.d3 * v.xyz.d2),
                ((xyz.d1 * v.xyz.d3) - (xyz.d3 * v.xyz.d1)),
                (xyz.d1 * v.xyz.d2) - (xyz.d2 * v.xyz.d1));
    }

    public Vector normalize() {
        double ls = this.lengthSquared();
        return new Vector(xyz.d1 / ls, xyz.d2 / ls, xyz.d3 / ls);
    }
}