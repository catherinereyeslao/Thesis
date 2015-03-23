package com.example.aralingpanlipunan.views.minigames;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.example.aralingpanlipunan.utils.FourPicsOneWordUtil;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;
import com.example.aralingpanlipunan.views.AppView;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * The 4 pics 1 word game. Currently contains only 6 questions
 */
public class FourPics extends AppView {
    private Texture bayaniTexture, hanapbuhayTexture, pagdiriwangTexture, presidenteTexture, lupaTexture, tubigTexture;
    private byte questionNum;
    private ArrayList<Texture> questionPic;
    private StringBuilder typedAnswer;
    private boolean ansCorrect;
    private BitmapFont font;
    private FourPicsOneWordUtil fourPicsOneWordUtil;

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;
        ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
        fourPicsOneWordUtil = new FourPicsOneWordUtil();
        fourPicsOneWordUtil.loadAssets(screenW, screenH);

        questionNum = 0;
        typedAnswer = new StringBuilder();
        font = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        font.setScale(1.5f);
        bayaniTexture = new Texture("minigames/fourpics/bayani.png");
        hanapbuhayTexture = new Texture("minigames/fourpics/hanapbuhay.png");
        pagdiriwangTexture = new Texture("minigames/fourpics/pagdiriwang.png");
        presidenteTexture = new Texture("minigames/fourpics/presidente.png");
        lupaTexture = new Texture("minigames/fourpics/yamang-lupa.png");
        tubigTexture = new Texture("minigames/fourpics/yamang-tubig.png");

        questionPic = new ArrayList<Texture>(6);
        questionPic.add(bayaniTexture);
        questionPic.add(hanapbuhayTexture);
        questionPic.add(pagdiriwangTexture);
        questionPic.add(presidenteTexture);
        questionPic.add(lupaTexture);
        questionPic.add(tubigTexture);
        Collections.shuffle(questionPic);
    }

    @Override
    public void display(Batch batch) {
        float answerFontX = (screenWidth / 2) - (font.getBounds(typedAnswer.toString()).width / 2);
        switch (questionNum) {
            case 0:
                batch.draw(questionPic.get(0), 0, 0, screenWidth, screenHeight);
                break;
            case 1:
                batch.draw(questionPic.get(1), 0, 0, screenWidth, screenHeight);
                break;
            case 2:
                batch.draw(questionPic.get(2), 0, 0, screenWidth, screenHeight);
                break;
            case 3:
                batch.draw(questionPic.get(3), 0, 0, screenWidth, screenHeight);
                break;
            case 4:
                batch.draw(questionPic.get(4), 0, 0, screenWidth, screenHeight);
                break;
            case 5:
                batch.draw(questionPic.get(5), 0, 0, screenWidth, screenHeight);
                break;
        }
        font.draw(batch, typedAnswer.toString(), answerFontX, screenHeight / 3.6f);
        if (ansCorrect) {
            fourPicsOneWordUtil.displayCorrect(batch);
        }
    }

    @Override
    public void dispose() {
        for (Texture pic : questionPic) {
            pic.dispose();
        }
        font.dispose();
        fourPicsOneWordUtil.dispose();
    }

    /**
     * Displays android's keyboard when user touches anywhere.
     * on the screen during 4pics1word game. If user got the
     * correct answer, set touch listener to remove the correct
     * font
     */
    public void touchDown() {
        if (ansCorrect) {
            ansCorrect = false;
            typedAnswer.setLength(0);
            if (questionNum < 5)
                questionNum++;
            else
                questionNum = 0;
        }
        else
            Gdx.input.setOnscreenKeyboardVisible(true);
    }

    /**
     * Delete typed answer when user presses back space
     * @param keycode The keycode typed by user. 67 = backspace
     */
    public void keyDown(int keycode) {
        if (keycode == 67) {
            typedAnswer.setLength(0);
        }
    }

    /**
     * Listen to keyboard typing so user can enter the correct answer
     * @param character Character typed by user
     */
    public void keyTyped(char character) {
        if (!ansCorrect && character != '\b') {
            typedAnswer.append(character);
            checkAnswer();
        }
    }

    /**
     * Checks the typed answer whether it is correct or now. If correct
     * answer is typed, display a text at the center indicating that the
     * user got the correct answer. User can touch anywhere the screen to
     * move to next question
     */
    private void checkAnswer() {
        switch (questionNum) {
            case 0:
                if (typedAnswer.toString().toLowerCase().contentEquals(getImageAnswer((byte) 0))) {
                    ansCorrect = true;
                    Gdx.input.setOnscreenKeyboardVisible(false);
                }
                break;
            case 1:
                if (typedAnswer.toString().toLowerCase().contentEquals(getImageAnswer((byte) 1))) {
                    ansCorrect = true;
                    Gdx.input.setOnscreenKeyboardVisible(false);
                }
                break;
            case 2:
                if (typedAnswer.toString().toLowerCase().contentEquals(getImageAnswer((byte) 2))) {
                    ansCorrect = true;
                    Gdx.input.setOnscreenKeyboardVisible(false);
                }
                break;
            case 3:
                if (typedAnswer.toString().toLowerCase().contentEquals(getImageAnswer((byte) 3))) {
                    ansCorrect = true;
                    Gdx.input.setOnscreenKeyboardVisible(false);
                }
                break;
            case 4:
                if (typedAnswer.toString().toLowerCase().contentEquals(getImageAnswer((byte) 4))) {
                    ansCorrect = true;
                    Gdx.input.setOnscreenKeyboardVisible(false);
                }
                break;
            case 5:
                if (typedAnswer.toString().toLowerCase().contentEquals(getImageAnswer((byte) 5))) {
                    ansCorrect = true;
                    Gdx.input.setOnscreenKeyboardVisible(false);
                }
                break;
        }
    }

    /**
     * Check the correct answer for a specific questionPic index
     *
     * @param questionPicIndex The index within the questionPic ArrayList
     * @return The correct answer for the selected questionPic
     * @exception java.security.InvalidParameterException if the index entered is not
     * registered within the questionPic ArrayList
     */
    private String getImageAnswer(byte questionPicIndex) {
        Texture questionPicToValidate = questionPic.get(questionPicIndex);
        if (questionPicToValidate.equals(bayaniTexture))
            return "bayani";
        else if (questionPicToValidate.equals(hanapbuhayTexture))
            return "hanapbuhay";
        else if (questionPicToValidate.equals(pagdiriwangTexture))
            return "pagdiriwang";
        else if (questionPicToValidate.equals(presidenteTexture))
            return "presidente";
        else if (questionPicToValidate.equals(lupaTexture))
            return "yamang lupa";
        else if (questionPicToValidate.equals(tubigTexture))
            return "yamang tubig";
        else if (questionPicIndex < 0 && questionPicIndex > 5)
            throw new InvalidParameterException("The parameter you passed is most likely invalid. Choose from within the indices declared in questionPic ArrayList");
        else
            return null;
    }
}
