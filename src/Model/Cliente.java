package Model;

public class Cliente extends Persona {
    private double saldo;

    public Cliente(String nombre, String identificacion, double saldo) {
        super(nombre, identificacion);
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void procesarCompra(Persona persona, double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            System.out.println("Pagando a: " + persona.getNombre() +". Pago exitoso. Saldo restante: $" + saldo);
        } else {
            System.out.println("Saldo insuficiente para realizar el pago.");
        }
    }

    @Override
    public void realizarAccion() {
        System.out.println("Accion cliente: El cliente "+ getNombre()+ " esta comprando productos.");
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Cliente: "+ getNombre()+ " | Identificacion: "+getIdentificacion()+ " | Saldo: "+ getSaldo());
    }

    @Override
    public double calcularBeneficio() {
        return saldo * 0.15;
    }
}