package lighting;

import primitives.*;

/**
 * DirectionalLight class
 */
public class DirectionalLight extends Light implements LightSource {
    private Vector direction;

    /**
     * Constructor
     * @param intensity the light's intensity.
     */
    public DirectionalLight(Color color, Vector vector) {
        super(color);
        this.direction = vector.normalize();
    }

    @Override
    public Color getIntensity(Point point) {
        return getIntensity();
    }

    @Override
    public Vector getL(Point point) {
        return direction;
    }

    @Override
    public double getDistance(Point point) {
        return Double.POSITIVE_INFINITY;
    }
}