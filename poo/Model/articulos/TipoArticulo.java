package articulos;

import enums.Amortizacion;

import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class TipoArticulo {

    /**
     * Default constructor
     */
    public TipoArticulo() {
    }

    /**
     * 
     */
    private Amortizacion amortizacion;

    /**
     * 
     */
    private int desgasteMax;

    /**
     * 
     */
    private String marca;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private float costo;

    /**
     * @return
     */
    public Amortizacion getAmortizacion() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getDesgasteMax() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String getMarca() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getNombre() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public float getCosto() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @param costo 
     * @return
     */
    public void setCosto(float costo) {
        // TODO implement here
        return null;
    }

}