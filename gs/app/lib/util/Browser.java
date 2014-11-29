package gs.app.lib.util;


import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Browser {

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

    public static boolean Open(URI uri) {
        if(Desktop.isDesktopSupported()){
            try {
                Desktop.getDesktop().browse(uri);
                return true;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return false;
    }
}
