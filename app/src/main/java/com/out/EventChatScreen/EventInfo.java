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
import android.widget.TextView;

import com.out.CommonMethods;
import com.out.MessagesContentView.ChatMessage;
import com.out.MessagesContentView.ChatMessageAdapter;
import com.out.R;

import java.util.ArrayList;
import java.util.Random;

public class EventInfo extends Fragment {

    private static EventInfo eventInfo = null;

    private String eventTime;
    private String eventDate;
    private String eventLocation;
    private View view;

    public static EventInfo getInstance() {
        if (eventInfo == null) {
            eventInfo = new EventInfo();
        }
        return eventInfo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.event_info_layout, container, false);
        this.view = view;

        this.updateLocation("Hertzel st. 25");
        this.updateDate("18/09/2017");
        this.updateTime("21:15");
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

    public void updateLocation(String eventLocation){
        this.eventLocation = eventLocation;
        ((TextView) (view.findViewById(R.id.eventlocationView))).setText(this.eventLocation);
    }
    public void updateDate(String eventDate){
        this.eventDate = eventDate;
        ((TextView) (view.findViewById(R.id.eventdateView))).setText(this.eventDate);
    }
    public void updateTime(String eventTime){
        this.eventTime = eventTime;
        ((TextView) (view.findViewById(R.id.eventtimeView))).setText(this.eventTime);
    }
}