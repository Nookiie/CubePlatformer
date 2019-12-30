package com.example.cubeplatformer;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class GameFragment extends Fragment {

    public GameFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Display display =
                getActivity().getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        IvanGameView ivanGameView = new IvanGameView(getActivity(), size.x, size.y);

        return ivanGameView;
    }
}
