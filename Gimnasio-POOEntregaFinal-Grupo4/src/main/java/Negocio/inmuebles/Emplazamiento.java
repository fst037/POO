package Negocio.inmuebles;

import Negocio.clases.Clase;
import Negocio.enums.TipoEmplazamiento;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Emplazamiento {
    private TipoEmplazamiento tipo;
    private float metrosCuadrados;    
    private List<Clase> agendaReservas;

    public Emplazamiento(TipoEmplazamiento tipo, float metrosCuadrados) {
        this.tipo = tipo;
        this.metrosCuadrados = metrosCuadrados;
        this.agendaReservas = new ArrayList<Clase>();
    }

    public String toString(){
        return this.getTipo() + "|" + this.getMetrosCuadrados() + "m^2";
    }

    public TipoEmplazamiento getTipo() {
        return tipo;
    }

    public float getMetrosCuadrados() {
        return metrosCuadrados;
    }
    
    public boolean isDisponibleParaFechaHorario(LocalDateTime fechaHoraInicio, LocalTime duracion) {
        boolean disponible = true;

        LocalTime horaFin = LocalTime.of(fechaHoraInicio.getHour() + duracion.getHour(), fechaHoraInicio.getMinute() + duracion.getMinute());
        LocalDateTime fechaHoraFin = LocalDateTime.of(fechaHoraInicio.toLocalDate(), horaFin);

        for (Clase clase: agendaReservas) {
            //si la clase para la que se quiere reservar el articulo se superpone con alguna clase ya reservada, no se puede reservar
            if
            (
                !(
                    fechaHoraInicio.isAfter(clase.getFechaHoraFin()) ||
                    fechaHoraFin.isBefore(clase.getFechaHoraInicio())
                )
            ) {
                disponible = false;
                break;
            }
        }

        return disponible;
    }

    public void reservarEnAgenda(Clase clase) {
        if (!this.agendaReservas.contains(clase) && this.isDisponibleParaFechaHorario(clase.getFechaHoraInicio(), clase.getDuracion())){
            this.agendaReservas.add(clase);
        }
    }
}