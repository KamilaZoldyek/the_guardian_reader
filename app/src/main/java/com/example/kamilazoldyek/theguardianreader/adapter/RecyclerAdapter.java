package com.example.kamilazoldyek.theguardianreader.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kamilazoldyek.theguardianreader.R;
import com.example.kamilazoldyek.theguardianreader.model.Result;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerAdapterViewHolder> {

    private List<Result> resultList;
    String headline, date;
    Context mContext;

    public RecyclerAdapter(List<Result> resultList, Context mContext) {
        this.resultList = resultList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.card_item, viewGroup, false);
        final RecyclerAdapter.RecyclerAdapterViewHolder vHolder = new RecyclerAdapterViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerAdapterViewHolder holder, int position) {

        final Result result = resultList.get(position);

        // TODO: 26/04/19 show headline and date 
        // TODO: 26/04/19 review the card_item xml and update it 
        //headlineTV = String.valueOf(result.getWebTitle());


    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }



    public class RecyclerAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public LinearLayout card_item;
        public TextView headlineTV;
        public TextView dateTV;




        public RecyclerAdapterViewHolder(View v) {
            super(v);

            // TODO: 26/04/19 findviewbyID & setOnclicklistener
        }

        @Override
        public void onClick(View view) {

            // TODO: 26/04/19 open webview 

        }
    }
}
