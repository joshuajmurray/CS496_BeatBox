package com.jmurray.android.beatbox;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshua on 11/14/2017.
 */

public class BeatBox {
    private static final String TAG = "BeatBox";

    private static final String SOUNDS_FOLDER = "sample_sounds";
    private static final int MAX_SOUNDS = 5;

    private AssetManager mAssets;
    private List<Sound> mSounds = new ArrayList<>();
    private SoundPool mSoundPool;

    public BeatBox(Context context) {
        mAssets = context.getAssets();
        mSoundPool = new SoundPool(MAX_SOUNDS, AudioManager.STREAM_MUSIC, 0);
        loadSounds();
    }

    public void play(Sound sound) {
        Integer soundId = sound.getmSoundID();
        if(soundId == null) {
            return;
        }
        mSoundPool.play(soundId, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    private void loadSounds() {
        String[] soundNames = {""};//what?
        try {
            soundNames = mAssets.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found" + soundNames.length + " sounds");
        } catch (IOException ioe) {
            Log.e(TAG, "Could not list assets", ioe);
        }

        for (String filename : soundNames) {
            try {
                String assetPath = SOUNDS_FOLDER + "/" + filename;
                Sound sound = new Sound(assetPath);
                load(sound);
                mSounds.add(sound);
            } catch (IOException ioe) {
                Log.e(TAG, "Could not load sound " + filename, ioe);
            }
        }
    }

    private void load(Sound sound) throws IOException {
        AssetFileDescriptor afd = mAssets.openFd(sound.getmAssetPath());
        int soundID = mSoundPool.load(afd, 1);
        sound.setmSoundID(soundID);
    }

    public List<Sound> getmSounds() {
        return mSounds;
    }
}