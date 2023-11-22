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
        this.clases = new ArrayList<Clase>();
    }
    
    public String toString(){
        return this.getNombre() + "|" + this.getDni() + "|" + this.nivel.toString();
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

    public void reservarClase(Clase clase, boolean isOnline) {
        boolean agendada = false;
        if (clienteDisponibleParaClase(clase)) {
            if (isOnline) {
                agendada = clase.inscribirAlumnoOnline(this);
            } else {
                agendada = clase.inscribirAlumnoPresencial(this);
            }
            if (agendada){
                this.clases.add(clase);
            }
        }
        assert agendada : "No se pudo agendar la clase";
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