package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.utils.FourPicsOneWordUtil;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;

import static com.example.aralingpanlipunan.android.database.DatabaseSetup.CHAPTER_ONE_SCORE;

public class ChapterOne extends ChapterCore {
    private Texture introBg, baybayinBg, kabukirinBg, kabundukanBg, lungsodBg, intro1balloonTexture, intro2balloonTexture, startQuizTexture, answer1Texture, answer2Texture, answer3Texture, answer4Texture, question1Texture, question2Texture, question3Texture, question4Texture;
    private Music bgMusic, baybayinBGs, lungsodBGs, bukidBGs, kabundukanBGs, intros, baybayins, bukids, bundoks, lungsods;/*baybayin1sound, baybayin2sound, baybayin3sound, bukid1sound, bukid2sound, intro1sound, intro2sound, lungsod1sound, lungsod2sound;*/
    private BitmapFont studentAnswer;
    private StringBuilder typedAnswer;
    private FourPicsOneWordUtil fourPicsOneWordUtil;
    private float ansX, ansY;
    private boolean ansCorrect;

    public ChapterOne(AndroidInterface androidInterface, String studentName, String password) {
        super(androidInterface, studentName, password);
    }

    public ChapterOne(AndroidInterface android, boolean isTeacher) {
        super(android, isTeacher);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        screenWidth = screenW;
        screenHeight = screenH;
        startOfQuestionSection = 5;
        lastChapterSection = 9;
        fourPicsOneWordUtil = new FourPicsOneWordUtil();
        fourPicsOneWordUtil.loadAssets(screenWidth, screenHeight);

        titleBgTexture = new Texture("chapters/chapter1/backgrounds/chapter1title.png");

        // If user type is teacher, Load answer keys backgrounds & set their score to be perfect
        if (isTeacher) {
            answer1Texture = new Texture("chapters/chapter1/answerkeys/answer1.jpg");
            answer2Texture = new Texture("chapters/chapter1/answerkeys/answer2.jpg");
            answer3Texture = new Texture("chapters/chapter1/answerkeys/answer3.jpg");
            answer4Texture = new Texture("chapters/chapter1/answerkeys/answer4.jpg");
            correctAnswers = 4;
            currentRecordedScore = 5;
        } else {
            ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
            typedAnswer = new StringBuilder();
            question1Texture = new Texture("chapters/chapter1/questions/baybayin.png");
            question2Texture = new Texture("chapters/chapter1/questions/kabundukan.png");
            question3Texture = new Texture("chapters/chapter1/questions/lungsod.png");
            question4Texture = new Texture("chapters/chapter1/questions/kabukiran.png");

            studentAnswer = new BitmapFont(screenSizeUtil.fontAsset(screenWidth));
            studentAnswer.setColor(1, 1, 1, 1);
            studentAnswer.setScale(getQuestionFontScale());
            currentRecordedScore = android.getScoresByStudent(loggedInStudent, studentPassword).get(0);
        }
        bgMusic = Gdx.audio.newMusic(Gdx.files.internal("backgrounds/bgMusic.mp3"));

        /*baybayin1sound = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sounds/baybayin1.mp3"));
        baybayin2sound = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sounds/baybayin2.mp3"));
        baybayin3sound = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sounds/baybayin3.mp3"));
        bukid1sound = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sounds/bukid1.mp3"));
        bukid2sound = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sounds/bukid2.mp3"));
        intro1sound = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sounds/intro1.mp3"));
        intro2sound = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sounds/intro2.mp3"));
        lungsod1sound = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sounds/lungsod1.mp3"));
        lungsod2sound = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sounds/lungsod2.mp3"));*/

        introBg = new Texture("chapters/chapter1/backgrounds/intro.png");
        baybayinBg = new Texture("chapters/chapter1/backgrounds/baybayin.png");
        kabukirinBg = new Texture("chapters/chapter1/backgrounds/kabukirin.png");
        kabundukanBg = new Texture("chapters/chapter1/backgrounds/kabundukan.png");
        lungsodBg = new Texture("chapters/chapter1/backgrounds/lungsod.png");

        baybayinBGs = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/bgsounds/baybayinBg.mp3"));
        lungsodBGs = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/bgsounds/lungsod.mp3"));
        bukidBGs = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/bgsounds/bukid.mp3"));
        kabundukanBGs = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/bgsounds/kabundukan.mp3"));

        intros = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sound2/G_intro1.mp3"));
        baybayins = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sound2/G_baybayin1.mp3"));
        bukids = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sound2/G_bukid1.mp3"));
        lungsods = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sound2/G_lungsod1.mp3"));
        bundoks = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter1/sound2/G_bundok1.mp3"));

        startQuizTexture = new Texture("buttons/menu/start.png");
        intro1balloonTexture = new Texture("chapters/chapter1/balloons/intro1.png");

        backgroundSprite = new Sprite(introBg);
        backgroundSprite.setSize(screenWidth, screenHeight);
        balloonSprite.setTexture(intro1balloonTexture);

        intro2balloonTexture = new Texture("chapters/chapter1/balloons/intro2.png");

        loadNextButton();
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) assetManager();
        chapter1Display(batch);

        if (ansCorrect) {
            fourPicsOneWordUtil.displayCorrect(batch);
            Gdx.input.setOnscreenKeyboardVisible(false);
        }

        drawQuizResult(batch);
    }

    @Override
    public void dispose() {
        super.dispose();
        bgMusic.stop();
        intros.stop();
        baybayins.stop();
        lungsods.stop();
        bukids.stop();
        baybayins.stop();
        bundoks.stop();

        baybayinBGs.stop();
        bukidBGs.stop();
        lungsods.stop();
        bundoks.stop();

        bgMusic.dispose();
        intros.dispose();
        baybayins.dispose();
        lungsods.dispose();
        bukids.dispose();
        baybayins.dispose();
        bundoks.dispose();

        baybayinBGs.dispose();
        bukidBGs.dispose();
        lungsods.dispose();
        bundoks.dispose();

        /*baybayinBgS.stop();
        baybayin1sound.stop();
        baybayin2sound.stop();
        baybayin3sound.stop();
        intro1sound.stop();
        intro2sound.stop();
        lungsod1sound.stop();
        lungsod2sound.stop();
        bukid1sound.stop();
        bukid2sound.stop();
        baybayin1sound.dispose();
        baybayin2sound.dispose();
        baybayin3sound.dispose();
        intro1sound.dispose();
        intro2sound.dispose();
        lungsod1sound.dispose();
        lungsod2sound.dispose();
        bukid1sound.dispose();
        bukid2sound.dispose();*/
        nextChapTexture.dispose();
        /*baybayin1sound.dispose();
        baybayin2sound.dispose();
        baybayin3sound.dispose();
        intro1sound.dispose();
        intro2sound.dispose();
        lungsod1sound.dispose();
        lungsod2sound.dispose();
        bukid1sound.dispose();
        bukid2sound.dispose();*/
        introBg.dispose();
        intro1balloonTexture.dispose();
        intro2balloonTexture.dispose();
        baybayinBg.dispose();
        kabukirinBg.dispose();
        kabundukanBg.dispose();
        lungsodBg.dispose();
        startQuizTexture.dispose();
        bgMusic.dispose();
        baybayinBGs.dispose();
        fourPicsOneWordUtil.dispose();
        if (!isTeacher) {
            question1Texture.dispose();
            question2Texture.dispose();
            question3Texture.dispose();
            question4Texture.dispose();
        }
    }

    /**
     * If user finished
     * the lecture and clicked "back to chapter", 50 is returned to
     * signal to go back to chapters selection. 100 is returned to
     * do nothing. If user finished the quiz, its score is returned
     * to Student class.
     *
     * @param x The x coordinate of touched screen
     * @param y The y coordinate of touched screen
     * @return int
     */
    @Override
    public int touchDown(float x, float y) {
        if (ansCorrect) {
            chapterSection++;
            assetNeedUpdate = true;
            ansCorrect = false;
        } else {
            if (!isTeacher && chapterSection >= startOfQuestionSection && chapterSection < lastChapterSection)
                Gdx.input.setOnscreenKeyboardVisible(true);
            else if (chapterSection == lastChapterSection)
            return displayLastSectionButtons(1, 2, x, y);
        }
        return super.touchDown(x, y);
    }

        @Override
        public int keyDown(int keycode) {
            if (!isTeacher && typedAnswer.length() > 0 && keycode == 67)
                typedAnswer.setLength(typedAnswer.length() - 1);
            return super.keyDown(keycode);
        }

    public void keyPressed(char character) {
        if (!isTeacher && typedAnswer.length() < 10 && Character.isLetter(character))
            typedAnswer.append(character);
    }

    /**
     * When assetNeedUpdate is true, this will be called to update
     * properties of objects & other assets. Any tasks that are
     * not supposed to be called at all time should be placed here to
     * help improve performance
     */
    private void assetManager() {
        switch (chapterSection) {

            case 0:
                if (backgroundSprite.getTexture() != introBg)
                    backgroundSprite.setTexture(introBg);
                intros.play();
                // baybayinBGs.stop();
                baybayins.stop();
                break;
            case 1:
                backgroundSprite.setTexture(baybayinBg);
                intros.stop();
                //baybayinBGs.play();
                baybayins.play();
                bukids.stop();
                bukidBGs.stop();
                break;
            case 2:
                backgroundSprite.setTexture(kabukirinBg);

                baybayinBGs.stop();
                baybayins.stop();
                bukids.play();
                // bukidBGs.play();
                bundoks.stop();
                kabundukanBGs.stop();
                break;
            case 3:
                if (backgroundSprite.getTexture() != kabundukanBg)
                    backgroundSprite.setTexture(kabundukanBg);

                bukids.stop();
                bukidBGs.stop();
                bundoks.play();
                //kabundukanBGs.play();
                lungsodBGs.stop();
                lungsods.stop();
                break;
            case 4:
                backgroundSprite.setTexture(lungsodBg);
                bundoks.stop();
                kabundukanBGs.stop();
                //lungsodBGs.play();
                lungsods.play();
                break;
            case 5: // Start of game
                lungsodBGs.stop();
                lungsods.stop();
                baybayinBGs.stop();
                baybayins.stop();
                bukids.stop();
                bukidBGs.stop();
                bundoks.stop();
                kabundukanBGs.stop();
                intros.stop();

                question.setScale(getQuestionFontScale());
                if (isTeacher) {
                    backgroundSprite.setTexture(answer1Texture);
                } else {
                    backgroundSprite.setTexture(question1Texture);
                }
                break;
            case 6:
                if (isTeacher)
                    backgroundSprite.setTexture(answer2Texture);
                else {
                    if (typedAnswer.toString().toLowerCase().contentEquals("baybayin"))
                        correctAnswers++;
                    typedAnswer.setLength(0);
                    backgroundSprite.setTexture(question2Texture);
                }
                break;
            case 7:
                if (isTeacher)
                    backgroundSprite.setTexture(answer3Texture);
                else {
                    if (typedAnswer.toString().toLowerCase().contentEquals("kabundukan"))
                        correctAnswers++;
                    typedAnswer.setLength(0);
                    backgroundSprite.setTexture(question3Texture);
                }
                break;
            case 8:
                if (isTeacher)
                    backgroundSprite.setTexture(answer4Texture);
                else {
                    if (typedAnswer.toString().toLowerCase().contentEquals("lungsod"))
                        correctAnswers++;
                    typedAnswer.setLength(0);
                    backgroundSprite.setTexture(question4Texture);
                }
                break;
                case 9:
                    if (!isTeacher) {
                        if (typedAnswer.toString().toLowerCase().contentEquals("kabukiran"))
                            correctAnswers++;
                        typedAnswer.setLength(0);
                        saveProgress(CHAPTER_ONE_SCORE);
                    }
                    backgroundSprite.setTexture(questionBg);
                    displayQuizResult(CHAPTER_ONE_SCORE, 2);
                    break;

                }
                assetNeedUpdate = false;
        }

        /**
         * Detect if typed answer is correct
         */
    private void detectCorrectAnswer() {
        switch (chapterSection) {
            case 9:
                if (typedAnswer.toString().toLowerCase().contentEquals("baybayin")) {
                    ansCorrect = true;
                }
                break;
            case 10:
                if (typedAnswer.toString().toLowerCase().contentEquals("kabundukan")) {
                    ansCorrect = true;
                }
                break;
            case 11:
                if (typedAnswer.toString().toLowerCase().contentEquals("lungsod")) {
                    ansCorrect = true;
                }
                break;
            case 12:
                if (typedAnswer.toString().toLowerCase().contentEquals("kabukiran")) {
                    ansCorrect = true;
                }
                break;
        }
    }

    /**
     * Renders the content for Chapter 1
     * @param batch The batch of the main game
     */
    private void chapter1Display(Batch batch) {
        backgroundSprite.draw(batch);
        renderSharedAssets(batch);
    if (!isTeacher && chapterSection >= startOfQuestionSection && chapterSection < lastChapterSection) {
        next.draw(batch);

        if (chapterSection == 9) {
            detectCorrectAnswer();
            ansX = (screenWidth / 1.6f) - (studentAnswer.getBounds(typedAnswer.toString()).width / 2);
            ansY = (screenHeight / 2.9f) - (studentAnswer.getBounds(typedAnswer.toString()).height / 2);
        } else if (chapterSection > 9 && chapterSection < lastChapterSection) {
            detectCorrectAnswer();
            ansX = (screenWidth / 1.6f) - (studentAnswer.getBounds(typedAnswer.toString()).width / 2);
            ansY = (screenHeight / 2.35f) - (studentAnswer.getBounds(typedAnswer.toString()).height / 2);
        }
        studentAnswer.draw(batch, typedAnswer.toString(), ansX, ansY);
    }
}
}