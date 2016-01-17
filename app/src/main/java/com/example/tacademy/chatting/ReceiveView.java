package com.example.tacademy.chatting;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Tacademy on 2016-01-16.
 */
public class ReceiveView extends FrameLayout {
    public ReceiveView(Context context) {
        super(context);
        init();
    }

    ImageView iconView;
    TextView messageView;
    ReceiveData data;
    TextView timeText;

    private void init() {
        inflate(getContext(), R.layout.view_receive, this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        messageView = (TextView)findViewById(R.id.text_message);
        timeText = (TextView)findViewById((R.id.text_time));
    }

    public void setData (ReceiveData data) {
        this.data = data;
        iconView.setImageResource(data.iconId);
        messageView.setText(data.message);
        timeText.setText(data.date);
    }
}
