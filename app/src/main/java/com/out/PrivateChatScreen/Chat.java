package com.out.PrivateChatScreen;

/**
 * Created by Victor on 21/09/2017.
 */

        import java.util.ArrayList;
        import java.util.Random;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.ViewGroup;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import android.widget.ListView;

        import com.out.MessagesContentView.ChatMessage;
        import com.out.MessagesContentView.ChatMessageAdapter;
        import com.out.CommonMethods;
        import com.out.R;

public class Chat extends Fragment implements OnClickListener {

    private EditText msg_edittext;
    private String user1 = "khushi", user2 = "khushi1";
    private Random random;
    public ArrayList<ChatMessage> chatlist;
    public ChatMessageAdapter chatMessageAdapter;
    ListView msgListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.private_chat_layout, container, false);
        random = new Random();
        msg_edittext = (EditText) view.findViewById(R.id.messageEditText);
        msgListView = (ListView) view.findViewById(R.id.msgListView);
        ImageButton sendButton = (ImageButton) view
                .findViewById(R.id.sendMessageButton);
        sendButton.setOnClickListener(this);

        // ----Set autoscroll of listview when a new message arrives----//
        msgListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        msgListView.setStackFromBottom(true);

        chatlist = new ArrayList<ChatMessage>();
        chatMessageAdapter = new ChatMessageAdapter(getActivity(), chatlist);
        msgListView.setAdapter(chatMessageAdapter);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

    public void sendTextMessage(View v) {
        String message = msg_edittext.getEditableText().toString();
        if (!message.equalsIgnoreCase("")) {
            final ChatMessage chatMessage = new ChatMessage(user1, user2,
                    message, "" + random.nextInt(1000), true, this);
            chatMessage.setMsgID();
            chatMessage.body = message;
            chatMessage.Date = CommonMethods.getCurrentDate();
            chatMessage.Time = CommonMethods.getCurrentTime();
            msg_edittext.setText("");
            chatMessageAdapter.add(chatMessage);
            chatMessageAdapter.notifyDataSetChanged();
            //MainActivity activity = ((MainActivity) getActivity());
            //activity.getmService().xmpp.sendMessage(chatMessage);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sendMessageButton:
                sendTextMessage(v);
        }
    }

}