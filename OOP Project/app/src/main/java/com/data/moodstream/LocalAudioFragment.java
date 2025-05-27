package com.data.moodstream;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

//import java.security.Permission;
import android.Manifest;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;

import java.io.File;
import java.util.ArrayList;

public class LocalAudioFragment extends Fragment {

    ListView listView;
    ArrayList<File> mySongs = new ArrayList<>();

    public LocalAudioFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_local_audio, container, false);
        listView = view.findViewById(R.id.listView);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            Dexter.withContext(requireContext())
                    .withPermission(Manifest.permission.READ_MEDIA_AUDIO)
                    .withListener(new PermissionListener() {
                        @Override
                        public void onPermissionGranted(PermissionGrantedResponse response) {
                            loadSongsInBackground();
                        }

                        @Override
                        public void onPermissionDenied(PermissionDeniedResponse response) {
                            Toast.makeText(requireContext(), "Audio permission denied", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                            token.continuePermissionRequest();
                        }
                    }).check();
        }

        listView.setOnItemClickListener((adapterView, itemView, position, id) -> {
            Intent intent = new Intent(getContext(), AudioPlayerActivity.class);
            intent.putExtra("song", mySongs.get(position));
            startActivity(intent);
        });

        return view;
    }

    public ArrayList<File> fetchSongs() {
        ArrayList<File> arrayList = new ArrayList<>();

        String[] projection = {
                MediaStore.Audio.Media.DATA
        };

        Cursor cursor = requireContext().getContentResolver().query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                projection,
                MediaStore.Audio.Media.IS_MUSIC + " != 0",
                null,
                null
        );

        if (cursor != null) {
            int dataIndex = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);
            while (cursor.moveToNext()) {
                String path = cursor.getString(dataIndex);
                File songFile = new File(path);
                arrayList.add(songFile);
            }
            cursor.close();
        }

        return arrayList;
    }

    private void loadSongsInBackground() {
        new Thread(() -> {
            mySongs = fetchSongs();
            requireActivity().runOnUiThread(this::showSongs);
        }).start();
    }

    private void showSongs() {
        String[] items = new String[mySongs.size()];
        for (int i = 0; i < mySongs.size(); i++) {
            items[i] = mySongs.get(i).getName().replace(".mp3", "").replace(".wav", "").replace(".opus", "").replace(".aac", "").replace(".au", "").replace(".m4a", "").replace(".acc", "");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(requireContext(), AudioPlayerActivity.class);
            intent.putExtra("songList", mySongs);
            intent.putExtra("currentSong", items[position]);
            intent.putExtra("position", position);
            startActivity(intent);
        });
    }
}