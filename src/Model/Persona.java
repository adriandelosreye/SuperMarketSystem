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

    // Metodo que define los pasos para realizar tareas de una persona (no se puede cambiar por eso el final)
    public final void realizarTareas() {
        mostrarInformacion();
        iniciarTareas();
        realizarAccion();
        double beneficio = calcularBeneficio();
        System.out.println("Beneficio calculado: $" + beneficio);
        finalizarTareas();
    }

    //Metodos concretos (comunes para todas las personas)
    public void iniciarTareas(){
        System.out.println("Iniciando tareas para: " + getNombre());
    }

    public void finalizarTareas(){
        System.out.println("Finalizando tareas para: " + getNombre());
    }

    // Metodo abstracto para definir una acción específica según el tipo de persona
    public abstract void realizarAccion();

    //Informacion
    public abstract void mostrarInformacion();

    // Beneficios.
    public abstract double calcularBeneficio();

    public abstract void procesarCompra(Persona persona, double monto);
}
