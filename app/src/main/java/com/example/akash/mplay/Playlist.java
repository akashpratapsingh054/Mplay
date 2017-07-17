package com.example.akash.mplay;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Random;

public class Playlist extends AppCompatActivity {


    public ArrayList<song> slist=MainActivity.songsList;
    MediaPlayer mediaPlayer=MainActivity.mp;
    ImageView im;
    TextView title;
    ImageButton prev,play,next;
    int ind=MainActivity.currentSongIndex;
    int size=slist.size();
    Utilities utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        //Toast.makeText(this,MainActivity.isRepeat+"",Toast.LENGTH_LONG).show();

       // Toast.makeText(this,MainActivity.currentSongIndex+"",Toast.LENGTH_SHORT).show();

        im=(ImageView)findViewById(R.id.imageView);
        title=(TextView)findViewById(R.id.stitle);
        prev=(ImageButton)findViewById(R.id.previous);
        play=(ImageButton)findViewById(R.id.pl);
        next=(ImageButton)findViewById(R.id.next);
       // Toast.makeText(this,"Akash",Toast.LENGTH_LONG).show();



        SongAdapter sAdapter=new SongAdapter(this,slist);
        ListView l=(ListView)findViewById(R.id.play);

        l.setAdapter(sAdapter);
        check();
        title.setText(slist.get(ind).getSongTitle());

        if(MainActivity.bitmap!=null)
        {
            im.setImageBitmap(MainActivity.bitmap);
        }
        else
        {
            im.setImageResource(R.drawable.adele);
        }

        LinearLayout ll= (LinearLayout)findViewById(R.id.llayout);

        // listening to single listitem click
        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting listitem index
                int songIndex = position;

                // Starting new intent
                Intent in = new Intent(getApplicationContext(),
                        MainActivity.class);
                // Sending songIndex to PlayerActivity
                in.putExtra("songIndex", songIndex);
                setResult(100, in);
                // Closing PlayListView
                finish();
            }
        });
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getApplicationContext(),
                        MainActivity.class);
                // Sending songIndex to PlayerActivity
                //in.putExtra("songIndex", songIndex);
                //setResult(100, in);
                // Closing PlayListView
                finish();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // check for already playing
                if (mediaPlayer.isPlaying()) {
                    if (mediaPlayer != null) {
                        mediaPlayer.pause();
                        // Changing button image to play button
                        play.setImageResource(R.drawable.img_btn_play);
                    }
                } else {
                    // Resume song
                    if (mediaPlayer != null) {
                        mediaPlayer.start();
                        // Changing button image to pause button
                        play.setImageResource(R.drawable.img_btn_pause);
                    }
                }

            }
        });

     /*   next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // check if next song is there or not
                //Toast.makeText(Playlist.this,"next",Toast.LENGTH_LONG).show();
                if (MainActivity.currentSongIndex < (MainActivity.songsList.size() - 1)) {
                    if(MainActivity.isShuffle==false) {
                        MainActivity.currentSongIndex = MainActivity.currentSongIndex + 1;
                    }
                    else
                    {
                        Random rand = new Random();
                        MainActivity.currentSongIndex = rand.nextInt((MainActivity.songsList.size() - 1) - 0 + 1) + 0;
                    }
                    playSong(MainActivity.currentSongIndex );
                } else {
                    // play first song
                    playSong(0);
                    MainActivity.currentSongIndex = 0;
                }

            }
        });

        /**
         * Back button click event
         * Plays previous song by currentSongIndex - 1
         * */

/*
        prev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (MainActivity.currentSongIndex > 0) {
                    if(MainActivity.isShuffle==false) {
                        MainActivity.currentSongIndex = MainActivity.currentSongIndex - 1;
                    }
                    else
                    {
                        Random rand = new Random();
                        MainActivity.currentSongIndex = rand.nextInt((MainActivity.songsList.size() - 1) - 0 + 1) + 0;
                    }
                    playSong(MainActivity.currentSongIndex - 1);

                } else {
                    // play last song
                    playSong(MainActivity.songsList.size() - 1);
                    MainActivity.currentSongIndex = MainActivity.songsList.size() - 1;
                }

            }
        });


   */

    }

    void check(){
        if(MainActivity.mp.isPlaying()){
            play.setImageResource(R.drawable.img_btn_pause);
        }
        else
            play.setImageResource(R.drawable.img_btn_play);
    }

    public void playSong(int ind){
        try {
            title.setText(slist.get(ind).getSongTitle());
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.setDataSource(slist.get(ind).getDataPath());

            if(MainActivity.bitmap!=null)
            {
                im.setImageBitmap(MainActivity.bitmap);
            }
            else
            {
                im.setImageResource(R.drawable.adele);
            }
            mediaPlayer.prepare();
            mediaPlayer.start();

        }
        catch (Exception e){

        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        //check();
    }
}
