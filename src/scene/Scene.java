package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import  primitives.Color;

import java.awt.*;

public class Scene {
    String sceneName;
    AmbientLight ambientLight;
    public Geometries geometries;

    Color background;

    public Scene(String name) {
        sceneName = name;
    }

    public Scene setAmbientLight(AmbientLight myAmbientLight) {
        ambientLight = myAmbientLight;
        return this;
    }

    public Scene setBackground(primitives.Color color) {
        background = color;
        return this;
    }
}


