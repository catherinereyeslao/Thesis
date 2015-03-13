package com.example.aralingpanlipunan.views.chapters;

import android.database.sqlite.SQLiteException;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.utils.Disposable;
import com.example.aralingpanlipunan.AppFragment;
import com.example.aralingpanlipunan.Trivia;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;
import com.example.aralingpanlipunan.views.AppView;
import com.example.aralingpanlipunan.views.Help;
import com.example.aralingpanlipunan.views.StudentProfile;

import java.security.InvalidParameterException;

public abstract class ChapterCore extends AppView implements AppFragment, Disposable {
    protected AndroidInterface android;
    protected TextureAtlas girlAtlas;
    protected Animation girlAnimation;
    protected Sprite girl, balloonSprite, backgroundSprite, imageQuestion, helpSprite, soundSprite, backToChapters, startQuiz, next;
    protected String loggedInStudent, studentPassword;
    protected int chapterSection, correctAnswers = 0;
    protected int startOfQuestionSection, lastChapterSection = 10;
    protected boolean assetNeedUpdate, lectureStarted, viewingHelp, isTeacher;
    protected float animationCounter, questionX, questionY, questionWidth = 0;
    protected String tanong = "PILIIN ANG URI NG KOMUNIDAD NA MAKIKITA SA LARAWAN";
    protected Texture questionBg, retakeTexture, nextChapTexture, nextTexture, titleBgTexture;
    protected BitmapFont question;
    protected int currentRecordedScore = 0;
    private Texture helpTexture, soundTexture, startQuizTexture, backToChapterTexture, rightArrowTexture, leftArrowTexture;
    private Sprite nextSlide, prevSlide;
    private Help help;
    private Trivia trivia;
    private boolean backHelp, passedQuestionSection, tappedChapTitle;
   

    public ChapterCore(AndroidInterface androidInterface, String studentName, String password) {
        this.android = androidInterface;
        this.loggedInStudent = studentName;
        this.studentPassword = password;
    }

    public ChapterCore(AndroidInterface androidInterface, boolean isTeacher) {
        if (!isTeacher)
            throw new InvalidParameterException("2nd parameter can only be true or student name");
        this.isTeacher = true;
        this.android = androidInterface;
    }

    @Override
    public void setUp(int screenW, int screenH) {
        screenWidth = screenW;
        screenHeight = screenH;

        if (!isTeacher) {
            if (loggedInStudent == null)
                loggedInStudent = StudentProfile.getTypedName();
            if (studentPassword == null)
                studentPassword = StudentProfile.getTypedPassword();
        }

        ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
        Texture introBalloonTexture = new Texture("chapters/chapter1/balloons/intro1.png");
        helpTexture = new Texture("buttons/help.png");
        soundTexture = new Texture("buttons/sound.png");
        startQuizTexture = new Texture("buttons/quiz.png");
        backToChapterTexture = new Texture("buttons/back-to-chapters.png");
        questionBg = new Texture("backgrounds/question.jpg");
        retakeTexture = new Texture("buttons/retake.png");
        nextChapTexture = new Texture("buttons/next-chapter.png");
        rightArrowTexture = new Texture("help/next.png");
        leftArrowTexture = new Texture("help/prev.png");

        nextSlide = new Sprite(rightArrowTexture);
        nextSlide.setSize(nextSlide.getWidth() * getButtonScale() / 2, nextSlide.getHeight() * getButtonScale() / 2);
        nextSlide.setBounds(
                (screenWidth - nextSlide.getWidth()) - (nextSlide.getWidth() / 10),
                (screenHeight / 1.7f) - (nextSlide.getHeight() / 2),
                nextSlide.getWidth(),
                nextSlide.getHeight()
        );

        prevSlide = new Sprite(leftArrowTexture);
        prevSlide.setSize(nextSlide.getWidth(), nextSlide.getHeight());
        prevSlide.setBounds(
                prevSlide.getWidth() / 10,
                (screenHeight / 1.7f) - (prevSlide.getHeight() / 2),
                prevSlide.getWidth(),
                prevSlide.getHeight()
        );

        backgroundSprite = new Sprite(introBalloonTexture);
        backgroundSprite.setSize(screenW, screenH);

        girlAtlas = new TextureAtlas("characters/girl/girl.atlas");
        girlAtlas.getRegions().removeIndex(0); // Remove waved hand for now, seems ugly to have this
        girlAnimation = new Animation(0.25f, girlAtlas.getRegions());
        girl = new Sprite(girlAnimation.getKeyFrames()[0]);
        girl.setSize(girl.getWidth() * getButtonScale() * 1.1f, girl.getHeight() * getButtonScale() * 1.1f);
        final float girlX = (screenW / 6) * -1;
        final float girlY = (screenH / 2.4f) - (girl.getHeight() / 2);
        girl.setPosition(girlX, girlY);
        girl.setBounds(girlX, girlY, girl.getWidth(), girl.getHeight());

        balloonSprite = new Sprite(introBalloonTexture);
        balloonSprite.setSize(balloonSprite.getWidth() * getButtonScale() * 2.3f, balloonSprite.getHeight() * getButtonScale() * 2.3f);
        balloonSprite.setPosition((screenW / 5) + (girl.getWidth() / 2), girlY + (girl.getHeight() / 2));

        helpSprite = new Sprite(helpTexture);
        helpSprite.setSize((helpSprite.getWidth() * getButtonScale() / 1.8f), (helpSprite.getHeight() * getButtonScale() / 1.8f));
        final float helpSpriteX = (screenW / 10) - (helpSprite.getWidth() / 2);
        final float helpSpriteY = (screenH - (screenH / 10)) - (helpSprite.getHeight() / 2);
        helpSprite.setPosition(helpSpriteX, helpSpriteY);
        helpSprite.setBounds(helpSpriteX, helpSpriteY, helpSprite.getWidth(), helpSprite.getHeight());

        soundSprite = new Sprite(soundTexture);
        soundSprite.setSize(helpSprite.getWidth(), helpSprite.getHeight());
        final float soundSpriteX = helpSpriteX + soundSprite.getWidth();
        soundSprite.setPosition(soundSpriteX, helpSpriteY);
        soundSprite.setBounds(soundSpriteX, helpSpriteY, soundSprite.getWidth(), soundSprite.getHeight());

        startQuiz = new Sprite(startQuizTexture);
        startQuiz.setSize(startQuiz.getWidth() * getButtonScale(), startQuiz.getHeight() * getButtonScale());
        final float startQuizX = (screenW - (screenW / 8)) - (startQuiz.getWidth() / 2);
        final float startQuizY = (screenH / 4) - (startQuiz.getHeight() / 2);
        startQuiz.setPosition(startQuizX, startQuizY);
        startQuiz.setBounds(startQuizX, startQuizY, startQuiz.getWidth(), startQuiz.getHeight());

        backToChapters = new Sprite(backToChapterTexture);
        backToChapters.setSize(startQuiz.getWidth(), startQuiz.getHeight());
        final float backToChapY = startQuizY - (backToChapters.getHeight());
        backToChapters.setPosition(startQuizX, backToChapY);
        backToChapters.setBounds(startQuizX, backToChapY, backToChapters.getWidth(), backToChapters.getHeight());

        question = new BitmapFont(screenSizeUtil.fontAsset(screenW));
        question.setColor(1, 1, 1, 1);
        question.setScale(getQuestionFontScale());
        questionWidth = screenWidth / 1.5f;
        questionX = (screenW / 1.7f) - (question.getWrappedBounds(tanong, questionWidth).width / 2);
        questionY = (screenH - (screenH / 11)) - ((question.getMultiLineBounds(tanong).height / 2));

        // Set up the trivia if not viewed yet & display it after a random seconds (see javadoc for how many seconds)
        if (!Trivia.isDone()) {
            trivia = new Trivia();
            trivia.setUp(screenWidth, screenHeight);
            trivia.setBoySize(girl.getWidth(), girl.getHeight());
        }

        assetNeedUpdate = true;
    }

    @Override
    public void dispose() {
        rightArrowTexture.dispose();
        leftArrowTexture.dispose();
        helpTexture.dispose();
        soundTexture.dispose();
        startQuizTexture.dispose();
        backToChapterTexture.dispose();
        questionBg.dispose();
        if (trivia != null)
            trivia.dispose(); // Trivia may have been disposed after being displayed
        if (nextTexture != null)
            nextTexture.dispose(); // Only exists for some chapters in student view
    }

    /**
     * If android's back key is pressed, return 1 to Student/UserType class
     * to give a signal to go back to Chapter Select
     *
     * @param keycode the keycode of the pressed button
     * @return int
     */
    public int keyDown(int keycode) {
        // If trivia is being displayed and user pressed back button
        if (!Trivia.isDone() && keycode == 4 && trivia.isDisplayed()) {
            trivia.setDone();
            trivia.dispose();
            trivia = null;
            return 0;
        }

        if (viewingHelp) {
            if (!backHelp) {
                backHelp = true;
                return 0;
            }

            if (help.keyDown(keycode)) {
                help.dispose();
                help = null;
                viewingHelp = false;
                backHelp = false;
                return 0;
            }
            backHelp = false;
            return 0;
        }
        backHelp = false;
        return keycode == 4 ? 1 : 0;
    }

    /**
     * This method renders all shared assets across all chapters in the game.
     * Put this in the chapter's draw method to put the animating girl and balloon
     * @param batch Batch
     */
    protected void renderSharedAssets(Batch batch) {
        if (titleBgTexture != null && !tappedChapTitle) {
            // Display chapter title if it exists
            batch.draw(titleBgTexture, 0, 0, screenWidth, screenHeight);
        } else {
            if (viewingHelp) {
                help.display(batch);
            } else {
                backgroundSprite.draw(batch);
                if (girl.getX() < (screenWidth / 5) - (girl.getWidth() / 2)) {
                    girl.setX(girl.getX() + 5);
                } else if (chapterSection < startOfQuestionSection) {
                    lectureStarted = true;
                    // Only animate girl & display balloon if trivia is not displayed
                    if (trivia == null || !trivia.isDisplayed()) {
                        animationCounter += Gdx.graphics.getDeltaTime();
                        //balloonSprite.draw(batch);
                    }
                    girl.setRegion(girlAnimation.getKeyFrame(animationCounter, true));
                }

                if (chapterSection < startOfQuestionSection) {
                    girl.draw(batch);
                    helpSprite.draw(batch);
                    soundSprite.draw(batch);
                }

                if (isTeacher || !passedQuestionSection) {
                    nextSlide.draw(batch);
                    prevSlide.draw(batch);
                }

                if (chapterSection < startOfQuestionSection) {
                    startQuiz.draw(batch);

                    if (chapterSection == startOfQuestionSection - 1)
                        backToChapters.draw(batch);
                }

                if (trivia != null)
                    trivia.display(batch);
            }
        }
    }

    public int touchDown(float x, float y) {
        // If chapter title is displayed and user tapped anywhere
        if (titleBgTexture != null && !tappedChapTitle) {
            tappedChapTitle = true;
            titleBgTexture.dispose();
            titleBgTexture = null;
        }

        if (viewingHelp) {
            help.touchDown(x, y);
        } else {
            // If trivia is displayed and user touched anywhere on screen
            if (!Trivia.isDone() && trivia.isDisplayed()) {
                trivia.setDone();
                trivia.dispose();
                trivia = null;
                return 100;
            }

            chapterLectureNavigator(x, y);

            // If user is viewing chapter lecture
            if (chapterSection < startOfQuestionSection) {
                if (startQuiz.getBoundingRectangle().contains(x, y)) {
                    chapterSection = startOfQuestionSection;
                    assetNeedUpdate = true;
                    passedQuestionSection = true;
                }
                if (backToChapters.getBoundingRectangle().contains(x, y))
                    return 500;
            }

            // If user touches the next button, which exists only in student view in chapter quiz
            if (!isTeacher && next != null && chapterSection >= startOfQuestionSection && chapterSection < lastChapterSection && next.getBoundingRectangle().contains(x, y)) {
                chapterSection++;
                assetNeedUpdate = true;
            }

            // If user touched the question mark icon, open help
            if (helpSprite.getBoundingRectangle().contains(x, y)) {
                help = new Help();
                help.setUp(screenWidth, screenHeight);
                viewingHelp = true;
            }
        }

        return 100;
    }

    /**
     * Set the listener for left & right arrows
     * @param x X coordinate of touched screen
     * @param y Y coordinate of touched screen
     */
    private void chapterLectureNavigator(float x, float y) {
        if (isTeacher && passedQuestionSection) {
            if (chapterSection > startOfQuestionSection && prevSlide.getBoundingRectangle().contains(x, y)) {
                chapterSection--;
                assetNeedUpdate = true;
            } else if (chapterSection < lastChapterSection && nextSlide.getBoundingRectangle().contains(x, y)) {
                chapterSection++;
                assetNeedUpdate = true;
            }
        } else if (!passedQuestionSection && lectureStarted) {
            if (chapterSection < startOfQuestionSection - 1 && nextSlide.getBoundingRectangle().contains(x, y)) {
                chapterSection++;
                assetNeedUpdate = true;
            } else if (chapterSection > 0 && prevSlide.getBoundingRectangle().contains(x, y)) {
                chapterSection--;
                assetNeedUpdate = true;
            }
        }
    }

    /**
     * If achieved score is higher than currently recorded chapter 1 score, then update
     * the student's score record.
     * @param chapter String The name of the database table to update the chapter record after the game
     */
    protected void saveProgress(String chapter) {
        if (correctAnswers > currentRecordedScore) {
            try {
                android.setStudentScore(loggedInStudent, studentPassword, chapter, correctAnswers);
                android.showToast("Your progress has been saved", 1);
            } catch (SQLiteException e) {
                android.showToast("Failed to save data", 1);
            }
        }
    }

    /**
     * Display the result of the test
     * @param chapterFieldToUpdate The Database Chapter field to save the data to
     * @param passingScore The passing score
     */
    protected void displayQuizResult(String chapterFieldToUpdate, int passingScore) {
        backgroundSprite.setTexture(questionBg);
        tanong = correctAnswers >= passingScore ? "CONGRATULATIONS!\n You're Passed!\nScore: " + correctAnswers : "YOU'RE FAILED!\nScore: " + correctAnswers;
        backToChapters.setPosition(
                screenWidth - (screenWidth / 6) - startQuiz.getWidth() / 2,
                screenHeight / 4.2f
        );
        // If student fails the test
        if (correctAnswers < passingScore) {
            startQuiz.setTexture(retakeTexture);
        } else {
            startQuiz.setTexture(nextChapTexture);
        }
        startQuiz.setPosition(backToChapters.getX(), backToChapters.getY() + startQuiz.getHeight());
        backToChapters.setSize(startQuiz.getWidth(), startQuiz.getHeight());
        if (!isTeacher) saveProgress(chapterFieldToUpdate);
    }

    /**
     * Set touch listeners for the last 2 buttons at the end of the quiz. User will be able to retake the quiz
     * if they failed. If passed, they'll have the option to take the next chapter
     * @param currentChapNum int Current Chapter number
     * @param x float The x coordinate of touched screen
     * @param y float The y coordinate of touched screen
     * @return int
     */
    protected int displayLastSectionButtons(int currentChapNum, int passingScore, float x, float y) {
        // If failed, we give student the option to retake quiz or back to chapters
        if (correctAnswers < passingScore) {
            if (startQuiz.getBoundingRectangle().contains(x, y)) {
                questionY = (screenHeight - (screenHeight / 11)) - ((question.getMultiLineBounds(tanong).height / 2));
                chapterSection = startOfQuestionSection;
                correctAnswers = 0;
                assetNeedUpdate = true;
                question.setScale(getQuestionFontScale() + 0.4f);
                tanong = "PILIIN ANG URI NG KOMUNIDAD NA MAKIKITA SA LARAWAN";
            }
            else if (backToChapters.getBoundingRectangle().contains(x, y))
                return 500;
        } else if (!this.getClass().getName().equals(ChapterNineteen.class.getName())) {
            if (startQuiz.getBoundingRectangle().contains(x, y)) {
                return currentChapNum + 501;
            }
        }
        if (backToChapters.getBoundingRectangle().contains(x, y)) {
            return 500;
        }
        return 100;
    }

    protected float getQuestionFontScale() {
        ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
        switch (screenSizeUtil.getScreenCategory(screenWidth)) {
            case ScreenSizeUtil.LDPI:
                return 1.4f;
            case ScreenSizeUtil.MDPI:
                return 1.8f;
            case ScreenSizeUtil.HDPI:
                return 2;
            case ScreenSizeUtil.XHDPI:
                return 2.2f;
            default:
                return 2.2f;
        }
    }

    /**
     * Loads the next/enter button which will be located in
     * lower right screen when taking the chapter quiz/game
     * Make sure to call next.draw(batch) in the display method
     * during the quiz/game section
     */
    protected void loadNextButton() {
        nextTexture = new Texture("buttons/enter.png");
        next = new Sprite(nextTexture);
        next.setSize(next.getWidth() * getButtonScale(), next.getHeight() * getButtonScale());
        final float nextX = (screenWidth / 1.4f);
        final float nextY = next.getHeight() / 10;
        next.setPosition(nextX, nextY);
        next.setBounds(nextX, nextY, next.getWidth(), next.getHeight());
    }

    /**
     * Displays the Quiz result, next chapter button or
     * retake quiz button & back to chapters button.
     * Will also contain a text to indicate pass or fail,
     * and the score is displayed below.
     * @param batch Batch
     */
    protected void drawQuizResult(Batch batch) {
        if (chapterSection == lastChapterSection) {
            if (!isTeacher) question.drawMultiLine(batch, tanong, questionX, questionY);
            if (!this.getClass().getName().equals(ChapterNineteen.class.getName()))
                startQuiz.draw(batch);
            backToChapters.draw(batch);
        }
    }
}
