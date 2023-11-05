package articulos;

import enums.Amortizacion;
import enums.TipoUsoPesa;

public class TipoPesa extends TipoArticulo {

    private float peso;
    private TipoUsoPesa tipoUso;

    public TipoPesa(float peso, TipoUsoPesa tipoUso, Amortizacion amortizacion, int desgasteMax, String marca, String nombre, float costo) {
        super(amortizacion, desgasteMax, marca, nombre, costo);
        this.peso = peso;
        this.tipoUso = tipoUso;
    }

    public float getPeso() {
        return this.peso;
    }

    public TipoUsoPesa getTipoUso() {
        return this.tipoUso;
    }
}