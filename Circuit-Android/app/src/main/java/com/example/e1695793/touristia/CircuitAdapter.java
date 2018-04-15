package com.example.e1695793.touristia;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
//import android.text.Html;
//import android.text.TextUtils;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_circuit, viewGroup, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder customViewHolder, int i) {
        Circuit circuit = circuitList.get(i);

        //Render image using Picasso library
        if (!TextUtils.isEmpty(circuit.getUrlImage())) {

            String url = "https://circuitvoyage.000webhostapp.com/pochettes/4ae51220e772299da34354965f2aae8acf0a73be.jpg";

            Picasso.with(mContext).load(circuit.getUrlImage())
                    .error(R.drawable.koala)
                    .placeholder(R.drawable.iconcircuit)
                    .into(customViewHolder.imageView);
        }

        customViewHolder.textViewTitre.setText(circuit.getNom());
        final String description = circuit.getDescription();
        final String prix = "$"+circuit.getPrix();

        customViewHolder.btn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (customViewHolder.layout_more.isShown()) {
                    customViewHolder.textViewDesc.setText("");
                    customViewHolder.layout_more.setVisibility(View.GONE);
                    customViewHolder.btn_more.setImageResource(R.drawable.keyboard_arrow_down_grey_48x48);
                } else {
                    customViewHolder.layout_more.setVisibility(View.VISIBLE);
                    customViewHolder.textViewDesc.setText(Html.fromHtml(description));
                    customViewHolder.txt_prix.setText(prix);
                    customViewHolder.btn_more.setImageResource(R.drawable.keyboard_arrow_up_grey_48x48);
                }
            }
        });
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
        protected Button btn_acheter;
        protected Button btn_detail;
        protected ImageView btn_more;
        protected LinearLayout layout_more;
        protected TextView txt_prix;



        public CustomViewHolder(View view) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.img_circuit);
            this.textViewTitre = (TextView) view.findViewById(R.id.titre_circuit);
            this.textViewDesc = (TextView) view.findViewById(R.id.desc_circuit);
            this.btn_more = (ImageView) view.findViewById(R.id.btnImg_more);
            this.layout_more = (LinearLayout) view.findViewById(R.id.detail_layout);
            this.txt_prix = (TextView) view.findViewById(R.id.prix_circuit);

        }
    }
}
