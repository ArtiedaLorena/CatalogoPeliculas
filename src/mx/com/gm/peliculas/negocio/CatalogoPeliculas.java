package mx.com.gm.peliculas.negocio;


public interface CatalogoPeliculas {

    String NOMBRE_ARCHIVO = "Peliculas.txt";

    void agregarPelicula(String nombrePelicula);

    void listarPeliculas();

    void buscarPeliculas(String buscar);

    void iniciarCatalogoPeliculas();

}
