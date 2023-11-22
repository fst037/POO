package Negocio.clases;

import Negocio.enums.Amortizacion;
import Negocio.enums.EstadoClase;
import Negocio.usuarios.Profesor;
import Negocio.articulos.Articulo;
import Negocio.articulos.TipoArticulo;
import Negocio.enums.Nivel;
import Negocio.inmuebles.Sede;
import Negocio.inmuebles.Emplazamiento;
import Negocio.usuarios.Cliente;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Clase {

    private EstadoClase estadoClase;    
    private Profesor profesor;    
    private TipoClase tipoClase;    
    private List<Articulo> articulosReservados;  
    private LocalDateTime fechaHoraInicio;    
    private LocalTime duracion;    
    private Sede sede;    
    private Emplazamiento emplazamiento;    
    private int capacidadMaxima;    
    private List<Cliente> alumnosInscriptosPresencial;    
    private List<Cliente> alumnosInscriptosOnline;

    public Clase(Profesor prof, TipoClase tipoClase, Sede sede, Emplazamiento emp, LocalDateTime fHI, LocalTime duracion) {
        this.profesor = prof;
        this.tipoClase = tipoClase;
        this.sede = sede;
        this.emplazamiento = emp;
        this.fechaHoraInicio = fHI;
        this.duracion = duracion;
        this.capacidadMaxima = ((int)emp.getMetrosCuadrados() / 2);
        this.articulosReservados = new ArrayList<Articulo>();

        assert emp.isDisponibleParaFechaHorario(fHI, duracion) : "El Emplazamiento no esta disponible en ese momento.";
        
        HashMap<TipoArticulo, Integer> cantidadesArticulosNecesarios = new HashMap<TipoArticulo, Integer>();

        for (TipoArticulo tipoArticulo: tipoClase.getArticulosNecesariosParaProfesor())
            //guarda la cantidad de articulos necesarios para el profesor
            if (cantidadesArticulosNecesarios.containsKey(tipoArticulo))
                cantidadesArticulosNecesarios.put(tipoArticulo, cantidadesArticulosNecesarios.get(tipoArticulo) + 1);
            else
                cantidadesArticulosNecesarios.put(tipoArticulo, 1);
        
        for (TipoArticulo tipoArticulo : tipoClase.getArticulosNecesariosPorCliente()){
            //guarda la cantidad de articulos necesarios para los clientes maximos de la clase
            if (cantidadesArticulosNecesarios.containsKey(tipoArticulo)){
                cantidadesArticulosNecesarios.put(tipoArticulo, cantidadesArticulosNecesarios.get(tipoArticulo) + this.capacidadMaxima);
            }
            else{
                cantidadesArticulosNecesarios.put(tipoArticulo, this.capacidadMaxima);
            }
        }        
        for (TipoArticulo tipoArticulo: cantidadesArticulosNecesarios.keySet()){
            for (Articulo articulo : this.sede.getArticulos()) {
                if (
                    articulo.getTipo() == tipoArticulo && 
                    cantidadesArticulosNecesarios.get(tipoArticulo) > 0 &&
                    articulo.isDisponibleParaFechaHorario(fHI, duracion) &&
                    articulo.tieneVidaUtilRestante()
                    ) {//agrega los articulos como reservados, pero los articulos no lo saben todavia, ya que si encuentra faltantes, la clase no se da, y los articulos nunca se reservan
                    this.articulosReservados.add(articulo);
                    cantidadesArticulosNecesarios.put(tipoArticulo, cantidadesArticulosNecesarios.get(tipoArticulo) - 1);
                }
            }
        }

        for (TipoArticulo tipoArticulo: cantidadesArticulosNecesarios.keySet()) {
            if (cantidadesArticulosNecesarios.get(tipoArticulo) > 0) {
                this.articulosReservados.clear();
                assert false : "No hay suficientes articulos para dictar la clase. Faltan articulos de tipo " + tipoArticulo.getNombre() + ".";
            }
        }

        //confirma las reservas, ya se que sabe que esta todo ok
        for (Articulo articulo : this.articulosReservados) {
            articulo.reservarEnAgenda(this);
        }

        emp.reservarEnAgenda(this);
        this.alumnosInscriptosPresencial = new ArrayList<Cliente>();
        this.alumnosInscriptosOnline = new ArrayList<Cliente>();
        this.estadoClase = EstadoClase.Agendada;
    }
    
    public String toString(){
        return this.tipoClase.getNombre() + " - " + this.estadoClase.toString() + " - " +  this.fechaHoraInicio.toString()
                + " - " + this.duracion + " - " + this.profesor.getNombre();
    }
    
    public EstadoClase getEstadoClase() {
        return this.estadoClase;
    }

    public void setEstadoClase(EstadoClase estadoClase) {
        this.estadoClase = estadoClase;      
    }

    public Profesor getProfesor() {
        return this.profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;      
    }

    public TipoClase getTipoClase() {
        return this.tipoClase;
    }

    public List<Articulo> getArticulosReservados() {
        return this.articulosReservados;
    }

    public void setArticulosReservados(List<Articulo> articulos) {
        this.articulosReservados = articulos;    
    }

    public float getCostos() {
        float costo = 0;

        costo = costo + this.profesor.getSalario() / 90;

        switch (emplazamiento.getTipo()) {
            case Salon:
                costo = costo + this.sede.getAlquiler() / 300;                
                break;
            
            case Pileta:
                costo = costo + this.sede.getAlquiler() / 150;                
                break;
            case AireLibre:
                costo = costo + this.emplazamiento.getMetrosCuadrados() * 500 * (this.getDuracion().getMinute() / 60 + this.getDuracion().getHour());                
                break;            
        }

        for (Articulo articulo : this.articulosReservados) {
            if (articulo.getAmortizacion() == Amortizacion.porUso) {
                costo = costo + articulo.getCosto() / articulo.getDesgasteMax(); //costo por uso
            } else {
                costo = costo + ((this.getDuracion().getMinute() / 60 + this.getDuracion().getHour()) / 8) * articulo.getCosto() / articulo.getDesgasteMax() ; //costo por fecha
            }
        }

        return costo;
    }

    public float getIngresos() {
        float ingresos = 0;

        for (Cliente alumno : this.alumnosInscriptosPresencial) {
            ingresos = ingresos + alumno.getCostoMensual() / 30;
        }

        for (Cliente alumno : this.alumnosInscriptosOnline) {
            ingresos = ingresos + alumno.getCostoMensual() / 30;
        }

        return ingresos;
    }

    public LocalDateTime getFechaHoraInicio() {
        return this.fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return this.fechaHoraInicio.plusMinutes(this.duracion.getMinute()).plusHours(this.duracion.getHour());
    }

    public void setFechaHoraInicio(LocalDateTime fecha) {
        this.fechaHoraInicio = fecha;    
    }

    public LocalTime getDuracion() {
        return this.duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public Sede getSede() {
        return this.sede;
    }

    public Emplazamiento getEmplazamiento() {
        return this.emplazamiento;
    }

    public void setEmplazamiento(Emplazamiento emplazamiento) {
        this.emplazamiento = emplazamiento;    
    }

    public int getCapacidadMaxima() {
        return this.capacidadMaxima;
    }

    public List<Cliente> getAlumnosInscriptosPresencial() {
        return this.alumnosInscriptosPresencial;
    }

    public void setAlumnosInscriptosPresencial(List<Cliente> alumnosInscriptosPresencial) {
        this.alumnosInscriptosPresencial = alumnosInscriptosPresencial;
    }

    public List<Cliente> getAlumnosInscriptosOnline() {
        return this.alumnosInscriptosOnline;
    }

    public void setAlumnosInscriptosOnline(List<Cliente> alumnosInscriptosOnline) {
        this.alumnosInscriptosOnline = alumnosInscriptosOnline;
    }

    public boolean isClaseRentable() {
        return this.getCostos() < this.getIngresos();
    }
    
    public boolean isAlumnoPermitido(Cliente alumno){
        List<Nivel> niveles = Arrays.asList(Nivel.values());
        return niveles.indexOf(alumno.getNivel()) >= niveles.indexOf(this.sede.getNivelMinimo());
    }

    public boolean inscribirAlumnoPresencial(Cliente alumno) {
        if (isAlumnoPermitido(alumno) && this.alumnosInscriptosPresencial.size() < this.capacidadMaxima) {
            this.alumnosInscriptosPresencial.add(alumno);
            if (this.isClaseRentable() && fechaHoraInicio.isBefore(LocalDateTime.now())){
                this.setEstadoClase(EstadoClase.Confirmada);
            }
            return true;
        }
        return false;
    }

    public boolean inscribirAlumnoOnline(Cliente alumno) {
        assert this.tipoClase.getGrabacionesMaximas() > 0 : "Este tipo de clase no acepta modalidad Online";
        this.alumnosInscriptosOnline.add(alumno);
        if (this.isClaseRentable() && fechaHoraInicio.isBefore(LocalDateTime.now())){
                this.setEstadoClase(EstadoClase.Confirmada);
        }
        return true;
    }

    public void dictarClase() {
        if (this.getEstadoClase() == EstadoClase.Confirmada){
            this.setEstadoClase(EstadoClase.Finalizada);            
            for (Articulo articulo : this.articulosReservados) {
                articulo.actualizarDesgaste();
            }
        }
    }
}