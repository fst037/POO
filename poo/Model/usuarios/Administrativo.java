package usuarios;

import gimnasios.Emplazamiento;
import gimnasios.Sede;
import clases.Clase;
import clases.StreamingClass;
import enums.EstadoClase;
import enums.Nivel;
import articulos.TipoArticulo;
import articulos.Articulo;
import clases.TipoClase;

import java.time.*;
import java.util.*;

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

    public Cliente darAltaCliente(String nombre, int dni) {
        Cliente nuevoCliente = new Cliente(nombre, dni, Nivel.Black);
        return nuevoCliente;
    }

    public Usuario darBajaCliente(Cliente cliente, List<Usuario> usuarios) {
        if (usuarios.contains(cliente)){
            return cliente;
        }        
        return null;
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

    public List<Articulo> listarArticulosDisponibles(List<Articulo> articulos, LocalDateTime fechaHoraInicio, LocalTime duracion) {        
        List<Articulo> articulosDisponibles = new ArrayList<Articulo>();

        for (Articulo articulo : articulos) {
            if (articulo.isDisponibleParaFechaHorario(fechaHoraInicio, duracion)) {
                articulosDisponibles.add(articulo);
            }
        }
        
        return articulosDisponibles;
    }
}