package com.data.moodstream;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.data.moodstream.databinding.ActivityMainPageBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainPage extends AppCompatActivity {

    ActivityMainPageBinding binding;

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityMainPageBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        binding.bottomNavigationView.setBackgroundColor(Color.BLACK);

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.home) {
                replaceFragment(new HomeFragment());
            } else if (id == R.id.online) {
                replaceFragment(new OnlineFragment());
            } else if (id == R.id.localmedia) {
                replaceFragment(new LocalMediaFragment());
            } else if (id == R.id.playlists) {
                replaceFragment(new PlaylistFragment());
            } else if (id == R.id.chatbot) {
                replaceFragment(new ChatBotFragment());
            }

            return true;
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}