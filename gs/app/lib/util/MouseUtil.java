package gs.app.lib.util;

import gs.app.lib.application.App;
import gs.app.lib.math.bounds;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseUtil implements MouseListener {

    public MouseUtil(){
        states = new boolean[RIGHT + 1][2];
    }

    public static final int LEFT =   MouseEvent.BUTTON1;
    public static final int RIGHT =  MouseEvent.BUTTON3;
    public static final int MIDDLE = MouseEvent.BUTTON2;
    private static boolean[][] states;
    private static boolean inProgram;

    public static Point getPoint(){
        return MouseInfo.getPointerInfo().getLocation();
    }

    public static bounds getBounds(){
        if(inProgram) {
            return new bounds(getX(), getY(), 0, 0);
        }

        return new bounds(-1000, -1000, -1000, -1000);
    }

    public static int getX(){
        if(inProgram) {
            return getPoint().x - App.GetBounds().x;
        }

        return -1000;
    }

    public static int getY(){
        if(inProgram) {
            return getPoint().y - App.GetBounds().y;
        }

        return -1000;
    }

    public static boolean isPressed(int Button){
        return states[Button][0];
    }

    public static boolean isHeld(int Button){
        return states[Button][1];
    }

    public static void clearPresses(){
        for(int i = 0;i < states.length;i ++){
            states[i][0] = false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        states[e.getButton()] = new boolean[]{ true, true };
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        states[e.getButton()][1] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        inProgram = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        inProgram = false;
    }
}
