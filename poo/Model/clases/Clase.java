package clases;

import enums.EstadoClase;
import usuarios.Profesor;
import articulos.Articulo;
import gimnasios.Sede;
import gimnasios.Emplazamiento;
import usuarios.Cliente;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Clase {

    private EstadoClase estadoClase;    
    private Profesor profesor;    
    private TipoClase tipoClase;    
    private List<Articulo> articulosReservados;    
    private float costos;    
    private float ingresos;    
    private LocalDateTime fechaHoraInicio;    
    private LocalTime duracion;    
    private Sede sede;    
    private Emplazamiento emplazamiento;    
    private int capacidadMaxima;    
    private List<Cliente> alumnosInscriptosPresencial;    
    private List<Cliente> alumnosInscriptosOnline;

    public Clase(Profesor prof, TipoClase tipoClase, Sede sede, Emplazamiento emp, LocalDateTime fHI, LocalTime duracion) {
        this.profesor = prof;
        this.tipoClase = tipoClase;
        this.sede = sede;
        this.emplazamiento = emp;
        this.fechaHoraInicio = fHI;
        this.duracion = duracion;
        this.articulosReservados = new ArrayList<Articulo>();
        this.alumnosInscriptosPresencial = new ArrayList<Cliente>();
        this.alumnosInscriptosOnline = new ArrayList<Cliente>();
        this.estadoClase = EstadoClase.Agendada;
    }
    
    public EstadoClase getEstadoClase() {
        return this.estadoClase;
    }

    public void setEstadoClase(EstadoClase estadoClase) {
        this.estadoClase = estadoClase;      
    }

    public Profesor getProfesor() {
        return this.profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;      
    }

    public TipoClase getTipoClase() {
        return this.tipoClase;
    }

    public List<Articulo> getArticulosReservados() {
        return this.articulosReservados;
    }

    public void setArticulosReservados(List<Articulo> articulos) {
        this.articulosReservados = articulos;    
    }

    public float getCostos() {
        return this.costos;
    }

    public float getIngresos() {
        return this.ingresos;
    }

    public LocalDateTime getFechaHoraInicio() {
        return this.fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return this.fechaHoraInicio.plusMinutes(this.duracion.getMinute()).plusHours(this.duracion.getHour());
    }

    public void setFechaHoraInicio(LocalDateTime fecha) {
        this.fechaHoraInicio = fecha;    
    }

    public LocalTime getDuracion() {
        return this.duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public Sede getSede() {
        return this.sede;
    }

    public Emplazamiento getEmplazamiento() {
        return this.emplazamiento;
    }

    public void setEmplazamiento(Emplazamiento emplazamiento) {
        this.emplazamiento = emplazamiento;    
    }

    public int getCapacidadMaxima() {
        return this.capacidadMaxima;
    }

    public List<Cliente> getAlumnosInscriptosPresencial() {
        return this.alumnosInscriptosPresencial;
    }

    public void setAlumnosInscriptosPresencial(List<Cliente> alumnosInscriptosPresencial) {
        this.alumnosInscriptosPresencial = alumnosInscriptosPresencial;
    }

    public List<Cliente> getAlumnosInscriptosOnline() {
        return this.alumnosInscriptosOnline;
    }

    public void setAlumnosInscriptosOnline(List<Cliente> alumnosInscriptosOnline) {
        this.alumnosInscriptosOnline = alumnosInscriptosOnline;
    }

    public boolean isClaseRentable() {
        // TODO implement here
        return false;
    }

    public boolean inscribirAlumno(Cliente alumno) {
        // TODO implement here
        return false;
    }

    public void dictarClase() {
        // TODO implement here
    }
}