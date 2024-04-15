package com.example.projetandroiderwando.ui.map;

import android.content.Context;

import com.example.projetandroiderwando.R;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JsonUtility {
    public static List<Parcours> readJsonFromRaw(Context context) {
        List<Parcours> parcoursList = new ArrayList<>();

        try {
            InputStream is = context.getResources().openRawResource(R.raw.datajson);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder jsonStringBuilder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                jsonStringBuilder.append(line);
            }
            br.close();

            Gson gson = new Gson();
            ParcoursData parcoursData = gson.fromJson(jsonStringBuilder.toString(), ParcoursData.class);
            parcoursList = parcoursData.getParcours();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parcoursList;
    }
}
