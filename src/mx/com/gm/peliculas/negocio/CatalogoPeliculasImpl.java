package mx.com.gm.peliculas.negocio;

import mx.com.gm.peliculas.datos.AccesoDatos;
import mx.com.gm.peliculas.datos.AccesoDatosImpl;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.peliculas.domain.Pelicula;

import java.io.FileNotFoundException;

public class CatalogoPeliculasImpl implements CatalogoPeliculas {

    private final AccesoDatos datos;

    public CatalogoPeliculasImpl(){

        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_ARCHIVO);
            for (var pelicula: peliculas){
                System.out.println("Pelicula = "+ pelicula);
            }
        } catch (AccesoDatosEx | FileNotFoundException e) {
            System.out.println("Error de acceso a datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPeliculas(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_ARCHIVO, buscar);
        }catch(AccesoDatosEx e){
            System.out.println("Error de acceso a datos en el metodo buscar pelicula");
            e.printStackTrace(System.out);
        }
        System.out.println("resultado = " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if(this.datos.existe(NOMBRE_ARCHIVO)){
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);


            }else{
                datos.crear(NOMBRE_ARCHIVO);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Error al iniciar catalogo de peliculas");
            e.printStackTrace(System.out);
        }
    }
}
