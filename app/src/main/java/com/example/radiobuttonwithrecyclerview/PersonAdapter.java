package com.example.radiobuttonwithrecyclerview;

import android.content.Context;

import java.util.List;

public class PersonAdapter extends RadioAdapter<Person> {
    PersonAdapter(Context context, List<Person> personList) {
        super(context, personList);
    }

    @Override
    public void onBindViewHolder(RadioAdapter.ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        viewHolder.radioBtn.setText(personList.get(i).name);
    }
}
