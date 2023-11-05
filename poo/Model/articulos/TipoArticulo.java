package articulos;

import enums.Amortizacion;

public abstract class TipoArticulo {

    private Amortizacion amortizacion;    
    private int desgasteMax;    
    private String marca;    
    private String nombre;    
    private float costo;

    public TipoArticulo(Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        this.amortizacion = amortizacion;
        this.desgasteMax = desgasteMax;
        this.marca = marca;
        this.nombre = nombre;
        this.costo = costo;
    }

    public Amortizacion getAmortizacion() {
        return this.amortizacion;
    }

    public int getDesgasteMax() {
        return this.desgasteMax;
    }
    
    public String getMarca() {
        return this.marca;
    }

    public String getNombre() {
        return this.nombre;
    }

    public float getCosto() {
        return this.costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}