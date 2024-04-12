package com.example.projetandroiderwando.ui.map;

import static com.google.android.gms.maps.CameraUpdateFactory.newLatLng;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.projetandroiderwando.R;
import com.example.projetandroiderwando.databinding.FragmentMapBinding;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MapFragment extends Fragment implements OnMapReadyCallback  {

    private FragmentMapBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_map, container, false);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.mapFragment);

        if (mapFragment != null) {
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    List<Parcours> parcours = new ArrayList<>();
                    parcours.add(new Parcours(new LatLng(-33.852, 151.211), "Sydney"));
                    parcours.add(new Parcours(new LatLng(-33.852, 151.211), "Sydney"));
                    parcours.add(new Parcours(new LatLng(-33.852, 151.211), "Sydney"));

                    List<Parcours> parcoursList = JsonUtility.readJsonFromRaw(requireContext());
                    if (parcoursList != null) {
                        for (Parcours itineraire: parcoursList) {
                            // Faites quelque chose avec chaque objet Parcours
                        }
                    }
                    parcours.forEach(itineraire -> {
                        googleMap.moveCamera(newLatLng(itineraire.getLatLng()));
                        MarkerOptions options = new MarkerOptions()
                                .position(itineraire.getLatLng())
                                .title(itineraire.getVille())
                                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                        googleMap.addMarker(options);
                    });
                }
            });
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }
}