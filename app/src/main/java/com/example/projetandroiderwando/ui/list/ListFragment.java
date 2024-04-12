package com.example.projetandroiderwando.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.projetandroiderwando.R;
import com.example.projetandroiderwando.databinding.FragmentListBinding;
import com.example.projetandroiderwando.ui.map.JsonUtility;
import com.example.projetandroiderwando.ui.map.Parcours;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private FragmentListBinding binding;
    private ListView listView;
    private String countries[];
    private ArrayAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        ListView listView = rootView.findViewById(R.id.list_view_id);

        List<Parcours> parcoursList = JsonUtility.readJsonFromRaw(requireContext());

        ParcoursAdapter adapter = new ParcoursAdapter(requireContext(), parcoursList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Parcours selectedParcours = parcoursList.get(position);
            String nomTrajet = selectedParcours.getVille();
            Toast.makeText(requireContext(), nomTrajet, Toast.LENGTH_LONG).show();
        });

        return rootView;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}