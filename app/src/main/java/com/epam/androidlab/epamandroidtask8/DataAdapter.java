package com.epam.androidlab.epamandroidtask8;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private Music music;
    private Context context;

    public DataAdapter(Music music, Context context) {
        this.music = music;
        this.context = context;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Song song = music.getSong(position);
        holder.text.setText(song.getSongName());
        Picasso.with(context).load(song.getAlbumURL()).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return music.getSongsCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public TextView text;

        public ViewHolder(View v) {
            super(v);
            img = (ImageView) v.findViewById(R.id.album);
            text = (TextView) v.findViewById(R.id.song);
        }
    }
}
