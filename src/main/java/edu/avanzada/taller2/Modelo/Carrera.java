package edu.avanzada.taller2.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private List<Caballo> caballos;
    private int longitudPista;
    private boolean carreraEnCurso;

    public Carrera(int longitudPista) {
        this.caballos = new ArrayList<>();
        this.longitudPista = longitudPista;
        this.carreraEnCurso = false;
    }

    public boolean isCarreraEnCurso() {
        return carreraEnCurso;
    }

    public void setCarreraEnCurso(boolean carreraEnCurso) {
        this.carreraEnCurso = carreraEnCurso;
    }

    public int getLongitudPista() {
        return longitudPista;
    }

    public List<Caballo> getCaballos() {
        return caballos;
    }

    public int numCaballos() {
        return caballos.size();
    }

    public void agregarCaballo(Caballo caballo) {
        caballos.add(caballo);
    }
    public boolean comprobarNombre(String nombre) {
        for (Caballo caballo : getCaballos()) {
            if (caballo.getNombre().equalsIgnoreCase(nombre)) {
                return false;
            }
        }
        return true;
    }
}
