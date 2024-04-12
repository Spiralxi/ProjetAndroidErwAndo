package com.example.projetandroiderwando.ui.map;

import android.content.Context;

import com.example.projetandroiderwando.R;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonUtility {
    public static List<Parcours> readJsonFromRaw(Context context) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.nom_du_fichier_json);

            List<Parcours> parcoursList = objectMapper.readValue(inputStream, new TypeReference<List<Parcours>>() {});
            inputStream.close();

            return parcoursList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
