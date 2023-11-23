package Negocio.usuarios;

import Negocio.enums.Nivel;
import Negocio.enums.TipoEmplazamiento;
import Negocio.inmuebles.Emplazamiento;
import Negocio.inmuebles.Sede;
import Negocio.articulos.TipoAccesorio;
import Negocio.articulos.TipoArticulo;
import Negocio.articulos.TipoColchoneta;
import Negocio.articulos.TipoPesa;
import Negocio.clases.TipoClase;
import Negocio.enums.TipoUsoPesa;
import Negocio.enums.Amortizacion;

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

    public Profesor crearNuevoProfesor(String nombre, int dni, float salario) {
        Profesor nuevoProfesor = new Profesor(nombre, dni, salario);
        return nuevoProfesor;
    }

    public Administrativo crearNuevoAdministrativo(String nombre, int dni) {
        Administrativo nuevoAdministrativo = new Administrativo(nombre, dni);
        return nuevoAdministrativo;
    }

    public void agregarSedeAdministrativo(Sede sede, Administrativo administrativo) {
        administrativo.addSede(sede);
    }

    public TipoClase crearTipoDeClase(String nombre, List<TipoArticulo> artNecPProf, List<TipoArticulo> artNecPCli, int grabMax) {
        TipoClase nuevoTipoClase = new TipoClase(nombre, artNecPProf, artNecPCli, grabMax);
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

    public void crearEmplazamiento(Sede sede, TipoEmplazamiento tipo, int metrosCuadrados) {
        Emplazamiento emplazamiento = new Emplazamiento(tipo, metrosCuadrados);
        sede.addEmplazamiento(emplazamiento);
    }
}