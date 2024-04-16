package com.example.projetandroiderwando.ui.map;

import android.content.Intent;

import com.google.android.gms.maps.model.LatLng;
public class Parcours {

    private LatLng latLng;
    private String ville;

    private String nom;
    private String region;
    private Double distance;
    private String duree;

    private Integer denivele;


    public Parcours() {
    }

    public Parcours(LatLng latLng, String ville, String nom, String region, Double distance, String duree, Integer denivele) {
        this.latLng = latLng;
        this.ville = ville;
        this.nom = nom;
        this.region = region;
        this.distance = distance;
        this.duree = duree;
        this.denivele = denivele;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public Integer getDenivele() {
        return denivele;
    }

    public void setDenivele(Integer denivele) {
        this.denivele = denivele;
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
