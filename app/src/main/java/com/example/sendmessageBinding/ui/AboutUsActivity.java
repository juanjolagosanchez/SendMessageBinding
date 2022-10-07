package com.example.sendmessageBinding.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sendmessageBinding.R;
import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        AboutView view = AboutBuilder.with(this)
                .setPhoto(R.mipmap.ic_launcher)
                .setCover(R.mipmap.ic_launcher)
                .setName(R.string.AboutName)
                .setSubTitle(R.string.aboutUsTitle)
                .setBrief(R.string.aboutUsInfo)
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.aboutUsName)
                .addGooglePlayStoreLink("8002078663318221363")
                .addGitHubLink("juanjolagosanchez")
                .addFacebookLink("user")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .build();
        setContentView(view);
    }
}