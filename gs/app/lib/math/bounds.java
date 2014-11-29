package gs.app.lib.math;

public class bounds {
    public int x;
    public int y;
    public int w;
    public int h;

    public bounds(){

    }

    public bounds(int X, int Y, int width, int height){
        x = X;
        y = Y;
        w = width;
        h = height;
    }

    public int getLeftX(){
        return x + w;
    }

    public int getDownY(){
        return y + h;
    }

    public void addBorder(bounds b) {
        x += b.x;
        y += b.y;
        w -= b.x + b.w;
        h -= b.y + b.h;
    }

    public boolean compare(bounds other){
        return other.x == x && other.y == y && other.w == w && other.h == h;
    }
}
