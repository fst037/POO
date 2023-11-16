package Negocio.articulos;

import Negocio.enums.Amortizacion;

public class TipoAccesorio extends TipoArticulo {

    private String descripcion;

    public TipoAccesorio(String descripcion, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        super(amortizacion, desgasteMax, marca, nombre, costo);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

}