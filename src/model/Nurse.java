package model;

public class Nurse extends User {

    public Nurse (String nombre, String email){
        super(nombre, email);
    }

    @Override
    public void showDataUser() {

    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    private String especialidad;






}
