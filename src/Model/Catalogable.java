package Model;

public interface Catalogable {
    int getId();
    double getPrecio();
    void aplicarDescuento(double porcentaje);
}
