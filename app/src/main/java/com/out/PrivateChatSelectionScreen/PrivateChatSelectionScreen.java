package com.out.PrivateChatSelectionScreen;

/**
 * Created by Victor on 22/09/2017.
 */

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.out.R;

import com.out.PrivateChatScreen.*;

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
        this.privateChatsList.add(new ChatSelectable("doggo 1", null));
        this.privateChatsList.add(new ChatSelectable("doggo 2", null));
        this.privateChatsList.add(new ChatSelectable("doggo 3", null));
        this.privateChatsList.add(new ChatSelectable("doggo 4", null));
        this.privateChatsList.add(new ChatSelectable("doggo 5", null));
        View view = inflater.inflate(R.layout.private_chat_selection, container, false);
        contactSelectableListView = (ListView) view.findViewById(R.id.privateChatsListView);

        contactSelectableListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        contactSelectableListView.setStackFromBottom(false);

        chatSelectionAdapter = new ChatSelectionAdapter(getActivity(),privateChatsList );

        contactSelectableListView.setAdapter(chatSelectionAdapter);

        return view;
    }

    public void onChatSelected(View view) {
        this.getActivity().setContentView(new Chat().onCreateView(inflater, container, savedInstanceState));
    }

}
