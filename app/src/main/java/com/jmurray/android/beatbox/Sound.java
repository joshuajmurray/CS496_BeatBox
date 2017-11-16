package com.jmurray.android.beatbox;

/**
 * Created by joshu on 11/14/2017.
 */

public class Sound {
    private String mAssetPath;
    private String mName;
    private Integer mSoundID;

    public Sound(String assetPath) {
        mAssetPath = assetPath;
        String[] components = assetPath.split("/");
        String filename = components[components.length - 1];
        mName = filename.replace(".wav", "");
    }

    public String getmAssetPath() {
        return mAssetPath;
    }

    public String getmName() {
        return mName;
    }

    public Integer getmSoundID() {
        return mSoundID;
    }

    public void setmSoundID(Integer soundID) {
        mSoundID = soundID;
    }
}
