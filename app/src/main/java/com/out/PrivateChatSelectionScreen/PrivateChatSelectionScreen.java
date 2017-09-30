package com.out.PrivateChatSelectionScreen;

/**
 * Created by Victor on 22/09/2017.
 */

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.out.R;

import com.out.PrivateChatScreen.PrivateChatActivity;

public class PrivateChatSelectionScreen extends Fragment {
    public static ArrayList<ChatSelectable> privateChatsList;
    private ListView contactSelectableListView;
    private ChatSelectionAdapter chatSelectionAdapter;
    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        this.savedInstanceState = savedInstanceState;

        this.privateChatsList = new ArrayList<>();
        this.privateChatsList.add(new ChatSelectable("Victor", null));
        this.privateChatsList.add(new ChatSelectable("Adam", null));
        this.privateChatsList.add(new ChatSelectable("Gilad", null));
        this.privateChatsList.add(new ChatSelectable("Matan", null));
        this.privateChatsList.add(new ChatSelectable("Boaz", null));
        this.privateChatsList.add(new ChatSelectable("Genadi", null));
        this.privateChatsList.add(new ChatSelectable("Mom", null));
        this.privateChatsList.add(new ChatSelectable("Banana man", null));
        this.privateChatsList.add(new ChatSelectable("Baby", null));
        this.privateChatsList.add(new ChatSelectable("Barak obama", null));
        this.privateChatsList.add(new ChatSelectable("John snow", null));
        View view = inflater.inflate(R.layout.private_chat_selection, container, false);
        contactSelectableListView = (ListView) view.findViewById(R.id.privateChatsListView);

        contactSelectableListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        contactSelectableListView.setStackFromBottom(false);

        chatSelectionAdapter = new ChatSelectionAdapter(getActivity(),privateChatsList );

        contactSelectableListView.setAdapter(chatSelectionAdapter);

        return view;
    }

    public void onButtonClick(View view) {
        Log.println(Log.ERROR, "poop", "poop");
    }
}
