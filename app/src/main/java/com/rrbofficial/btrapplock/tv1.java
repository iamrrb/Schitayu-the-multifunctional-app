package com.rrbofficial.btrapplock;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class tv1 extends Fragment {

    ImageView img1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tv1, container, false);


        img1=(ImageView) rootView.findViewById(R.id.aajtak);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it =new Intent(getActivity(),PlayerActivity.class);
                startActivity(it);
            }
        });


        return rootView;
    }

}
