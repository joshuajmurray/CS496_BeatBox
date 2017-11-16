package com.jmurray.android.beatbox;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by joshu on 11/14/2017.
 */

public class SoundViewModel extends BaseObservable {
    private Sound mSound;
    private BeatBox mBeatBox;

    public SoundViewModel(BeatBox beatBox) {
        mBeatBox = beatBox;
    }

    public Sound getSound() {
        return mSound;
    }

    @Bindable
    public String getTitle() {
        return mSound.getmName();
    }

    public void setSound(Sound sound) {
        mSound = sound;
        notifyChange();
    }
}
