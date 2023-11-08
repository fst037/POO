package usuarios;

import gimnasios.Sede;
import clases.Clase;
import enums.EstadoClase;
import enums.Nivel;
import articulos.TipoArticulo;
import articulos.Articulo;
import clases.TipoClase;

import java.util.*;

public class Administrativo extends Usuario {

    private List<Sede> sedes;

    public Administrativo(String nombre, int dni) {
        super(nombre, dni);
        this.sedes = new ArrayList<Sede>();
    }

    public List<Sede> getSedes() {
        // TODO implement here
        return this.sedes;
    }

    public void setSedes(List<Sede> sedes) {
        // TODO implement here
    }

    public void addSede(Sede sede) {
        // TODO implement here
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

    public void darAltaCliente(String nombre, int dni, Set<Sede> sedes) {
        // TODO implement here
    }

    public void darBajaCliente(Cliente cliente) {
        // TODO implement here
    }

    public void actualizarCliente(Cliente cliente, Nivel nivel) {
        // TODO implement here
    }

    public void incorporarArticulo(Sede sede, TipoArticulo tipoArticulo) {
        // TODO implement here
    }

    public void actualizarDesgasteArticulos(Sede sede) {
        // TODO implement here
    }

    public void darBajaArticulo(Sede sede, Articulo articulo) {
        // TODO implement here
    }

    public List<Clase> verClasesAlmacenadas(TipoClase tipoClase, Sede sede) {
        // TODO implement here
        return null;
    }

    public void removeSede(Sede sede) {
        // TODO implement here
    }

    public List<Articulo> listarArticulos() {
        // TODO implement here
        return null;
    }

    public List<Clase> listarClases() {
        // TODO implement here
        return null;
    }

    public float verDesgasteArticulo(Articulo articulo, Sede sede) {
        // TODO implement here
        return 0.0f;
    }

    public int contarArticulosDisponibles(List<Articulo> articulos) {
        // TODO implement here
        return 0;
    }
}