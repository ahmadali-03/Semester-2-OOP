package com.data.moodstream;

import static java.lang.Thread.sleep;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AudioPlayerActivity extends AppCompatActivity {

    ImageView play, next, previous;
    TextView textView;
    ArrayList<File> songs;
    MediaPlayer mediaPlayer;
    int position;
    SeekBar seekBar;

    Handler handler = new Handler();
    Runnable updateSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);

        play = findViewById(R.id.play);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.previous);
        textView = findViewById(R.id.textView);
        seekBar = findViewById(R.id.seekBar);

        Intent intent = getIntent();
        songs = (ArrayList<File>) intent.getSerializableExtra("songList");
        String songName = intent.getStringExtra("currentSong");
        position = intent.getIntExtra("position", 0);

        textView.setText(songName);

        initializePlayer();

        play.setOnClickListener(v -> togglePlayPause());
        next.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            if (position < songs.size() - 1) {
                position++;
            } else {
                position = 0;
            }
            initializePlayer();
        });

        previous.setOnClickListener(v -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }
            position = (position - 1 + songs.size()) % songs.size();
            initializePlayer();
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            boolean userTouch = false;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (userTouch && mediaPlayer != null) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                userTouch = true;
                handler.removeCallbacks(updateSeekBar);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                userTouch = false;
                mediaPlayer.seekTo(seekBar.getProgress());
                handler.removeCallbacks(updateSeekBar);
            }
        });
    }

    private void initializePlayer() {
        try {
            if (handler != null && updateSeekBar != null) {
                handler.removeCallbacks(updateSeekBar);
            }
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }

            mediaPlayer = new MediaPlayer();
            mediaPlayer.setDataSource(songs.get(position).getAbsolutePath());
            mediaPlayer.prepare();
            mediaPlayer.start();

            play.setImageResource(android.R.drawable.ic_media_pause);
            textView.setText(songs.get(position).getName());

            seekBar.setMax(mediaPlayer.getDuration());

            // Runnable to update SeekBar progress
            updateSeekBar = new Runnable() {
                @Override
                public void run() {
                    if (mediaPlayer != null) {
                        int currentPosition = mediaPlayer.getCurrentPosition();
                        seekBar.setProgress(currentPosition);
                        handler.postDelayed(this, 500);
                    }
                }
            };
            handler.post(updateSeekBar);

            mediaPlayer.setOnCompletionListener(mp -> {
                position = (position + 1) % songs.size();
                initializePlayer();
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void togglePlayPause() {
        if (handler != null && updateSeekBar != null) {
            handler.removeCallbacks(updateSeekBar);
        }
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                play.setImageResource(android.R.drawable.ic_media_play);
            } else {
                mediaPlayer.start();
                play.setImageResource(android.R.drawable.ic_media_pause);
            }
        }
    }

    @Override
    protected void onDestroy() {
        if (handler != null && updateSeekBar != null) {
            handler.removeCallbacks(updateSeekBar);
        }
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        if (handler != null && updateSeekBar != null) {
            handler.removeCallbacks(updateSeekBar);
        }
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onBackPressed();
    }
}