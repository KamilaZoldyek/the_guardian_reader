package com.example.kamilazoldyek.theguardianreader.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.kamilazoldyek.theguardianreader.R;
import com.example.kamilazoldyek.theguardianreader.model.Result;
import com.example.kamilazoldyek.theguardianreader.util.DateFormat;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerAdapterViewHolder> {

    private List<Result> resultList;
    private Context mContext;

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
        String section = result.getSectionName();

        holder.formattedDate = DateFormat.DateFormat(String.valueOf(result.getWebPublicationDate()));
        holder.cardItem.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition));
        holder.headlineTV.setText(String.valueOf(result.getWebTitle()));
        holder.sectionTV.setText(section);
        holder.dateTV.setText(holder.formattedDate);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }


    public class RecyclerAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public CardView cardItem;
        public TextView headlineTV;
        public TextView dateTV;
        public String formattedDate;
        public TextView sectionTV;


        public RecyclerAdapterViewHolder(View v) {
            super(v);
            headlineTV = v.findViewById(R.id.headline_text);
            dateTV = v.findViewById(R.id.dateTime);
            cardItem = v.findViewById(R.id.cardView);
            sectionTV = v.findViewById(R.id.sectionTV);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            String weburl = resultList.get(getAdapterPosition()).getWebUrl();
            int color = mContext.getResources().getColor(R.color.colorPrimaryDark);

            CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();

            builder.setStartAnimations(mContext, R.anim.fade_in_left, R.anim.fade_out_left);
            builder.setExitAnimations(mContext, R.anim.fade_in_right, R.anim.fade_out_right);
            builder.setToolbarColor(color);
            builder.setShowTitle(true);

            CustomTabsIntent customTabsIntent = builder.build();
            customTabsIntent.launchUrl(mContext, Uri.parse(weburl));
        }
    }
}
