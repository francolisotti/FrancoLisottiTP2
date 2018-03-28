/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mipaquete;

import java.util.Observable;

/**
 *
 * @author usuario
 */
public class Auto extends Observable{
    String patente;
    int anio;
    String modelo;
    String marca;
    double nivelAceite;
    double presionNeumaticos;
    double nivelAgua;

    public Auto (String patente, int anio, String modelo, String marca, double nivelAceite, double presionNeumaticos, double nivelAgua)
    {
        this.patente=patente;
        this.anio=anio;
        this.modelo=modelo;
        this.marca=marca;
        this.nivelAceite=nivelAceite;
        this.presionNeumaticos=presionNeumaticos;
        this.nivelAgua=nivelAgua;
    }
    
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getNivelAceite() {
        return nivelAceite;
    }

    public void setNivelAceite(double nivelAceite) {
        this.nivelAceite = nivelAceite;
        setChanged();
        notifyObservers(nivelAceite);
    }

    public double getPresionNeumaticos() {
        return presionNeumaticos;
    }

    public void setPresionNeumaticos(double presionNeumaticos) {
        this.presionNeumaticos = presionNeumaticos;
        setChanged();
        notifyObservers(presionNeumaticos);
    }

    public double getNivelAgua() {
        return nivelAgua;
    }

    public void setNivelAgua(double nivelAgua) {
        this.nivelAgua = nivelAgua;
        setChanged();
        notifyObservers(nivelAgua);
    }
    
    
}
