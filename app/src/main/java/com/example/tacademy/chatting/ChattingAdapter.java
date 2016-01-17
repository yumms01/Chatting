package com.example.tacademy.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2016-01-16.
 */
public class ChattingAdapter extends BaseAdapter {
    ArrayList<ChattingData> items = new ArrayList<ChattingData>();

    private static final int VIEW_TYPE_COUNT = 2;

    private static final int TYPE_RECEIVE = 0;
    private static final int TYPE_SEND = 1;

    public void add(ChattingData data) {
        items.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        ChattingData data = items.get(position);
        if (data instanceof ReceiveData) {
            return TYPE_RECEIVE;
        } else {
            return TYPE_SEND;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case TYPE_RECEIVE: {
                ReceiveView view;
                if (convertView != null && convertView instanceof ReceiveView) {
                    view = (ReceiveView) convertView;
                } else {
                    view = new ReceiveView(parent.getContext());
                }
                view.setData((ReceiveData) items.get(position));
                return view;
            }

            case TYPE_SEND: {
                SendView view;
                if (convertView != null && convertView instanceof SendView) {
                    view = (SendView) convertView;
                } else {
                    view = new SendView(parent.getContext());
                }
                view.setData((SendData) items.get(position));
                return view;
            }

        }
        return convertView;
    }
}
