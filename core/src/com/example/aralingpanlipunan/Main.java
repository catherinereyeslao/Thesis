package com.example.aralingpanlipunan;

import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.example.aralingpanlipunan.android.AndroidInterface;
import com.example.aralingpanlipunan.utils.BackgroundMusic;
import com.example.aralingpanlipunan.utils.DummyAndroidInterface;
import com.example.aralingpanlipunan.views.Menu;
import com.example.aralingpanlipunan.views.Start;
import com.example.aralingpanlipunan.views.Student;
import com.example.aralingpanlipunan.views.Teacher;
import com.example.aralingpanlipunan.views.minigames.MiniGamesMenu;

public class Main extends ApplicationAdapter implements ApplicationListener, GestureListener, InputProcessor {
	private static final byte MENU = 0;
	private static final byte START = 1;
	private static final byte STUDENT = 2;
	private static final byte TEACHER = 3;
	private static final byte MINI_GAMES = 5;
	private static final byte EXIT = 8;
	private byte triage = MENU;
	private SpriteBatch batch;
	private Menu menu;
	private Start start;
	private Student student;
    private Teacher teacher;
    private MiniGamesMenu miniGamesMenu;
	private AndroidInterface android;

	public Main() {
		android = new DummyAndroidInterface();
	}

	public Main(AndroidInterface androidInterface) {
		android = androidInterface;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		menu = new Menu();

		menu.setUp(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        BackgroundMusic.playBgMusic();

		// Set input listeners
		InputMultiplexer im = new InputMultiplexer();
		GestureDetector gd = new GestureDetector(this);
		im.addProcessor(gd);
		im.addProcessor(this);
		Gdx.input.setInputProcessor(im);
	}

	@Override
	public void resize(int screenW, int screenH) {
		batch = new SpriteBatch();
		switch (triage) {
			case MENU:
				menu.setUp(screenW, screenH);
				break;
			case START:
				start.setUp(screenW, screenH);
				break;
			case STUDENT:
				student.setUp(screenW, screenH);
				break;
            case MINI_GAMES:
                miniGamesMenu.setUp(screenW, screenH);
                break;
            case TEACHER:
                teacher.setUp(screenW, screenH);
                break;
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		switch (triage) {
			case START:
				start.display(batch);
				break;
			case STUDENT:
				student.display(batch);
				break;
			case TEACHER:
				teacher.display(batch);
				break;
			case MINI_GAMES:
				miniGamesMenu.display(batch);
				break;
			case MENU:
				menu.display(batch);
				break;
		}
        batch.end();
	}

	@Override
	public void dispose() {
		switch (triage) {
			case MENU:
				menu.dispose();
				break;
			case START:
				start.dispose();
				break;
			case STUDENT:
				student.dispose();
                break;
            case MINI_GAMES:
                miniGamesMenu.dispose();
                break;
            case TEACHER:
                teacher.dispose();
                break;
		}
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		final float normalisedY = Gdx.graphics.getHeight() - y;
        switch (triage) {
            case MENU:
                if (menu.clickedMenu(x, normalisedY) == Menu.START) {
                    menu.dispose();
                    start = new Start();
                    start.setUp(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                    triage = START;
                } else if (menu.clickedMenu(x, normalisedY) == Menu.MINI_GAMES) {
                    menu.dispose();
                    miniGamesMenu = new MiniGamesMenu();
                    miniGamesMenu.setUp(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                    triage = MINI_GAMES;
                } else if (menu.clickedMenu(x, normalisedY) == Menu.EXIT) {
                    triage = EXIT;
                    dispose();
                    if (android != null) {
                        BackgroundMusic.stopBgMusic();
                        BackgroundMusic.disposeBgMusic();
                        android.exit();
                    }
                }
                break;
            case START:
                start.touchDown(x, normalisedY);
                break;
            case STUDENT:
                student.touchDown(x, normalisedY);
                break;
            case MINI_GAMES:
                miniGamesMenu.touchDown(x, normalisedY);
                break;
            case TEACHER:
                teacher.touchDown(x, normalisedY);
                break;
        }
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

	@Override
	public boolean keyDown(int keycode) {
		// If back button is pushed in android
		if (keycode == 4) {
			switch (triage) {
				case MENU:
					menu.dispose();
					if (android != null) {
                        BackgroundMusic.stopBgMusic();
                        BackgroundMusic.disposeBgMusic();
                        android.exit();
                    }
					break;
				case START:
					start.dispose();
					start = null;
					menu.setUp(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
					triage = MENU;
					break;
				case STUDENT:
					if (student.keyDown(keycode) == 1) {
						student.dispose();
						student = null;
						start = new Start();
						start.setUp(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
						triage = START;
					}
					break;
                case TEACHER:
                    if (teacher.keyDown(keycode) == 1) {
                        teacher.dispose();
                        teacher = null;
                        start = new Start();
                        start.setUp(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                        triage = START;
                    }
                    break;
                case MINI_GAMES:
                    if (miniGamesMenu.keyDown(keycode) == 1) {
                        miniGamesMenu.dispose();
                        miniGamesMenu = null;
                        start = new Start();
                        start.setUp(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                        triage = START;
                    }
                    break;
			}
		} else {
            switch (triage) {
                case STUDENT:
                    student.keyDown(keycode);
                    break;
                case MINI_GAMES:
                    miniGamesMenu.keyDown(keycode);
                    break;
            }
        }
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		switch (triage) {
            case STUDENT:
                student.keyTyped(character);
                break;
            case MINI_GAMES:
                miniGamesMenu.keyTyped(character);
                break;
        }
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		final int normalisedY = Gdx.graphics.getHeight() - screenY;
		if (triage == START) {
			switch (start.touchUp(screenX, normalisedY)) {
				case Start.STUDENT:
					start.dispose();
					student = new Student(android);
					student.setUp(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
					start = null;
					triage = STUDENT;
					break;
                case Start.TEACHER:
                    start.dispose();
                    teacher = new Teacher(android, true);
                    teacher.setUp(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                    start = null;
                    triage = TEACHER;
                    break;
                case Start.MINI_GAMES:
                    start.dispose();
                    miniGamesMenu = new MiniGamesMenu();
                    miniGamesMenu.setUp(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                    start = null;
                    triage = MINI_GAMES;
                    break;
				case Start.EXIT:
                    BackgroundMusic.stopBgMusic();
                    BackgroundMusic.disposeBgMusic();
					start.dispose();
					android.exit();
					break;
			}
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		switch (triage) {
            case STUDENT:
                student.touchDragged(screenX);
                break;
            case TEACHER:
                teacher.touchDragged(screenX);
                break;
        }
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
