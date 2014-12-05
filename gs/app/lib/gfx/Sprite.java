package gs.app.lib.gfx;

import gs.app.lib.math.bounds;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Sprite {
    /* image object if needed */
    private BufferedImage img;
    /* color object */
    private Color c;
    /* position of the sprite */
    private bounds b;
    /* rotation and alpha */
    private float r, a;
    /* flip */
    private boolean xflip, yflip;

    /* create a new sprite */
    public Sprite() {
        b = new bounds();
    }

    /* create a new sprite with image */
    public Sprite(BufferedImage img) {
        this.img = img;
        b = new bounds();
    }

    /* set the color */
    public void setColor(Color color){
        c = color;
    }

    /* get color */
    public Color getColor() {
        return c;
    }

    /* set bounds */
    public void setBounds(bounds bounds){
        b = bounds;
    }

    /* get bounds */
    public bounds getBounds() {
        return b;
    }

    /* set bounds */
    public void setBounds(int x, int y, int width, int height){
        b = new bounds(x, y, width, height);
    }

    /* set x and y positions */
    public void setPosition(int x, int y){
        b.x = x;
        b.y = y;
    }

    /* set width and height */
    public void setSize(int width, int height){
        b.w = width;
        b.h = height;
    }

    /* get sprite alpha */
    public float getAlpha() {
        return a;
    }

    /* set alpha */
    public void setAlpha(float alpha){
        a = alpha;
    }

    /* set rotation */
    public void setRotation(float rotation){
        r = rotation;
    }

    /* add to rotation */
    public void rotate(float rotation){
        r += rotation;
    }

    /* get rotation */
    public float getRotation() {
        return r;
    }

    /* get image of the sprite */
    public BufferedImage getImage() {
        return img;
    }

    /* set flips */
    public void setFlip(boolean xFlip, boolean yFlip){
        xflip = xFlip;
        yflip = yFlip;
    }

    /* get X flip */
    public boolean getXFlip(){
        return xflip;
    }

    /* get Y flip */
    public boolean getYFlip(){
        return yflip;
    }
}
