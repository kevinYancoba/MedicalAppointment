package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User{

    // Atributos
    private String especialidad;

    //constructor
    public Doctor(String nombre, String email){
        super(nombre, email);
    }

    //setter and Getters
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    //listas
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();

    public void addAvailableAppointment(String fecha, String hora){
        availableAppointments.add(new Doctor.AvailableAppointment(fecha, hora) );
    }
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }

    //Polimorfismo de sobre escritura por Interfaces
    @Override
    public String toString() {
        return super.toString() + "\nEspecialidad: " + especialidad + "Agenda: "+ availableAppointments.toString();
    }

    // Polimorfismo por clase abstracta
    @Override
    public void showDataUser() {
        System.out.println("Pertenece al Hospital: cruz roja");
        System.out.println("Departamento de: Cancerologia");
    }

    //Sub clase
    public static class AvailableAppointment{
    int id;
    Date fecha;
    String hora;
    SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");


        // constructor
        public AvailableAppointment(String fecha, String hora) {
            try {
                this.fecha = format.parse(fecha);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            this.hora = hora;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getFecha() {
            return fecha;
        }
        public String getFecha(String FECHA) {
            return format.format(fecha);
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }




        public String getHora() {
            return hora;
        }

        public void setHora(String hora) {
            this.hora = hora;
        }




        @Override
        public String toString() {
            return "AvailableAppointment" +
                    "\nfecha: " + fecha +
                    "\nhora: '" + hora;
        }
    }

}
