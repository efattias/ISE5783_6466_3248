package scene;

import geometries.Geometries;
import lighting.AmbientLight;

import java.awt.*;

public class Scene {
    String sceneName;
    AmbientLight ambientLight;
    Geometries geometries;
    public Scene(String name) {
        sceneName = name;
    }


    public Component setAmbientLight(AmbientLight ambientLight) {
    }
}
