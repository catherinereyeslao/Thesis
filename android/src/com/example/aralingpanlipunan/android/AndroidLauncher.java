package com.example.aralingpanlipunan.android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.widget.Toast;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.example.aralingpanlipunan.Main;
import com.example.aralingpanlipunan.android.database.StudentData;

import java.util.ArrayList;

public class AndroidLauncher extends AndroidApplication implements AndroidInterface, OnClickListener, Runnable {
	private static final int ALERT = 1;
	private static final int TOAST = 2;
	private int androidBackgroudnTask;
	private String[] alertMessage = new String[4];
	private boolean alertButtonClicked = false;

	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.useGLSurfaceView20API18 = true;
		config.useWakelock = true;
		initialize(new Main(this), config);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		finish();
	}

	@Override
	public void exit() {
		onDestroy();
	}

	@Override
	public boolean studentExists(String studentName) {
		StudentData studentData = new StudentData(this);
		studentData.open();
		boolean exists = studentData.studentExists(studentName);
		studentData.close();
		return exists;
	}

	@Override
	public boolean registerNewStudent(String studentName) {
		StudentData studentData = new StudentData(this);
		studentData.open();
		try {
			studentData.registerStudent(studentName);
		} catch (SQLiteException e) {
			return false;
		}
		studentData.close();
		return true;
	}

	@Override
	public ArrayList<Integer> getScoresByStudent(String studentName) {
		StudentData studentData = new StudentData(this);
		studentData.open();
		try {
			return studentData.getScoresByStudent(studentName);
		} catch (SQLiteException e) {
			e.printStackTrace();
			return null;
		} finally {
			studentData.close();
		}
	}

	@Override
	public boolean showAlertDialog(String title, String message, String yesButton, String noButton) {
		// Run the AlertDialog in the UI thread since it cannot run from the GL thread (game view)
		this.runOnUiThread(this);
		alertMessage[0] = title;
		alertMessage[1] = message;
		alertMessage[2] = yesButton;
		alertMessage[3] = noButton;
		androidBackgroudnTask = ALERT;
		return alertButtonClicked;
	}

	@Override
	public void onBackPressed() {
		// If user presses the back button, do not exit app unless we're in Menu
	}

	@Override
	public void showToast(String message, int length) {
		this.runOnUiThread(this);
		alertMessage[0] = message;
		alertMessage[1] = Integer.toString(length);
		androidBackgroudnTask = TOAST;
	}

	@Override
	public void onClick(DialogInterface dialogInterface, int i) {
		switch (i) {
			case DialogInterface.BUTTON_POSITIVE:
				alertButtonClicked = true;
				break;
			case DialogInterface.BUTTON_NEGATIVE:
				dialogInterface.cancel();
				alertButtonClicked = false;
				break;
		}
	}

	@Override
	public void setStudentScore(String studName, String chapter, int studScore) {
		StudentData studentData = new StudentData(this);
		studentData.open();
		try {
			studentData.setStudentScore(studName, chapter, studScore);
		} catch (SQLiteException e) {
			e.printStackTrace();
		} finally {
			studentData.close();
		}
	}

	@Override
	public void playChap6Video() {
		Intent chap6VideoIntent;
		if (Build.VERSION.SDK_INT >= 13)
			chap6VideoIntent = new Intent(this, ChapterSixVideo.class);
		else
			chap6VideoIntent = new Intent(this, ChapterSixVideoCompat.class);
		startActivity(chap6VideoIntent);
	}

	@Override
	public void run() {
		switch (androidBackgroudnTask) {
			case ALERT:
				if (Build.VERSION.SDK_INT < 11) {
					// For older android version compatibility, use old alertDialog box
					final AlertDialog.Builder alert = new AlertDialog.Builder(this);
					alert.setTitle(alertMessage[0]);
					alert.setMessage(alertMessage[1]);
					alert.setCancelable(false);
					alert.setPositiveButton(alertMessage[2], this);
					alert.setNegativeButton(alertMessage[3], this);
					alert.show();
				} else {
					final AlertDialog alert = new AlertDialog.Builder(this, AlertDialog.THEME_HOLO_DARK).create();
					alert.setTitle(alertMessage[0]);
					alert.setMessage(alertMessage[1]);
					alert.setButton(AlertDialog.BUTTON_POSITIVE, alertMessage[2], this);
					alert.setButton(AlertDialog.BUTTON_NEGATIVE, alertMessage[3], this);
					alert.show();
				}
				break;
			case TOAST:
				Toast.makeText(this, alertMessage[0], Integer.parseInt(alertMessage[1]) > 0 ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
				break;
		}
	}
}
