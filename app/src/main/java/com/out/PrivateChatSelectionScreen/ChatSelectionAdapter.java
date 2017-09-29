package com.out.PrivateChatSelectionScreen;

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

public class ChatSelectionAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    ArrayList<ChatSelectable> privateChatsList;

    public ChatSelectionAdapter(Activity activity, ArrayList<ChatSelectable> list) {
        privateChatsList = list;
        inflater = (LayoutInflater) activity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ChatSelectable chatSelectable = (ChatSelectable) privateChatsList.get(position);
        View vi = convertView;
        if (convertView == null)
            vi = inflater.inflate(R.layout.chat_selectable_button, null);

        TextView contactNameTextView = (TextView) vi.findViewById(R.id.contact_selectable_name);
        contactNameTextView.setText(chatSelectable.contactName);


        return vi;
    }

    @Override
    public int getCount() {
        return privateChatsList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public Object getItem(int position) {
        return this.privateChatsList.get(position);
    }

    public void add(ChatSelectable object) {
        privateChatsList.add(object);
    }
}

