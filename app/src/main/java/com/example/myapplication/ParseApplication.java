package com.example.myapplication;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // Retgister your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("mQGdLfKDTYvU6j1F2mNslXRwKlxj8rT7tDNW44t1")
                .clientKey("3Wbdzs4r1Lecf6l4Z1WySx6DbogTgcc8s9HqxGwm")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
