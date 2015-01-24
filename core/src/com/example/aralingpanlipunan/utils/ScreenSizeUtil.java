package com.example.aralingpanlipunan.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * This is a utility class to analyze the device's screen size so we can use the appropriate
 * assets and fit them well for different screen sizes
 */
public class ScreenSizeUtil {
    public static final int LDPI = 0;
    public static final int MDPI = 1;
    public static final int HDPI = 2;
    public static final int XHDPI = 4;
    public static final int XXHDPI = 8;

    /**
     * Use the correct font asset according to screen size
     * @param screenW width of device in pixels
     * @return FileHandle of the font
     */
    public FileHandle fontAsset(int screenW) {
        final int screenCategory = getScreenCategory(screenW);
        switch (screenCategory) {
            case LDPI:
                return Gdx.files.internal("fonts/ldpi/comic-sans.fnt");
            case MDPI:
                return Gdx.files.internal("fonts/mdpi/comic-sans.fnt");
            case HDPI:
                return Gdx.files.internal("fonts/hdpi/comic-sans.fnt");
            case XHDPI:
                return Gdx.files.internal("fonts/xhdpi/comic-sans.fnt");
            case XXHDPI:
                return Gdx.files.internal("fonts/xxhdpi/comic-sans.fnt");
            default:
                return Gdx.files.internal("fonts/xxhdpi/comic-sans.fnt");
        }
    }

    /**
     * Determine if screen size belongs to which category
     * @param screenW width (in pixels) of the screen to analyze
     * @return int
     */
    public int getScreenCategory(int screenW) {
        if (screenW <= 480)
            return LDPI;
        else if (screenW > 480 && screenW <= 800)
            return MDPI;
        else if (screenW > 800 && screenW <= 1280)
            return HDPI;
        else if (screenW > 1280 && screenW <= 1920)
            return XHDPI;
        else
            return XXHDPI;
    }

    /**
     * Does the calculations to put the BitmapFont x coordinate centered inside the sprite
     * @param buttonSprite Button Sprite
     * @param textBounds TextBound object of the font
     * @return x coordinate of the BitmapFont inside the sprite
     */
    public float textInSpriteX(Sprite buttonSprite, BitmapFont.TextBounds textBounds) {
        return buttonSprite.getX() - (textBounds.width / 2) + (buttonSprite.getWidth() / 2);
    }

    /**
     * Does the calculation to put the BitmapFont y coordinate centered inside the sprite
     * @param buttonSprite Bubble Sprite
     * @return y coordinate of the BitmapFont inside the sprite
     */
    public float textInSpriteY(Sprite buttonSprite) {
        return buttonSprite.getY() + (buttonSprite.getHeight() / 1.5f);
    }
}