package com.example.newu.attendancetaker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";


    private ArrayList<StudentBasics> mStudent = new ArrayList<>();

    private Context mContext;;

    public RecyclerViewAdapter(ArrayList<StudentBasics> mStudent, Context mContext) {
        this.mStudent = mStudent;
        this.mContext = mContext;
    }

    @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent
            ,false);
            ViewHolder viewHolder = new ViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

            Log.d(TAG, "onBindViewHolder: called.");
            //Glide.
            StudentBasics msb = mStudent.get(position);
            holder.rollTv.setText(msb.getRoll());
            //holder.statusTv.setText(mStatuses.get(position));
            holder.fullnameTv.setText(msb.getName());

            if (msb.getTick()) {
                holder.tickCb.setChecked(true);
            } else {
                holder.tickCb.setChecked(false);
            }

            holder.statusTv.setText(mStudent.get(position).getStatus());

        }

        @Override
        public int getItemCount() {

            return mStudent.size();
        }





    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView rollTv,fullnameTv,statusTv;
        CheckBox tickCb;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            rollTv = itemView.findViewById(R.id.roll);
            fullnameTv = itemView.findViewById(R.id.fullname);

            tickCb = itemView.findViewById(R.id.tick);
            statusTv = itemView.findViewById(R.id.status);

            //itemView.setOnClickListener(this);

            //checkbox click event handling
            tickCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked) {
                    if (isChecked) {
                        statusTv.setText(R.string.present);
                    } else {
                        statusTv.setText(R.string.absent);
                    }
                    Toast.makeText(mContext,
                            rollTv.getText()+" marked " + statusTv.getText(),
                            Toast.LENGTH_LONG).show();
                }
            });

        }


    }
}
