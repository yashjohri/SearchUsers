package com.example.searchusers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

    private Context context;
    private ArrayList<GithubUser> list;

    public MyAdapter(Context context, ArrayList<GithubUser> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyHolder holder, int position) {

        GithubUser user=list.get(position);

        holder.tvLogin.setText(user.getLogin());
        holder.tvHtml.setText(user.getHtml_url());
        holder.tvScore.setText("Score: "+user.getScore());

        Picasso.get().load( user.getAvatar_url() ).into(holder.ivImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView tvLogin, tvHtml, tvScore;
        ImageView ivImage;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            tvLogin=itemView.findViewById(R.id.tvLogin);
            tvHtml=itemView.findViewById(R.id.tvHtml);
            tvScore=itemView.findViewById(R.id.tvScore);
            ivImage=itemView.findViewById(R.id.ivImage);
        }
    }
}
