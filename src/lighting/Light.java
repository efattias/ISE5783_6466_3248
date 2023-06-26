package lighting;

import primitives.Color;

/**
 * Class that represents a light source.
 */
abstract class Light {
    private Color intensity;

    /**
     * Constructor
     * @param intensity the light's intensity.
     */
    protected Light(Color intensity) {
        this.intensity = intensity;
    }

    /**
     * Getter for intensity.
     * @return the light's intensity.
     */
    public Color getIntensity() {
        return intensity;
    }
}