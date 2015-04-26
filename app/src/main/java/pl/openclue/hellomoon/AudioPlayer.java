package pl.openclue.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Daniel on 2015-04-26.
 */
public class AudioPlayer {
    private MediaPlayer mPlayer;
    private boolean isPaused;

    public void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
        }
    }

    public void play(Context c) {
        if (isPaused) {
            mPlayer.start();
            isPaused = false;
            return;
        }
        stop();
        mPlayer = MediaPlayer.create(c, R.raw.one_small_step);
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mPlayer.start();
    }

    public void pause() {
        if (!isPaused && mPlayer != null) {
            mPlayer.pause();
            isPaused = true;
        }
    }
}
