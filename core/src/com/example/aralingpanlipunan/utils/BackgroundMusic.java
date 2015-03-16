package com.example.aralingpanlipunan.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Provides control for the background music that can be
 * played throughout the entire app
 */
public class BackgroundMusic {
    private static Music backgroundMusic;

    /**
     * Play the background music. If music is over, play again
     */
    public static void playBgMusic() {
        AppPreferences appPreferences = new AppPreferences();

        if (backgroundMusic == null) {
            backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("backgrounds/bgMusic.mp3"));
            backgroundMusic.setVolume(appPreferences.getSoundPreference() ? 1 : 0);
        }

        backgroundMusic.play();
        backgroundMusic.setOnCompletionListener(new Music.OnCompletionListener() {
            @Override
            public void onCompletion(Music music) {
                music.play();
            }
        });
    }

    /**
     * Stop the background music
     */
    public static void stopBgMusic() {
        backgroundMusic.stop();
    }

    /**
     * Dispose the background music
     */
    public static void disposeBgMusic() {
        backgroundMusic.dispose();
    }

    /**
     * Determine if the background music is already playing
     * @return boolean
     */
    public static boolean isBgMUsicPlaying() {
        return backgroundMusic != null && backgroundMusic.isPlaying();
    }
}
