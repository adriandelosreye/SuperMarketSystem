package Model;

public abstract class Persona {
    private String nombre;
    private String identificacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Persona(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    // Metodo abstracto para definir una acción específica según el tipo de persona
    public abstract void realizarAccion();

    //Informacion
    public abstract void mostrarInformacion();

    // Beneficios.
    public abstract double calcularBeneficio();

}
