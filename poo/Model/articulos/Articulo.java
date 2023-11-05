package articulos;

import gimnasios.Sede;
import clases.Clase;
import enums.Amortizacion;

import java.io.*;
import java.time.*;
import java.util.*;

/**
 * 
 */
public class Articulo {

    private TipoArticulo tipo;
    private Sede sede;
    private int desgasteActual;
    private LocalDate fechaFabricacion;
    private List<Clase> agendaReservas;

    public Articulo(TipoArticulo tipo, Sede sede, LocalDate fechaFabricacion) {
        this.tipo = tipo;
        this.sede = sede;
        this.desgasteActual = 0;
        this.fechaFabricacion = fechaFabricacion;
        this.agendaReservas = new ArrayList<Clase>()
    }
    public Amortizacion getAmortizacion() {
        return this.tipo.getAmortizacion();
    }
    public Sede getSede() {
        return this.sede;
    }
    public void setSede(Sede sede) {
        this.sede = sede;
    }
    public int getDesgasteMax() {
        return this.tipo.getDesgasteMax();
    }
    public int getDesgasteActual() {
        return this.desgasteActual;
    }
    public void setDesgasteActual(int desgasteActual) {
        this.desgasteActual = desgasteActual;
    }
    public LocalDate getFechaFabricacion() {
        return this.fechaFabricacion;
    }
    public float getCosto() {
        return this.tipo.getCosto();
    }
    public boolean isDisponibleParaFechaHorario(LocalDateTime fechaHoraInicio, LocalTime duracion) {
        boolean disponible = true;

        LocalTime horaFin = LocalTime.of(fechaHoraInicio.getHour() + duracion.getHour(), fechaHoraInicio.getMinute() + duracion.getMinute());
        LocalDateTime fechaHoraFin = LocalDateTime.of(fechaHoraInicio.toLocalDate(), horaFin);

        for (Clase clase: agendaReservas) {
            //si la clase es el mismo dia
            if
            (
                (
                    fechaHoraFin.isAfter(clase.getFechaHoraInicio())
                    &&
                    fechaHoraFin.isBefore(clase.getFechaHoraFin())
                ) || (
                    fechaHoraInicio.isAfter(clase.getFechaHoraInicio())
                    &&
                    fechaHoraFin.isBefore(clase.getFechaHoraFin())
                ) || (
                    fechaHoraInicio.isBefore(clase.getFechaHoraInicio())
                    &&
                    fechaHoraFin.isAfter(clase.getFechaHoraFin())
                )
            ) {
                disponible = true;
                break;
            }
        }

        return disponible;
    }
    public void reservarEnAgenda(Clase clase) {
        if (!this.agendaReservas.contains(clase)){
            this.agendaReservas.add(clase);
        }
    }
    public boolean tieneVidaUtilRestante() {
        return this.getDesgasteActual() < this.getDesgasteMax();
    }
    public void actualizarDesgaste() {
        // TODO implement here
        return null;
    }
    public float verDesgasteEnPorcentaje() {
        // TODO implement here
        return 0.0f;
    }

}