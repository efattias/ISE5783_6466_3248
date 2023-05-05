package primitives;

/**
 * this class creates vectors in the 3 dimensional space. vector is sort of point so the class
 * extends from the class point
 */
public class Vector extends Point {

    /**
     * constructor to initialize a vector. vector contains 3 values the constructor get the values and
     * put them in the field xyz
     * @param p1 the first value
     * @param p2 the second value
     * @param p3 the third value
     */

    public Vector(double p1, double p2, double p3) {
        super(p1, p2, p3);
        if (xyz.equals(Double3.ZERO))
            throw new IllegalArgumentException("You should not create vector zero");

    }

    /**
     * constructor to initialize a vector. vector contains 3 values the constructor get parameter of type
     * double 3 that contains the 3 values of the point
     * @param d3 a double 3 value to put in the field xyz
     */
    Vector(Double3 d3) {
        super(d3);
        if (xyz.equals(Double3.ZERO))
            throw new IllegalArgumentException("you should not create vector zero");
    }

    /**
     * this function calculates the squared length of the vector
     * @return a double value - the squared length
     */
    public double lengthSquared() {
        return (xyz.d1 * xyz.d1) +
                (xyz.d2 * xyz.d2) +
                (xyz.d3 * xyz.d3);
    }

    /**
     * calculates the final value of the length of the vector
     * @return a double value - the length
     */
    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    /**
     * this function calculates the dot product between 2 vectors
     * @param v the function gets a vector to calculate the dot product between it and the vector
     *         that called the function
     * @return a double value - the result of the product.
     */
    public double dotProduct(Vector v) {
        return (xyz.d1 * v.xyz.d1) +
                (xyz.d2 * v.xyz.d2) +
                (xyz.d3 * v.xyz.d3);
    }

    /**
     * this function calculates the cross product between 2 vectors
     * @param v the function gets a vector to calculate the cross product between it and the vector
     *          that called the function
     * @return  a vector value - the result of the cross product. the vector of the result is orthogonal to the
     * 2 other vectors
     */
    public Vector crossProduct(Vector v) {
        return new Vector((xyz.d2 * v.xyz.d3) - (xyz.d3 * v.xyz.d2),
                -((xyz.d1 * v.xyz.d3) - (xyz.d3 * v.xyz.d1)),
                (xyz.d1 * v.xyz.d2) - (xyz.d2 * v.xyz.d1));
    }

    /**
     * this function calculate the normalized vector (vector with length 1) of the vector that called the
     * function
     * @return a vector value - the normalized vector
     */
    public Vector normalize() {
        double ls = this.length();
        return new Vector(xyz.d1 / ls, xyz.d2 / ls, xyz.d3 / ls);
    }

    /**
     * this function calculates the result of adding vector to other vector
     * @param vector vector for adding
     * @return a vector value - the result of adding vector to the vector that called the function
     */
    public Vector add(Vector vector) {
        return new Vector(xyz.add(vector.xyz));
    }

    /**
     * this function returns a scaled vector of the vector that called the function. It scalling the vector by t -
     * a parameter that the functions get
     * @param t calculate the scaled vector by t
     * @return vector value - the scaled vector
     */
    public Vector scale(double t){
        return new Vector(xyz.scale(t));
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "Vector{" + super.toString() + "}";
    }
}