package com.example.notes_lesson_6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NotesFolderAdapter extends RecyclerView.Adapter<NotesFolderAdapter.MyViewHolder> {
    private String[] data;
    OnClickItemListener onClickItemListener;

    public void setData(String[] data) {
        this.data = data;
        notifyDataSetChanged();
    }
    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }
    NotesFolderAdapter(){
    }
    NotesFolderAdapter(String[] data){
        this.data = data;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        layoutInflater.inflate(R.layout.fragment_folders_list_item, parent, false);
        return new MyViewHolder(layoutInflater.inflate(R.layout.fragment_folders_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindContentWithLayout(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView;
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onClickItemListener != null){
                        onClickItemListener.onItemClick(getAdapterPosition());
                    }

                }
            });
        }

        public void bindContentWithLayout(String content) {
            textView.setText(content);
        }
    }
}
