package com.example.e1695793.touristia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
//import android.text.Html;
//import android.text.TextUtils;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Picasso;

import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CircuitAdapter extends RecyclerView.Adapter<CircuitAdapter.CustomViewHolder> {

    private List<Circuit> circuitList;
    private Context mContext;

    public CircuitAdapter(Context context, List<Circuit> feedItemList) {
        this.circuitList = feedItemList;
        this.mContext = context;
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_circuit, viewGroup,false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder customViewHolder, int i) {
        Circuit circuit = circuitList.get(i);

        //Render image using Picasso library
     if (!TextUtils.isEmpty(circuit.getUrlImage())) {

          String url = "https://circuitvoyage.000webhostapp.com/pochettes/4ae51220e772299da34354965f2aae8acf0a73be.jpg";

          Picasso.with(mContext).load(url)
                    .error(R.drawable.koala)
                    .placeholder(R.drawable.iconcircuit)
                    .into(customViewHolder.imageView);
       }

        //Setting text view title
/*        customViewHolder.textViewTitre.setText(circuit.getNom());
        customViewHolder.textViewDesc.setText(circuit.getDescription());*/

        customViewHolder.textViewTitre.setText("circuit "+i);
        customViewHolder.textViewDesc.setText(circuit.getNom());

        //customViewHolder.imageView.setImageURI(uriImg);
/*      Glide.with(mContext).load("https://circuitvoyage.000webhostapp.com/pochettes/4ae51220e772299da34354965f2aae8acf0a73be.jpg")
                .fitCenter()
                .into(customViewHolder.imageView);*/
    }

    @Override
    public int getItemCount() {
        return (null != circuitList ? circuitList.size() : 0);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView textViewTitre;
        protected TextView textViewDesc;

        public CustomViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.img_circuit);
            this.textViewTitre = (TextView) view.findViewById(R.id.titre_circuit);
            this.textViewDesc = (TextView) view.findViewById(R.id.desc_circuit);
        }
    }
}
