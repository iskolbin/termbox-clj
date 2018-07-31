public class Termbox {
	static {
		System.load(System.getProperty("user.dir") + "/target/jni/libtermbox.so");
	}

	public final static int KEY_F1               = (0xFFFF-0);
	public final static int KEY_F2               = (0xFFFF-1);
	public final static int KEY_F3               = (0xFFFF-2);
	public final static int KEY_F4               = (0xFFFF-3);
	public final static int KEY_F5               = (0xFFFF-4);
	public final static int KEY_F6               = (0xFFFF-5);
	public final static int KEY_F7               = (0xFFFF-6);
	public final static int KEY_F8               = (0xFFFF-7);
	public final static int KEY_F9               = (0xFFFF-8);
	public final static int KEY_F10              = (0xFFFF-9);
	public final static int KEY_F11              = (0xFFFF-10);
	public final static int KEY_F12              = (0xFFFF-11);
	public final static int KEY_INSERT           = (0xFFFF-12);
	public final static int KEY_DELETE           = (0xFFFF-13);
	public final static int KEY_HOME             = (0xFFFF-14);
	public final static int KEY_END              = (0xFFFF-15);
	public final static int KEY_PGUP             = (0xFFFF-16);
	public final static int KEY_PGDN             = (0xFFFF-17);
	public final static int KEY_ARROW_UP         = (0xFFFF-18);
	public final static int KEY_ARROW_DOWN       = (0xFFFF-19);
	public final static int KEY_ARROW_LEFT       = (0xFFFF-20);
	public final static int KEY_ARROW_RIGHT      = (0xFFFF-21);

	public final static int TB_KEY_CTRL_TILDE        = 0x00;
	public final static int TB_KEY_CTRL_2            = 0x00; /* clash with 'CTRL_TILDE' */
	public final static int TB_KEY_CTRL_A            = 0x01;
	public final static int TB_KEY_CTRL_B            = 0x02;
	public final static int TB_KEY_CTRL_C            = 0x03;
	public final static int TB_KEY_CTRL_D            = 0x04;
	public final static int TB_KEY_CTRL_E            = 0x05;
	public final static int TB_KEY_CTRL_F            = 0x06;
	public final static int TB_KEY_CTRL_G            = 0x07;
	public final static int TB_KEY_BACKSPACE         = 0x08;
	public final static int TB_KEY_CTRL_H            = 0x08; /* clash with 'CTRL_BACKSPACE' */
	public final static int TB_KEY_TAB               = 0x09;
	public final static int TB_KEY_CTRL_I            = 0x09; /* clash with 'TAB' */
	public final static int TB_KEY_CTRL_J            = 0x0A;
	public final static int TB_KEY_CTRL_K            = 0x0B;
	public final static int TB_KEY_CTRL_L            = 0x0C;
	public final static int TB_KEY_ENTER             = 0x0D;
	public final static int TB_KEY_CTRL_M            = 0x0D; /* clash with 'ENTER' */
	public final static int TB_KEY_CTRL_N            = 0x0E;
	public final static int TB_KEY_CTRL_O            = 0x0F;
	public final static int TB_KEY_CTRL_P            = 0x10;
	public final static int TB_KEY_CTRL_Q            = 0x11;
	public final static int TB_KEY_CTRL_R            = 0x12;
	public final static int TB_KEY_CTRL_S            = 0x13;
	public final static int TB_KEY_CTRL_T            = 0x14;
	public final static int TB_KEY_CTRL_U            = 0x15;
	public final static int TB_KEY_CTRL_V            = 0x16;
	public final static int TB_KEY_CTRL_W            = 0x17;
	public final static int TB_KEY_CTRL_X            = 0x18;
	public final static int TB_KEY_CTRL_Y            = 0x19;
	public final static int TB_KEY_CTRL_Z            = 0x1A;
	public final static int TB_KEY_ESC               = 0x1B;
	public final static int TB_KEY_CTRL_LSQ_BRACKET  = 0x1B; /* clash with 'ESC' */
	public final static int TB_KEY_CTRL_3            = 0x1B; /* clash with 'ESC' */
	public final static int TB_KEY_CTRL_4            = 0x1C;
	public final static int TB_KEY_CTRL_BACKSLASH    = 0x1C; /* clash with 'CTRL_4' */
	public final static int TB_KEY_CTRL_5            = 0x1D;
	public final static int TB_KEY_CTRL_RSQ_BRACKET  = 0x1D; /* clash with 'CTRL_5' */
	public final static int TB_KEY_CTRL_6            = 0x1E;
	public final static int TB_KEY_CTRL_7            = 0x1F;
	public final static int TB_KEY_CTRL_SLASH        = 0x1F; /* clash with 'CTRL_7' */
	public final static int TB_KEY_CTRL_UNDERSCORE   = 0x1F; /* clash with 'CTRL_7' */
	public final static int TB_KEY_SPACE             = 0x20;
	public final static int TB_KEY_BACKSPACE2        = 0x7F;
	public final static int TB_KEY_CTRL_8            = 0x7F; /* clash with 'BACKSPACE2' */


	public final static int MOUSE_LEFT       = (0xFFFF-22);
	public final static int MOUSE_RIGHT      = (0xFFFF-23);
	public final static int MOUSE_MIDDLE     = (0xFFFF-24);
	public final static int MOUSE_RELEASE    = (0xFFFF-25);
	public final static int MOUSE_WHEEL_UP   = (0xFFFF-26);
	public final static int MOUSE_WHEEL_DOWN = (0xFFFF-27);

	public final static int MOD_ALT    = 0x01;
	public final static int MOD_MOTION = 0x02;

	public final static int BOLD      = 0x0100;
	public final static int UNDERLINE = 0x0200;
	public final static int REVERSE   = 0x0400;

	public final static int EVENT_ERROR   = -1;
	public final static int EVENT_TIMEOUT = 0;
	public final static int EVENT_KEY     = 1;
	public final static int EVENT_RESIZE  = 2;
	public final static int EVENT_MOUSE   = 3;

	public final static int INPUT_CURRENT = 0;
	public final static int INPUT_ESC     = 1;
	public final static int INPUT_ALT     = 2;
	public final static int INPUT_MOUSE   = 4;

	public final static int OUTPUT_CURRENT   = 0;
	public final static int OUTPUT_NORMAL    = 1;
	public final static int OUTPUT_256       = 2;
	public final static int OUTPUT_216       = 3;
	public final static int OUTPUT_GRAYSCALE = 4;

	public final static int DEFAULT  = 0x00;
	public final static int BLACK    = 0x01;
	public final static int RED      = 0x02;
	public final static int GREEN    = 0x03;
	public final static int YELLOW   = 0x04;
	public final static int BLUE     = 0x05;
	public final static int MAGENTA  = 0x06;
	public final static int CYAN     = 0x07;
	public final static int WHITE    = 0x08;

	public final static int WRAP_CROP    = 0;
	public final static int WRAP_NEWLINE = 1;
	public final static int WRAP_CYCLE   = 2;

	public static native void init();
	public static native void shutdown();
	public static native void present();
	public static native void clear();
	public static native int getWidth();
	public static native int getHeight();
	public static native char getCharacter(int x, int y);
	public static native int getTextColor(int x, int y);
	public static native int getBackColor(int x, int y);
	public static native void setCell(int x, int y, char character, int textColor, int backColor);
	public static native void setCells(int x, int y, String string, int textColor, int backColor, int wrapMode);
	public static native void setCharacter(int x, int y, char character);
	public static native void setTextColor(int x, int y, int textColor);
	public static native void setBackColor(int x, int y, int backColor);
	public static native void setInputMode(int mode);
	public static native void setOutputMode(int mode);
	public static native void setCursor(int x, int y);
	public static native int peek(int timeout);
	public static native int poll();
	public static native char getKeyboardCharacter();
	public static native short getKeyboardModifier();
	public static native int getKeyboardKey();
	public static native int getMouseX();
	public static native int getMouseY();
	public static native int getMouseButton();
}
