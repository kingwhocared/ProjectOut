package com.out.EventChatScreen;

/**
 * Created by Victor on 21/09/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.out.CommonMethods;
import com.out.MessagesContentView.ChatMessage;
import com.out.MessagesContentView.ChatMessageAdapter;
import com.out.R;

import java.util.ArrayList;
import java.util.Random;

public class EventInfo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_info_layout, container, false);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

}