package com.data.moodstream;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class LocalMediaFragment extends Fragment {

    ImageButton btnAudio, btnVideo;

    public LocalMediaFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_media, container, false);

        btnAudio = view.findViewById(R.id.btnAudio);
        btnVideo = view.findViewById(R.id.btnVideo);

        btnAudio.setOnClickListener(v -> loadFragment(new LocalAudioFragment()));
        btnVideo.setOnClickListener(v -> loadFragment(new LocalVideoFragment()));

        return view;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
