package com.abhinandan.periodictable.Adapters;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abhinandan.periodictable.AppData.AppData;
import com.abhinandan.periodictable.R;
import com.bumptech.glide.Glide;

import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterValue extends RecyclerView.Adapter<AdapterValue.ViewHolder> {

    private Context context;
    private TextToSpeech textToSpeech;

    public AdapterValue(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_values,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {


        holder.name.setText(AppData.getInstance().getNames().get(position));
        holder.value.setText(AppData.getInstance().getValues().get(position));
        Glide.with(context)
                .load(AppData.getInstance().getDrawables().get(position))
                .placeholder(R.color.pink)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return AppData.getInstance().getValues().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView name, value;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.valueImage);
            name = itemView.findViewById(R.id.valueName);
            value =  itemView.findViewById(R.id.valueValue);
            parent = itemView.findViewById(R.id.valueParent);
        }
    }
}
