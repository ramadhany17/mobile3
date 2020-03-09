package com.example.prak4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_DATA = "extra_data";
    private ImageView mImgPhoto;
    private TextView mTxtName, mTxtDesc;
    private Button mBtnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mImgPhoto = findViewById(R.id.adiv_hero_image);
        mTxtName = findViewById(R.id.adtv_hero_name);
        mTxtDesc = findViewById(R.id.adtv_hero_desc);
        mBtnShare = findViewById(R.id.adbtn_share_hero);

        Hero hero = getIntent().getParcelableExtra(EXTRA_DATA);
        if (hero == null) {
            mTxtName.setText("Data Kosong");
            return;
        }

        final String description = hero.getDesc();


        Glide.with(this).load(hero.getImage()).into(mImgPhoto);
        mTxtName.setText(hero.getName());
        mTxtDesc.setText(description);

        mBtnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, description);
                intent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(intent, null);
                startActivity(shareIntent);
            }
        });
    }
}
