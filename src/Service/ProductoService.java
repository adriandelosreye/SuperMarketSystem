package Service;

import Model.Producto;
import Enum.Categoria;

import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    private List<Producto> productos;

    public ProductoService() {
        this.productos = new ArrayList<>();
        productos.add(new Producto(1, "Manzana", 20, Categoria.FRUTAS));
        productos.add(new Producto(2, "Leche", 40, Categoria.LACTEOS));
    }

    public List<Producto> obtenerProductos(){
        return productos;
    }

    public List<Producto> obtenerProductos(Categoria categoria){
        return productos.stream().filter(producto -> producto.getCategoria() == categoria).toList();
    }

    public Producto obtenerProducto(int id){
           for (Producto producto : productos){
               if(producto.getId() == id){
                   return producto;
               }
           }
           return null;
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
}
