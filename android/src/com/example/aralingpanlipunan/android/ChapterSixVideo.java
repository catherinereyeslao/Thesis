package com.example.aralingpanlipunan.android;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * This Video Activity will be displayed in Chapter 6. This uses the new theme
 * compatible for android versions >= 13
 */
public class ChapterSixVideo extends Activity implements OnCompletionListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.chapter_six_video);

        String cebu = "android.resource://" + getPackageName() + "/raw/chapsix";

        VideoView video = (VideoView) this.findViewById(R.id.video);
        video.setVideoURI(Uri.parse(cebu));

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(video);
        mediaController.setMediaPlayer(video);

        video.setMediaController(mediaController);
        video.setOnCompletionListener(this);
        video.start();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        finish();
    }
}
