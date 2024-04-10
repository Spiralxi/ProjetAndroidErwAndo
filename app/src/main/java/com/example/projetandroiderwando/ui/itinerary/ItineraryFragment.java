package com.example.projetandroiderwando.ui.itinerary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.projetandroiderwando.databinding.FragmentItineraryBinding;

public class ItineraryFragment extends Fragment {

    private FragmentItineraryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ItineraryViewModel itineraryViewModel =
                new ViewModelProvider(this).get(ItineraryViewModel.class);

        binding = FragmentItineraryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textItinerary;
        itineraryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}