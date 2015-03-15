package com.example.aralingpanlipunan.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Contains utility methods for retrieving and toggling saved preferences for the app
 */
public class AppPreferences {
    private static final String APP_PREFERENCE_NAME = "AralingPanlipunanPrefs";
    private static final String SOUND_PREFERENCE = "soundPrefs";
    private Preferences appPrefs;

    public AppPreferences() {
        appPrefs = Gdx.app.getPreferences(APP_PREFERENCE_NAME);
    }

    /**
     * Trigger the sound on / off
     * @param preference true to activate sounds. false to mute
     */
    public void setSoundPreference(boolean preference) {
        appPrefs.putBoolean(SOUND_PREFERENCE, preference).flush();
    }

    /**
     * Retrieve the preferences for sound
     * @return true if user set the sounds activated. false if muted
     */
    public boolean getSoundPreference() {
        return appPrefs.getBoolean(SOUND_PREFERENCE, true);
    }
}
