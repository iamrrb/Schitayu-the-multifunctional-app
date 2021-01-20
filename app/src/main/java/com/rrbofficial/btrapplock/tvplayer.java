package com.rrbofficial.btrapplock;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class tvplayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {



    YouTubePlayer youTubePlayer;
    Button fullscreen ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_tvplayer);
        YouTubePlayerView playerView = (YouTubePlayerView)findViewById(R.id.youtubeplayerview);
        playerView.initialize(DeveloperKey.DEVELOPER_KEY,this);

        fullscreen =(Button)findViewById(R.id.fullscn);
        fullscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayer.setFullscreen(true);
            }
        });

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        this.youTubePlayer=youTubePlayer;
        if (!b){

            youTubePlayer.loadVideo("gHykKPYuWvs");
            youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
        }
    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
