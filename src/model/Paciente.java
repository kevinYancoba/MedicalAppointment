package model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

public class Paciente extends User {

    //atributos
    private String birthDay;
    private double peso;
    private double altura;
    private String sangre;
    private Type atributo3;


    private ArrayList<AppointmentsDoctor> appointmentsDoctors = new ArrayList<>();
    private ArrayList<AppointmetNurse> appointmetNurses = new ArrayList<>();

    public ArrayList<AppointmentsDoctor> getAppointmentsDoctors() {
        return appointmentsDoctors;
    }
    public void addAppointmentsDoctors(Doctor doctor, Date fecha, String hora) {
        AppointmentsDoctor  appointmentDoctors = new AppointmentsDoctor(this, doctor);
        appointmentDoctors.schedule(fecha, hora);
        appointmentsDoctors.add(appointmentDoctors);

    }

    public ArrayList<AppointmetNurse> getAppointmetNurses() {
        return appointmetNurses;
    }

    public void setAppointmetNurses(ArrayList<AppointmetNurse> appointmetNurses) {
        this.appointmetNurses = appointmetNurses;
    }


    //Metodo Constructor
    public Paciente (String nombre, String email){
        super(nombre, email);
    }

    // Setter and Getters
    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getAltura(){
    return altura + " mts";
    }


    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public double getPeso() {
        return peso ;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getSangre() {
        return sangre;
    }

    public void setSangre(String sangre) {
        this.sangre = sangre;
    }

    //polimorfismo por sobreescritura usando Interfaces
    @Override
    public String toString() {
        return super.toString()+ "\nEdad: "+ birthDay + "\nAltura: " + altura ;
    }

    //polimorfismo por Clase abstracta
    @Override
    public void showDataUser() {
        System.out.println("Historial Medico del Paciente");
        System.out.println("");
    }
}
