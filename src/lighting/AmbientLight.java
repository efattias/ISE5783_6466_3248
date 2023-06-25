package lighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight {

    private Color intensity;
    public AmbientLight(Color myIntensity, Double3 kA) {
        intensity = myIntensity.scale(kA);
    }
}
