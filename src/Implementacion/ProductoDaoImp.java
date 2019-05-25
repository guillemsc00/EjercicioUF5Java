package Implementacion;

import Definicion.ProductoDao;
import Objetos.Empleado;
import Objetos.Producto;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProductoDaoImp implements ProductoDao {

    List<Producto> productos;
    private String rutaArchivoProductos = "src/archivos/productos.txt";

    public ProductoDaoImp() {
        setProductos(leerArchivo());

    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getRutaArchivoProductos() {
        return rutaArchivoProductos;
    }

    public void setRutaArchivoProductos(String rutaArchivoProductos) {
        this.rutaArchivoProductos = rutaArchivoProductos;
    }

    @Override
    public void cambiarNombre(Producto producto, String nombreProducto) {

        for (int i = 0; i < this.getProductos().size(); i++) {
            if (this.getProductos().get(i).getCodigo() == producto.getCodigo()) {
                this.productos.get(i).setNombre(nombreProducto);
            }
        }
        escribirEnArchivo();
    }

    @Override
    public void cambiarCodigo(Producto producto, int codigoProducto) {
        for (int i = 0; i < this.getProductos().size(); i++) {
            if (this.getProductos().get(i).getCodigo() == producto.getCodigo()) {
                this.productos.get(i).setCodigo(codigoProducto);
            }
        }
        escribirEnArchivo();

    }

    @Override
    public void cambiarPrecio(Producto producto, double precioProducto) {
        for (int i = 0; i < this.getProductos().size(); i++) {
            if (this.getProductos().get(i).getCodigo() == producto.getCodigo()) {
                this.productos.get(i).setPrecio(precioProducto);
            }
        }
        escribirEnArchivo();

    }

    @Override
    public void escribirEnArchivo() {
        String listaProductos = this.toString();
        try {
            FileWriter ecribirArchivo = new FileWriter(this.rutaArchivoProductos);
            ecribirArchivo.write(listaProductos);
            ecribirArchivo.close();
        } catch (IOException e) {

        }

    }

    @Override
    public List<Producto> leerArchivo() {

        Path path = Paths.get(this.rutaArchivoProductos);
        List<Producto> productos = new ArrayList<>();

        try (var leerArchivo = Files.newBufferedReader(path)) {

            int codigoProducto;
            String nombreProducto;
            String descripcionProducto;
            double precioProducto;

            while (leerArchivo.readLine() != null) {

                leerArchivo.readLine();
                codigoProducto = Integer.parseInt(leerArchivo.readLine().trim());

                leerArchivo.readLine();
                nombreProducto = leerArchivo.readLine().trim();

                leerArchivo.readLine();
                descripcionProducto = leerArchivo.readLine().trim();

                leerArchivo.readLine();
                precioProducto = Double.parseDouble(leerArchivo.readLine().trim());

                productos.add(new Producto(codigoProducto, nombreProducto, descripcionProducto, precioProducto));

            }
        } catch (IOException e) {

        }
        return productos;
    }

    @Override
    public String toString() {
        String ListaProductos = "";
        for (Producto i : this.getProductos()) {
            ListaProductos
                    += "[producto]"
                    + "\n [codigo]\n "
                    + i.getCodigo()
                    + "\n [nombre]\n "
                    + i.getNombre()
                    + "\n [descripcion]\n "
                    + i.getDescripcion()
                    + "\n [precio]\n "
                    + i.getPrecio()
                    + "\n";
        }

        return ListaProductos;
    }

    public static Producto getProductoPorCodigo(ProductoDaoImp productos, int codigoDeProducto) {
        Producto producto = new Producto();
        for (int i = 0; i < productos.getProductos().size(); i++){
            if(productos.getProductos().get(i).getCodigo() == codigoDeProducto){
                producto = productos.getProductos().get(i);
            }
        }
        return producto;
    }

}
