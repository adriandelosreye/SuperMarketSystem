package Model;
import Enum.Categoria;

public class Producto implements Catalogable {
    private int id;
    private String nombre;
    private double precio;
    private Categoria categoria;

    public Producto(int id, String nombre, double precio, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void aplicarDescuento(double porcentaje){
        if(porcentaje > 0 && porcentaje <= 100){
            setPrecio(getPrecio() - getPrecio() * (porcentaje / 100));
        }
    }

    @Override
    public String toString() {
        return "ID: " + getId() + ", Nombre: " + getNombre() + ", Precio: $" + getPrecio();
    }
}
