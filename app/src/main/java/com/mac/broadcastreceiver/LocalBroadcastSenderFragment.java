package com.mac.broadcastreceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LocalBroadcastSenderFragment extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View v = inflater.inflate(
                R.layout.fragment_two, container, false);
        v.findViewById(R.id.send).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent("constant");
        LocalBroadcastManager.getInstance(getActivity()).sendBroadcast(intent);
    }
}