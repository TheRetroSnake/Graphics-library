package gs.app.lib.application;

import gs.app.lib.gfx.Graphics;
import gs.app.lib.math.bounds;
import gs.app.lib.util.KeyUtil;
import gs.app.lib.util.MouseUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App {

    private static AppConfig Config;
    private static AppRun app;
    private static Surface s;
    private static Launch l;
    private static boolean render = false;

    public App(AppConfig c, AppRun a){
        Config = c;
        app = a;

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                l = new Launch();
                l.setVisible(true);
            }
        });
    }

    public static JPanel getJPanel(){
        return s;
    }

    public static void SetTitle(String title){
        l.setTitle(title);
    }

    public static JFrame getJFrame(){
        return l;
    }

    public static bounds GetBounds(){
        if(s.isShowing()) {
            return new bounds((int) s.getLocationOnScreen().getX(), (int) s.getLocationOnScreen().getY(), s.getWidth(), s.getHeight());
        }
        return new bounds(-1000, -1000, -1000, -1000);
    }

    public static void SetPosition(bounds bound){
        l.setBounds(bound.x, bound.y, bound.w, bound.h);
        s.setBounds(bound.x, bound.y, bound.w, bound.h);
        l.setVisible(true);
    }

    private class Launch extends JFrame {
        public Launch(){
            setTitle(Config.title);
            setResizable(Config.resizable);
            s = new Surface();
            s.addMouseListener(new MouseUtil());
            addKeyListener(new KeyUtil());

            add(s);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            pack();
            setBounds(Config.x, Config.y, Config.width, Config.height);

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                    super.windowOpened(e);
                    render = true;
                    app.create();
                    l.repaint();
                }

                @Override
                public void windowClosed(WindowEvent e) {
                    exit(0);
                }
            });

            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    app.resize(s.getWidth(), s.getHeight());
                }
            });

            addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    app.focus();
                }

                @Override
                public void focusLost(FocusEvent e) {
                    app.unfocus();
                }
            });

            Config = null;
        }
    }

    private class Surface extends JPanel {

        @Override
        public void paintComponent(java.awt.Graphics g) {

            super.paintComponent(g);
            if (render) {
                app.render(new Graphics((Graphics2D) g));
            }
        }
    }

    public static void exit(int error){
        app.dispose();
        l.dispose();
        System.exit(error);
    }

    public static void repaint(){
        l.repaint();
    }
}
