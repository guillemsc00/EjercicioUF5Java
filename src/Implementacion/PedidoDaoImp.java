/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementacion;

import Definicion.PedidoDao;
import Objetos.*;
import Definicion.*;
import Implementacion.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDaoImp implements PedidoDao{
    
    List <Producto> cesta;
    Empleado empleadoAutenticado;
    
    public PedidoDaoImp(Empleado empleadoAutenticado){
        setEmpleadoAutenticado(empleadoAutenticado);
        setCesta(new ArrayList<Producto>());
        
    }    

    public List<Producto> getCesta() {
        return cesta;
    }

    public void setCesta(List<Producto> cesta) {
        this.cesta = cesta;
    }

    public Empleado getEmpleadoAutenticado() {
        return empleadoAutenticado;
    }

    public void setEmpleadoAutenticado(Empleado empleadoAutenticado) {
        this.empleadoAutenticado = empleadoAutenticado;
    }
    
    
    
    @Override
    public void añadirProducto(Producto producto) {
        this.cesta.add(producto);
        
    }

    @Override
    public double leerPrecioTotal() {
        double precioTotal=0.0;
        
        for (Producto producto : this.getCesta()) {
            precioTotal +=producto.getPrecio();
        }
        return precioTotal;
    }

    @Override
    public void imprimirRecibo() {
        for (Producto i : this.cesta) {
                System.out.println(
                        "Codigo: " + i.getCodigo()+ "\n"
                        + "Nombre: " + i.getNombre()+ "\n"
                        + "Descripcion: " + i.getDescripcion()+ "\n"
                        + "Precio: " + i.getPrecio()+ "\n"
                );
                System.out.println(
                        "el precio total es de: " + leerPrecioTotal()
                        + "\nEl vendedor a cargo fue: " + this.getEmpleadoAutenticado().getNombre()
                        
                        );
                
            }

        
    }
    
    
}
