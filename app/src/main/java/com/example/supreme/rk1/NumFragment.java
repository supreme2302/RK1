package com.example.supreme.rk1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NumFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        final LinearLayout relativeLayout = (LinearLayout) inflater.inflate(R.layout.one_more, container, false);
        TextView tvNum = relativeLayout.findViewById(R.id.tv_one_more);
        if (bundle != null) {
            tvNum.setText(bundle.getString("num"));
            String color = bundle.getString("color");
            if (color.equals("blue")) {
                tvNum.setTextColor(Color.parseColor("#0000ff"));
            }
        }

        return relativeLayout;
    }

}
