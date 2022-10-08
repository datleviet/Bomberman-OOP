package uet.oop.bomberman.components.entities;

import javafx.scene.canvas.GraphicsContext;
import uet.oop.bomberman.core.Camera;

public abstract class Entity {
    protected double x;
    protected double y;

    protected int width;
    protected int height;

    protected boolean active;

    protected final Camera camera = Camera.getInstance();

    public Entity() {
        x = 0;
        y = 0;
        width = 0;
        height = 0;
        active = true;
    }

    public Entity(double x, double y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        active = true;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract void render(GraphicsContext gc);

    public abstract void update();
}
