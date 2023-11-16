package Negocio.clases;

import java.util.*;

public class StreamingClass {

    private TipoClase tipoClase;
    private int cantAlmacenadas;
    private List<Clase> clases;

    public StreamingClass(TipoClase tipoClase) {
        this.tipoClase = tipoClase;
        this.cantAlmacenadas = 0;
        this.clases = new ArrayList<Clase>();
    }

    public TipoClase getTipoClase() {
        return this.tipoClase;
    }

    public int getCantAlmacenadas() {
        return this.cantAlmacenadas;
    }

    public void setAlmacenadas(int cantAlmacenadas) {
        this.cantAlmacenadas = cantAlmacenadas;
    }

    public List<Clase> getClases() {
        return this.clases;
    }

    public void addClase(Clase clase) {        //agrega una clase
        if (this.cantAlmacenadas >= this.tipoClase.getGrabacionesMaximas()) {
            clases.remove(0);
            this.cantAlmacenadas--;
        }
        this.clases.add(clase);
        this.cantAlmacenadas++;
    }
}