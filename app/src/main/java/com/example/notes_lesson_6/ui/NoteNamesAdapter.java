package com.example.notes_lesson_6.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notes_lesson_6.R;
import com.example.notes_lesson_6.repository.CardData;
import com.example.notes_lesson_6.repository.CardSource;

public class NoteNamesAdapter extends RecyclerView.Adapter<NoteNamesAdapter.MyViewHolder> {
    private CardSource cardSource;
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setData(CardSource cardSource) {
        this.cardSource = cardSource;
        notifyDataSetChanged();
    }

    NoteNamesAdapter(CardSource cardSource) {
        this.cardSource = cardSource;
    }

    NoteNamesAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater.inflate(R.layout.fragment_notes_names_cardview_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindContentWithLayout(cardSource.getCardData(position));

    }

    @Override
    public int getItemCount() {
        return cardSource.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewName;
        private TextView textViewDescription;
        private ImageView imageView;
        private CheckBox checkBox;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.cardViewNoteName);
            textViewDescription = (TextView) itemView.findViewById(R.id.cardViewNoteDescription);
            imageView = (ImageView) itemView.findViewById(R.id.CardViewImage);
            checkBox = (CheckBox) itemView.findViewById(R.id.cardViewLike);


            /*textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null){
                        onItemClickListener.onItemClick(getLayoutPosition());

                    }
                }
            });

             */
        }

        public void bindContentWithLayout(CardData content) {
            textViewName.setText(content.getNoteName());
            textViewDescription.setText(content.getDescription());
            imageView.setImageResource(content.getPicture());
            checkBox.setChecked(content.isLike());

        }
    }
}
