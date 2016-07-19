package com.mac.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LocalBroadcastReceiverFragment extends Fragment {
    private TextView receiveText;
    private int count = 1;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(mSelectionReceiver,
                new IntentFilter("constant"));

        View v = inflater.inflate(
                R.layout.fragment_one, container, false);
        receiveText = (TextView) v.findViewById(R.id.receiveText);
        return v;
    }

    private BroadcastReceiver mSelectionReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            receiveText.setText("BC received: "+count++);

        }
    };

    @Override
    public void onDestroy() {
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(mSelectionReceiver);
        super.onDestroy();
    }
}