package usuarios;

import gimnasios.Sede;
import clases.Clase;
import enums.Nivel;
import articulos.TipoArticulo;
import articulos.Articulo;
import clases.TipoClase;

import java.io.*;
import java.util.*;

public class Administrativo extends Usuario {

    public Administrativo() {
    }

    private Set<Sede> sedes;

    public Administrativo(String nombre, int dni) {
        // TODO implement here
    }

    public Set<Sede> getSedes() {
        // TODO implement here
        return null;
    }

    public void setSedes(Set<Sede> sedes) {
        // TODO implement here
        return null;
    }

    public void addSede(Sede sede) {
        // TODO implement here
        return null;
    }

    public void agendarClase(Clase clase) {
        // TODO implement here
        return null;
    }

    public boolean confirmarClase(Clase clase) {
        // TODO implement here
        return false;
    }

    public void actualizarClase(Clase clase, estadoClase estado) {
        // TODO implement here
        return null;
    }

    public void darAltaCliente(String nombre, int dni, Set<Sede> sedes) {
        // TODO implement here
        return null;
    }

    public void darBajaCliente(Cliente cliente) {
        // TODO implement here
        return null;
    }

    public void actualizarCliente(Cliente cliente, Nivel nivel) {
        // TODO implement here
        return null;
    }

    public void incorporarArticulo(Sede sede, TipoArticulo tipoArticulo) {
        // TODO implement here
        return null;
    }

    public void actualizarDesgasteArticulos(Sede sede) {
        // TODO implement here
        return null;
    }

    public void darBajaArticulo(Sede sede, Articulo articulo) {
        // TODO implement here
        return null;
    }

    public Set<Clase> verClasesAlmacenadas(TipoClase tipoClase, Sede sede) {
        // TODO implement here
        return null;
    }

    public void removeSede(void Sede sede) {
        // TODO implement here
        return null;
    }

    public Set<Articulo> listarArticulos() {
        // TODO implement here
        return null;
    }

    public Set<Clase> listarClases() {
        // TODO implement here
        return null;
    }

    public float verDesgasteArticulo(Articulo articulo, Sede sede) {
        // TODO implement here
        return 0.0f;
    }

    public int contarArticulosDisponibles(Set<Articulo> articulos) {
        // TODO implement here
        return 0;
    }
}