package mx.com.gm.peliculas.datos;


import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.peliculas.domain.Pelicula;

import java.io.FileNotFoundException;
import java.util.List;

public interface AccesoDatos {
     boolean existe (String nombreArchivo)throws AccesoDatosEx;
     List<Pelicula> listar (String nombre) throws LecturaDatosEx, FileNotFoundException;
     void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar)throws EscrituraDatosEx;
     String buscar (String nombreArchivo, String buscar) throws LecturaDatosEx;
     void crear(String nombreArchivo) throws AccesoDatosEx;
     void borrar(String nombreArchivo) throws AccesoDatosEx;


}
