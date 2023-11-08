package usuarios;

import enums.Nivel;
import gimnasios.Sede;
import articulos.TipoArticulo;
import enums.TipoUsoPesa;
import enums.Amortizacion;

import java.util.*;

public class SoporteTecnico extends Usuario {

    public SoporteTecnico(String nombre, int dni) {
        super(nombre, dni);
    }

    public void crearNuevaSede(String nombre, Nivel nivelMinimo, String barrio, float alquiler) {
        // TODO implement here
    }

    public void crearNuevoCliente(String nombre, int dni, Nivel nivel) {
        // TODO implement here
    }

    public void crearNuevoAdministrativo(String nombre, int dni, Set<Sede> sedes) {
        // TODO implement here
    }

    public void crearTipoDeClase(String nombre, Set<TipoArticulo> artNecPProf, Set<TipoArticulo> artNecPCli, int grabMax) {

    }

    public void crearTipoDePesa(float peso, TipoUsoPesa tipoUso, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        // TODO implement here
    }

    public void crearTipoDeColchoneta(float ancho, float largo, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        // TODO implement here
    }

    public void crearTipoDeAccesorio(String descripcion, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        // TODO implement here
    }

}