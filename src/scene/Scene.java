package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import lighting.LightSource;
import primitives.*;
import java.util.LinkedList;
import java.util.List;

public class Scene {
    public String sceneName;
    public Color background = Color.BLACK;
    public AmbientLight ambientLight;
    public Geometries geometries;
    public List<LightSource> lights;

    public Scene(String name) {
        this.sceneName = name;
        geometries = new Geometries();
        lights = new LinkedList<>();
        ambientLight = new AmbientLight();
    }

    /**
     * setter for background
     * @return this
     */
    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    /**
     * setter for ambientLight
     * @return this
     */
    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    /**
     * setter for geometries
     * @return this
     */
    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }

    /**
     * setter for light
     * @return this
     */
    public Scene addLight(LightSource light) {
        lights.add(light);
        return this;
    }
}