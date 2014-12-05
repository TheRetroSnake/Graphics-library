package gs.app.lib.util;


import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Browser {

    /* open URL from string */
    public static boolean Open(String url){
        try {
            return Open(new URL(url).toURI());

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return false;
    }

    /* open URL from URI object */
    public static boolean Open(URI uri) {
        if(Desktop.isDesktopSupported()){
            try {
                /* open the URL */
                Desktop.getDesktop().browse(uri);
                return true;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return false;
    }
}
