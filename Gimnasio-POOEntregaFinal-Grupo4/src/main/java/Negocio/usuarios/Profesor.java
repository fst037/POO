package Negocio.usuarios;

import Negocio.clases.Clase;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Profesor extends Usuario{    
    
    private float salario;
    private List<Clase> clases;

    public Profesor(String nombre, int dni, float salario) {
        super(nombre, dni);
        this.salario = salario;
        this.clases = new ArrayList<Clase>();
    }

    public String toString(){
        return "Nombre: " + this.getNombre() + " DNI: " + this.getDni();
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
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
        boolean disponible = true;
              
        List<Clase> clasesDelDia = new ArrayList<Clase>();       

        for (Clase clase : this.getClases()) {
            if (clase.getFechaHoraInicio().toLocalDate().equals(fHI.toLocalDate())) {  //si la clase es en el mismo dia
                clasesDelDia.add(clase);
            }
        }
        //valida si el profesor tiene menos de 3 clases agendadas para el dia
        if (clasesDelDia.size() < 3){
            for (Clase clase : clasesDelDia) {
                //chequea si para cada clase ya agendada si se superpone en 3 hs con el horario actual
                if (!(clase.getFechaHoraInicio().toLocalTime().isBefore(fHI.toLocalTime().minusHours(3)) || 
                    clase.getFechaHoraFin().toLocalTime().isAfter(fHI.toLocalTime().plusHours(3)))) {
                    disponible = false;
                    break;
                }                
            }
        } else {
            disponible = false;
        }

        return disponible;
    }

    public void removeClase(Clase clase) {
        for (Clase claseEnLaLista:this.getClases()){  //saca una clase solicitada de la lista
            if (claseEnLaLista.equals(clase)){
                this.clases.remove(clase);
            }
        }
    }
}