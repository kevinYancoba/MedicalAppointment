package model;

import javax.print.Doc;
import java.util.Date;

public class AppointmentsDoctor implements ISchedulable{

    // Atributos
    private int id;
    private Paciente paciente;
    private Doctor doctor;
    private Date fecha;
    private String hora;

    //constructor


    public AppointmentsDoctor(Paciente paciente, Doctor doctor) {
        this.paciente = paciente;
        this.doctor = doctor;
    }

    //Setter and Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora + " hrs.";
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    //Implememtacion de la Interface
    @Override
    public void schedule(Date fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }
}
