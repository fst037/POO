package Aplication;

import Negocio.enums.*;
import Negocio.inmuebles.Emplazamiento;
import Negocio.inmuebles.Sede;
import Negocio.articulos.Articulo;
import Negocio.articulos.TipoAccesorio;
import Negocio.articulos.TipoArticulo;
import Negocio.articulos.TipoColchoneta;
import Negocio.articulos.TipoPesa;
import Negocio.clases.Clase;
import Negocio.clases.TipoClase;
import Negocio.usuarios.Administrativo;
import Negocio.usuarios.Cliente;
import Negocio.usuarios.Profesor;
import Negocio.usuarios.SoporteTecnico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Gimnasio {
    
    private List<Sede> sedes;
    private List<TipoClase> tiposDeClase;
    private List<TipoArticulo> tiposDeArticulo;
    private List<Cliente> clientes;
    private List<Administrativo> administrativos;
    private List<Profesor> profesores;
    private SoporteTecnico soporteTecnico;

    public Gimnasio() {
        this.sedes = new ArrayList<Sede>();
        this.tiposDeClase = new ArrayList<TipoClase>();
        this.tiposDeArticulo = new ArrayList<TipoArticulo>();
        this.clientes = new ArrayList<Cliente>();
        this.administrativos = new ArrayList<Administrativo>();
        this.profesores = new ArrayList<Profesor>();
        this.soporteTecnico = new SoporteTecnico("Soporte Tecnico", 0);
    }
    
    public List<Sede> listarSedes(){
        return this.sedes;
    }
    
    public List<TipoClase> listarTiposDeClase(){
        return this.tiposDeClase;
    }
    
    public List<TipoArticulo> listarTiposDeArticulo(){
        return this.tiposDeArticulo;
    }
    
    public List<Cliente> listarClientes(){
        return this.clientes;
    }
    
    public List<Administrativo> listarAdministrativos(){
        return this.administrativos;
    }
    
    public List<Profesor> listarProfesores(){
        return this.profesores;
    }
    public SoporteTecnico mostrarSoporteTecnico(){
        return this.soporteTecnico;
    }
    
    public void crearSede(String nombre, Nivel nivelMinimo, String barrio, float alquiler) {
        for (Sede sede : sedes ){
            assert sede.getBarrio().equals(barrio) : "Ya existe una sede en ese barrio";
        }
        Sede sede = soporteTecnico.crearNuevaSede(nombre, nivelMinimo, barrio, alquiler);
        sedes.add(sede);
    }
    public void agregarEmplazamiento(Sede sede, TipoEmplazamiento tipo, float metrosCuadrados) {
        Emplazamiento emplazamiento = soporteTecnico.crearEmplazamiento( sede, tipo, metrosCuadrados);
        sedes.add(sede);
    }

    public void crearAdministrativo(String nombre, int dni) {
        for (Administrativo administrativo : administrativos){
            assert administrativo.getDni() != dni: "El dni ya esta asociado a un administrativo";
        }
        administrativos.add(soporteTecnico.crearNuevoAdministrativo(nombre, dni));
    }

    public void agregarSedeAdministrativo(Administrativo administrativo, Sede sede) {
        administrativo.addSede(sede);
    }

    public void crearProfesor(String nombre, int dni, float salario) {
        for (Profesor profesor : profesores){
            assert profesor.getDni() != dni: "El dni ya esta asociado a un profesor";
        }
        profesores.add(soporteTecnico.crearNuevoProfesor(nombre, dni, salario));
    }

    public void crearTipoClase(String nombre, List<TipoArticulo> artNecPProf, List<TipoArticulo> artNecPCli, int grabMax) {
        
        for (TipoClase tipoClase : this.tiposDeClase){
            assert !tipoClase.getNombre().equals(nombre) : "Ya existe un TipoClase con ese nombre";
        }                 

        TipoClase tipoClase = soporteTecnico.crearTipoDeClase(nombre, artNecPProf, artNecPCli, grabMax); 
    
        tiposDeClase.add(tipoClase);
    }

    public void crearTipoDePesa(SoporteTecnico soporteTecnico, float peso, TipoUsoPesa tipoUso, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        TipoPesa nuevoTipoDePesa = this.soporteTecnico.crearTipoDePesa(peso, tipoUso, amortizacion, desgasteMax, marca, nombre, costo);
        this.tiposDeArticulo.add(nuevoTipoDePesa);
    }

    public void crearTipoDeColchoneta(SoporteTecnico soporteTecnico, float ancho, float largo, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        TipoColchoneta nuevoTipoColchoneta = this.soporteTecnico.crearTipoDeColchoneta(ancho, largo, amortizacion, desgasteMax, marca, nombre, costo);
        this.tiposDeArticulo.add(nuevoTipoColchoneta);
    }
 
    public void crearTipoDeAccesorio(String descripcion, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        TipoAccesorio nuevoTipoAccesorio = this.soporteTecnico.crearTipoDeAccesorio(descripcion, amortizacion, desgasteMax, marca, nombre, costo);
        this.tiposDeArticulo.add(nuevoTipoAccesorio);  
    }

    public boolean agendarClase(Profesor prof, TipoClase tipoClase, Sede sede, Emplazamiento emp, LocalDateTime fHI, LocalTime duracion, Administrativo administrativo) {
        assert administrativo.getSedes().contains(sede) : "El administrativo seleccionado no maneja la sede";
        
        administrativo.agendarClase(prof, tipoClase, sede, emp, fHI, duracion);
        return true;
    }
    
    public List<Sede> listarSedesAdministrativo(Administrativo admin){
        return admin.getSedes();
    }
    
    public List<Emplazamiento> listarEmplazamientosSede(Sede sede){
        return sede.getEmplazamientos();
    }
    
    public void actualizarEstadoClase(Sede sede, Clase clase, Administrativo administrativo, EstadoClase estado) {
        assert administrativo.getSedes().contains(sede) : "El administrativo seleccionado no maneja la sede";
        
        administrativo.actualizarClase(clase, estado);
    }

    public void darAltaArticulo(Administrativo administrativo, Sede sede, TipoArticulo tipoArticulo, LocalDate fechaFabricacion) {
        assert administrativo.getSedes().contains(sede) : "El administrativo seleccionado no maneja la sede";
        
        administrativo.darAltaArticulo(sede, tipoArticulo, fechaFabricacion);
    }
 
    public void darBajaArticulo(Administrativo administrativo, Sede sede, Articulo articulo) {
        assert administrativo.getSedes().contains(sede) : "El administrativo seleccionado no maneja la sede";
        
        administrativo.darBajaArticulo(sede, articulo);
    }

    public void darAltaCliente(Administrativo administrativo, String nombre, int dni, Nivel nivel) {
        for (Cliente cliente: clientes){
            assert cliente.getDni() != dni: "El dni ya esta asociado a un cliente";
        }
        clientes.add(administrativo.darAltaCliente(nombre, dni, nivel));        
    }

    public void darBajaCliente(Administrativo administrativo, Cliente cliente) {
        administrativo.darBajaCliente(cliente, clientes);
    }

    public void actualizarNivelCliente(int dni_cliente, String nivel, Administrativo administrativo) {
        for (Cliente cliente: this.clientes){
            if (cliente.getDni() == dni_cliente){
                administrativo.actualizarCliente(cliente, Nivel.valueOf(nivel));
                return;            
            }
        }
        assert false : "No existe el dni especificado";
    }

    public List<Articulo> verArtDisp(Sede sede, Administrativo administrativo, LocalDateTime fechaHoraInicio, LocalTime duracion) {
        
        return administrativo.listarArticulosDisponibles(sede, fechaHoraInicio, duracion);
    }

    public List<Articulo> verTodosArt(Sede sede, Administrativo administrativo){
        return administrativo.listarArticulos(sede);
    }
    
    public float verDesgasteActArt(Sede sede, Administrativo administrativo, Articulo articulo) {
        return administrativo.verDesgasteArticulo(articulo, sede);
    }

    public List<Clase> verClasesAlmacenadas(TipoClase tipoClase, Sede sede, Administrativo administrativo) {
        
        assert administrativo.getSedes().contains(sede) : "El administrativo seleccionado no maneja la sede";
        
        return administrativo.verClasesAlmacenadas(tipoClase, sede);
    }

    public void reservarClaseAlumno(Cliente cliente, Clase clase, boolean online) {
        assert cliente.reservarClase(clase, online) : "No se pudo reservar la clase";
    }

    public List<Clase> visualizarClases(Sede sede, EstadoClase estadoClase, Administrativo administrativo) {
             
        assert administrativo.getSedes().contains(sede) : "El administrativo actual no maneja la sede elegida";

        return administrativo.listarClases(sede, estadoClase);
    }
}