package usuarios;
import clases.Clase;
import enums.Nivel;
import java.util.*;
public class Cliente extends Usuario {
    private Nivel nivel;
    private List<Clase> clases;

    public Cliente(String nombre, int dni, Nivel nivel) {
        super(nombre, dni);
        this.nivel = nivel;
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

    public boolean reservarClase(Clase clase, boolean isOnline) {
        if (clienteDisponibleParaClase(clase)) {
            this.clases.add(clase);
            clase.inscribirAlumno(this);
            //System.out.println("clase reservada");
            return true;
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