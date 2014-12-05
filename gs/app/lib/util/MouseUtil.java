package gs.app.lib.util;

import gs.app.lib.application.App;
import gs.app.lib.math.bounds;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseUtil implements MouseListener {

    /* new mouseUtil */
    public MouseUtil(){
        states = new byte[RIGHT + 1];
    }

    /* available button states */
    public static final int LEFT =   MouseEvent.BUTTON1;
    public static final int RIGHT =  MouseEvent.BUTTON3;
    public static final int MIDDLE = MouseEvent.BUTTON2;

    /* states of buttons
     * bit 0 = pressed state
     * bit 1 = held state */
    private static byte[] states;

    /* true if the mouse is inside the program, else is false */
    private static boolean inProgram;

    /* get Point object of the mouse */
    public static Point getPoint(){
        return MouseInfo.getPointerInfo().getLocation();
    }

    /* get bounds object of mouse position */
    public static bounds getBounds() {
        return new bounds(getX(), getY(), 0, 0);
    }

    public static int getX(){
        /* if is in program, get position */
        if(inProgram) {
            return getPoint().x - App.GetBounds().x;
        }

        /* if not in program, return bullshit value */
        return -1000;
    }

    public static int getY(){
        /* if is in program, get position */
        if(inProgram) {
            return getPoint().y - App.GetBounds().y;
        }

        /* if not in program, return bullshit values */
        return -1000;
    }

    /* return pressed button state */
    public static boolean isPressed(int Button){
        return (states[Button] & 1) != 0;
    }

    /* return held button state */
    public static boolean isHeld(int Button){
        return (states[Button] & 2) != 0;
    }

    /* clear button presses */
    public static void clearPresses(){
        for(int i = 0;i < states.length;i ++){
            /* remove pressed state */
            states[i] &= 2;
        }
    }

    /* if mouse is clicked */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /* if mouse is pressed */
    @Override
    public void mousePressed(MouseEvent e) {
        states[e.getButton()] = 3;
    }

    /* if mouse button is released */
    @Override
    public void mouseReleased(MouseEvent e) {
        states[e.getButton()] &= 1;
    }

    /* if mouse entered program */
    @Override
    public void mouseEntered(MouseEvent e) {
        inProgram = true;
    }

    /* if mouse exited the program */
    @Override
    public void mouseExited(MouseEvent e) {
        inProgram = false;
    }
}
