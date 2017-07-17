package com.example.akash.mplay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akash on 16-07-2017.
 */
public class SongAdapter extends ArrayAdapter<song> {
    public SongAdapter(Context context, ArrayList<song> list) {
        super(context, 0, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View list=convertView;
        if(list==null)
        {
            list= LayoutInflater.from(getContext()).inflate(R.layout.playlist_item, parent, false);
        }

        song s = getItem(position);
        TextView title = (TextView) list.findViewById(R.id.songTitle);
        TextView artist = (TextView) list.findViewById(R.id.artist);
        TextView duration = (TextView) list.findViewById(R.id.duration);
        title.setText(s.getSongTitle());
        artist.setText(s.getArtist());
        //duration.setText(s.getDuration()+"");
        return list;
    }
}
