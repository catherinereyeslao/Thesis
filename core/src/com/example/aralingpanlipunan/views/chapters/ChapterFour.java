package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.android.database.DatabaseSetup;

public class ChapterFour extends ChapterCore {
    private Texture introBg, libanganBg, pangEdukasyonBg, pangKalusuganBg, pagkainBg, answerMarker,
            question1Bg, question2Bg, question3Bg;
    private Sprite ans1True, ans1False, ans2True, ans2False, ans3True, ans3False, ans4True, ans4False, ans5True, ans5False;
    private Music libanganBgS, intros, kaligtasans, libangans, pagaarals, pagkain;
    private boolean ans1TrueTouched, ans1FalseTouched, ans2TrueTouched, ans2FalseTouched, ans3TrueTouched, ans3FalseTouched, ans4TrueTouched, ans4FalseTouched, ans5TrueTouched, ans5FalseTouched = false;

    public ChapterFour(AndroidInterface androidInterface, String studentName, String password) {
        super(androidInterface, studentName, password);
    }

    public ChapterFour(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

    @Override
    public void setUp(int screenW, int screenH) {
        super.setUp(screenW, screenH);
        startOfQuestionSection = 5;
        lastChapterSection = 8;
        
        
        titleBgTexture = new Texture("titlepages/chapter4.png");
        libanganBgS = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter4/sound2/libangan1.mp3"));
        introBg = new Texture("chapters/chapter4/backgrounds/intro.png");
        libanganBg = new Texture("chapters/chapter4/backgrounds/Libangan.png");
        pangEdukasyonBg = new Texture("chapters/chapter4/backgrounds/tulong-pang-edukasyon.png");
        pangKalusuganBg = new Texture("chapters/chapter4/backgrounds/tulong-pangkalusugan.png");
        pagkainBg = new Texture("chapters/chapter4/backgrounds/tulong-pagkain.png");
       
        intros = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter4/sound2/intro1.mp3"));
        libangans  = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter4/sound2/libangan1.mp3"));
        pagaarals  = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter4/sound2/pagaaral1.mp3"));
        kaligtasans = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter4/sound2/kaligtasan1.mp3"));
        pagkain = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter4/sounds/pagkain.amr"));

      
        if (isTeacher) {
			question1Bg = new Texture(
					"chapters/chapter4/answerkeys/answer1.jpg");
			question2Bg = new Texture(
					"chapters/chapter4/answerkeys/answer2.jpg");
			question3Bg = new Texture(
					"chapters/chapter4/answerkeys/answer3.jpg");

			correctAnswers = 10;
		} else {
			question1Bg = new Texture(
					"chapters/chapter4/backgrounds/question1.jpg");
			question2Bg = new Texture(
					"chapters/chapter4/backgrounds/question2.jpg");
			question3Bg = new Texture(
					"chapters/chapter4/backgrounds/question3.jpg");
            setUpGame();
            loadNextButton();
            toggleSoundVolume();
		}
    }

    @Override
    public void display(Batch batch) {
        if (assetNeedUpdate) assetManager();
        renderSharedAssets(batch);

        if (!isTeacher && chapterSection >= startOfQuestionSection && chapterSection < lastChapterSection) {
            next.draw(batch);
        }
        switch (chapterSection) {
            case 5:
                if (!isTeacher) {
                    ans1True.draw(batch);
                    ans1False.draw(batch);
                    ans2True.draw(batch);
                    ans2False.draw(batch);
                    ans3True.draw(batch);
                    ans3False.draw(batch);
                }
                break;
            case 6:
                if (!isTeacher) {
                    ans1True.draw(batch);
                    ans1False.draw(batch);
                    ans2True.draw(batch);
                    ans2False.draw(batch);
                    ans3True.draw(batch);
                    ans3False.draw(batch);
                    ans4True.draw(batch);
                    ans4False.draw(batch);
                    ans5True.draw(batch);
                    ans5False.draw(batch);
                }
                break;
            case 7:
                if (!isTeacher) {
                    ans1True.draw(batch);
                    ans1False.draw(batch);
                    ans2True.draw(batch);
                    ans2False.draw(batch);
                }
                break;
            case 8:
                if (!isTeacher)
                    question.drawMultiLine(batch, tanong, questionX, questionY);
                startQuiz.draw(batch);
                backToChapters.draw(batch);
                break;
        }
    }

    private void assetManager() {
        float ans1Y, ans2Y, ans3Y;
        switch (chapterSection) {
            
        	case 0:
        		backgroundSprite.setTexture(introBg);
        		intros.play();
        		kaligtasans.stop();
        		break;
        	case 1:
        		backgroundSprite.setTexture(pangKalusuganBg);
        		intros.stop();
        		kaligtasans.play();
        		libangans.stop();
        		break;
        	case 2:
        		backgroundSprite.setTexture(libanganBg);
        		kaligtasans.stop();
        		libangans.play();
        		libanganBgS.play();
        		pagaarals.stop();
        		break;
        	case 3:
        		backgroundSprite.setTexture(pangEdukasyonBg);
        		libangans.stop();
        		pagaarals.play();
        		libanganBgS.stop();
        		pagkain.stop();
        		break;
        	case 4:
        		backgroundSprite.setTexture(pagkainBg);
        		pagaarals.stop();
        		pagkain.play();
        		break;
            case 5: // Start of Game
            	intros.stop();
            	kaligtasans.stop();
            	libangans.stop();
            	libanganBgS.stop();
            	pagaarals.stop();
            	pagkain.stop();
                correctAnswers = 0;
                backgroundSprite.setTexture(question1Bg);
                break;
            case 6:
                backgroundSprite.setTexture(question2Bg);
                if (!isTeacher) {
                    if (ans1TrueTouched) correctAnswers++;
                    if (ans2TrueTouched) correctAnswers++;
                    if (ans3FalseTouched) correctAnswers++;

                    ans1Y = (screenHeight / 1.22f) - (ans1True.getHeight() / 2);
                    ans1True.setAlpha(0);
                    ans1True.setY(ans1Y);
                    ans1True.setBounds(ans1True.getX(), ans1Y, ans1True.getWidth(), ans1True.getHeight());

                    ans1False.setAlpha(0);
                    ans1False.setY(ans1Y);
                    ans1False.setBounds(ans1False.getX(), ans1Y, ans1False.getWidth(), ans1False.getHeight());

                    ans2Y = (screenHeight / 1.44f) - (ans2True.getHeight() / 2);
                    ans2True.setAlpha(0);
                    ans2True.setY(ans2Y);
                    ans2True.setBounds(ans2True.getX(), ans2Y, ans2True.getWidth(), ans2True.getHeight());

                    ans2False.setAlpha(0);
                    ans2False.setY(ans2Y);
                    ans2False.setBounds(ans2False.getX(), ans2Y, ans2False.getWidth(), ans2False.getHeight());

                    ans3Y = (screenHeight / 1.75f) - (ans3True.getHeight() / 2);
                    ans3True.setAlpha(0);
                    ans3True.setY(ans3Y);
                    ans3True.setBounds(ans3True.getX(), ans3Y, ans3True.getWidth(), ans3True.getHeight());

                    ans3False.setAlpha(0);
                    ans3False.setY(ans3Y);
                    ans3False.setBounds(ans3False.getX(), ans3Y, ans3False.getWidth(), ans3False.getHeight());
                }
                break;
            case 7:
                backgroundSprite.setTexture(question3Bg);
                if (!isTeacher) {
                    if (ans1TrueTouched) correctAnswers++;
                    if (ans2TrueTouched) correctAnswers++;
                    if (ans3TrueTouched) correctAnswers++;
                    if (ans4TrueTouched) correctAnswers++;
                    if (ans5TrueTouched) correctAnswers++;

                    ans1TrueTouched = ans1FalseTouched = ans2TrueTouched = ans2FalseTouched = false;
                    ans1Y = (screenHeight / 1.28f) - (ans1True.getHeight() / 2);
                    ans1True.setAlpha(0);
                    ans1True.setY(ans1Y);
                    ans1True.setBounds(ans1True.getX(), ans1Y, ans1True.getWidth(), ans1True.getHeight());

                    ans1False.setAlpha(0);
                    ans1False.setY(ans1Y);
                    ans1False.setBounds(ans1False.getX(), ans1Y, ans1False.getWidth(), ans1False.getHeight());

                    ans2Y = (screenHeight / 1.49f) - (ans2True.getHeight() / 2);
                    ans2True.setAlpha(0);
                    ans2True.setY(ans2Y);
                    ans2True.setBounds(ans2True.getX(), ans2Y, ans2True.getWidth(), ans2True.getHeight());

                    ans2False.setAlpha(0);
                    ans2False.setY(ans2Y);
                    ans2False.setBounds(ans2False.getX(), ans2Y, ans2False.getWidth(), ans2False.getHeight());
                }
                break;
            case 8:
                if (isTeacher) {
                    correctAnswers = 10;
                } else {
                    if (ans1TrueTouched) correctAnswers++;
                    if (ans2TrueTouched) correctAnswers++;
                }
                displayQuizResult(DatabaseSetup.CHAPTER_FOUR_SCORE, 5);
                break;
        }
        assetNeedUpdate = false;
    }

    /**
     * Sets up the assets for the game/quiz
     */
    private void setUpGame() {
        answerMarker = new Texture("encircle.png");

        ans1True = new Sprite(answerMarker);
        ans1True.setSize(ans1True.getWidth() * getButtonScale(), ans1True.getHeight() * getButtonScale());
        final float ans1TrueX = (screenWidth / 2.2f) - (ans1True.getWidth() / 2);
        final float ans1TrueY = (screenHeight / 1.53f) - (ans1True.getHeight() / 2);
        ans1True.setPosition(ans1TrueX, ans1TrueY);
        ans1True.setAlpha(0);
        ans1True.setBounds(ans1TrueX, ans1TrueY, ans1True.getWidth(), ans1True.getHeight());

        ans1False = new Sprite(answerMarker);
        ans1False.setSize(ans1False.getWidth() * getButtonScale(), ans1False.getHeight() * getButtonScale());
        final float ans1FalseX = (screenWidth / 1.48f) - (ans1False.getWidth() / 2);
        ans1False.setPosition(ans1FalseX, ans1TrueY);
        ans1False.setAlpha(0);
        ans1False.setBounds(ans1FalseX, ans1TrueY, ans1False.getWidth(), ans1False.getHeight());

        ans2True = new Sprite(answerMarker);
        ans2True.setSize(ans2True.getWidth() * getButtonScale(), ans2True.getHeight() * getButtonScale());
        final float ans2TrueY = (screenHeight / 2.1f) - (ans1True.getHeight() / 2);
        ans2True.setPosition(ans1TrueX, ans2TrueY);
        ans2True.setAlpha(0);
        ans2True.setBounds(ans1TrueX, ans2TrueY, ans2True.getWidth(), ans2True.getHeight());

        ans2False = new Sprite(answerMarker);
        ans2False.setSize(ans2False.getWidth() * getButtonScale(), ans2False.getHeight() * getButtonScale());
        ans2False.setPosition(ans1FalseX, ans2TrueY);
        ans2False.setAlpha(0);
        ans2False.setBounds(ans1FalseX, ans2TrueY, ans2False.getWidth(), ans2False.getHeight());

        ans3True = new Sprite(answerMarker);
        ans3True.setSize(ans3True.getWidth() * getButtonScale(), ans3True.getHeight() * getButtonScale());
        final float ans3TrueY = (screenHeight / 3.2f) - (ans1True.getHeight() / 2);
        ans3True.setAlpha(0);
        ans3True.setPosition(ans1TrueX, ans3TrueY);
        ans3True.setBounds(ans1TrueX, ans3TrueY, ans3True.getWidth(), ans3True.getHeight());

        ans3False = new Sprite(answerMarker);
        ans3False.setSize(ans3False.getWidth() * getButtonScale(), ans3False.getHeight() * getButtonScale());
        ans3False.setAlpha(0);
        ans3False.setPosition(ans1FalseX, ans3TrueY);
        ans3False.setBounds(ans1FalseX, ans3TrueY, ans3False.getWidth(), ans3False.getHeight());

        ans4True = new Sprite(answerMarker);
        ans4True.setSize(ans4True.getWidth() * getButtonScale(), ans4True.getHeight() * getButtonScale());
        final float ans4TrueY = (screenHeight / 2.39f) - (ans1True.getHeight() / 2);
        ans4True.setAlpha(0);
        ans4True.setPosition(ans1TrueX, ans4TrueY);
        ans4True.setBounds(ans1TrueX, ans4TrueY, ans4True.getWidth(), ans4True.getHeight());

        ans4False = new Sprite(answerMarker);
        ans4False.setSize(ans4False.getWidth() * getButtonScale(), ans4False.getHeight() * getButtonScale());
        ans4False.setAlpha(0);
        ans4False.setPosition(ans1FalseX, ans4TrueY);
        ans4False.setBounds(ans1FalseX, ans4TrueY, ans4False.getWidth(), ans4False.getHeight());

        ans5True = new Sprite(answerMarker);
        ans5True.setSize(ans5True.getWidth() * getButtonScale(), ans5True.getHeight() * getButtonScale());
        final float ans5TrueY = (screenHeight / 3.43f) - (ans1True.getHeight() / 2);
        ans5True.setAlpha(0);
        ans5True.setPosition(ans1TrueX, ans5TrueY);
        ans5True.setBounds(ans1TrueX, ans5TrueY, ans5True.getWidth(), ans5True.getHeight());

        ans5False = new Sprite(answerMarker);
        ans5False.setSize(ans5False.getWidth() * getButtonScale(), ans5False.getHeight() * getButtonScale());
        ans5False.setAlpha(0);
        ans5False.setPosition(ans1FalseX, ans5TrueY);
        ans5False.setBounds(ans1FalseX, ans5TrueY, ans5False.getWidth(), ans5False.getHeight());

        loadNextButton();
    }

    @Override
    public int touchDown(float x, float y) {
        if (chapterSection >= startOfQuestionSection) {
        	if(!isTeacher) {
                if (ans1True.getBoundingRectangle().contains(x, y)) {
                    ans1TrueTouched = !ans1TrueTouched;
                    if (ans1TrueTouched) {
                        ans1True.setAlpha(1);
                        ans1False.setAlpha(0);
                        ans1FalseTouched = false;
                    } else
                        ans1True.setAlpha(0);
                }
                if (ans1False.getBoundingRectangle().contains(x, y)) {
                    ans1FalseTouched = !ans1FalseTouched;
                    if (ans1FalseTouched) {
                        ans1False.setAlpha(1);
                        ans1True.setAlpha(0);
                        ans1TrueTouched = false;
                    } else
                        ans1False.setAlpha(0);
                }
                if (ans2True.getBoundingRectangle().contains(x, y)) {
                    ans2TrueTouched = !ans2TrueTouched;
                    if (ans2TrueTouched) {
                        ans2True.setAlpha(1);
                        ans2False.setAlpha(0);
                        ans2FalseTouched = false;
                    } else
                        ans2True.setAlpha(0);
                }
                if (ans2False.getBoundingRectangle().contains(x, y)) {
                    ans2FalseTouched = !ans2FalseTouched;
                    if (ans2FalseTouched) {
                        ans2False.setAlpha(1);
                        ans2True.setAlpha(0);
                        ans2TrueTouched = false;
                    } else
                        ans2False.setAlpha(0);
                }
                if (ans3True.getBoundingRectangle().contains(x, y) && chapterSection < 12) {
                    ans3TrueTouched = !ans3TrueTouched;
                    if (ans3TrueTouched) {
                        ans3True.setAlpha(1);
                        ans3False.setAlpha(0);
                        ans3FalseTouched = false;
                    } else
                        ans3True.setAlpha(0);
                }
                if (ans3False.getBoundingRectangle().contains(x, y) && chapterSection < 12) {
                    ans3FalseTouched = !ans3FalseTouched;
                    if (ans3FalseTouched) {
                        ans3False.setAlpha(1);
                        ans3True.setAlpha(0);
                        ans3TrueTouched = false;
                    } else
                        ans3False.setAlpha(0);
                }
                if (ans4True.getBoundingRectangle().contains(x, y) && chapterSection == 10) {
                    ans4TrueTouched = !ans4TrueTouched;
                    if (ans4TrueTouched) {
                        ans4True.setAlpha(1);
                        ans4False.setAlpha(0);
                        ans4FalseTouched = false;
                    } else
                        ans4True.setAlpha(0);
                }
                if (ans4False.getBoundingRectangle().contains(x, y) && chapterSection == 10) {
                    ans4FalseTouched = !ans4FalseTouched;
                    if (ans4FalseTouched) {
                        ans4False.setAlpha(1);
                        ans4True.setAlpha(0);
                        ans4TrueTouched = false;
                    } else
                        ans4False.setAlpha(0);
                }
                if (ans5True.getBoundingRectangle().contains(x, y) && chapterSection == 10) {
                    ans5TrueTouched = !ans5TrueTouched;
                    if (ans5TrueTouched) {
                        ans5True.setAlpha(1);
                        ans5False.setAlpha(0);
                        ans5FalseTouched = false;
                    } else
                        ans5True.setAlpha(0);
                }
                if (ans5False.getBoundingRectangle().contains(x, y) && chapterSection == 10) {
                    ans5FalseTouched = !ans5FalseTouched;
                    if (ans5FalseTouched) {
                        ans5False.setAlpha(1);
                        ans5True.setAlpha(0);
                        ans5TrueTouched = false;
                    } else
                        ans5False.setAlpha(0);
                }
            }
        }
        if (chapterSection == lastChapterSection)
            return displayLastSectionButtons(4, 5, x,y);
        return super.touchDown(x, y);
    }

    /**
     * Toggles volumes of all music in the chapter. This is where you should
     * set the volume to mute or max depending on how the user set their sounds
     * in the settings menu
     */
    @Override
    protected void toggleSoundVolume() {
        
        intros.setVolume(appPreferences.getSoundPreference() ? 5 : 0);
        libanganBgS.setVolume(appPreferences.getSoundPreference() ? 0.5f : 0);
        pagaarals.setVolume(appPreferences.getSoundPreference() ? 5 : 0);
        libangans.setVolume(appPreferences.getSoundPreference() ? 5 : 0);
        kaligtasans.setVolume(appPreferences.getSoundPreference() ? 5 : 0);
        pagkain.setVolume(appPreferences.getSoundPreference() ? 5 : 0);
        pagkain.setVolume(appPreferences.getSoundPreference() ? 5 : 0);
    }

    @Override
    public void dispose() {
        super.dispose();
        
        intros.stop();
        pagaarals.stop();
        libangans.stop();
        kaligtasans.stop();
        pagkain.stop();
        pagkain.stop();
        introBg.dispose();
        libanganBg.dispose();
        pagkainBg.dispose();
        pangEdukasyonBg.dispose();
        pangKalusuganBg.dispose();
        libanganBgS.dispose();
        intros.dispose();
        pagaarals.dispose();
        libangans.dispose();
        libanganBgS.stop();
        kaligtasans.dispose();
        pagkain.dispose();
        pagkain.dispose();
        question1Bg.dispose();
        question2Bg.dispose();
        question3Bg.dispose();

        // If user entered the game, dispose these loaded game assets
        if (chapterSection >= startOfQuestionSection) {
            if (!isTeacher) {
                answerMarker.dispose();
            }
            question1Bg.dispose();
            question2Bg.dispose();
            question3Bg.dispose();
        }
    }
}
