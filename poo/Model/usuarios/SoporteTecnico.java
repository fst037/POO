package usuarios;

import enums.Nivel;
import gimnasios.Sede;
import articulos.TipoAccesorio;
import articulos.TipoArticulo;
import articulos.TipoColchoneta;
import articulos.TipoPesa;
import clases.TipoClase;
import enums.TipoUsoPesa;
import enums.Amortizacion;

import java.util.*;

public class SoporteTecnico extends Usuario {

    public SoporteTecnico(String nombre, int dni) {
        super(nombre, dni);
    }

    public Sede crearNuevaSede(String nombre, Nivel nivelMinimo, String barrio, float alquiler) {
        Sede sedeNueva = new Sede(nombre, nivelMinimo, barrio, alquiler);
        return sedeNueva;
    }

    public Cliente crearNuevoCliente(String nombre, int dni, Nivel nivel) {
        Cliente nuevoCliente = new Cliente(nombre, dni, nivel);
        return nuevoCliente;
    }

    public Administrativo crearNuevoAdministrativo(String nombre, int dni) {
        Administrativo nuevoAdministrativo = new Administrativo(nombre, dni);
        return nuevoAdministrativo;
    }

    public TipoClase crearTipoDeClase(String nombre, Set<TipoArticulo> artNecPProf, Set<TipoArticulo> artNecPCli, int grabMax) {
        TipoClase nuevoTipoClase = new TipoClase(nombre, null, null, grabMax);
        return nuevoTipoClase;
    }

    public TipoPesa crearTipoDePesa(float peso, TipoUsoPesa tipoUso, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        TipoPesa nuevoTipoPesa = new TipoPesa(peso, tipoUso, amortizacion, desgasteMax, marca, nombre, costo);
        return nuevoTipoPesa;
    }

    public TipoColchoneta crearTipoDeColchoneta(float ancho, float largo, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        TipoColchoneta nuevoTipoColchoneta = new TipoColchoneta(ancho, largo, amortizacion, desgasteMax, marca, nombre, costo);
        return nuevoTipoColchoneta;
    }

    public TipoAccesorio crearTipoDeAccesorio(String descripcion, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        TipoAccesorio nuevoTipoAccesorio = new TipoAccesorio(descripcion, amortizacion, desgasteMax, marca, nombre, costo);
        return nuevoTipoAccesorio;
    }

}