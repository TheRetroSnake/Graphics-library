package gs.app.lib.application;

import gs.app.lib.gfx.Graphics;
import gs.app.lib.math.bounds;
import gs.app.lib.util.KeyUtil;
import gs.app.lib.util.MouseUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {

    /* app configuration */
    private static AppConfig Config;
    /* object to run */
    private static AppRun app;
    /* the JPanel */
    private static Surface s;
    /* the JFrame */
    private static Launch l;
    /* allow rendering (to dirtily fix some bugs) */
    private static boolean render = false;

    /* create new program */
    public App(AppConfig c, AppRun a){
        Config = c;
        app = a;

        /* start the application in optimal time */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /* start */
                l = new Launch();
                l.setVisible(true);
            }
        });
    }

    /* get JPanel (Surface) */
    public static JPanel getJPanel(){
        return s;
    }

    /* set program title */
    public static void SetTitle(String title){
        l.setTitle(title);
    }

    /* get JFrame (Launch) */
    public static JFrame getJFrame(){
        return l;
    }

    /* get program position */
    public static bounds GetBounds(){
        /* if is still showing, return position */
        if(s.isShowing()) {
            /* get program x, y, width, and height */
            return new bounds((int) s.getLocationOnScreen().getX(), (int) s.getLocationOnScreen().getY(), s.getWidth(), s.getHeight());
        }

        /* return bullshit values */
        return new bounds(-1000, -1000, -1000, -1000);
    }

    /* set program position */
    public static void SetPosition(bounds bound){
        l.setBounds(bound.x, bound.y, bound.w, bound.h);
        s.setBounds(bound.x, bound.y, bound.w, bound.h);
        l.setVisible(true);
    }

    /* the Jframe controller class */
    private class Launch extends JFrame {
        public Launch(){
            /* set title and resizable */
            setTitle(Config.title);
            setResizable(Config.resizable);

            /* new JPanel */
            s = new Surface();

            /* add mouse and key listeners */
            s.addMouseListener(new MouseUtil());
            addKeyListener(new KeyUtil());

            /* add JPanel to JFrame and set variables */
            add(s);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            pack();
            setBounds(Config.x, Config.y, Config.width, Config.height);

            /* add window listener */
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                    super.windowOpened(e);
                    /* allow rendering */
                    render = true;
                    /* create the app */
                    app.create();
                    /* render the screen */
                    l.repaint();
                }

                @Override
                public void windowClosed(WindowEvent e) {
                    /* exit normally */
                    exit(0);
                }
            });

            /* add component listener for resizing */
            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    /* resize properly */
                    app.resize(s.getWidth(), s.getHeight());
                }
            });

            /* add focusing listener */
            addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    /* focus */
                    app.focus();
                }

                @Override
                public void focusLost(FocusEvent e) {
                    /* unfocus */
                    app.unfocus();
                }
            });

            /* free some memory by removing the AppConfig object */
            Config = null;
        }
    }

    /* the JPanel controller class */
    private class Surface extends JPanel {

        @Override
        public void paintComponent(java.awt.Graphics g) {
            super.paintComponent(g);

            /* if we can render, render the app */
            if (render) {
                app.render(new Graphics((Graphics2D) g));
            }
        }
    }

    /* exit program */
    public static void exit(int error){
        /* call dispose on the JFrame and application */
        app.dispose();
        l.dispose();
        /* exit */
        System.exit(error);
    }

    /* render the program again */
    public static void repaint(){
        l.repaint();
    }
}
