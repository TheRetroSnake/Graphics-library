package gs.app.lib.application;

public class AppConfig {
    public String title;
    public int x;
    public int y;
    public int width;
    public int height;
    public boolean resizable;

    public AppConfig() {
        title = "";
        x = 0;
        y = 0;
        width = 0;
        height = 0;
        resizable = true;
    }

    public AppConfig(String Title, int X, int Y, int Width, int Height, boolean resize) {
        title = Title;
        x = X;
        y = Y;
        width = Width;
        height = Height;
        resizable = resize;
    }
}
