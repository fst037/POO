package articulos;

import enums.Amortizacion;

import java.io.*;
import java.util.*;

/**
 * 
 */
public class TipoPesa extends TipoArticulo {

    /**
     * Default constructor
     */
    public TipoPesa() {
    }

    /**
     * 
     */
    private float peso;

    /**
     * 
     */
    private TipoUsoPesa tipoUso;

    /**
     * Default constructor
     * @param peso 
     * @param tipoUso 
     * @param amortizacion 
     * @param desgasteMax 
     * @param marca 
     * @param nombre 
     * @param costo
     */
    public TipoPesa(float peso, TipoUsoPesa tipoUso, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        // TODO implement here
    }

    /**
     * @return
     */
    public float getPeso() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public TipoUsoPesa getTipoUso() {
        // TODO implement here
        return null;
    }

}