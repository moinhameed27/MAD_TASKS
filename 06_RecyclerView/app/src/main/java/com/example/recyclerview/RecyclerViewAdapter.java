package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;


    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {
        String data[];

        public RecyclerViewAdapter(String[] data) {
            this.data = data;
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.item_layout, parent, false);
            return new Holder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            holder.t1.setText(data[position]);
        }

        @Override
        public int getItemCount() {
            return data.length;
        }

        public static class Holder extends RecyclerView.ViewHolder {
            TextView t1;

            public Holder(@NonNull View itemView) {
                super(itemView);
                t1 = itemView.findViewById(R.id.t1);
            }
        }
    }

