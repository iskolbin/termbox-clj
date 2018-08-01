#define ISL_TERMBOX_IMPLEMENTATION
#include "Termbox.h"
#include "isl_termbox/isl_termbox.h"

static struct tb_event event;
/*
 * Class:     Termbox
 * Method:    init
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_Termbox_init(JNIEnv *env, jclass cls) {
	tb_init();
}

/*
 * Class:     Termbox
 * Method:    shutdown
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_Termbox_shutdown(JNIEnv *env, jclass cls) {
	tb_shutdown();
}


/*
 * Class:     Termbox
 * Method:    present
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_Termbox_present(JNIEnv *env, jclass cls) {
	tb_present();
}

/*
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_Termbox_clear (JNIEnv *env, jclass cls) {
	tb_clear();
}

/*
 * Class:     Termbox
 * Method:    getWidth
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_Termbox_getWidth(JNIEnv *env, jclass cls) {
	return (jint) tb_width();
}

/*
 * Class:     Termbox
 * Method:    getHeight
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_Termbox_getHeight(JNIEnv *env, jclass cls) {
	return (jint) tb_height();
}

static struct tb_cell *tb_get_cell(int x, int y) {
	return  tb_cell_buffer() + y * tb_width() + x;
}

static uint32_t tb_get_char(int x, int y) {
	return tb_get_cell(x, y)->ch;
}

/*
 * Class:     Termbox
 * Method:    getCharacter
 * Signature: (II)C
 */
JNIEXPORT jchar JNICALL Java_Termbox_getCharacter(JNIEnv *env, jclass cls, jint x, jint y) {
	return (jchar) tb_get_char((int) x, (int) y);
}

/*
 * Class:     Termbox
 * Method:    getTextColor
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_Termbox_getTextColor(JNIEnv *env, jclass cls, jint x, jint y) {
	return (jint) tb_get_cell((int) x, (int) y)->fg;
}

/*
 * Class:     Termbox
 * Method:    getBackColor
 * Signature: (II)I
 */
JNIEXPORT jint JNICALL Java_Termbox_getBackColor(JNIEnv *env, jclass cls, jint x, jint y) {
	return (jint) tb_get_cell((int) x, (int) y)->bg;
}

/*
 * Class:     Termbox
 * Method:    setCell
 * Signature: (IICII)V
 */
JNIEXPORT void JNICALL Java_Termbox_setCell(JNIEnv *env, jclass cls, jint x, jint y, jchar ch, jint fg, jint bg) {
	tb_change_cell((int) x, (int) y, (uint32_t) ch, (uint16_t) fg, (uint16_t) bg);
}

/*
 * Class:     Termbox
 * Method:    setCells
 * Signature: (IILjava/lang/String;II)V
 */
JNIEXPORT void JNICALL Java_Termbox_setCells(JNIEnv *env, jclass cls, jint x, jint y, jstring str, jint fg, jint bg) {
	int len = 0;
	const char *native_str = (*env)->GetStringUTFChars(env, str, 0);
	const char *nstr = native_str;
	while (*nstr) {
		uint32_t uni;
		nstr += tb_utf8_char_to_unicode(&uni, nstr);
		tb_change_cell((int) x++, (int) y, uni, (uint16_t) fg, (uint16_t) bg);
		len++;
	}
	(*env)->ReleaseStringUTFChars(env, str, native_str);
}

/*
 * Class:     Termbox
 * Method:    setCharacter
 * Signature: (IIC)V
 */
JNIEXPORT void JNICALL Java_Termbox_setCharacter(JNIEnv *env, jclass cls, jint x, jint y, jchar ch) {
	tb_change_cell((int) x, (int) y, (uint32_t) ch, TB_DEFAULT, TB_DEFAULT);
}

/*
 * Class:     Termbox
 * Method:    setTextColor
 * Signature: (IIS)V
 */
JNIEXPORT void JNICALL Java_Termbox_setTextColor(JNIEnv *env, jclass cls, jint x, jint y, jint fg) {
	tb_change_cell((int) x, (int) y, tb_get_char((int) x, (int) y), (uint16_t) fg, TB_DEFAULT);
}

/*
 * Class:     Termbox
 * Method:    setBackColor
 * Signature: (IIS)V
 */
JNIEXPORT void JNICALL Java_Termbox_setBackColor(JNIEnv *env, jclass cls, jint x, jint y, jint bg) {
	tb_change_cell((int) x, (int) y, tb_get_char((int) x, (int) y), TB_DEFAULT, (uint16_t) bg);
}

/*
 * Class:     Termbox
 * Method:    setInputMode
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_Termbox_setInputMode(JNIEnv *env, jclass cls, jint mode) {
	tb_select_input_mode((int) mode);
}

/*
 * Class:     Termbox
 * Method:    setOutputMode
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_Termbox_setOutputMode(JNIEnv *env, jclass cls, jint mode) {
	tb_select_output_mode((int) mode);
}

/*
 * Class:     Termbox
 * Method:    setCursor
 * Signature: (II)V
 */
JNIEXPORT void JNICALL Java_Termbox_setCursor(JNIEnv *env, jclass cls, jint cx, jint cy) {
	tb_set_cursor((int) cx, (int) cy);
}

/*
 * Class:     Termbox
 * Method:    peek
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_Termbox_peek(JNIEnv *env, jclass cls, jint timeout) {
	return (jint) tb_peek_event(&event, (int) timeout);
}

/*
 * Class:     Termbox
 * Method:    poll
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_Termbox_poll(JNIEnv *env, jclass cls) {
	return (jint) tb_poll_event(&event);
}

/*
 * Class:     Termbox
 * Method:    getKeyboardCharacter
 * Signature: ()C
 */
JNIEXPORT jchar JNICALL Java_Termbox_getKeyboardCharacter(JNIEnv *env, jclass cls) {
	return (jchar) event.ch;
}

/*
 * Class:     Termbox
 * Method:    getKeyboardModifier
 * Signature: ()S
 */
JNIEXPORT jshort JNICALL Java_Termbox_getKeyboardModifier(JNIEnv *env, jclass cls) {
	return (jshort) event.mod;
}

/*
 * Class:     Termbox
 * Method:    getKeyboardKey
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_Termbox_getKeyboardKey(JNIEnv *env, jclass cls) {
	return (jint) event.key;
}

/*
 * Class:     Termbox
 * Method:    getMouseX
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_Termbox_getMouseX(JNIEnv *env, jclass cls) {
	return (jint) event.x;
}

/*
 * Class:     Termbox
 * Method:    getMouseY
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_Termbox_getMouseY(JNIEnv *env, jclass cls) {
	return (jint) event.y;
}

/*
 * Class:     Termbox
 * Method:    getMouseButton
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_Termbox_getMouseButton(JNIEnv *env, jclass cls) {
	return (jint) 0;
}
