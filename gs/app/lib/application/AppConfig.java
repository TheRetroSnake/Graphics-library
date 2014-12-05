package gs.app.lib.application;

public class AppConfig {
    /* program title */
    public String title;
    /* program positions */
    public int x;
    public int y;
    public int width;
    public int height;
    /* get if is resizable */
    public boolean resizable;

    /* new blank configuration */
    public AppConfig() {
        title = "";
        x = 0;
        y = 0;
        width = 0;
        height = 0;
        resizable = true;
    }

    /* new configuration from data */
    public AppConfig(String Title, int X, int Y, int Width, int Height, boolean resize) {
        title = Title;
        x = X;
        y = Y;
        width = Width;
        height = Height;
        resizable = resize;
    }
}
