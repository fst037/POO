package clases;

import articulos.TipoArticulo;

import java.util.*;

public class TipoClase {
    private String nombre;
    private List<TipoArticulo> articulosNecesariosParaProfesor;
    private List<TipoArticulo> articulosNecesariosPorCliente;
    private int grabacionesMaximas;

    public TipoClase(String nombre, List<TipoArticulo> artNecPProf, List<TipoArticulo> artNecPCli, int grabMax) {
        this.nombre = nombre;
        this.articulosNecesariosParaProfesor = artNecPProf;
        this.articulosNecesariosPorCliente = artNecPCli;
        this.grabacionesMaximas = grabMax;
    }

    public String getNombre() {
        return this.nombre;
    }

    public List<TipoArticulo> getArticulosNecesariosParaProfesor() {
        return this.articulosNecesariosParaProfesor;
    }

    public void setArticulosNecesariosParaProfesor(List<TipoArticulo> articulos) {
        this.articulosNecesariosParaProfesor = articulos;
    }

    public List<TipoArticulo> getArticulosNecesariosPorCliente() {
        return this.articulosNecesariosPorCliente;
    }

    public void setArticulosNecesariosPorCliente(List<TipoArticulo> articulos) {
        this.articulosNecesariosPorCliente = articulos;
    }

    public int getGrabacionesMaximas() {
        return grabacionesMaximas;
    }

    public void setGrabacionesMaximas(int grabacionesMaximas) {
        this.grabacionesMaximas = grabacionesMaximas;
    }
}