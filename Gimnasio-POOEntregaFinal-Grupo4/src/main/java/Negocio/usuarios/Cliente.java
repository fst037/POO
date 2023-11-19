package Negocio.usuarios;
import Negocio.clases.Clase;
import Negocio.enums.Nivel;
import java.util.*;
public class Cliente extends Usuario {
    private Nivel nivel;
    private List<Clase> clases;

    public Cliente(String nombre, int dni, Nivel nivel) {
        super(nombre, dni);
        this.nivel = nivel;
    }

    @Override
    public String toString(){
        return "Nombre: " + this.getNombre() + " DNI: " + this.getDni();
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public float getCostoMensual() {
        switch (this.getNivel()) {
            case Black:
                return (float)3000;
            case Oro:
                return (float)2000;
            case Platinum:
                return (float)1000;
            default:
                return (float)0;
        }
    }

    public boolean reservarClase(Clase clase, boolean isOnline) {
        if (clienteDisponibleParaClase(clase)) {
            this.clases.add(clase);
            if (isOnline) {
                return clase.inscribirAlumnoOnline(this);
            } else {
                return clase.inscribirAlumnoPresencial(this);
            }
            //System.out.println("clase reservada");            
        }
        //System.out.println("la clase no puede ser reservada");
        return false;
    }

    // un cliente no puede tener mas de una clase por dia
    public boolean clienteDisponibleParaClase(Clase clase) {
        // veo si existe alguna clase agendada para el dia que quiero reservar otra clase distinta
        for(Clase claseGuardada: this.clases){
            if (claseGuardada.getFechaHoraInicio().toLocalDate() == clase.getFechaHoraInicio().toLocalDate()) {
                return false;
            }
        }
        return true;
    }
}