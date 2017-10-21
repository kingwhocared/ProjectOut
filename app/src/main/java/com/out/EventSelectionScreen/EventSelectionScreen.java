package com.out.EventSelectionScreen;

/**
 * Created by Victor on 22/09/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.out.R;

import java.util.ArrayList;

public class EventSelectionScreen extends Fragment {
    public static ArrayList<EventSelectable> privateChatsList;
    private ListView contactSelectableListView;
    private EventSelectionAdapter eventSelectionAdapter;
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
        this.privateChatsList.add(new EventSelectable("Leganski bar", null));
        this.privateChatsList.add(new EventSelectable("Football friday", null));
        this.privateChatsList.add(new EventSelectable("Yoni's birthday", null));
        this.privateChatsList.add(new EventSelectable("The wanted unwanted", null));
        this.privateChatsList.add(new EventSelectable("Bob's furious seven", null));
        this.privateChatsList.add(new EventSelectable("Rick and morty club", null));
        View view = inflater.inflate(R.layout.private_chat_selection, container, false);
        contactSelectableListView = (ListView) view.findViewById(R.id.privateChatsListView);

        contactSelectableListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        contactSelectableListView.setStackFromBottom(false);

        eventSelectionAdapter = new EventSelectionAdapter(getActivity(),privateChatsList );

        contactSelectableListView.setAdapter(eventSelectionAdapter);

        return view;
    }

    public void onButtonClick(View view) {
        Log.println(Log.ERROR, "poop", "poop");
    }
}
