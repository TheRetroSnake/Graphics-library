package gs.app.lib.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyUtil implements KeyListener {

    private static boolean[][] states;

    public KeyUtil(){
        states = new boolean[KeyEvent.VK_CONTEXT_MENU + 1][2];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() < states.length){
            states[e.getKeyCode()] = new boolean[]{ true, true };
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() < states.length){
            states[e.getKeyCode()][1] = false;
        }
    }

    public static boolean isHeld(int Button){
        return states[Button][1];
    }

    public static boolean isPressed(int Button){
        return states[Button][0];
    }

    public static void clearPresses(){
        for(int i = 0;i < states.length;i ++){
            states[i][0] = false;
        }
    }

    public static String toString(int Button){
        return KeyEvent.getKeyText(Button);
    }

    public static String toShortString(int Button){
        if(Button == COMMA) {
            return ",";

        } else if(Button == PERIOD){
            return ".";

        } else if(Button == SLASH || Button == DIVIDE){
            return "/";

        } else if(Button == BACKSLASH){
            return "\\";

        } else if(Button == SEMICOLON){
            return ";";

        } else if(Button == COLON){
            return ":";

        } else if(Button == EQUALS){
            return "=";

        } else if(Button == PLUS || Button == ADD){
            return "+";

        } else if(Button == MINUS ||Button == SUBTRACT){
            return "-";

        } else if(Button >= NUMPAD0 && Button <= NUMPAD9){
            return KeyEvent.getKeyText(Button).replaceAll("\\D", "");

        } else if(Button == MULTIPLY){
            return "*";

        } else if(Button == QUOTE){
            return "\"";

        } else if(Button == BACK_QUOTE){
            return "\"";

        } else if(Button == AT){
            return "@";

        } else if(Button == CIRCUMFLEX){
            return "^^";

        } else if(Button == DOLLAR){
            return "$";

        } else if(Button == EURO_SIGN){
            return "€";

        } else if(Button == EXCLAMATION){
            return "!";

        } else if(Button == INV_EXCLAMATION){
            return "¡";

        } else if(Button == LEFT_PARENTHESIS){
            return "(";

        } else if(Button == RIGHT_PARENTHESIS){
            return ")";

        } else if(Button == NUMBER_SIGN){
            return "#";

        } else if(Button == UNDERSCORE){
            return "_";

        } else if(Button == OPEN_BRACKET){
            return "[";

        } else if(Button == CLOSE_BRACKET){
            return "]";

        }

        return toString(Button);
    }

    public static final int CANCEL =       KeyEvent.VK_CANCEL;      // 0x03

    public static final int BACKSPACE =    KeyEvent.VK_BACK_SPACE;  // 0x08
    public static final int TAB =          KeyEvent.VK_TAB;         // 0x09
    public static final int ENTER =        KeyEvent.VK_ENTER;       // 0x0A

    public static final int CLEAR =        KeyEvent.VK_CLEAR;       // 0x0C
    public static final int SHIFT =        KeyEvent.VK_SHIFT;       // 0x10
    public static final int CONTROL =      KeyEvent.VK_CONTROL;     // 0x11
    public static final int ALT =          KeyEvent.VK_ALT;         // 0x12
    public static final int PAUSE =        KeyEvent.VK_PAUSE;       // 0x13
    public static final int CAPSLOCK =     KeyEvent.VK_CAPS_LOCK;   // 0x14
    public static final int ESCAPE =       KeyEvent.VK_ESCAPE;      // 0x1B

    public static final int SPACE =        KeyEvent.VK_SPACE;       // 0x20
    public static final int PAGE_UP =      KeyEvent.VK_PAGE_UP;     // 0x21
    public static final int PAGE_DOWN =    KeyEvent.VK_PAGE_DOWN;   // 0x22
    public static final int END =          KeyEvent.VK_END;         // 0x23
    public static final int HOME =         KeyEvent.VK_HOME;        // 0x24

    public static final int LEFT_ARROW =  KeyEvent.VK_LEFT;         // 0x25
    public static final int UP_ARROW =    KeyEvent.VK_UP;           // 0x26
    public static final int RIGHT_ARROW = KeyEvent.VK_RIGHT;        // 0x27
    public static final int DOWN_ARROW =  KeyEvent.VK_DOWN;         // 0x28

    public static final int COMMA =         KeyEvent.VK_COMMA;      // 0x2C
    public static final int MINUS =         KeyEvent.VK_MINUS;      // 0x2D
    public static final int PERIOD =        KeyEvent.VK_PERIOD;     // 0x2E
    public static final int SLASH =         KeyEvent.VK_SLASH;      // 0x2F

    public static final int NUM0 =    KeyEvent.VK_0;    // 0x30
    public static final int NUM1 =    KeyEvent.VK_1;
    public static final int NUM2 =    KeyEvent.VK_2;
    public static final int NUM3 =    KeyEvent.VK_3;
    public static final int NUM4 =    KeyEvent.VK_4;    // through
    public static final int NUM5 =    KeyEvent.VK_5;
    public static final int NUM6 =    KeyEvent.VK_6;
    public static final int NUM7 =    KeyEvent.VK_7;
    public static final int NUM8 =    KeyEvent.VK_8;
    public static final int NUM9 =    KeyEvent.VK_9;    // 0x39

    public static final int SEMICOLON =     KeyEvent.VK_SEMICOLON;      // 0x3B
    public static final int EQUALS =        KeyEvent.VK_EQUALS;         // 0x3D

    public static final int A = KeyEvent.VK_A;  // 0x41
    public static final int B = KeyEvent.VK_B;
    public static final int C = KeyEvent.VK_C;
    public static final int D = KeyEvent.VK_D;
    public static final int E = KeyEvent.VK_E;
    public static final int F = KeyEvent.VK_F;
    public static final int G = KeyEvent.VK_G;
    public static final int H = KeyEvent.VK_H;
    public static final int I = KeyEvent.VK_I;
    public static final int J = KeyEvent.VK_J;
    public static final int K = KeyEvent.VK_K;
    public static final int L = KeyEvent.VK_L;
    public static final int M = KeyEvent.VK_M;
    public static final int N = KeyEvent.VK_N;
    public static final int O = KeyEvent.VK_O;
    public static final int P = KeyEvent.VK_P;
    public static final int Q = KeyEvent.VK_Q;
    public static final int R = KeyEvent.VK_R;
    public static final int S = KeyEvent.VK_S;
    public static final int T = KeyEvent.VK_T;
    public static final int U = KeyEvent.VK_U;
    public static final int V = KeyEvent.VK_V;
    public static final int W = KeyEvent.VK_W;
    public static final int X = KeyEvent.VK_X;
    public static final int Y = KeyEvent.VK_Y;
    public static final int Z = KeyEvent.VK_Z;  // 0x5A

    public static final int OPEN_BRACKET =  KeyEvent.VK_OPEN_BRACKET;   // 0x5B
    public static final int BACKSLASH =     KeyEvent.VK_BACK_SLASH;     // 0x5C
    public static final int CLOSE_BRACKET = KeyEvent.VK_CLOSE_BRACKET;  // 0x5D

    public static final int NUMPAD0 = KeyEvent.VK_NUMPAD0;  // 0x60
    public static final int NUMPAD1 = KeyEvent.VK_NUMPAD1;
    public static final int NUMPAD2 = KeyEvent.VK_NUMPAD2;
    public static final int NUMPAD3 = KeyEvent.VK_NUMPAD3;
    public static final int NUMPAD4 = KeyEvent.VK_NUMPAD4;
    public static final int NUMPAD5 = KeyEvent.VK_NUMPAD5;
    public static final int NUMPAD6 = KeyEvent.VK_NUMPAD6;
    public static final int NUMPAD7 = KeyEvent.VK_NUMPAD7;
    public static final int NUMPAD8 = KeyEvent.VK_NUMPAD8;
    public static final int NUMPAD9 = KeyEvent.VK_NUMPAD9;  // 0x69

    public static final int MULTIPLY =      KeyEvent.VK_MULTIPLY;       // 0x6A
    public static final int ADD =           KeyEvent.VK_ADD;            // 0x6B
    public static final int SEPARATOR =     KeyEvent.VK_SEPARATOR;      // 0x6C
    public static final int SUBTRACT =      KeyEvent.VK_SUBTRACT;       // 0x6D
    public static final int DECIMAL =       KeyEvent.VK_DECIMAL;        // 0x6E
    public static final int DIVIDE =        KeyEvent.VK_DIVIDE;         // 0x6F

    public static final int F1 =  KeyEvent.VK_F1;   // 0x70
    public static final int F2 =  KeyEvent.VK_F2;
    public static final int F3 =  KeyEvent.VK_F3;
    public static final int F4 =  KeyEvent.VK_F4;
    public static final int F5 =  KeyEvent.VK_F5;
    public static final int F6 =  KeyEvent.VK_F6;
    public static final int F7 =  KeyEvent.VK_F7;
    public static final int F8 =  KeyEvent.VK_F8;
    public static final int F9 =  KeyEvent.VK_F9;
    public static final int F10 = KeyEvent.VK_F10;
    public static final int F11 = KeyEvent.VK_F11;
    public static final int F12 = KeyEvent.VK_F12;  // 0x7B

    public static final int DELETE =       KeyEvent.VK_DELETE;      // 0x7F

    public static final int NUM_LOCK =     KeyEvent.VK_NUM_LOCK;    // 0x90
    public static final int SCROLL_LOCK =  KeyEvent.VK_SCROLL_LOCK; // 0x91

    public static final int PRINTSCREEN =  KeyEvent.VK_PRINTSCREEN; // 0x9A
    public static final int INSERT =       KeyEvent.VK_INSERT;      // 0x9B
    public static final int HELP =         KeyEvent.VK_HELP;        // 0x9C
    public static final int META =         KeyEvent.VK_META;        // 0x9D
    public static final int BACK_QUOTE =   KeyEvent.VK_BACK_QUOTE;  // 0xC0
    public static final int QUOTE =        KeyEvent.VK_QUOTE;       // 0xDF

    public static final int AT =                KeyEvent.VK_AT;                 // 0x0200
    public static final int COLON =             KeyEvent.VK_COLON;              // 0x0201
    public static final int CIRCUMFLEX =        KeyEvent.VK_CIRCUMFLEX;         // 0x0202
    public static final int DOLLAR =            KeyEvent.VK_DOLLAR;             // 0x0203
    public static final int EURO_SIGN =         KeyEvent.VK_EURO_SIGN;          // 0x0204
    public static final int EXCLAMATION =       KeyEvent.VK_EXCLAMATION_MARK;   // 0x0205
    public static final int INV_EXCLAMATION =   KeyEvent.VK_INVERTED_EXCLAMATION_MARK;// 0x0206
    public static final int LEFT_PARENTHESIS =  KeyEvent.VK_LEFT_PARENTHESIS;   // 0x0207
    public static final int NUMBER_SIGN =       KeyEvent.VK_NUMBER_SIGN;        // 0x0208
    public static final int PLUS =              KeyEvent.VK_PLUS;               // 0x0209
    public static final int RIGHT_PARENTHESIS = KeyEvent.VK_RIGHT_PARENTHESIS;  // 0x020A
    public static final int UNDERSCORE =        KeyEvent.VK_UNDERSCORE;         // 0x020B
    public static final int WINDOWS_KEY =       KeyEvent.VK_WINDOWS;            // 0x020C
    public static final int WIN_CONTEXT_MENU =  KeyEvent.VK_CONTEXT_MENU;       // 0x020D
}
