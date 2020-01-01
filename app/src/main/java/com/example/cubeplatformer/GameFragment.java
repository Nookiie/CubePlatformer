package com.example.cubeplatformer;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cubeplatformer.Common.GameTracker;


public class GameFragment extends Fragment {

    private static MediaPlayer mediaPlayer;

    public GameFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Display display =
                getActivity().getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        IvanGameView ivanGameView = new IvanGameView(getActivity(), GameTracker.getViewSize().x, GameTracker.getViewSize().y);
        ivanGameView.surfaceHolder.setFixedSize(GameTracker.getScreenSize().x, GameTracker.getScreenSize().y);

        playMusic();
        return ivanGameView;
    }

    public void playMusic() {
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lv1);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();


    }

    public static void stopMusic() {
        mediaPlayer.stop();
    }
}
