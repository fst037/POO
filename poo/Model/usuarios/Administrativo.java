package usuarios;

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
        this.sedes.add(sede);
    }

    public void agendarClase(Clase clase) {
        // TODO implement here
    }

    public boolean confirmarClase(Clase clase) {
        // TODO implement here
        return false;
    }

    public void actualizarClase(Clase clase, EstadoClase estado) {
        // TODO implement here
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

    public List<Articulo> listarArticulos() {
        return null;
    }

    public List<Clase> listarClases() {
        // TODO implement here
        return null;
    }



    public int contarArticulosDisponibles(List<Articulo> articulos) {
        // TODO implement here
        return 0;
    }
}