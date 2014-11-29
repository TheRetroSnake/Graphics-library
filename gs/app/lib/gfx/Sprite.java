package gs.app.lib.gfx;

import gs.app.lib.math.bounds;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Sprite {
    private BufferedImage img;
    private Color c;
    private bounds b;
    private float r, a;
    private boolean xflip, yflip;

    public Sprite() {
        b = new bounds();
    }

    public Sprite(BufferedImage img ) {
        this.img = img;
        b = new bounds();
    }

    public void setColor(Color color){
        c = color;
    }

    public Color getColor() {
        return c;
    }

    public void setBounds(bounds bounds){
        b = bounds;
    }

    public bounds getBounds() {
        return b;
    }

    public void setBounds(int x, int y, int width, int height){
        b = new bounds(x, y, width, height);
    }

    public void setPosition(int x, int y){
        b.x = x;
        b.y = y;
    }

    public void setSize(int width, int height){
        b.w = width;
        b.h = height;
    }

    public float getAlpha() {
        return a;
    }

    public void setAlpha(float alpha){
        a = alpha;
    }

    public void setRotation(float rotation){
        r = rotation;
    }

    public void rotate(float rotation){
        r += rotation;
    }

    public float getRotation() {
        return r;
    }

    public BufferedImage getImage() {
        return img;
    }

    public void setFlip(boolean xFlip, boolean yFlip){
        xflip = xFlip;
        yflip = yFlip;
    }

    public boolean getXFlip(){
        return xflip;
    }

    public boolean getYFlip(){
        return yflip;
    }
}
