package Model;

public class Empleado extends Persona{
    private String puesto;
    private double salario;

    public Empleado(String nombre, String identificacion, String puesto, double salario ){
        super(nombre, identificacion);
        this.puesto = puesto;
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Método específico para procesar una compra
    public void procesarCompra(Cliente cliente, double monto) {
        System.out.println("Procesando compra por $" + monto + " para el cliente " + cliente.getNombre());

    }

    @Override
    public void realizarAccion() {
        System.out.println("El empleado "+ getNombre()+ " esta atendiendo en el area de  "+getPuesto());
    }


    @Override
    public void mostrarInformacion() {
        System.out.println("Empleado: "+ getNombre() + "| Identificacion: "+ getIdentificacion()+" | Puesto: "+ getPuesto()+" | Salario: "+ getSalario());
    }

    @Override
    public double calcularBeneficio() {
        return  salario * 0.15;
    }

}
