package com.rrbofficial.btrapplock;

/**
 * Created by ROHIT on 10/09/2018.
 */

public class SongInfo {
    public String SongName,artistName,SongUrl;
     public SongInfo(){
     }

    public SongInfo(String songName, String artistName, String songUrl) {
        SongName = songName;
        this.artistName = artistName;
        SongUrl = songUrl;
    }

    public String getSongName() {
        return SongName;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getSongUrl() {
        return SongUrl;
    }
}
