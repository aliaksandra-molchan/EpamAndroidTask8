package com.epam.androidlab.epamandroidtask8;


import java.util.ArrayList;
import java.util.List;

public class Music {
    private List<Song> songs = new ArrayList<>();

    public void addSong(String name, String url) {
        Song song = new Song();
        song.setSongName(name);
        song.setAlbumURL(url);
        songs.add(song);
    }

    public int getSongsCount() {
        return songs.size();
    }

    public Song getSong(int position) {
        return songs.get(position);
    }
}
