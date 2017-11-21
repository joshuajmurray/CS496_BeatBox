package com.jmurray.android.beatbox;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by joshua on 11/20/2017.
 */
public class SoundViewModelTest {
    private BeatBox mBeatbox;
    private Sound mSound;
    private SoundViewModel mSubject;

    @Before
    public void setUp() throws Exception {
        mBeatbox = mock(BeatBox.class);
        mSound = new Sound("assettPath");
        mSubject = new SoundViewModel(mBeatbox);
        mSubject.setSound(mSound);
    }

    @Test
    public void exposesSoundNameAsTitle() {
        assertThat(mSubject.getTitle(), is(mSound.getmName()));
    }

    @Test
    public void CallsBeatBoxPlayOnButtonClicked() {
        mSubject.onButtonClicked();
        
        verify(mBeatbox).play(mSound);
    }

    private BeatBox verify(BeatBox mBeatbox) {
    }

}