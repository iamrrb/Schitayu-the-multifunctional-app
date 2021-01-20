package com.rrbofficial.btrapplock;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class schitayuintro extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(AppIntroFragment.newInstance("INTRODUCING GCOEAN'S SCHITAYU",
                "An app by GCOEA CSE Students (Batch of 2015-2019",
                R.drawable.icontp,
                Color.parseColor("#039be5")
        ));

        addSlide(AppIntroFragment.newInstance("A MULTIFUNCTIONAL ANDROID APP",
                "Includes camera ,tv enterntainment ,social things ,sms,call,and many more",
                R.drawable.icontp,
                Color.parseColor("#0288d1")
        ));

        addSlide(AppIntroFragment.newInstance("INTRODUCING TV ,ENTERTAINMENT ,AND MANY MORE",
                "An app by GCOEA CSE Students (Batch of 2015-2019",
                R.drawable.icontp,
                Color.parseColor("#0277bd")
        ));
        addSlide(AppIntroFragment.newInstance("EXXPLORING THE FEATURES",
                "An app by GCOEA CSE Students (Batch of 2015-2019",
                R.drawable.icontp,
                Color.parseColor("#01579b")
        ));

        showStatusBar(false);
        setBarColor(Color.parseColor("#231f20"));
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        Intent it = new Intent(schitayuintro.this,schitayuhome.class);
        startActivity(it);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        Intent it = new Intent(schitayuintro.this,schitayuhome.class);
        startActivity(it);
    }

    @Override
    public void onSlideChanged() {
    }
}
