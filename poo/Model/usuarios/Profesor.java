package usuarios;

import clases.Clase;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Profesor {

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;
    private float sueldo;
    private List<Clase> clases;


    public String getNombre() {
        return nombre;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public void agendarClase(Clase clase) {  //agrega clase a la lista
        this.clases.add(clase);
    }

    public boolean isDisponibleParaClase(LocalDateTime fHI, LocalTime duracion) {  //verifica si el profesor esta disponible para dar una clase
        //TODO: implement here
        return true;
    }

    public void removeClase(Clase clase) {
        for (Clase claseEnLaLista:this.getClases()){  //saca una clase solicitada de la lista
            if (claseEnLaLista.equals(clase)){
                this.clases.remove(clase);
            }
        }
    }
}