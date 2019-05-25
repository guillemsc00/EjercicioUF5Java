/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.util.List;
import Objetos.Producto;



public class Pedido {
    private Empleado empleado;
    private List<Producto> listaPedido;
    private double precioTotal;

    public Pedido(Empleado empleado, List<Producto> listaPedido, double precioTotal) {
        this.empleado = empleado;
        this.listaPedido = listaPedido;
        this.precioTotal = precioTotal;
    }
    
    public Pedido(){
        this(null,null,0.0);
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Producto> getListaPedido() {
        return listaPedido;
    }

    public void setListaPedido(List<Producto> listaPedido) {
        this.listaPedido = listaPedido;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
    
    
    
    
    
}
