package com.example.baihat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BaiHatAdapter extends ArrayAdapter<BaiHat> {
    public BaiHatAdapter(@NonNull Context context, int resource, @NonNull BaiHat[] objects) {
        super(context, resource, objects);
    }

    public BaiHatAdapter(@NonNull Context context, int resource, @NonNull List<BaiHat> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if(v==null){
            LayoutInflater vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.items,null);

        }
        BaiHat baiHat = getItem(position);
        if(baiHat!=null){
            TextView tv0 = (TextView) v.findViewById(R.id.textViewName);
            TextView tv1 = (TextView) v.findViewById(R.id.textViewSinger);
            TextView tv2 = (TextView) v.findViewById(R.id.textViewTime);
            tv0.setText(baiHat.Name);
            tv1.setText(baiHat.Singer);
            tv2.setText(String.valueOf(baiHat.Time));
        }
        return v;
    }
}
