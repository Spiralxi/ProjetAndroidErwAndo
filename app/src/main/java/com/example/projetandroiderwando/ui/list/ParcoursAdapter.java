package com.example.projetandroiderwando.ui.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projetandroiderwando.ui.map.Parcours;

import java.util.List;

public class ParcoursAdapter  extends ArrayAdapter<Parcours> {
    public ParcoursAdapter(Context context, List<Parcours> parcoursList) {
        super(context, 0, parcoursList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        Parcours parcours = getItem(position);

        TextView tvNom = convertView.findViewById(android.R.id.text1);

        if (parcours != null) {
            tvNom.setText(parcours.getVille());
        }

        return convertView;
    }
}
