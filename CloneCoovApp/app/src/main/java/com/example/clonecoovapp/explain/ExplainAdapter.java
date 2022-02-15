package com.example.clonecoovapp.explain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonecoovapp.R;

import java.util.ArrayList;

public class ExplainAdapter extends RecyclerView.Adapter<ExplainAdapter.ViewHolder>{

    ArrayList<ExplainDTO> list;
    LayoutInflater inflater;
    Context context;

    public ExplainAdapter(ArrayList<ExplainDTO> list, Context context) {
        this.list = list;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_explain, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_ex;
        TextView tv_exTitle, tv_exDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_ex = itemView.findViewById(R.id.img_ex);
            tv_exTitle = itemView.findViewById(R.id.tv_exTitle);
            tv_exDesc = itemView.findViewById(R.id.tv_exDesc);
        }

        public void bind(@NonNull ViewHolder holder, int i){
            ExplainDTO dto = list.get(i);
            holder.img_ex.setImageResource(dto.getImg_id());
            holder.tv_exTitle.setText(dto.getTitle());
            holder.tv_exDesc.setText(dto.getDesc());
        }
    }
}
