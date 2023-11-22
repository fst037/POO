package Negocio.articulos;

import Negocio.inmuebles.Sede;
import Negocio.clases.Clase;
import Negocio.enums.Amortizacion;

import java.time.*;
import java.util.*;

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
        this.agendaReservas = new ArrayList<Clase>();
    }

    public final String toString(){
        return this.tipo + "|" + this.verDesgasteEnPorcentaje() + "%|" + this.fechaFabricacion.toString();
    }
    
    public Amortizacion getAmortizacion() {
        return this.tipo.getAmortizacion();
    }

    public TipoArticulo getTipo() {
        return this.tipo;
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

    public boolean tieneVidaUtilRestante() {
        this.setDesgasteActual(this.fechaFabricacion.until(LocalDate.now()).getDays());
        return this.getDesgasteActual() < this.getDesgasteMax();
    }

    public void actualizarDesgaste() {
        // si su desgaste es por uso, le suma 1 y sino calcula la diferencia de dias entre la fecha de fabricacion y la fecha actual
        if (this.getAmortizacion() == Amortizacion.porUso) {
            this.setDesgasteActual(this.getDesgasteActual() + 1);
        } else {
            this.setDesgasteActual(this.fechaFabricacion.until(LocalDate.now()).getDays());
        }
    }
    
    public final float verDesgasteEnPorcentaje() {
        // devuelve el desgaste entre 1.00 y 0.00. Siendo 1.00 el 100% de desgaste y 0.00 el 0% de desgaste
        return this.getDesgasteActual() / this.getDesgasteMax();
    }

}