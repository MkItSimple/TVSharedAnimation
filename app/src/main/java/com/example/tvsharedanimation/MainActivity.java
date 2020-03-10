package com.example.tvsharedanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mListLayout;
    private ImageView mImage;
    private TextView mName;
    private TextView mDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListLayout = findViewById(R.id.list_layout);
        mImage = findViewById(R.id.profile_image);
        mName = findViewById(R.id.profile_name);
        mDesc = findViewById(R.id.profile_description);

        mListLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shareIntent = new Intent(MainActivity.this, SharedActivity.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(mImage, "imageTransition");
                pairs[1] = new Pair<View, String>(mName, "nameTransition");
                pairs[2] = new Pair<View, String>(mDesc, "descTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);

                startActivity(shareIntent, options.toBundle());
            }
        });
    }
}
