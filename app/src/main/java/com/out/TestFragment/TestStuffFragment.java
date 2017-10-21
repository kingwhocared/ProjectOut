package com.out.TestFragment;
import com.out.*;

/**
 * Created by Victor on 22/09/2017.
 */

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.out.MessageHub;
import com.out.PrivateChatSelectionScreen.ChatSelectable;
import com.out.PrivateChatSelectionScreen.ChatSelectionAdapter;
import com.out.R;

import java.util.ArrayList;

public class TestStuffFragment extends Fragment implements MessageSubscriber {
    private ChatSelectionAdapter chatSelectionAdapter;
    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        this.savedInstanceState = savedInstanceState;

        View view = inflater.inflate(R.layout.test_stuff_fragment, container, false);

        MessageHub.getInstance().setSubscirber(this);
        this.view = view;
        return view;
    }

    @Override
    public void recieve(Object msg) {
    }
}
