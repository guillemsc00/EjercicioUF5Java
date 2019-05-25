package consola;

import Implementacion.EmpleadoDaoImp;
import Implementacion.PedidoDaoImp;
import Implementacion.ProductoDaoImp;
import Objetos.Empleado;
import java.io.Closeable;
import java.util.Scanner;

public class Consola {

    Scanner scan = new Scanner(System.in);
    Empleado empleadoAutenticado;
    PedidoDaoImp pedido;
    ProductoDaoImp productos;
    EmpleadoDaoImp empleados;

    public Consola(Empleado empleadoAutenticado, PedidoDaoImp pedido, ProductoDaoImp productos, EmpleadoDaoImp empleados) {
        this.empleadoAutenticado = empleadoAutenticado;
        this.pedido = pedido;
        this.productos = productos;
        this.empleados = empleados;
    }



    public void menu() {

        System.out.println("1. Hacer pedido\n"
                + "2. Modificar un producto\n"
                + "3. Cambiar contraseña empleado\n"
                + "4. Cerrar sesión");

        int respuesta = scan.nextInt();

        switch (respuesta) {
            case 1:
                hacerPedido();
                break;
            case 2:
                modificarProducto();
                break;
            case 3:
                cambiarContraseña();
                break;
            case 4:
                cerrarSesion();
                break;
        }
    }

    public void hacerPedido() {
        System.out.println("1.1Añadir producto a la cesta\n"
                + "1.2 Visualizar precio total de la cesta\n"
                + "1.3 Imprimir factura\n"
                + "1.4 Terminar pedido");
        int respuesta = scan.nextInt();

        switch (respuesta) {
            case 1:
                //pedido.añadirProducto(ProductoDaoImp.getProductoPorCodigo(this.productos, this.scan.nextInt()));
                break;
            case 2:
                pedido.getCesta();
                break;
            case 3:
                pedido.imprimirRecibo();
                break;
            case 4:
                cerrarSesion();
                break;
        }

    }

    public void modificarProducto() {
        System.out.println("2.1 Modificar nombre de producto\n"
                + "2.2 Modificar precio de producto\n"
                + "2.3 Modificar código de producto"
                + "2.4 Cerrar sesion"    );
        int respuesta = scan.nextInt();

        switch (respuesta) {
            case 1: productos.cambiarNombre(ProductoDaoImp.getProductoPorCodigo(this.productos, this.scan.nextInt()), this.scan.nextLine());
                break;            
            case 2: productos.cambiarPrecio(ProductoDaoImp.getProductoPorCodigo(this.productos, this.scan.nextInt()), this.scan.nextDouble());
                break;
            case 3: productos.cambiarCodigo(ProductoDaoImp.getProductoPorCodigo(this.productos, this.scan.nextInt()), this.scan.nextInt());
                break;
            case 4: cerrarSesion();
                break;
        }
    }

    public void cambiarContraseña() {
            empleados.cambiarContraseña(empleadoAutenticado.getCodigo(), this.scan.nextLine());
            System.out.println("\nEscribir la contraseña anterior: \n");
        this.empleadoAutenticado.getCodigo();
        var empleados = new EmpleadoDaoImp();
        empleados.cambiarContraseña(empleadoAutenticado.getCodigo(), this.scan.nextLine());
        System.out.println("\n Contraseña actualizada! \n");
        menu();
    }

    public void cerrarSesion() {
        this.empleadoAutenticado = new Empleado();
        this.pedido = new PedidoDaoImp(empleadoAutenticado);
        //loggin();//COMO LLAMO AL LOGIN DEL MAIN
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public Empleado getEmpleadoAutenticado() {
        return empleadoAutenticado;
    }

    public void setEmpleadoAutenticado(Empleado empleadoAutenticado) {
        this.empleadoAutenticado = empleadoAutenticado;
    }

    public PedidoDaoImp getPedido() {
        return pedido;
    }

    public void setPedido(PedidoDaoImp pedido) {
        this.pedido = pedido;
    }

    public ProductoDaoImp getProductos() {
        return productos;
    }

    public void setProductos(ProductoDaoImp productos) {
        this.productos = productos;
    }

}
