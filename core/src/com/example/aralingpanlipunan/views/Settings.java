package com.example.aralingpanlipunan.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.utils.AppPreferences;

/**
 * The settings view which is displayed in Chapters
 */
public class Settings {
    private static final byte SETTINGS_MENU = 0;
    private static final byte NAVIGATION1 = 1;
    private static final byte NAVIGATION2 = 2;
    private static final byte TUTORIAL1 = 3;
    private static final byte TUTORIAL2 = 4;
    private static final byte TUTORIAL3 = 5;

    private Texture blackBgSettingsTexture, settingsTexture, navigationTexture, tutorialTexture, soundsTexture, navigation1Texture, navigation2Texture, navigation3Texture, tutorial1Texture, tutorial2Texture, tutorial3Texture;
    private Sprite settingsBg, settings, navigation, tutorial, sounds;
    private AppPreferences appPreferences;
    private byte settingsDisplay = SETTINGS_MENU;

    /**
     * Set up the assets for settings view
     * @param screenW Width of the screen
     * @param screenH Height of the screen
     */
    public void setUp(int screenW, int screenH) {
        appPreferences = new AppPreferences();
        blackBgSettingsTexture = new Texture("settings/settings-bg.png");

        settingsBg = new Sprite(blackBgSettingsTexture);
        settingsBg.setSize(screenW / 2, screenH / 1.8f);
        settingsBg.setPosition(
                (screenW / 2) - (settingsBg.getWidth() / 2),
                (screenH / 1.7f) - (settingsBg.getHeight() / 2)
        );

        settingsTexture = new Texture("settings/settings-option.png");
        settings = new Sprite(settingsTexture);
        settings.setSize(settingsBg.getWidth() / 1.85f, settingsBg.getHeight() / 4.3f);
        settings.setPosition(
                settingsBg.getX() + ((settingsBg.getWidth() / 2) - settings.getWidth() / 2),
                settingsBg.getY() + (settingsBg.getHeight() - (settingsBg.getHeight() / 4))
        );

        navigationTexture = new Texture("settings/navigation-option.png");
        navigation = new Sprite(navigationTexture);
        navigation.setSize(settingsBg.getWidth() / 1.3f, settingsBg.getHeight() / 4.3f);
        navigation.setBounds(
                settingsBg.getX() + ((settingsBg.getWidth() / 2) - navigation.getWidth() / 2),
                settingsBg.getY() + (settingsBg.getHeight() - (settingsBg.getHeight() / 2)),
                navigation.getWidth(),
                navigation.getHeight()
        );

        tutorialTexture = new Texture("settings/tutorial-option.png");
        tutorial = new Sprite(tutorialTexture);
        tutorial.setSize(settingsBg.getWidth() / 1.8f, settingsBg.getHeight() / 4.3f);
        tutorial.setBounds(
                settingsBg.getX() + ((settingsBg.getWidth() / 2) - tutorial.getWidth() / 2),
                settingsBg.getY() + (settingsBg.getHeight() - (settingsBg.getHeight() / 1.3f)),
                tutorial.getWidth(),
                tutorial.getHeight()
        );

        soundsTexture = new Texture("settings/sounds-option.png");
        sounds = new Sprite(soundsTexture);
        sounds.setSize(settingsBg.getWidth() / 2, settingsBg.getHeight() / 4.3f);
        sounds.setBounds(
                settingsBg.getX() + ((settingsBg.getWidth() / 2) - sounds.getWidth() / 2),
                settingsBg.getY() + (settingsBg.getHeight() - (settingsBg.getHeight())),
                sounds.getWidth(),
                sounds.getHeight()
        );
        sounds.setAlpha(appPreferences.getSoundPreference() ? 1 : 0.5f);

        navigation1Texture = new Texture("settings/main-menu.png");
        navigation2Texture = new Texture("settings/chapters1.png");
        navigation3Texture = new Texture("settings/chapters2.png");
        tutorial1Texture = new Texture("settings/quiz1.png");
        tutorial2Texture = new Texture("settings/quiz2.png");
        tutorial3Texture = new Texture("settings/mini-games.png");
    }

    /**
     * Display thr settings menu
     * @param batch Batch
     */
    public void display(Batch batch) {
        settingsBg.draw(batch);

        if (settingsDisplay == SETTINGS_MENU) {
            settings.draw(batch);
            navigation.draw(batch);
            tutorial.draw(batch);
            sounds.draw(batch);
        }
    }

    /**
     * Dispose assets associated with settings
     */
    public void dispose() {
        blackBgSettingsTexture.dispose();
        settingsTexture.dispose();
        navigationTexture.dispose();
        tutorialTexture.dispose();
        soundsTexture.dispose();
        navigation1Texture.dispose();
        navigation2Texture.dispose();
        navigation3Texture.dispose();
        tutorial1Texture.dispose();
        tutorial2Texture.dispose();
        tutorial3Texture.dispose();
    }

    /**
     * Set touch down listener for settings
     * @param x X coordinate of touched screen
     * @param y Y coordinate of touched screen
     */
    public void touchDown(float x, float y) {
        switch (settingsDisplay) {
            case SETTINGS_MENU:
                if (navigation.getBoundingRectangle().contains(x, y)) {
                    settingsBg.setTexture(navigation1Texture);
                    settingsDisplay = NAVIGATION1;

                } else if (tutorial.getBoundingRectangle().contains(x, y)) {
                    settingsBg.setTexture(tutorial1Texture);
                    settingsDisplay = TUTORIAL1;
                } else if (sounds.getBoundingRectangle().contains(x, y)) {
                    appPreferences.setSoundPreference(!appPreferences.getSoundPreference());
                    sounds.setAlpha(appPreferences.getSoundPreference() ? 1 : 0.5f);
                }
                break;
            case NAVIGATION1:
                settingsBg.setTexture(navigation2Texture);
                settingsDisplay = NAVIGATION2;
                break;
            case NAVIGATION2:
                settingsBg.setTexture(blackBgSettingsTexture);
                settingsDisplay = SETTINGS_MENU;
                break;
            case TUTORIAL1:
                settingsBg.setTexture(tutorial2Texture);
                settingsDisplay = TUTORIAL2;
                break;
            case TUTORIAL2:
                settingsBg.setTexture(tutorial3Texture);
                settingsDisplay = TUTORIAL3;
                break;
            case TUTORIAL3:
                settingsBg.setTexture(blackBgSettingsTexture);
                settingsDisplay = SETTINGS_MENU;
                break;
        }
    }
}
