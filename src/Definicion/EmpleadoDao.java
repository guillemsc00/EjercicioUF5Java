/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Definicion;

import Objetos.Empleado;
import java.util.ArrayList;
import java.util.List;

public interface EmpleadoDao {
    
    void cambiarContraseña(int codigoEmpleado, String nuevaContraseña);
    
    void escribirEnArchivo();
    
    List<Empleado> leerArchivo();
    
    @Override
    String toString();   
    
}
