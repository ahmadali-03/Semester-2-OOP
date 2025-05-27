package com.data.moodstream;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

public class LocalVideoFragment extends Fragment {

    ListView listView;
    ArrayList<File> myVideos = new ArrayList<>();

    public LocalVideoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_video, container, false);
        listView = view.findViewById(R.id.listView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            Dexter.withContext(requireContext())
                    .withPermission(Manifest.permission.READ_MEDIA_VIDEO)
                    .withListener(new PermissionListener() {
                        @Override
                        public void onPermissionGranted(PermissionGrantedResponse response) {
                            loadVideosInBackground();
                        }

                        @Override
                        public void onPermissionDenied(PermissionDeniedResponse response) {
                            Toast.makeText(requireContext(), "Video permission denied", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                            token.continuePermissionRequest();
                        }
                    }).check();
        }
        else {
            Dexter.withContext(requireContext())
                    .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                    .withListener(new PermissionListener() {
                        @Override
                        public void onPermissionGranted(PermissionGrantedResponse response) {
                            loadVideosInBackground();
                        }

                        @Override
                        public void onPermissionDenied(PermissionDeniedResponse response) {
                            Toast.makeText(requireContext(), "Storage permission denied", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                            token.continuePermissionRequest();
                        }
                    }).check();
        }

        /*listView.setOnItemClickListener((parent, view1, position, id) -> {
            Intent intent = new Intent(requireContext(), VideoPlayer.class);
            intent.putStringArrayListExtra("videoList", getVideoPaths());
            intent.putExtra("position", position);
            startActivity(intent);
        });*/

        return view;
    }

    private void loadVideosInBackground() {
        new Thread(() -> {
            myVideos = fetchVideos();
            requireActivity().runOnUiThread(this::showVideos);
        }).start();
    }

    private ArrayList<File> fetchVideos() {
        ArrayList<File> videoFiles = new ArrayList<>();

        Cursor cursor = requireContext().getContentResolver().query(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Video.Media.DATA},
                null,
                null,
                null
        );

        if (cursor != null) {
            int dataIndex = cursor.getColumnIndex(MediaStore.Video.Media.DATA);
            while (cursor.moveToNext()) {
                String path = cursor.getString(dataIndex);
                File videoFile = new File(path);
                if (videoFile.exists()) {
                    videoFiles.add(videoFile);
                }
            }
            cursor.close();
        }

        return videoFiles;
    }

    private void showVideos() {
        String[] videoNames = new String[myVideos.size()];
        for (int i = 0; i < myVideos.size(); i++) {
            videoNames[i] = myVideos.get(i).getName().replace(".mp4", "").replace(".mkv", "").replace(".avi", "").replace(".mov", "").replace(".webm", "");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, videoNames);
        listView.setAdapter(adapter);
    }

    private ArrayList<String> getVideoPaths() {
        ArrayList<String> paths = new ArrayList<>();
        for (File file : myVideos) {
            paths.add(file.getAbsolutePath());
        }
        return paths;
    }
}