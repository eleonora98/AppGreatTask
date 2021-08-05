package com.example.appgreattask.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appgreattask.ImagesFragment.ImageItem;
import com.example.appgreattask.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> implements Filterable {

    int[] arr;
    Context context;
    List<ImageItem> list;
    List<ImageItem> filteredItemList;

    public RecyclerViewAdapter(Context context, List<ImageItem> list) {
        this.context = context;
        this.list = list;
        this.filteredItemList=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_image_view, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ImageItem item = filteredItemList.get(position);
        holder.setImageView(item.getImageUrl());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getImageUrl()));
               context.startActivity(intent);
            }
        });

    }

    public ImageItem getItem(int position){
        return filteredItemList.get(position);
    }

    @Override
    public int getItemCount() {
        return filteredItemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void setImageView(String url) {
            imageView = itemView.findViewById(R.id.imageView);
            Glide.with(context).load(url).into(imageView);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    filteredItemList = list;
                } else {
                    List<ImageItem> filteredList = new ArrayList<>();
                    for (ImageItem item : list) {
                        if (item.getTags().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(item);
                        }
                    }
                    filteredItemList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredItemList;
                filterResults.count = filteredItemList.size();
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredItemList = (ArrayList<ImageItem>) filterResults.values;

                notifyDataSetChanged();
            }
        };
    }
}
