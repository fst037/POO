package Negocio.articulos;

import Negocio.enums.Amortizacion;

public class TipoColchoneta extends TipoArticulo {

    private float ancho;
    private float largo;

    public TipoColchoneta(float ancho, float largo, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {        
        super(amortizacion, desgasteMax, marca, nombre, costo);
        this.ancho = ancho;
        this.largo = largo;
    }

    public float getAncho() {
        return this.ancho;
    }

    public float getLargo() {
        return this.largo;
    }

}