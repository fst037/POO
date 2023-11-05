package gimnasios;

import enums.TipoEmplazamiento;

public class Emplazamiento {
    private TipoEmplazamiento tipo;
    private float metrosCuadrados;

    public Emplazamiento(TipoEmplazamiento tipo, float metrosCuadrados) {
        this.tipo = tipo;
        this.metrosCuadrados = metrosCuadrados;
    }

    public TipoEmplazamiento getTipo() {
        return tipo;
    }

    public float getMetrosCuadrados() {
        return metrosCuadrados;
    }
}