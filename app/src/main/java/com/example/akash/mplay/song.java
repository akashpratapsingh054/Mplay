package com.example.akash.mplay;

import java.io.StringReader;

/**
 * Created by Akash on 16-07-2017.
 */
public class song {

    String songTitle,dataPath,displayName,dateAdded,dateModified,artist,album,albumId;
    long songId,Duration;
    song(long sId,String dPath,String sTitle,long Dur,String dispName,String art)
    {
        songId=sId;
        dataPath=dPath;
        songTitle=sTitle;
        Duration=Dur;
        displayName=dispName;
        artist=art;
    }
    public long getID(){return songId;}
    public String getDisplayName(){return displayName;}
    //public String getArtist(){return artist;}
    public String getDataPath(){return dataPath;}
    public String getSongTitle(){return songTitle;}
    public long getDuration(){return Duration;}
    public String getArtist(){ return artist;    }

}
