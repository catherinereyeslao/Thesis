package com.example.aralingpanlipunan.views;

import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;

public abstract class AppView implements AppFragment, Disposable {
    protected int screenWidth, screenHeight;
    protected float exitScaledY = 0;

    /**
     * Scales the button to a size that fits the screen size and sets the y position of exit button
     * @return float
     */
    protected float getButtonScale() {
        ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
        switch (screenSizeUtil.getScreenCategory(screenWidth)) {
            case ScreenSizeUtil.LDPI:
                exitScaledY = 5;
                return 0.2f;
            case ScreenSizeUtil.MDPI:
                exitScaledY = 2.9f;
                return 0.4f;
            case ScreenSizeUtil.HDPI:
                exitScaledY = 2;
                return 0.6f;
            case ScreenSizeUtil.XHDPI:
                exitScaledY = 1.8f;
                return 0.7f;
            case ScreenSizeUtil.XXHDPI:
                exitScaledY = 1.4f;
                return 0.9f;
            default:
                exitScaledY = 1.4f;
                return 0.9f;
        }
    }
}
