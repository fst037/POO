package Negocio.usuarios;

import Negocio.inmuebles.Emplazamiento;
import Negocio.inmuebles.Sede;
import Negocio.clases.Clase;
import Negocio.clases.StreamingClass;
import Negocio.enums.EstadoClase;
import Negocio.enums.Nivel;
import Negocio.articulos.TipoArticulo;
import Negocio.articulos.Articulo;
import Negocio.clases.TipoClase;

import java.time.*;
import java.util.*;
import Negocio.usuarios.Cliente;
import Negocio.usuarios.Profesor;
import Negocio.usuarios.Usuario;

public class Administrativo extends Usuario {

    private List<Sede> sedes;

    public Administrativo(String nombre, int dni) {
        super(nombre, dni);
        this.sedes = new ArrayList<Sede>();
    }

    public List<Sede> getSedes() {
        return this.sedes;
    }

    public void addSede(Sede sede) {
        if (!this.sedes.contains(sede))
            this.sedes.add(sede);
    }

    public void agendarClase(Profesor prof, TipoClase tipoClase, Sede sede, Emplazamiento emp, LocalDateTime fHI, LocalTime duracion) {
        if (sedes.contains(sede) && prof.isDisponibleParaClase(fHI, duracion)){
            Clase nuevaClase = new Clase(prof, tipoClase, sede, emp, fHI, duracion);
            prof.agendarClase(nuevaClase);
            sede.agendarClase(nuevaClase);
        }
    }

    public void actualizarClase(Clase clase, EstadoClase estado) {
        clase.setEstadoClase(estado);
    }

    public Cliente darAltaCliente(String nombre, int dni, Nivel nivel) {
        Cliente nuevoCliente = new Cliente(nombre, dni, nivel);
        return nuevoCliente;
    }

    public void darBajaCliente(Cliente cliente, List<Cliente> clientes) {
        clientes.remove(cliente);
    }

    public void actualizarCliente(Cliente cliente, Nivel nivel) {
        cliente.setNivel(nivel);
    }

    public Articulo darAltaArticulo(Sede sede, TipoArticulo tipoArticulo, LocalDate fechaFabricacion) {
        Articulo nuevoArticulo = new Articulo(tipoArticulo, sede, fechaFabricacion);
        sede.darAltaArticulo(nuevoArticulo);
        return nuevoArticulo;
    }

    public void darBajaArticulo(Sede sede, Articulo articulo) {
        sede.darBajaArticulo(articulo);
    }

    public float verDesgasteArticulo(Articulo articulo, Sede sede) {
        if(sede.getArticulos().contains(articulo)){
            return articulo.getDesgasteActual();
        } else {
            assert false: "No se encontro el articulo en la sede";
            return 0.0f;
        }
    }

    public List<Clase> verClasesAlmacenadas(TipoClase tipoClase, Sede sede) {
        for (StreamingClass clase : sede.getClasesAlmacenadasPorTipo()){
            if(clase.getTipoClase() == tipoClase){
                return clase.getClases();
            }
        }
        return null;
    }

    public void removeSede(Sede sede, List<Sede> sedes) {
        if (sedes.contains(sede)){
            sedes.remove(sede);
        }
    }    

    public List<Clase> listarClases(Sede sede, EstadoClase estadoClase) {
        switch (estadoClase) {
            case Agendada:
                return sede.getClasesAgendadas();
            case Confirmada:
                return sede.getClasesConfirmadas();
            case Finalizada:             
                return sede.getClasesFinalizadas();        
            default:
                return null;
        }
    }

    public List<Articulo> listarArticulos(Sede sede) {
        return sede.getArticulos();
    }

    public List<Articulo> listarArticulosDisponibles(Sede sede, LocalDateTime fechaHoraInicio, LocalTime duracion) {        
        List<Articulo> articulosDisponibles = new ArrayList<Articulo>();

        for (Articulo articulo : sede.getArticulos()) {
            if (articulo.isDisponibleParaFechaHorario(fechaHoraInicio, duracion)) {
                articulosDisponibles.add(articulo);
            }
        }

        return articulosDisponibles;
    }
}