package model;

    //Declaración de una clase Abstracta
public abstract class User {
    //atributos
    private static int id;
    private String nombre;
    private String email;
    private String direccion;
    private String telefono;

    //constructor
    public User(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    //metodos set y get
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String eMail) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if(telefono.length() > 8){
            System.out.println("tu numero no debe ser mayor a 8 digitos");
        } else if (telefono.length() == 8) {
            this.telefono = telefono;
        }
    }

    // Polimorfismo por sobre escritura a travez de interfaces
    @Override
    public String toString() {
        return "Nombre: " + nombre+ "\ne-mail"+ email+ "\nTelefono: " +telefono ;
    }
    public abstract void showDataUser();
}
