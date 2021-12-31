package mx.com.gm.peliculas.datos;

import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;
import mx.com.peliculas.domain.Pelicula;
import java.io.*;
import java.util.*;


public class AccesoDatosImpl implements AccesoDatos {


    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File (nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx, FileNotFoundException {
        File archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();
        try (var entrada = new BufferedReader(new FileReader(archivo))) {
            String linea = null;
            linea = entrada.readLine();
            while(linea != null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar peliculas " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File (nombreArchivo);
        try {
            var salida = new PrintWriter((new FileWriter(archivo, anexar)));
            salida.println((pelicula.toString()));
            salida.close();
            System.out.println("Se ha escrito informacion al archivo "+ pelicula);
        } catch (IOException e) {
            throw new EscrituraDatosEx("Excepcion al escribir peliculas "+ e.getMessage());
        }
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            var entrada = new BufferedReader((new FileReader(nombreArchivo)));

            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while(linea != null){
                if( buscar != null && buscar.equalsIgnoreCase(linea)){
                resultado = "Pelicula "+ "'"+ linea +"'"+" encontrada en el indice:  " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar pelicula: "+ ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar pelicula: " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File (nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo ");
        } catch (IOException ex) {

            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear archivo: "+ ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        var archivo = new File (nombreArchivo);
        if (archivo.exists())
        archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }
}
