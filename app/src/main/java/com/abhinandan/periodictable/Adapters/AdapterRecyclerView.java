package com.abhinandan.periodictable.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.abhinandan.periodictable.Activites.InfoActivity;
import com.abhinandan.periodictable.AppData.AppData;
import com.abhinandan.periodictable.R;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.util.Hex;


import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private Context context;

    public AdapterRecyclerView(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_element,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.symbol.setText(AppData.getInstance().getElement().get(position).getSymbol());
        holder.name.setText(AppData.getInstance().getElement().get(position).getName());
        holder.number.setText(AppData.getInstance().getElement().get(position).getAtomicNumber());
        holder.mass.setText(AppData.getInstance().getElement().get(position).getAtomicMass());
        Log.e("Color Error","Color " + AppData.getInstance().getElement().get(position).getColor());
        Bitmap bitmap = BitmapFactory.decodeByteArray( AppData.getInstance().getElement().get(position).getColor().getBytes(),0, AppData.getInstance().getElement().get(position).getColor().length());


        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked! "+ AppData.getInstance().getElement().get(position).getName(), Toast.LENGTH_SHORT).show();
                AppData.getInstance().getValues().clear();

                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getName());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getSymbol());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getAtomicMass());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getAtomicNumber());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getStandardState());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getAtomicRedius());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getBoilingPoint());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getBondingType());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getDensity());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getElectronAffinity());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getElectroNegativity());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getElectronicConfiguration());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getGroupBlock());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getMeltingPoint());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getOxidationSate());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getVanDelWallsRadius());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getYearDiscovered());
                AppData.getInstance().getValues().add(AppData.getInstance().getElement().get(position).getIonizationEnergy());


                AppData.getInstance().getDrawables().add(R.drawable.name);
                AppData.getInstance().getDrawables().add(R.drawable.bg);
                AppData.getInstance().getDrawables().add(R.drawable.bg);
                AppData.getInstance().getDrawables().add(R.drawable.bg);
                AppData.getInstance().getDrawables().add(R.drawable.state);
                AppData.getInstance().getDrawables().add(R.drawable.radius);
                AppData.getInstance().getDrawables().add(R.drawable.boling);
                AppData.getInstance().getDrawables().add(R.drawable.bonding);
                AppData.getInstance().getDrawables().add(R.drawable.density);
                AppData.getInstance().getDrawables().add(R.drawable.bg);
                AppData.getInstance().getDrawables().add(R.drawable.bg);
                AppData.getInstance().getDrawables().add(R.drawable.configuration);
                AppData.getInstance().getDrawables().add(R.drawable.bg);
                AppData.getInstance().getDrawables().add(R.drawable.boling);
                AppData.getInstance().getDrawables().add(R.drawable.bg);
                AppData.getInstance().getDrawables().add(R.drawable.vandelwall);
                AppData.getInstance().getDrawables().add(R.drawable.discovery);
                AppData.getInstance().getDrawables().add(R.drawable.energy);



                AppData.getInstance().getNames().add("Name");
                AppData.getInstance().getNames().add("Symbol");
                AppData.getInstance().getNames().add("Atomic Mass");
                AppData.getInstance().getNames().add("Atomic Number");
                AppData.getInstance().getNames().add("State");
                AppData.getInstance().getNames().add("Atomic Radius");
                AppData.getInstance().getNames().add("Boiling Point");
                AppData.getInstance().getNames().add("Bonding Type");
                AppData.getInstance().getNames().add("Density");
                AppData.getInstance().getNames().add("Electron Affinity");
                AppData.getInstance().getNames().add("ElectroNegativity");
                AppData.getInstance().getNames().add("Electronic configuration");
                AppData.getInstance().getNames().add("Group Block");
                AppData.getInstance().getNames().add("Melting Point");
                AppData.getInstance().getNames().add("Oxidation State");
                AppData.getInstance().getNames().add("VandelWall Radius");
                AppData.getInstance().getNames().add("Discovery Year");
                AppData.getInstance().getNames().add("Ionization Energy");

                Intent intent = new Intent(context, InfoActivity.class);
                context.startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return AppData.getInstance().getElement().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView image;
        private TextView symbol;
        private TextView name;
        private TextView number;
        private TextView mass;
        private CardView parent;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.itemImage);
            symbol = itemView.findViewById(R.id.itemSymbol);
            name = itemView.findViewById(R.id.itemName);
            number = itemView.findViewById(R.id.itemNumber);
            mass = itemView.findViewById(R.id.itemMass);
            parent = itemView.findViewById(R.id.itemParent);

        }
    }
}
