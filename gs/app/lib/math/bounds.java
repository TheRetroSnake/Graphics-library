package gs.app.lib.math;

public class bounds {
    /* variables for position */
    public int x;
    public int y;
    public int w;
    public int h;

    /* create new object */
    public bounds(){

    }

    /* create new object from positions */
    public bounds(int X, int Y, int width, int height){
        x = X;
        y = Y;
        w = width;
        h = height;
    }

    /* create new object from bounds object */
    public bounds(bounds obj){
        x = obj.x;
        y = obj.y;
        w = obj.w;
        h = obj.h;
    }

    /* get left side */
    public int getLeftX(){
        return x + w;
    }

    /* get down side */
    public int getDownY(){
        return y + h;
    }

    /* add a border to bounds */
    public void addBorder(bounds b) {
        x += b.x;
        y += b.y;
        w -= b.x + b.w;
        h -= b.y + b.h;
    }

    /* compare bound objects */
    public boolean compare(bounds other){
        return other.x == x && other.y == y && other.w == w && other.h == h;
    }
}
