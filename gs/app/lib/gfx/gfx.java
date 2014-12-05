package gs.app.lib.gfx;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class gfx {

    /* get a font from string */
    public static Font getFont(String file, int style, float size){
        try {
            /* create a new font object */
            Font f = Font.createFont(Font.TRUETYPE_FONT, new File(file)).deriveFont(style, size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

            /* register the font */
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(file)));

            /* return the font */
            return f;

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(FontFormatException e) {
            e.printStackTrace();
        }

        return null;
    }

    /* get image from file */
    public static BufferedImage getImage(File file){
        try {
            /* return the image */
            return ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /* get image from string */
    public static BufferedImage getImage(String file){
        return getImage(new File(file));
    }
}
