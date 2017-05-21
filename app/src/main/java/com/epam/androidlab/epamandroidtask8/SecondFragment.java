package com.epam.androidlab.epamandroidtask8;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SecondFragment extends Fragment {
    private Music music;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createMusic();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        Context context = this.getContext();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        DataAdapter adapter = new DataAdapter(music, context);
        recyclerView.setAdapter(adapter);
        return view;
    }

    protected void createMusic() {
        music = new Music();
        music.addSong("Adele",
                "https://draw.acharts.net/cover/60742-54d01316f35c2-l.jpg");
        music.addSong("Nirvana",
                "http://images.sequart.org/images/81B5Xe9YfdL._SL1425_.jpg");
        music.addSong("Eminem",
                "https://eminem50cent.ru/images/stories/Eminem_-_The_Marshall_Mathers_LP_2_album_cover.jpg");
        music.addSong("Lady Gaga",
                "https://lastfm-img2.akamaized.net/i/u/300x300/1623ee43952b4e38ce4d0d66ec1267b0.jpg");
        music.addSong("Birdy",
                "https://upload.wikimedia.org/wikipedia/en/4/45/Birdy_%28Birdy_album%29.png");
        music.addSong("Green Day",
                "http://www.crimsonart.net/uploads/2/6/6/7/26673516/9763.jpg");
        music.addSong("Lorde",
                "https://s-media-cache-ak0.pinimg.com/736x/6f/e3/bc/6fe3bc252967203ac8e95f16b058e86c.jpg");
        music.addSong("Imagine dragons",
                "https://cs25.myzuka.fm/img/68/3254304/15379710.jpg");
        music.addSong("Kanye West",
                "http://megalyrics.ru/uploads/album/0a/5205be0ae9c5a4ff44a0c6fc/px240_R-4664769-1372020336-4108.jpeg");
        music.addSong("Linkin Park",
                "http://g-ecx.images-amazon.com/images/G/01/ciu/be/a5/5136c060ada0d0d37af3c110.L._AA300_.jpg");
    }

}
