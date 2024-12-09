package ui;

import Model.Cliente;
import Model.Empleado;
import Model.Persona;
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
                    4- Operaciones Cliente.
                    5- Operaciones Empleado.
                    6- Salir
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
                case 4:
                    operacionesCliente();
                    break;
                case 5:
                    operacionesEmpleado();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (option != 6);
    }

//    private static void operacionesEmpleado() {
//        System.out.println("----OPERACIONES EMPLEADO--------");
//        Cliente cliente1 = new Cliente("Marina","110423394",1000);
//        Empleado empleado1 = new Empleado("Carlos","11046278293","Cajero",800);
//        empleado1.mostrarInformacion();
//        System.out.println("Beneficio empleado : "+empleado1.calcularBeneficio());
//        empleado1.realizarAccion();
//        empleado1.procesarCompra(cliente1,500);
//    }

//    private static void operacionesCliente() {
//        System.out.println("----OPERACIONES CLIENTE--------");
//        Cliente cliente1 = new Cliente("Carlos","1105673443",500);
//        cliente1.mostrarInformacion();
//        System.out.println("Beneficio cliente : "+ cliente1.calcularBeneficio());
//        cliente1.realizarAccion();
//        cliente1.pagar(400);
//    }

    private static void operacionesEmpleado(){
        System.out.println("----OPERACIONES EMPLEADO--------");

        Persona cliente = new Cliente("Marina","110423394",1000);
        Persona empleado = new Empleado("Carlos","11046278293","Cajero",800);

        empleado.realizarTareas();
        empleado.procesarCompra(cliente, 400);
    }

    private static void operacionesCliente(){
        System.out.println("----OPERACIONES CLIENTE--------");

        Persona cliente = new Cliente("Marina","110423394",1000);
        Persona empleado = new Empleado("Carlos","11046278293","Cajero",800);

        cliente.realizarTareas();
        cliente.procesarCompra(empleado,400);
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
