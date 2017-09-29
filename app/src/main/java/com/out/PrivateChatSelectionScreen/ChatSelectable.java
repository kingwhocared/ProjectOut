package com.out.PrivateChatSelectionScreen;

import android.widget.ImageView;

/**
 * Created by Victor on 22/09/2017.
 */

public class ChatSelectable {
    public String contactName;
    public ImageView contactPicture;

    public ChatSelectable(String contactName, ImageView contactPicture) {
        this.contactName = contactName;
        this.contactPicture = contactPicture;
    }
}
