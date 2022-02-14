package com.example.clonecoovapp.setup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.clonecoovapp.R;
import com.example.clonecoovapp.common.CommonVal;

import java.util.ArrayList;
import java.util.List;

public class SetupAdapter extends RecyclerView.Adapter<SetupAdapter.ViewHolder> {


    ViewHolder selectedVH = null;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context context;
    List<OptionVO> list;
    LayoutInflater inflater;

    public SetupAdapter(Context context, List<OptionVO> list) {
        this.context = context;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        prefs = context.getSharedPreferences("Setup", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item_setup, parent, false);
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

        TextView option_name, option_selected, option_not_support;
        LinearLayout item_setup;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            option_name = itemView.findViewById(R.id.option_name);
            option_selected = itemView.findViewById(R.id.option_selected);
            option_not_support = itemView.findViewById(R.id.option_not_support);
            item_setup = itemView.findViewById(R.id.item_setup);
        }

        public void bind(@NonNull ViewHolder holder, int i) {

            OptionVO vo = list.get(i);

            // 언제든지 해야하는 것.
            holder.option_name.setText(vo.getName());

            if (!vo.getSupport()) {
                // 지원하지 않을 때 해야하는 것.
                holder.option_not_support.setVisibility(View.VISIBLE);
                holder.option_name.setTextColor(Color.parseColor("#aaaaaa"));
            } else {
                holder.option_selected.setVisibility(View.GONE);
                if (vo.getSelect()) {
                    holder.option_selected.setVisibility(View.VISIBLE);
                    selectedVH = holder;
                }
                holder.item_setup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "야옹", Toast.LENGTH_SHORT).show();
                        resetSelected(i);
                        selectedVH.option_selected.setVisibility(View.GONE);
                        selectedVH = holder;
                        holder.option_selected.setVisibility(View.VISIBLE);
                    }
                });
            }
        }
    }

    private void resetSelected(int i) {
        if (list.get(i).getCategory() == CommonVal.SEL_LANGUAGE) {
            editor.putString("set_language", list.get(i).getName());
        } else {
            editor.putString("set_country", list.get(i).getName());
        }
    }
}
