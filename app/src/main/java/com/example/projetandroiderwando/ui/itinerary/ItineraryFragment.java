package com.example.projetandroiderwando.ui.itinerary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.projetandroiderwando.R;
import com.example.projetandroiderwando.databinding.FragmentItineraryBinding;

public class ItineraryFragment extends Fragment {

    private FragmentItineraryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_itinerary, container, false);

        EditText editTextSource = root.findViewById(R.id.source);
        EditText editTextDestination = root.findViewById(R.id.destination);
        Button button = root.findViewById(R.id.btnSubmit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String source = editTextSource.getText().toString();
                String destination = editTextDestination.getText().toString();
                if(source.isEmpty() && destination.isEmpty()){
                    Toast.makeText(getContext(), "Veuillez préciser un départ et une arrivée",
                            Toast.LENGTH_LONG).show();
                }
                else {
                    Uri uri = Uri.parse("https://www.google.com/maps/dir/" + source + "/"
                            + destination);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.apps.maps");
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}