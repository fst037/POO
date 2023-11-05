package clases;

import java.util.*;

public class StreamingClass {

    private TipoClase tipoClase;
    private int almacenadas;
    private List<Clase> clases;

    public StreamingClass(TipoClase tipoClase) {
        this.tipoClase=tipoClase;
    }
    public TipoClase getTipoClase() {
        return this.tipoClase;
    }

    public int getAlmacenadas() {
        return this.almacenadas;
    }

    public void setAlmacenadas(int almacenadas) {    //suma 1 a las clases almacenadas
        this.almacenadas++;
    }

    public List<Clase> getClases() {
        return this.clases;
    }

    public void setClases(Clase clase) {        //agrega una clase
         this.clases.add(clase);
    }
}