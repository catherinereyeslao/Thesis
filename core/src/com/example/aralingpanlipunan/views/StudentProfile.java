package com.example.aralingpanlipunan.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;

public class StudentProfile extends AppView implements AppFragment, Disposable {
    private static final byte TOUCHED_NAME = 1;
    private static final byte TOUCHED_PASSWORD = 2;
    private static StringBuilder typedName;
    private static StringBuilder typedPassword;
    private static boolean alertYesTouched = false;
    private Texture background, textBoxTexture, enterTexture;
    private Sprite nameTextBox, passwordTextBox, enter;
    private BitmapFont nameFont, passwordFont;
    private ScreenSizeUtil screenSizeUtil;
    private AndroidInterface android;
    private byte touchedTextBox;

    public StudentProfile(AndroidInterface androidInterface) {
        android = androidInterface;
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;

        typedName = new StringBuilder();
        typedPassword = new StringBuilder();

        screenSizeUtil = new ScreenSizeUtil();
        background = new Texture("backgrounds/start-background.jpg");
        textBoxTexture = new Texture("balloons/textbox.png");
        enterTexture = new Texture("buttons/enter.png");

        nameFont = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        nameFont.setColor(0.3f, 0.3f, 0.3f, 0.7f);
        nameFont.scale(1.6f);

        passwordFont = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        passwordFont.setColor(0.3f, 0.3f, 0.3f, 0.7f);
        passwordFont.scale(1.6f);

        nameTextBox = new Sprite(textBoxTexture);
        nameTextBox.setSize((nameTextBox.getWidth() * getButtonScale()) * 2.1f, nameTextBox.getHeight() * getButtonScale());
        final float nameX = (screenW / 2) - (nameTextBox.getWidth() / 1.9f);
        final float nameY = (screenH / 1.35f) - (nameTextBox.getHeight() / 2);
        nameTextBox.setBounds(nameX, nameY, nameTextBox.getWidth(), nameTextBox.getHeight());

        passwordTextBox = new Sprite(textBoxTexture);
        passwordTextBox.setSize((passwordTextBox.getWidth() * getButtonScale()) * 2.1f, passwordTextBox.getHeight() * getButtonScale());
        final float passwordX = (screenW / 2) - (passwordTextBox.getWidth() / 1.9f);
        final float passwordY = (screenH / 2) - (passwordTextBox.getHeight() / 2);
        passwordTextBox.setBounds(passwordX, passwordY, passwordTextBox.getWidth(), passwordTextBox.getHeight());

        enter = new Sprite(enterTexture);
        enter.setSize(enter.getWidth() * getButtonScale(), enter.getHeight() * getButtonScale());
        final float enterX = (screenW / 2) - (enter.getWidth() / 2f);
        final float enterY = (screenH / 3.7f) - (enter.getHeight() / 2);
        enter.setBounds(enterX, enterY, enter.getWidth(), enter.getHeight());

        clearTypedName();
        clearTypedPassword();
    }

    @Override
    public void display(Batch batch) {
        String displayName = typedName.length() > 0 ? typedName.toString() : "Enter your name";
        String displayPw = typedPassword.length() > 0 ? typedPassword.toString() : "Enter your password";
        batch.draw(background, 0, 0, screenWidth, screenHeight);
        nameTextBox.draw(batch);
        passwordTextBox.draw(batch);

        nameFont.draw(
                batch,
                displayName,
                screenSizeUtil.textInSpriteX(nameTextBox, nameFont.getBounds(displayName)),
                screenSizeUtil.textInSpriteY(nameTextBox)
        );
        passwordFont.draw(
                batch,
                displayPw,
                screenSizeUtil.textInSpriteX(passwordTextBox, passwordFont.getBounds(displayPw)),
                screenSizeUtil.textInSpriteY(passwordTextBox)
        );

        enter.draw(batch);
    }

    /**
     * After the user touches the "Register" in the alertBox, set the
     * {@link #alertYesTouched} property to true, to indicate that a
     * registration of a new user is requested
     * @param alert boolean
     */
    public static void setAlertYesTouched(boolean alert) {
        alertYesTouched = alert;
    }

    public static boolean isAlertYesTouched() {
        return alertYesTouched;
    }

    public static String getTypedName() {
        return typedName.toString();
    }

    public static String getTypedPassword() {
        return typedPassword.toString();
    }

    public static void clearTypedName() {
        typedName.setLength(0);
    }

    public static void clearTypedPassword() {
        typedPassword.setLength(0);
    }

    @Override
    public void dispose() {
        background.dispose();
        textBoxTexture.dispose();
        enterTexture.dispose();
        nameFont.dispose();
    }

    /**
     * Listen to screen touches. If the user registers or logs in, open the chapter section by returning student name
     * @param x The x coordinate of touched screen
     * @param y The y coordinate of touched screen
     * @return String name of signed in student
     */
    public String touchDown(float x, float y) {
        // If nameTextBox is touched, display the soft keyboard in android device
        if (nameTextBox.getBoundingRectangle().contains(x, y)) {
            touchedTextBox = TOUCHED_NAME;
            Gdx.input.setOnscreenKeyboardVisible(true);
        } else if (passwordTextBox.getBoundingRectangle().contains(x, y)) {
            touchedTextBox = TOUCHED_PASSWORD;
            Gdx.input.setOnscreenKeyboardVisible(true);
        }

        // If typedName & password are not empty and user touched the "enter" button
        if (typedName.toString().length() > 1 && typedPassword.toString().length() > 1 && enter.getBoundingRectangle().contains(x, y)) {
            Gdx.input.setOnscreenKeyboardVisible(false);
            if (android.studentExists(typedName.toString(), typedPassword.toString())) {
                return typedName.toString();
            }
            else {
                android.showAlertDialog(
                        "Register as new user?",
                        "The name you entered doesn't exist yet, Would you like to register as a new user?",
                        "Register",
                        "Back"
                );
            }
        }
        return null;
    }

    /**
     * Listen to what users are typing in keyboard.
     * @param keyCode code of the keyboard pressed
     */
    public int keyDown(int keyCode) {
        if (keyCode == 4)
            return 1;

        // 67 is keyCode for backspace
        if (keyCode == 67)
            switch (touchedTextBox) {
                case TOUCHED_NAME:
                    try {
                        typedName.setLength(typedName.length() - 1);
                    } catch (StringIndexOutOfBoundsException e) {
                        typedName.setLength(0);
                    }
                    break;
                case TOUCHED_PASSWORD:
                    try {
                        typedPassword.setLength(typedPassword.length() - 1);
                    } catch (StringIndexOutOfBoundsException e) {
                        typedPassword.setLength(0);
                    }
                    break;
            }
        return 0;
    }

    /**
     * Listen to any characters typed from the keyboard, then display it in Student login or register
     * @param character letter pressed from keyboard
     */
    public void keyTyped(char character) {
        if (touchedTextBox == TOUCHED_NAME && Character.isLetter(character) && typedName.length() < 10)
            typedName.append(character);
        else if (touchedTextBox == TOUCHED_PASSWORD && Character.isLetter(character) && typedPassword.length() < 10)
            typedPassword.append(character);
    }
}
