package com.example.projetandroiderwando.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projetandroiderwando.R;
import com.example.projetandroiderwando.ui.map.Parcours;

import java.util.List;

public class ParcoursAdapter  extends ArrayAdapter<Parcours> {
   /* public ParcoursAdapter(Context context, List<Parcours> parcoursList) {
        super(context, 0, parcoursList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        Parcours parcours = getItem(position);

        TextView tvNom = convertView.findViewById(android.R.id.text1);

        if (parcours != null) {
            tvNom.setText(parcours.getVille());
        }

        return convertView;
    }*/

    private Context mContext;
    private List<Parcours> mParcoursList;

    public ParcoursAdapter(Context context, List<Parcours> parcoursList) {
        super(context, R.layout.list_item_parcours, parcoursList);
        mContext = context;
        mParcoursList = parcoursList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item_parcours, parent, false);
        }

        Parcours currentParcours = mParcoursList.get(position);

        TextView nomTextView = listItem.findViewById(R.id.text_nom);
        nomTextView.setText(currentParcours.getNom());

        TextView regionTextView = listItem.findViewById(R.id.text_region);
        regionTextView.setText("Region: " + currentParcours.getRegion());

        TextView distanceTextView = listItem.findViewById(R.id.text_distance);
        distanceTextView.setText("Distance: " + currentParcours.getDistance() + " km");

        TextView dureeTextView = listItem.findViewById(R.id.text_duree);
        dureeTextView.setText("Durée: " + currentParcours.getDuree());

        TextView deniveleTextView = listItem.findViewById(R.id.text_denivele);
        deniveleTextView.setText("Dénivelé: " + currentParcours.getDenivele() + " m");

        return listItem;
    }
}
