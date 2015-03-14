package com.example.aralingpanlipunan.views.chapters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.android.database.DatabaseSetup;
import com.example.aralingpanlipunan.utils.ScreenSizeUtil;

public class ChapterFive extends ChapterCore {
    //TODO: still no manggagawa balloon, removed manggagawa bg
	private Texture introBg, mangangalakalBg, pagmiminaBg, pagsasakaBg, pangingisdaBg,
					introBalloon1, introBalloon2, mangangalakalBalloon1, mangangalakalBalloon2,
					pagmiminaBalloon, pagsasakaBalloon1, pagsasakaBalloon2, 
					pangingisdaBalloon1, pangingisdaBalloon2, truckTexture, minerTexture,
                    farmerTexture, fisherTexture, baybayinTexture, ibaTexture, kabukiranTexture,
                    kabundukanTexture, lungsodTexture, parkeTexture, boxTexture, nextTexture,
                    question1Bg;
	private Music intro1S,  magsasaka, mangangalakal,pagmimina, pangingisda; /*intro2S, magsasaka1S, magsasaka2S, mangangalakal1S, mangangalakal2S, pagmimina1S, 
					pangingisda1S, pangingisda2S;*/
	private Sprite truck, miner, farmer, fisher, baybayin, iba, kabukiran, kabundukan, lungsod, parke, box, box2, box3, box4, box5, touchedAnswer, next;
	private float characterX, characterY, characterSpeed, baybayinX, baybayinY, ibaX, ibaY, kabukiranX, kabukiranY, kabundukanX, kabundukanY, lungsodX, lungsodY, parkeX, parkeY;
    private boolean box1Set, box2Set, box3Set, box4Set, box5Set;

	
	public ChapterFive(AndroidInterface androidInterface, String studName, String password) {
		super(androidInterface, studName, password);
	}

    public ChapterFive(AndroidInterface androidInterface, boolean isTeacher) {
        super(androidInterface, isTeacher);
    }

	@Override
	public void setUp(int screenW, int screenH){
		super.setUp(screenW, screenH);
		startOfQuestionSection = 9;
		lastChapterSection = 10;
        characterSpeed = getCharacterVelocityByScreen();
        boxTexture = new Texture("box.png");

        titleBgTexture = new Texture("chapters/chapter1/backgrounds/chapter1title.png");
        
        
        if (isTeacher) {
			question1Bg = new Texture("chapters/chapter5/answers/answer.jpg");

		} else {
			question1Bg = new Texture("chapters/chapter5/backgrounds/question.jpg");

            baybayinTexture = new Texture("chapters/chapter5/answers/baybayin.png");
            baybayin = new Sprite(baybayinTexture);
            baybayin.setSize(getAnswerWidth(baybayin), getAnswerHeight(baybayin));
            baybayinX = (screenWidth / 2.8f) - (baybayin.getWidth() / 2);
            baybayinY = (screenHeight / 1.45f) - (baybayin.getHeight() / 2);
            baybayin.setPosition(baybayinX, baybayinY);
            baybayin.setBounds(baybayinX, baybayinY, baybayin.getWidth(), baybayin.getHeight());

            ibaTexture = new Texture("chapters/chapter5/answers/iba.png");
            iba = new Sprite(ibaTexture);
            iba.setSize(getAnswerWidth(iba), getAnswerHeight(iba));
            ibaX = (screenWidth / 1.85f) - (iba.getWidth() / 2);
            ibaY = baybayinY;
            iba.setPosition(ibaX, ibaY);
            iba.setBounds(ibaX, ibaY, iba.getWidth(), iba.getHeight());

            kabukiranTexture = new Texture("chapters/chapter5/answers/kabukiran.png");
            kabukiran = new Sprite(kabukiranTexture);
            kabukiran.setSize(getAnswerWidth(kabukiran), getAnswerHeight(kabukiran));
            kabukiranX = (screenWidth / 1.4f) - (kabukiran.getWidth() / 2);
            kabukiranY = baybayinY;
            kabukiran.setPosition(kabukiranX, kabukiranY);
            kabukiran.setBounds(kabukiranX, kabukiranY, kabukiran.getWidth(), kabukiran.getHeight());

            kabundukanTexture = new Texture("chapters/chapter5/answers/kabundukan.png");
            kabundukan = new Sprite(kabundukanTexture);
            kabundukan.setSize(getAnswerWidth(kabundukan), getAnswerHeight(kabundukan));
            kabundukanX = (screenWidth / 1.15f) - (kabundukan.getWidth() / 2);
            kabundukanY = baybayinY;
            kabundukan.setPosition(kabundukanX, kabundukanY);
            kabundukan.setBounds(kabundukanX, kabukiranY, kabundukan.getWidth(), kabundukan.getHeight());

            lungsodTexture = new Texture("chapters/chapter5/answers/lungsod.png");
            lungsod = new Sprite(lungsodTexture);
            lungsod.setSize(getAnswerWidth(lungsod), getAnswerHeight(lungsod));
            lungsodX = baybayinX;
            lungsodY = (screenHeight / 1.65f) - (lungsod.getHeight() / 2);
            lungsod.setPosition(lungsodX, lungsodY);
            lungsod.setBounds(lungsodX, lungsodY, lungsod.getWidth(), lungsod.getHeight());

            parkeTexture = new Texture("chapters/chapter5/answers/parke.png");
            parke = new Sprite(parkeTexture);
            parke.setSize(getAnswerWidth(parke), getAnswerHeight(parke));
            parkeX = ibaX;
            parkeY = lungsodY;
            parke.setPosition(parkeX, parkeY);
            parke.setBounds(parkeX, parkeY, parke.getWidth(), parke.getHeight());

            backgroundSprite.setTexture(introBg);
            balloonSprite.setTexture(introBalloon1);

            boxTexture = new Texture("box.png");
            box = new Sprite(boxTexture);
            box.setSize(iba.getWidth(), iba.getHeight());
            final float boxX = (screenWidth / 1.25f) - (box.getWidth() / 2);
            final float boxY = (screenHeight / 2.15f) - (box.getHeight() / 2);
            box.setPosition(boxX, boxY);
            box.setBounds(boxX, boxY, box.getWidth(), box.getHeight());

            box2 = new Sprite(boxTexture);
            box2.setSize(iba.getWidth(), iba.getHeight());
            final float box2Y = (screenHeight / 2.45f) - (box2.getHeight() / 2);
            box2.setPosition(boxX, box2Y);
            box2.setBounds(boxX, box2Y, box2.getWidth(), box2.getHeight());

            box3 = new Sprite(boxTexture);
            box3.setSize(iba.getWidth(), iba.getHeight());
            final float box3Y = (screenHeight / 2.8f) - (box3.getHeight() / 2);
            box3.setPosition(boxX, box3Y);
            box3.setBounds(boxX, box3Y, box3.getWidth(), box3.getHeight());

            box4 = new Sprite(boxTexture);
            box4.setSize(iba.getWidth(), iba.getHeight());
            final float box4Y = (screenHeight / 3.3f) - (box4.getHeight() / 2);
            box4.setPosition(boxX, box4Y);
            box4.setBounds(boxX, box4Y, box4.getWidth(), box4.getHeight());

            box5 = new Sprite(boxTexture);
            box5.setSize(iba.getWidth(), iba.getHeight());
            final float box5Y = (screenHeight / 3.95f) - (box5.getHeight() / 2);
            box5.setPosition(boxX, box5Y);
            box5.setBounds(boxX, box5Y, box5.getWidth(), box5.getHeight());

            nextTexture = new Texture("buttons/enter.png");
            next = new Sprite(nextTexture);
            next.setSize(next.getWidth() * getButtonScale(), next.getHeight() * getButtonScale());
            final float nextX = (screenWidth / 1.4f);
            final float nextY = next.getHeight() / 10;
            next.setPosition(nextX, nextY);
            next.setBounds(nextX, nextY, next.getWidth(), next.getHeight());
		}
        //sounds
        intro1S = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter5/sound2/intro1chap5.mp3"));
        magsasaka = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter5/sound2/magsasaka1.mp3"));
        mangangalakal = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter5/sound2/mangangalakal1.mp3"));
        pangingisda = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter5/sound2/pangingisada1.mp3"));
        pagmimina = Gdx.audio.newMusic(Gdx.files.internal("chapters/chapter5/sounds/pagmimina.m4a"));
		
		//backgrounds
		introBg = new Texture("chapters/chapter5/backgrounds/IntroForChapter5.png");
		mangangalakalBg = new Texture("chapters/chapter5/backgrounds/Mangagalakal.png");
		pagmiminaBg = new Texture("chapters/chapter5/backgrounds/Pagmimina.png");
		pagsasakaBg = new Texture("chapters/chapter5/backgrounds/Pagsasaka.png");
		pangingisdaBg = new Texture("chapters/chapter5/backgrounds/Pangingisda.png");
		
		//balloons
//		introBalloon1 = new Texture("chapters/chapter5/balloons/Intro1.png");
//		introBalloon2 = new Texture("chapters/chapter5/balloons/Intro2.png");
//		mangangalakalBalloon1 = new Texture("chapters/chapter5/balloons/Mangangalakal1.png");
//		mangangalakalBalloon2 = new Texture("chapters/chapter5/balloons/Mangangalakal2.png");
//		pagmiminaBalloon = new Texture("chapters/chapter5/balloons/Pagmimina.png");
//		pagsasakaBalloon1 = new Texture("chapters/chapter5/balloons/Magsasaka1.png");
//		pagsasakaBalloon2 = new Texture("chapters/chapter5/balloons/Magsasaka2.png");
//		pangingisdaBalloon1 = new Texture("chapters/chapter5/balloons/Pangingisda1.png");
//		pangingisdaBalloon2 = new Texture("chapters/chapter5/balloons/Pangingisda2.png");

        truckTexture = new Texture("chapters/chapter5/characters/truck.png");
        truck = new Sprite(truckTexture);
        truck.setSize((truck.getWidth() * getButtonScale() * 1.3f), (truck.getHeight() * getButtonScale()) * 1.3f);

        minerTexture = new Texture("chapters/chapter5/characters/miner.png");
        miner = new Sprite(minerTexture);
        miner.setSize(miner.getWidth() * getButtonScale() * 1.3f, miner.getHeight() * getButtonScale() * 1.3f);

        farmerTexture = new Texture("chapters/chapter5/characters/farmer.png");
        farmer = new Sprite(farmerTexture);
        farmer.setSize(farmer.getWidth() * getButtonScale(), farmer.getHeight() * getButtonScale());

        fisherTexture = new Texture("chapters/chapter5/characters/fisher.png");
        fisher = new Sprite(fisherTexture);
        fisher.setSize(fisher.getWidth() * getButtonScale() * 1.2f, fisher.getHeight() * getButtonScale() * 1.2f);

        characterX = truck.getWidth() * -1.25f; // Start truck from outer left portion of screen
        characterY = (screenHeight / 3) - (truck.getHeight() / 2);
	}

	@Override
	public void display(Batch batch){
		if (assetNeedUpdate) assetManager();
		renderSharedAssets(batch);

		switch (chapterSection) {
			case 2:
				drawMovingTruck(batch);
				break;
			case 3:
				drawMovingTruck(batch);
				break;
			case 4:
				drawMiner(batch);
				break;
            case 5:
                drawFarmer(batch);
                break;
            case 6:
                drawFarmer(batch);
                break;
            case 7:
                fisher.draw(batch);
                break;
            case 8:
                fisher.draw(batch);
                break;
            case 9:
                if (!isTeacher) {
                    box.draw(batch);
                    box2.draw(batch);
                    box3.draw(batch);
                    box4.draw(batch);
                    box5.draw(batch);
                    next.draw(batch);
                    baybayin.draw(batch);
                    iba.draw(batch);
                    kabukiran.draw(batch);
                    kabundukan.draw(batch);
                    lungsod.draw(batch);
                    parke.draw(batch);
                }
                break;
            case 10:
                if (!isTeacher) question.drawMultiLine(batch, tanong, questionX, questionY);
                startQuiz.draw(batch);
                backToChapters.draw(batch);
                break;
		}

		// Make sure no other characters are blocking the talkative girl and balloon
		if (chapterSection > 1 && chapterSection < startOfQuestionSection) {
			girl.draw(batch);
			balloonSprite.draw(batch);
		}
	}

    private void assetManager() {
		switch (chapterSection) {
		case 0:
			backgroundSprite.setTexture(introBg);
			intro1S.play();
			mangangalakal.stop();
			break;
		case 2:
			backgroundSprite.setTexture(mangangalakalBg);
			intro1S.stop();
			mangangalakal.play();
			pagmimina.stop();
			break;
		case 4:
			backgroundSprite.setTexture(pagmiminaBg);
			
			characterX = miner.getWidth() * -1.15f;
			characterY = 0;
			mangangalakal.stop();
			pagmimina.play();
			magsasaka.stop();
			break;
		case 5:
			backgroundSprite.setTexture(pagsasakaBg);
			characterX = farmer.getWidth() * -1.15f;
			characterY = (screenHeight / 2) - (farmer.getHeight());
			pagmimina.stop();
			magsasaka.play();
			pangingisda.stop();
			break;
		
		case 7:
			backgroundSprite.setTexture(pangingisdaBg);
			magsasaka.stop();
			pangingisda.play();
            characterX = (screenWidth / 2) - (fisher.getWidth() / 2);
            characterY = (screenHeight / 4) - (fisher.getHeight() / 2);
            fisher.setPosition(characterX, characterY);
           
			break;
		//game
		case 9:
			intro1S.stop();
			mangangalakal.stop();
			pagmimina.stop();
			magsasaka.stop();
			pangingisda.stop();
			
            if (isTeacher) {
                backgroundSprite.setTexture(question1Bg);
            } else {
                baybayin.setPosition(baybayinX, baybayinY);
                iba.setPosition(ibaX, ibaY);
                kabukiran.setPosition(kabukiranX, kabukiranY);
                kabundukan.setPosition(kabundukanX, kabundukanY);
                lungsod.setPosition(lungsodX, lungsodY);
                parke.setPosition(parkeX, parkeY);
                backgroundSprite.setTexture(question1Bg);
            }
           

			break;
        case 10:
            if (isTeacher) correctAnswers = 5;
            displayQuizResult(DatabaseSetup.CHAPTER_FIVE_SCORE, 3);
            break;
		}
		assetNeedUpdate = false;
	}

    @Override
    public int touchDown(float x, float y) {
    	if (soundSprite.getBoundingRectangle().contains(x, y)) {
            playSoundForSection();
        }
        if (chapterSection == lastChapterSection)
            return displayLastSectionButtons(5, 3, x, y);

        if(!isTeacher){
        if (next.getBoundingRectangle().contains(x, y)) {
            // If next button is clicked, check the position of answers and count
            // correct answers, then proceed to score page
            if (kabukiran.getY() == box.getY())
                correctAnswers++;
            if (baybayin.getY() == box2.getY())
                correctAnswers++;
            if (kabundukan.getY() == box3.getY())
                correctAnswers++;
            if (lungsod.getY() == box4.getY())
                correctAnswers++;
            if (iba.getY() == box5.getY())
                correctAnswers++;

            chapterSection++;
            assetNeedUpdate = true;
        }
        if (touchedAnswer == null) {
            if (baybayin.getBoundingRectangle().contains(x, y)) {
                touchedAnswer = baybayin;
                baybayin.setPosition(baybayinX, baybayinY);
            }
            if (iba.getBoundingRectangle().contains(x, y)) {
                touchedAnswer = iba;
                iba.setPosition(ibaX, ibaY);
            }
            if (kabukiran.getBoundingRectangle().contains(x, y)) {
                touchedAnswer = kabukiran;
                kabukiran.setPosition(kabukiranX, kabukiranY);
            }
            if (kabundukan.getBoundingRectangle().contains(x, y)) {
                touchedAnswer = kabundukan;
                kabundukan.setPosition(kabundukanX, kabundukanY);
            }
            if (lungsod.getBoundingRectangle().contains(x, y)) {
                touchedAnswer = lungsod;
                lungsod.setPosition(lungsodX, lungsodY);
            }
            if (parke.getBoundingRectangle().contains(x, y)) {
                touchedAnswer = parke;
                parke.setPosition(parkeX, parkeY);
            }
            if (box.getBoundingRectangle().contains(x, y))
                box1Set = false;
            if (box2.getBoundingRectangle().contains(x, y))
                box2Set = false;
            if (box3.getBoundingRectangle().contains(x, y))
                box3Set = false;
            if (box4.getBoundingRectangle().contains(x, y))
                box4Set = false;
            if (box5.getBoundingRectangle().contains(x, y))
                box5Set = false;
        } else {
            if (box.getBoundingRectangle().contains(x, y) && !box1Set) {
                touchedAnswer.setPosition(box.getX(), box.getY());
                box1Set = true;
            }
            else if (box2.getBoundingRectangle().contains(x, y) && !box2Set) {
                touchedAnswer.setPosition(box2.getX(), box2.getY());
                box2Set = true;
            }
            else if (box3.getBoundingRectangle().contains(x, y) && !box3Set) {
                touchedAnswer.setPosition(box3.getX(), box3.getY());
                box3Set = true;
            }
            else if (box4.getBoundingRectangle().contains(x, y) && !box4Set) {
                touchedAnswer.setPosition(box4.getX(), box4.getY());
                box4Set = true;
            }
            else if (box5.getBoundingRectangle().contains(x, y) && !box5Set) {
                touchedAnswer.setPosition(box5.getX(), box5.getY());
                box5Set = true;
            }
            touchedAnswer = null;
        }
        }
        return super.touchDown(x, y);
    }

	private void playSoundForSection() {
		// TODO Auto-generated method stub
	    	/* switch (chapterSection) {
	         case 0:
	             intro1S.stop();
	             intro1S.play();
	             break;
	         case 1:
	        	
	        	 intro2S.stop();
	        	 intro2S.play();
	        	 break;
	         case 2:
	        	 mangangalakal1S.stop();
	        	 mangangalakal1S.play();
	        	 break;
	         case 3:
	        	 mangangalakal2S.stop();
	        	 mangangalakal2S.play();
	        	 break;
	         case 4:
	        	 pagmimina1S.stop();
	        	 pagmimina1S.play();
	        	 break;
	         case 5:
	        	 magsasaka1S.stop();
	        	 magsasaka1S.play();
	        	 break;
	         case 6:
	        	 magsasaka2S.stop();
	        	 magsasaka2S.play();
	        	 break;
	         case 7:
	        	 pangingisda1S.stop();
	        	 pangingisda1S.play();
	        	 break;
	         case 8:
	        	 pangingisda2S.stop();
	        	 pangingisda2S.play();
	        	 break;
	         
	    	 }*/
	}

	@Override
	public void dispose(){
		super.dispose();
		intro1S.stop();
		magsasaka.stop();
		pagmimina.stop();
		pangingisda.stop();
		mangangalakal.stop();
		intro1S.dispose();
		magsasaka.dispose();
		pagmimina.dispose();
		pangingisda.dispose();
		mangangalakal.dispose();
		
		introBg.dispose();
		mangangalakalBg.dispose();
		pagmiminaBg.dispose();
		pagsasakaBg.dispose();
		pangingisdaBg.dispose();
		introBalloon1.dispose();
		introBalloon2.dispose();
		mangangalakalBalloon1.dispose();
		mangangalakalBalloon2.dispose();
		pagmiminaBalloon.dispose();
		pagsasakaBalloon1.dispose();
		pagsasakaBalloon2.dispose();
		pangingisdaBalloon1.dispose();
		pangingisdaBalloon2.dispose();
		questionBg.dispose();
        if (!isTeacher) {
            boxTexture.dispose();
            nextTexture.dispose();
            truckTexture.dispose();
            minerTexture.dispose();
            farmerTexture.dispose();
            fisherTexture.dispose();
            baybayinTexture.dispose();
            ibaTexture.dispose();
            kabukiranTexture.dispose();
            kabundukanTexture.dispose();
            lungsodTexture.dispose();
            parkeTexture.dispose();
        }
	}

	/**
	 * Draws the moving truck from left to right, then right to left
	 * @param batch Batch
	 */
	private void drawMovingTruck(Batch batch) {
		truck.setPosition(characterX, characterY);
		truck.draw(batch);

		if (characterX > screenWidth + truck.getWidth() * 1.1f)
			truck.flip(true, false);
		if (characterX < truck.getWidth() * -1.1f) {
			truck.setFlip(false, false);
		}

		if (truck.isFlipX()) {
			characterX -= characterSpeed;
			characterY = (screenHeight / 2) - (truck.getHeight() / 2);
		} else {
			characterX += characterSpeed;
			characterY = (screenHeight / 3) - (truck.getHeight() / 2);
		}
	}

	/**
	 * Draw a moving miner until it reaches the right portion
	 * of the screen
	 * @param batch Batch
	 */
	private void drawMiner(Batch batch) {
		miner.setPosition(characterX, characterY);
		miner.draw(batch);

		if (characterX < screenWidth / 1.5f)
			characterX += characterSpeed;
	}

    /**
     * Draws the moving farmer from left to right, then right to left
     * @param batch Batch
     */
    private void drawFarmer(Batch batch) {
        farmer.setPosition(characterX, characterY);
        farmer.draw(batch);

        if (characterX > screenWidth + farmer.getWidth() * 1.1f)
            farmer.setFlip(true, false);
        if (characterX < farmer.getWidth() * -1.1f)
            farmer.setFlip(false, false);

        if (farmer.isFlipX())
            characterX -= characterSpeed;
        else
            characterX += characterSpeed;
    }

	/**
	 * Get the speed of moving characters based on device's screen size
	 * @return float
	 */
	private float getCharacterVelocityByScreen() {
		ScreenSizeUtil screenSizeUtil = new ScreenSizeUtil();
		switch (screenSizeUtil.getScreenCategory(screenWidth)) {
			case ScreenSizeUtil.LDPI:
				return 2;
			case ScreenSizeUtil.MDPI:
				return 3;
			case ScreenSizeUtil.HDPI:
				return 4;
			case ScreenSizeUtil.XHDPI:
				return 4.75f;
			default:
				return 5.2f;
		}
	}

    /**
     * Gets the proper width for the answer sprite
     * @param answer Sprite
     * @return float
     */
    private float getAnswerWidth(Sprite answer) {
        return (answer.getWidth() * getButtonScale() * 1.8f);
    }

    /**
     * Gets the proper height of the answer sprite
     * @param answer Sprite
     * @return float
     */
    private float getAnswerHeight(Sprite answer) {
        return (answer.getHeight() * getButtonScale() * 1.6f);
    }
}
