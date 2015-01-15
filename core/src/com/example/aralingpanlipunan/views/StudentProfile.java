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
    private Texture background, balloonTexture, enterTexture;
    private Sprite balloon, enter;
    private BitmapFont text;
    private ScreenSizeUtil screenSizeUtil;
    private String typedName = "";
    private AndroidInterface android;

    public StudentProfile(AndroidInterface androidInterface) {
        android = androidInterface;
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;

        screenSizeUtil = new ScreenSizeUtil();
        background = new Texture("backgrounds/start-background.jpg");
        balloonTexture = new Texture("balloons/empty-balloon.png");
        enterTexture = new Texture("buttons/student/enter.png");

        text = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        text.setColor(0.3f, 0.3f, 0.3f, 0.7f);
        text.scale(1.6f);

        balloon = new Sprite(balloonTexture);
        balloon.setSize((balloon.getWidth() * getButtonScale()) * 3, balloon.getHeight() * getButtonScale());
        final float balloonX = (screenW / 3) - (balloon.getWidth() / 2);
        final float balloonY = (screenH - (screenH / 6)) - (balloon.getHeight() / 2);
        balloon.setPosition(balloonX, balloonY);
        balloon.setBounds(balloonX, balloonY, balloon.getWidth(), balloon.getHeight());

        enter = new Sprite(enterTexture);
        enter.setSize(enter.getWidth() * getButtonScale(), enter.getHeight() * getButtonScale());
        final float enterX = (screenW - (screenW / 6)) - (enter.getWidth() / 2);
        final float enterY = (screenH - (screenH / 7)) - (enter.getHeight() / 2);
        enter.setPosition(enterX, enterY);
        enter.setBounds(enterX, enterY, enter.getWidth(), enter.getHeight());
    }

    @Override
    public void display(Batch batch) {
        String displayName = typedName.length() > 0 ? typedName : "Enter your name";
        batch.draw(background, 0, 0, screenWidth, screenHeight);
        balloon.draw(batch);
        text.draw(batch, displayName, screenSizeUtil.textInSpriteX(balloon, text.getBounds(displayName)),screenSizeUtil.textInSpriteY(balloon));
        enter.draw(batch);
    }

    @Override
    public void dispose() {
        background.dispose();
        balloonTexture.dispose();
        enterTexture.dispose();
        text.dispose();
    }

    /**
     * Listen to screen touches. If the user registers or logs in, open the chapter section by returning student name
     * @param x The x coordinate of touched screen
     * @param y The y coordinate of touched screen
     * @return String name of signed in student
     */
    public String touchDown(float x, float y) {
        // If balloon is touched, display the soft keyboard in android device
        if (balloon.getBoundingRectangle().contains(x, y))
            Gdx.input.setOnscreenKeyboardVisible(true);

        // If typedName is not empty and user touched the "enter" cloud
        if (typedName.length() > 1 && enter.getBoundingRectangle().contains(x, y)) {
            Gdx.input.setOnscreenKeyboardVisible(false);
            if (android.studentExists(typedName)) {
                return typedName;
            }
            else {
                boolean register = android.showAlertDialog(
                        "Register as new user?",
                        "The name you entered doesn't exist yet, Would you like to register as a new user?",
                        "Register",
                        "Back"
                );
                if (register) {
                    android.registerNewStudent(typedName);
                    return typedName;
                }
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
        try {
            // 67 is keyCode for backspace
            if (keyCode == 67)
                typedName = typedName.substring(0, typedName.length() - 1);
        } catch (StringIndexOutOfBoundsException e) {
            // User is probably pressing the backspace key even if the name is already empty, ignore exception
            typedName = "";
        }
        return 0;
    }

    /**
     * Listen to any characters typed from the keyboard, then display it in Student login or register
     * @param character letter pressed from keyboard
     */
    public void keyTyped(char character) {
        if (Character.isLetter(character) && typedName.length() < 10)
            typedName += character;
    }
}
