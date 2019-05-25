/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definicion;

import Objetos.*;

public interface PedidoDao {
    void añadirProducto(Producto codProducto);
    double leerPrecioTotal();
    void imprimirRecibo();
}
