package com.example.utsav.checkbox;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private Context context;
    private ArrayList<UserData> dataArrayList=new ArrayList<>();
    private PostsAdapterListener listener;




    public DataAdapter(Context context, ArrayList<UserData> dataArrayList, PostsAdapterListener listener) {
        this.context = context;
        this.dataArrayList = dataArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_data_row, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataViewHolder holder, int position) {

        final UserData userData = dataArrayList.get(position);
        holder.name.setText(userData.getName());
        if (userData.getSelected()){
            holder.imageViewcheck.setVisibility(View.VISIBLE);
            holder.imageView.setVisibility(View.GONE);
        }else {
            holder.imageView.setVisibility(View.VISIBLE);
            holder.imageViewcheck.setVisibility(View.GONE);
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imageView.setVisibility(View.GONE);
                holder.imageViewcheck.setVisibility(View.VISIBLE);
                userData.setSelected(true);
                listener.onPostClicked(userData);

            }
        });
        holder.imageViewcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imageView.setVisibility(View.VISIBLE);
                holder.imageViewcheck.setVisibility(View.GONE);
                userData.setSelected(false);
                listener.onPostClicked(userData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView imageView,imageViewcheck;

        public DataViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            imageView = itemView.findViewById(R.id.checkbox);
            imageViewcheck=itemView.findViewById(R.id.checkboxcheck);
        }
    }
    public interface PostsAdapterListener {
        void onPostClicked(UserData post);
    }
}
