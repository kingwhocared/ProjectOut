package com.out.EventSelectionScreen;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.out.R;

import java.util.ArrayList;

/**
 * Created by Victor on 22/09/2017.
 */

public class EventSelectionAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    ArrayList<EventSelectable> eventsList;

    public EventSelectionAdapter(Activity activity, ArrayList<EventSelectable> list) {
        eventsList = list;
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        EventSelectable eventSelectable = (EventSelectable) eventsList.get(position);
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.event_selectable_button, null);

        TextView contactNameTextView = (TextView) vi.findViewById(R.id.event_selectable_name);
        contactNameTextView.setText(eventSelectable.eventName);

        return vi;
    }

    @Override
    public int getCount() {
        return eventsList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public Object getItem(int position) {
        return this.eventsList.get(position);
    }

    public void add(EventSelectable object) {
        eventsList.add(object);
    }
}

