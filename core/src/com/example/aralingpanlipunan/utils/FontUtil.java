package com.example.aralingpanlipunan.utils;

import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;

/**
 * This is a utility class for handling fonts
 */
public class FontUtil {

    /**
     * Detects touch event if it is within the BitmapFont
     * @param screenX touched x coordinate
     * @param screenY touched y coordinate
     * @param textX x coordinate of the font
     * @param textY y coordinate of the font
     * @param textBound TextBound object of the font
     * @return boolean
     */
    public boolean detectTextTouch(float screenX, float screenY, float textX, float textY, TextBounds textBound) {
        return screenX > textX && screenX < textX + textBound.width && screenY > textY  - textBound.height && screenY < textY;
    }
}
