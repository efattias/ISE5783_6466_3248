package lighting;

import primitives.*;

/**
 * class AmbientLight
 */
public class AmbientLight extends Light {

    /**
     * constructor that receives a color and sets the intensity based in kA
     */
    public AmbientLight(Color iA, Double3 kA) {
        super(iA.scale(kA));
    }

    public AmbientLight(Color iA, double kA){
        super(iA.scale(kA));
    }

    /**
     * default constructor
     */
    public AmbientLight() {
        super(Color.BLACK);
    }
}
