package com.data.moodstream;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;

public class VideoPlayer extends AppCompatActivity {

    private VideoView videoView;
    private Button btnPlayPause, btnNext, btnPrevious;
    private TextView titleText;

    private ArrayList<File> videoFiles;
    private int currentPosition = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        videoView = findViewById(R.id.videoView);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);
        titleText = findViewById(R.id.titleText);

        videoFiles = (ArrayList<File>) getIntent().getSerializableExtra("videoList");
        currentPosition = getIntent().getIntExtra("position", 0);

        if (videoFiles == null) {
            finish();
            return;
        }

        if (videoFiles.isEmpty()) {
            finish();
            return;
        }

        if (currentPosition < 0 || currentPosition >= videoFiles.size()) {
            currentPosition = 0;
        }

        playVideo(currentPosition);

    }

    private void playVideo(int position) {
        File videoFile = videoFiles.get(position);
        Uri uri = Uri.fromFile(videoFile);

        titleText.setText(videoFile.getName());
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(mp -> {
            videoView.start();
            btnPlayPause.setText("Pause");
        });

        videoView.setOnCompletionListener(mp -> {
            currentPosition = (currentPosition + 1) % videoFiles.size();
            playVideo(currentPosition);
        });
    }
}