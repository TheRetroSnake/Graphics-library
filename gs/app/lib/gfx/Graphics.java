package gs.app.lib.gfx;

import gs.app.lib.application.App;
import gs.app.lib.math.bounds;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Graphics {

    private static Graphics2D g;

    public Graphics(Graphics2D gr) {
        g = gr;
    }

    public void dispose() {
        g.dispose();
    }

    public void fillRect(int x, int y, int width, int height){
        g.fillRect(x, y, width, height);
    }

    public void fillRect(Sprite s){
        Color c = g.getColor();
        g.setColor(s.getColor());

        fillRect(s.getBounds());
        g.setColor(c);
    }

    public void setColor(Color color){
        g.setColor(color);
    }

    public void fillRect(int x, int y, int width, int height, Color c){
        g.setColor(c);
        g.fillRect(x, y, width, height);
    }

    public void fillRect(bounds bounds){
        g.fillRect(bounds.x, bounds.y, bounds.w, bounds.h);
    }

    public void clearScreen(Color c){
        fillRect(0, 0, App.GetBounds().w, App.GetBounds().h, c);
    }

    public static void setFont(Font f){
        if(g != null) {
            g.setFont(f);
        }
    }

    public boolean setFont(String file, int style, float size){
        Font t = gfx.getFont(file, style, size);
        if(t != null) {
            g.setFont(t);
            return true;
        }

        return false;
    }



    public void draw(Shape s){
        g.draw(s);
    }

    public void drawText(String str, int x, int y){
        g.drawString(str, x, y + GetFontHeight(str));
    }

    public void drawText(String str, int x, int y, int alignment, int width){
        g.drawString(str, x + AlignPos(alignment, width, str), y + GetFontHeight(str));
    }

    private int AlignPos(int alignment, int width, String text) {
        if(alignment == 1) return AlignCenter(width, text);
        if(alignment == 2) return AlignRight(width, text);
        return 0;
    }

    private int AlignCenter(int width, String text) {
        return AlignRight(width, text) / 2;
    }

    private int AlignRight(int width, String text) {
        return width - g.getFontMetrics().stringWidth(text);
    }

    private int GetFontHeight(String text) {
        return g.getFontMetrics(g.getFont()).getAscent();
    }

    public void drawText(String str, int x, int y, Color c, int alignment, int width){
        g.setColor(c);
        drawText(str, x, y, alignment, width);
    }

    public void drawText(String str, int x, int y, Color c){
        g.setColor(c);
        drawText(str, x, y);
    }

    public static FontRenderContext getFRC(){
        return g.getFontRenderContext();
    }

    public static double GetTextWidth(String text){
        return g.getFont().getStringBounds(text, getFRC()).getWidth();
    }

    public static double GetTextHeight(String text){
        return g.getFont().getStringBounds(text, getFRC()).getHeight();
    }

    public void drawImage(BufferedImage image, int x, int y){
        g.drawImage(image, x, y, null);
    }

    public void drawImage(BufferedImage image, int x, int y, int width, int height){
        g.drawImage(image, x, y, width, height, null);
    }

    public void drawImage(Sprite s){
        AffineTransform store = g.getTransform();
        AffineTransform tr = new AffineTransform();

        double scaleX = (double)s.getBounds().w / s.getImage().getWidth(), scaleY = (double)s.getBounds().h / s.getImage().getHeight();

        tr.setToTranslation(s.getBounds().x, s.getBounds().y);
        tr.scale(s.getXFlip() ? -scaleX : scaleX, s.getYFlip() ? -scaleY : scaleY);
        tr.translate(s.getXFlip() ? -s.getImage().getWidth() : 0, s.getYFlip() ? -s.getImage().getHeight() : 0);
        tr.rotate(Math.toRadians(s.getRotation()), s.getImage().getWidth() / 2, s.getImage().getHeight() / 2);

        AlphaComposite c = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, s.getAlpha());
        g.setComposite(c);

        g.drawImage(s.getImage(), tr, null);
        g.setTransform(store);
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }

    public void setAlpha(float alpha){
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
    }
}