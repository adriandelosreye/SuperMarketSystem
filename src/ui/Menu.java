package ui;

import Model.Producto;
import Enum.Categoria;
import Service.ProductoService;

import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);
    private static final ProductoService productoService = new ProductoService();

    public static void mostrar(){
        int option;
        System.out.println("Bienvenido al sistema del supermercado");
        do {
            System.out.println("""
                    Ingrese una opcion
                    1- Listar productos disponibles
                    2- Ver productos por categoria
                    3- Ver detalles de un producto
                    4- Comprar producto
                    5- Ingresar como empleado
                    5- Salir
                    """);
            option = sc.nextInt();

            switch (option){
                case 1:
                    listarProductos();
                    break;
                case 2:
                    listarProductosPorCategoria();
                    break;
                case 3:
                    verProductoDetalle();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (option != 5);
    }

    public static void listarProductos(){
        productoService.obtenerProductos().forEach(System.out::println);
    }

    public static void listarProductosPorCategoria(){
        Categoria[] categorias = Categoria.values();
        for (int i = 0; i < categorias.length; i++) {
            System.out.println(i + " - " + categorias[i]);
        }
        System.out.println("Ingresa una categoria por su numero");
        Categoria categoria = categorias[sc.nextInt()];
        productoService.obtenerProductos(categoria).forEach(System.out::println);
    }

    public static void verProductoDetalle(){
        listarProductos();
        System.out.println("Ingresa el id de un producto");
        Producto producto = productoService.obtenerProducto(sc.nextInt());
        System.out.println(producto != null ? producto : "El producto no existe");
    }
}
