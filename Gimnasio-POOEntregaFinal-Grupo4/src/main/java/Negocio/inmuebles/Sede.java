package Negocio.inmuebles;

import Negocio.enums.Nivel;
import Negocio.enums.TipoEmplazamiento;
import Negocio.usuarios.Administrativo;
import Negocio.clases.Clase;
import Negocio.clases.StreamingClass;
import Negocio.articulos.Articulo;
import Negocio.clases.TipoClase;
import Negocio.enums.EstadoClase;

import java.util.*;

public class Sede {

    private String nombre;
    private Nivel nivelMinimo;
    private List<Administrativo> administrativos;
    private List<Clase> clases;
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
        this.clases = new ArrayList<Clase>();
        this.clasesGrabadasPorTipo = new ArrayList<StreamingClass>();
        this.articulos = new ArrayList<Articulo>();
        this.emplazamientos = new ArrayList<Emplazamiento>();
    }

    @Override
    public String toString() {
        return this.nombre + "|" + this.barrio;
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

    public List<Clase> getClasesConEstado(EstadoClase estadoClase) {
        List<Clase> resultado = new ArrayList<Clase>();
        
        for(Clase clase : this.clases){
            if (clase.getEstadoClase() == estadoClase){
                resultado.add(clase);
            }
        }
        
        return resultado;
    }
    
    public List<Clase> listarClasesDisponiblesReservar(TipoClase tipoClase){
        List<Clase> resultado = new ArrayList<Clase>();
        
        for(Clase clase : this.clases){
            if (clase.getEstadoClase() != EstadoClase.Finalizada 
                    && clase.getTipoClase() == tipoClase
                    && clase.getAlumnosInscriptosPresencial().size() < clase.getCapacidadMaxima()
                    ){
                resultado.add(clase);
            }
        }
        
        return resultado;
    }
    
    public void agendarClase(Clase clase) {
        this.clases.add(clase);
    }

    public void borrarClase(Clase clase) {
        this.clases.remove(clase);
    }
    
    public List<StreamingClass> getClasesAlmacenadasPorTipo() {
        return this.clasesGrabadasPorTipo;
    }

    public void setClasesAlmacenadasPorTipo(List<StreamingClass> clasesGrabadaPorTipo) {
        this.clasesGrabadasPorTipo = clasesGrabadaPorTipo;
    }
    
    public void addClaseAAlmacenamiento(Clase clase){
        for (StreamingClass claseGrabadaDeTipo: this.clasesGrabadasPorTipo){
            if (claseGrabadaDeTipo.getTipoClase() == clase.getTipoClase()){
                claseGrabadaDeTipo.addClase(clase);
            }
        }
        StreamingClass nuevaClaseOnline = new StreamingClass(clase.getTipoClase());
        nuevaClaseOnline.addClase(clase);
        this.clasesGrabadasPorTipo.add(nuevaClaseOnline);
        
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
    
    public void addEmplazamiento(Emplazamiento emplazamiento) {
        this.emplazamientos.add(emplazamiento);
    }
}