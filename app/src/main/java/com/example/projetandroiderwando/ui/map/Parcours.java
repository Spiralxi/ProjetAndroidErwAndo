package com.example.projetandroiderwando.ui.map;

import com.google.android.gms.maps.model.LatLng;
public class Parcours {

    private LatLng latLng;
    private String ville;

    public Parcours() {
    }

    public Parcours(LatLng latLng, String ville) {
        this.latLng =latLng;
        this.ville = ville;
    }

    public LatLng getLatLng() {
        return latLng;
    }


    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
