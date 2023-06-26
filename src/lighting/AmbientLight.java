package lighting;

import primitives.*;

public class AmbientLight {
    private Color intensity;

    public AmbientLight(Color myIntensity, Double3 kA) {
        this.intensity = myIntensity.scale(kA);
    }
    public  AmbientLight(){
        this.intensity = Color.BLACK;
    }

    public Color getIntensity() {
        return intensity;
    }
}
