package gs.app.lib.gfx;

import gs.app.lib.application.App;
import gs.app.lib.math.bounds;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Graphics {

    /* graphics object */
    private static Graphics2D g;

    /* new object */
    public Graphics(Graphics2D gr) {
        g = gr;
    }

    /* dispose this object */
    public void dispose() {
        g.dispose();
    }

    /* fill rectangle with current color */
    public void fillRect(int x, int y, int width, int height){
        g.fillRect(x, y, width, height);
    }

    /* fill rectangle from sprite */
    public void fillRect(Sprite s){
        /* store last color and set color to sprite color */
        Color c = g.getColor();
        g.setColor(s.getColor());

        /* fill the rectangle with bounds */
        fillRect(s.getBounds());

        /* set the color back to original one */
        g.setColor(c);
    }

    /* set color */
    public void setColor(Color color){
        g.setColor(color);
    }

    /* fill rectangle with a color */
    public void fillRect(int x, int y, int width, int height, Color c){
        g.setColor(c);
        g.fillRect(x, y, width, height);
    }

    /* fill rectangle with bounds object */
    public void fillRect(bounds bounds){
        g.fillRect(bounds.x, bounds.y, bounds.w, bounds.h);
    }

    /* clear screen with color */
    public void clearScreen(Color c){
        fillRect(0, 0, App.GetBounds().w, App.GetBounds().h, c);
    }

    /* set font */
    public static void setFont(Font f){
        if(g != null) {
            g.setFont(f);
        }
    }

    /* set font from file and style and size */
    public boolean setFont(String file, int style, float size){
        Font t = gfx.getFont(file, style, size);
        if(t != null) {
            g.setFont(t);
            return true;
        }

        return false;
    }

    /* draw a shape */
    public void draw(Shape s){
        g.draw(s);
    }

    /* draw text */
    public void drawText(String str, int x, int y){
        g.drawString(str, x, y + GetFontHeight(str));
    }

    /* draw text with alignment */
    public void drawText(String str, int x, int y, int alignment, int width){
        g.drawString(str, x + AlignPos(alignment, width, str), y + GetFontHeight(str));
    }

    /* align the text */
    private int AlignPos(int alignment, int width, String text) {
        /* if alignment is center */
        if(alignment == 1) return AlignCenter(width, text);
        /* if alignment is right */
        if(alignment == 2) return AlignRight(width, text);
        /* alignment is left */
        return 0;
    }

    /* align text to center */
    private int AlignCenter(int width, String text) {
        return AlignRight(width, text) / 2;
    }

    /* align text to right */
    private int AlignRight(int width, String text) {
        return width - g.getFontMetrics().stringWidth(text);
    }

    /* get font height */
    private int GetFontHeight(String text) {
        return g.getFontMetrics(g.getFont()).getAscent();
    }

    /* draw text with color and alignment */
    public void drawText(String str, int x, int y, Color c, int alignment, int width){
        g.setColor(c);
        drawText(str, x, y, alignment, width);
    }

    /* draw text with color */
    public void drawText(String str, int x, int y, Color c){
        g.setColor(c);
        drawText(str, x, y);
    }

    /* get fontRenderContext */
    public static FontRenderContext getFRC(){
        return g.getFontRenderContext();
    }

    /* get text width */
    public static double GetTextWidth(String text){
        return g.getFont().getStringBounds(text, getFRC()).getWidth();
    }

    /* get text height */
    public static double GetTextHeight(String text){
        return g.getFont().getStringBounds(text, getFRC()).getHeight();
    }

    /* draw image */
    public void drawImage(BufferedImage image, int x, int y){
        g.drawImage(image, x, y, null);
    }

    /* draw image with size */
    public void drawImage(BufferedImage image, int x, int y, int width, int height){
        g.drawImage(image, x, y, width, height, null);
    }

    /* draw image from sprite */
    public void drawImage(Sprite s){
        /* store AffineTransform of current setup */
        AffineTransform store = g.getTransform();
        /* create new transform */
        AffineTransform tr = new AffineTransform();

        /* get scale size of image */
        double scaleX = (double)s.getBounds().w / s.getImage().getWidth(), scaleY = (double)s.getBounds().h / s.getImage().getHeight();

        /* scale the image */
        tr.setToTranslation(s.getBounds().x, s.getBounds().y);
        tr.scale(s.getXFlip() ? -scaleX : scaleX, s.getYFlip() ? -scaleY : scaleY);

        /* put to right position */
        tr.translate(s.getXFlip() ? -s.getImage().getWidth() : 0, s.getYFlip() ? -s.getImage().getHeight() : 0);

        /* rotate image */
        tr.rotate(Math.toRadians(s.getRotation()), s.getImage().getWidth() / 2, s.getImage().getHeight() / 2);

        /* set alpha of image */
        AlphaComposite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, s.getAlpha());
        g.setComposite(c);

        /* draw the image finally */
        g.drawImage(s.getImage(), tr, null);

        /* reset AffineTransform and alpha */
        g.setTransform(store);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }

    /* set alpha */
    public void setAlpha(float alpha){
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
    }
}