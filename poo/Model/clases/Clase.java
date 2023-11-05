package clases;

import enums.EstadoClase;
import usuarios.Profesor;
import articulos.Articulo;
import gimnasios.Sede;
import gimnasios.Emplazamiento;
import usuarios.Cliente;

import java.io.*;
import java.util.*;

public class Clase {

    public Clase() {
    }

    /**
     * 
     */
    private EstadoClase estadoClase;

    /**
     * 
     */
    private Profesor profesor;

    /**
     * 
     */
    private TipoClase tipoClase;

    /**
     * 
     */
    private Set<Articulo> articulosReservados;

    /**
     * 
     */
    private float costos;

    /**
     * 
     */
    private float ingresos;

    /**
     * 
     */
    private LocalDateTime fechaHoraInicio;

    /**
     * 
     */
    private LocalTime duracion;

    /**
     * 
     */
    private Sede sede;

    /**
     * 
     */
    private Emplazamiento emplazamiento;

    /**
     * 
     */
    private int capacidadMaxima;

    /**
     * 
     */
    private Set<Cliente> clientesInscriptosPresencial;

    /**
     * 
     */
    private Set<Cliente> clientesInscriptosOnline;

    /**
     * Default constructor
     * @param prof 
     * @param tipoClase 
     * @param sede 
     * @param emp 
     * @param fHI 
     * @param duracion
     */
    public Clase(Profesor prof, TipoClase tipoClase, Sede sede, Emplazamiento emp, LocalDateTime fHI, LocalTime duracion) {
        // TODO implement here
    }

    /**
     * @return
     */
    public EstadoClase getEstadoClase() {
        // TODO implement here
        return null;
    }

    /**
     * @param estadoClase 
     * @return
     */
    public void setEstadoClase(void estadoClase) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Profesor getProfesor() {
        // TODO implement here
        return null;
    }

    /**
     * @param profesor 
     * @return
     */
    public void setProfesor(Profesor profesor) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public TipoClase getTipoClase() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<Articulo> getArticulosReservados() {
        // TODO implement here
        return null;
    }

    /**
     * @param articulos 
     * @return
     */
    public void setArticulosReservados(Set<Articulo> articulos) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public float getCostos() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public float getIngresos() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public LocalDateTime getFechaHoraInicio() {
        // TODO implement here
        return null;
    }

    /**
     * @param fecha 
     * @return
     */
    public void setFechaHoraInicio(LocalDateTime fecha) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public LocalTime getDuracion() {
        // TODO implement here
        return null;
    }

    /**
     * @param duracion 
     * @return
     */
    public void setDuracion(LocalTime duracion) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Sede getSede() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Emplazamiento getEmplazamiento() {
        // TODO implement here
        return null;
    }

    /**
     * @param emplazamiento 
     * @return
     */
    public void setEmplazamiento(Emplazamiento emplazamiento) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getCapacidadMaxima() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public Set<Cliente> getAlumnosInscriptosPresencial() {
        // TODO implement here
        return null;
    }

    /**
     * @param alumnosInscriptosPresencial 
     * @return
     */
    public void setAlumnosInscriptosPresencial(Set<Cliente> alumnosInscriptosPresencial) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<Cliente> getAlumnosInscriptosOnline() {
        // TODO implement here
        return null;
    }

    /**
     * @param alumnosInscriptosOnline 
     * @return
     */
    public void setAlumnosInscriptosOnline(Set<Cliente> alumnosInscriptosOnline) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public boolean isClaseRentable() {
        // TODO implement here
        return false;
    }

    /**
     * @param alumno 
     * @return
     */
    public boolean inscribirAlumno(Cliente alumno) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public void dictarClase() {
        // TODO implement here
        return null;
    }

}