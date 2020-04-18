package com.example.radiobuttonwithrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class RadioAdapter<P> extends RecyclerView.Adapter<RadioAdapter.ViewHolder> {
    private int mSelectedItem = -1;
    List<Person> personList;
    private Context context;

    RadioAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @Override
    public void onBindViewHolder(RadioAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.radioBtn.setChecked(i == mSelectedItem);
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.model_layout_design, viewGroup, false);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RadioButton radioBtn;
        TextView radioBtnTv;

        ViewHolder(final View parentView) {
            super(parentView);

            radioBtn = parentView.findViewById(R.id.radioBtnId);
            radioBtnTv = parentView.findViewById(R.id.radioBtnTvId);

            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSelectedItem = getAdapterPosition();
                    notifyItemRangeChanged(0, personList.size());
                }
            };
            itemView.setOnClickListener(clickListener);
            radioBtn.setOnClickListener(clickListener);
        }
    }
}
