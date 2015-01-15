package com.example.aralingpanlipunan;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface AppFragment {
    /**
     * Sets up the required assets to render
     */
    public void setUp(int screenW, int screenH);

    /**
     * Use the created assets and display on screen
     */
    public void display(Batch batch);
}
