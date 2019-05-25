/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementacion;

import Definicion.EmpleadoDao;
import Objetos.Empleado;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDaoImp implements EmpleadoDao{
    
    List<Empleado> empleados;
    private String rutaArchivoEmpleados = "src/archivos/empleados.txt"; 
   
    
    public EmpleadoDaoImp(){
        setEmpleados(leerArchivo());
    }
    

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public String getRutaArchivoEmpleados() {
        return rutaArchivoEmpleados;
    }

    public void setRutaArchivoEmpleados(String rutaArchivoEmpleados) {
        this.rutaArchivoEmpleados = rutaArchivoEmpleados;
    }

    @Override
    public void cambiarContraseña(int codigoEmpleado, String nuevaContraseña) {
        for(int i =0;i<this.getEmpleados().size();i++){
            if (this.getEmpleados().get(i).getCodigo()==codigoEmpleado){
                this.empleados.get(i).setContraseña(nuevaContraseña);
            }
            }
        escribirEnArchivo();
    }

    @Override
    public void escribirEnArchivo() {
        String listaEmpleados = this.toString();
        try{
            FileWriter ecribirArchivo = new FileWriter(this.rutaArchivoEmpleados);
            ecribirArchivo.write(listaEmpleados);
            ecribirArchivo.close();
        }catch(IOException e){
            
        }
        
    }

    @Override
    public List<Empleado> leerArchivo() {
        Path path = Paths.get(this.rutaArchivoEmpleados);
        List<Empleado> empleados = new ArrayList<>(); 
        
        try(var leerArchivo = Files.newBufferedReader(path)){
            
            int codigoEmpleado;
            String nombreEmpleado;
            String apellidoEmpleado;
            String contraseñaEmpleado;
            
            
            while(leerArchivo.readLine() != null){
                
                leerArchivo.readLine();
                codigoEmpleado=Integer.parseInt(leerArchivo.readLine().trim());
                
                leerArchivo.readLine();
                nombreEmpleado= leerArchivo.readLine().trim();
                
                leerArchivo.readLine();
                apellidoEmpleado= leerArchivo.readLine().trim();
                
                leerArchivo.readLine();
                contraseñaEmpleado= leerArchivo.readLine().trim();
                
                empleados.add(new Empleado(codigoEmpleado, nombreEmpleado, apellidoEmpleado, contraseñaEmpleado));
                
            }
        }catch(IOException e){
            
        }
        return empleados;
        
    }
    
    @Override
    public String toString(){
        String ListaEmpleados="";
        for(Empleado i : this.getEmpleados()){
            ListaEmpleados+=
                    "[empleado]" + 
                    "\n [codigo]\n " + 
                     i.getCodigo()+
                    "\n [nombre]\n " + 
                    i.getNombre() +
                    "\n [apellidos]\n " + 
                    i.getApellido() +
                    "\n [contraseña]\n " +
                    i.getContraseña()+
                    "\n";
        }
        
        return ListaEmpleados;
    }
}
