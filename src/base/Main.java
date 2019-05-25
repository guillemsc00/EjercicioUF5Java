package base;

import Implementacion.EmpleadoDaoImp;
import Implementacion.PedidoDaoImp;
import Implementacion.ProductoDaoImp;
import Objetos.Empleado;
import consola.Consola;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Main aplicacion = new Main();
        aplicacion.start();

    }

    public static void start() {
        
        
        var empleadoAutenticado = new Empleado();
        var empleados = new EmpleadoDaoImp();
        var productos = new ProductoDaoImp();
        
        var pedidos = new PedidoDaoImp(empleadoAutenticado);

        var Consola = new Consola( empleadoAutenticado,  pedidos,  productos,  empleados);

        
    }

}
