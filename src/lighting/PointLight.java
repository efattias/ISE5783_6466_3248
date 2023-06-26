package lighting;

import primitives.*;

/**
 * class PointLight represents a point light source
 */
public class PointLight extends Light implements LightSource {

    private Point position;
    private double kC = 1, kL = 0, kQ = 0;

    /**
     * Constructor
     * @param intensity the light's intensity.
     */
    public PointLight(Color intensity, Point position) {
        super(intensity);
        this.position = position;
    }

    /**
     * setter for kC
     */
    public PointLight setKc(double _kC) {
        kC = _kC;
        return this;
    }

    /**
     * setter for kL
     */
    public PointLight setKl(double _kL) {
        kL = _kL;
        return this;
    }

    /**
     * setter for kQ
     */
    public PointLight setKq(double _kQ) {
        kQ = _kQ;
        return this;
    }

    @Override
    public Color getIntensity(Point point) {
        double d = position.distance(point);
        return super.getIntensity().reduce(kC + kL * d + kQ * d * d);
    }

    @Override
    public Vector getL(Point point) {
        return point.subtract(position).normalize();
    }
}
