package com.example.examplelist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MultiImageAdapter extends RecyclerView.Adapter<MultiImageAdapter.ViewHolder> {

    private Context context;
    private ArrayList<String> imageList = new ArrayList<>();
    private View view;

    public MultiImageAdapter(Context context) {
        this.context = context;
    }

    public void setImageList(ArrayList<String> imageList) {
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public MultiImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        view = LayoutInflater.from(context).inflate(R.layout.multi_image_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MultiImageAdapter.ViewHolder holder, int position) {
        String image = imageList.get(position);
        Log.d("Adapter", "이미지 URL : " + image);

        Glide.with(view).load(image).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_view);
        }
    }
}
