package com.out.EventSelectionScreen;

import android.widget.ImageView;

/**
 * Created by Victor on 22/09/2017.
 */

public class EventSelectable {
    public String eventName;
    public ImageView eventPicture;

    public EventSelectable(String eventName, ImageView eventPicture) {
        this.eventName = eventName;
        this.eventPicture = eventPicture;
    }
}
