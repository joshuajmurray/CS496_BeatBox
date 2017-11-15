package com.jmurray.android.beatbox;

/**
 * Created by joshu on 11/14/2017.
 */

public class SoundViewModel {
    private Sound mSound;
    private BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    public Sound getSound() {
        return mSound;
    }

    public String getTitle() {
        return mSound.getmName();
    }

    public void setSound(Sound sound) {
        mSound = sound;
    }
}
