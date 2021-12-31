package mx.com.gm.peliculas.excepciones;

import mx.com.gm.peliculas.datos.AccesoDatosImpl;

public class AccesoDatosEx extends Exception{

    public AccesoDatosEx (String mensaje){
        super(mensaje);
    }
}
