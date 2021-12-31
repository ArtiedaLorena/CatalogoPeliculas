package mx.com.gm.peliculas.presentacion;

//Aca se trabaja con el usuario

import mx.com.gm.peliculas.negocio.CatalogoPeliculas;
import mx.com.gm.peliculas.negocio.CatalogoPeliculasImpl;

import java.util.Scanner;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        var opcion = -1;
        Scanner scanner = new Scanner (System.in);
        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0){
            System.out.println("\nElige una opcion: \n" +
                    "1. Inciar catalogo de peliculas\n"+
                    "2. Agregar pelicula\n"+
                    "3. Listar peliculas\n"+
                    "4. Buscar pelicula\n"+
                    "0. Salir");

            opcion = Integer. parseInt(scanner.nextLine());

            switch (opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;

                case 2:
                    System.out.println("Introduce el nombre de la pelicula");
                    var nombrePelicula= scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce la pelicual a buscar : ");
                    var buscarPelicula = scanner.nextLine();
                    catalogo.buscarPeliculas(buscarPelicula);
                    break;

                case 0:
                    System.out.println("Muchas gracias por elegirnos. Hasta pronto!");

                default:
                    System.out.println("Esa opcion no es correcta");
                    break;
            }

        }
    }
}
