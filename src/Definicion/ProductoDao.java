
package Definicion;

import Objetos.Producto;
import java.util.List;

public interface ProductoDao {
    
    void cambiarNombre(Producto producto, String nombreProducto);
    
    void cambiarCodigo(Producto producto, int codigoProducto);
    
    void cambiarPrecio(Producto producto, double precioProducto);
    
    void escribirEnArchivo();
    
    List<Producto> leerArchivo();
    
    @Override
    String toString();
    
    
}
