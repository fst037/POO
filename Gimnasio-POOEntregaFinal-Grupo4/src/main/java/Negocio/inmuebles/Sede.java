package Negocio.inmuebles;

import Negocio.enums.Nivel;
import Negocio.enums.TipoEmplazamiento;
import Negocio.usuarios.Administrativo;
import Negocio.clases.Clase;
import Negocio.clases.StreamingClass;
import Negocio.articulos.Articulo;

import java.util.*;

public class Sede {

    private String nombre;
    private Nivel nivelMinimo;
    private List<Administrativo> administrativos;
    private List<Clase> clasesAgendadas;
    private List<Clase> clasesConfirmadas;
    private List<Clase> clasesFinalizadas;
    private List<StreamingClass> clasesGrabadasPorTipo;
    private List<Articulo> articulos;
    private float alquiler;
    private String barrio;
    private List<Emplazamiento> emplazamientos;

    public Sede(String nombre, Nivel nivelMinimo, String barrio, float alquiler) {
        this.nombre = nombre;
        this.nivelMinimo = nivelMinimo;
        this.barrio = barrio;
        this.alquiler = alquiler;
        this.clasesAgendadas = new ArrayList<Clase>();
        this.clasesConfirmadas = new ArrayList<Clase>();
        this.clasesFinalizadas = new ArrayList<Clase>();
        this.clasesGrabadasPorTipo = new ArrayList<StreamingClass>();
        this.articulos = new ArrayList<Articulo>();
        this.emplazamientos = new ArrayList<Emplazamiento>();
    }

    @Override
    public String toString() {
        return this.nombre;
    }


    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nivel getNivelMinimo() {
        return this.nivelMinimo;
    }

    public void setNivelMinimo(Nivel nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }

    public List<Administrativo> getAdministrativos() {
        return this.administrativos;
    }

    public void setAdministrativos(List<Administrativo> administrativos) {
        this.administrativos = administrativos;
    }

    public List<Clase> getClasesAgendadas() {
        return this.clasesAgendadas;
    }

    public void setClasesAgendadas(List<Clase> clasesAgendadas) {
        this.clasesAgendadas = clasesAgendadas;
    }

    public void agendarClase(Clase clase) {
        this.clasesAgendadas.add(clase);
    }

    public void borrarClase(Clase clase) {
        this.clasesAgendadas.remove(clase);
    }

    public List<Clase> getClasesConfirmadas() {
        return this.clasesConfirmadas;
    }

    public void setClasesConfirmadas(List<Clase> clasesConfirmadas) {
        this.clasesConfirmadas = clasesConfirmadas;
    }

    public List<Clase> getClasesFinalizadas() {
        return this.clasesFinalizadas;
    }

    public void setClasesFinalizadas(List<Clase> clasesFinalizadas) {
        this.clasesFinalizadas = clasesFinalizadas;
    }

    public List<StreamingClass> getClasesAlmacenadasPorTipo() {
        return this.clasesGrabadasPorTipo;
    }

    public void setClasesAlmacenadasPorTipo(List<StreamingClass> claseGrabadaPorTipo) {
        this.clasesGrabadasPorTipo = claseGrabadaPorTipo;
    }

    public List<Articulo> getArticulos() {
        return this.articulos;
    }

    public void darBajaArticulo(Articulo articulo){
        this.articulos.remove(articulo);
    }

    public void darAltaArticulo(Articulo articulo) {
        this.articulos.add(articulo);
    }

    public float getAlquiler() {
        return this.alquiler;
    }

    public void setAlquiler(float alquiler) {
        this.alquiler = alquiler;
    }

    public String getBarrio() {
        return this.barrio;
    }

    public List<Emplazamiento> getEmplazamientos() {
        return this.emplazamientos;
    }

    public void setEmplazamientos(List<Emplazamiento> emplazamientos) {
        this.emplazamientos = emplazamientos;
    }
    public void agregarEmplazamiento(Emplazamiento emplazamiento) {
        this.emplazamientos.add(emplazamiento);
    }
}