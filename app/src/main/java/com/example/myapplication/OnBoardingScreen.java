package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class OnBoardingScreen extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addFragment(new Step.Builder().setTitle("Extract Text from Images using ML")
                .setContent("hfshdiushdfuhdfsjdfsh. uhfkjsdfh kjdsf.jfhiuahfufshdjfsdjbnfjsbdhjfbjhdfsdsajhfadskj.hfn  hhuhdfsuhsfj uh sfuh guihgfuhadfsjk huhgfudh iu  uj ijfdigfjkfngu ou hiuh gishfh uh iuh gsfkj hfg ")
                .setBackgroundColor(Color.parseColor("#000000")) // int background color
                .setDrawable(R.drawable.ob1) // int top drawable
                .setSummary("This is summary")
                .build());

        addFragment(new Step.Builder().setTitle("This is header")
                .setContent("This is content. igs hiugsh u ghsauh gasnbfjngsooagnf g  gfiosij agsngsaog s hg  gfa go gfouf ajnjdfjndfshkjnfdo   jjgf adjfdnhojg naf  df i  d")
                .setBackgroundColor(Color.parseColor("#000000")) // int background color
                .setDrawable(R.drawable.ob2) // int top drawable
                .setSummary("This is summary")
                .build());

        addFragment(new Step.Builder().setTitle("Copy on One CLick")
                .setContent("This is content. jfdsj d jsn jjfgn asuh  gsafuughgf  jh gsug ouuh   ghshuafohgf h g hfoashg fsj  ngnmn vcdsjfai aewjrdnvmvxcnzasjdjfiasurh gieraioewth     ji   j jij  i h gsoia i ")
                .setBackgroundColor(Color.parseColor("#000000")) // int background color
                .setDrawable(R.drawable.ob3) // int top drawable
                .setSummary("This is summary")
                .build());
    }


    @Override
    public void finishTutorial() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void currentFragmentPosition(int position) {

    }
}