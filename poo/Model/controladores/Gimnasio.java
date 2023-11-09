package controladores;

import gimnasios.Emplazamiento;
import gimnasios.Sede;
import articulos.TipoArticulo;
import clases.TipoClase;
import enums.Amortizacion;
import enums.Nivel;
import enums.TipoUsoPesa;
import usuarios.Administrativo;
import usuarios.Profesor;
import usuarios.SoporteTecnico;
import usuarios.Usuario;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Gimnasio {
    
    private List<Sede> sedes;
    private static List<TipoClase> tiposDeClase;
    private static List<TipoArticulo> tiposDeArticulo;
    private List<Usuario> usuarios;
    private SoporteTecnico soporteTecnico;

    public Gimnasio() {
        this.sedes = new ArrayList<Sede>();
        this.usuarios = new ArrayList<Usuario>();
        this.soporteTecnico = new SoporteTecnico("Soporte Tecnico", 0);
    }

    public void crearSede() {
        // TODO implement here    
    }

    public void crearCliente() {
        // TODO implement here 
    }

    public void crearAdministrativo() {
        // TODO implement here 
    }

    public void agregarSedeAdministrativo() {
        // TODO implement here 
    }

    public void crearProfesor() {
        // TODO implement here 
    }

    public void crearTipoClase() {
        // TODO implement here 
    }

    public void crearTipoDePesa() {
        // TODO implement here 
    }

    public void crearTipoDeColchoneta() {
        // TODO implement here 
    }

    public void crearTipoDeAccesorio() {
        // TODO implement here       
    }

    public void agendarClase() {
        // TODO implement here
    }

    public void actualizarEstadoClase() {
        // TODO implement here
    }

    public void darAltaArticulo() {
        // TODO implement here
    }

    public void darBajaArticulo() {
        // TODO implement here
    }

    public void darAltaCliente() {
        // TODO implement here
    }

    public void darBajaCliente() {
        // TODO implement here
    }

    public void actualizarNivelCliente() {
        // TODO implement here
    }

    public void verCantArtDisp() {
        // TODO implement here
    }

    public void verDesgasteActArt() {
        // TODO implement here
    }

    public void verClasesAlmacenadas() {
        // TODO implement here
    }

    public void reservarEspacioClases() {
        // TODO implement here
    }

    public void visualizarClasesReservadas() {
        // TODO implement here
    }

}