package com.example.newu.attendancetaker;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mRolls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mStatuses = new ArrayList<>();
    //private ArrayList<String> mTicks = new ArrayList<>();
    private Context mContext;;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mRolls, ArrayList<String> mNames, ArrayList<String> mStatuses) {
        this.mRolls = mRolls;
        this.mNames = mNames;
        this.mStatuses = mStatuses;
        this.mContext = mContext;
    }




        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent
            ,false);
            ViewHolder viewHolder = new ViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

            Log.d(TAG, "onBindViewHolder: called.");
            //Glide.

            holder.rollTv.setText(mRolls.get(position));
            holder.statusTv.setText(mStatuses.get(position));
            holder.fullnameTv.setText(mNames.get(position));

            /*holder.parentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "onCLick: clickedOn"+mNames.get(position));

                    Toast.makeText(mContext, mNames.get(position), Toast.LENGTH_SHORT).show();
                }
            });*/
        }

        @Override
        public int getItemCount() {

            return mNames.size();
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

        }
    }
}
