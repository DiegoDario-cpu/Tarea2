import java.util.ArrayList;
import java.util.HashSet;

public class Catalogo {
    // Atributos
    private ArrayList<Cancion> canciones;
    private String dueno1;
    private String dueno2;

    // Constructor
    public Catalogo(String dueno1, String dueno2) {
        this.canciones = new ArrayList<>();
        this.dueno1 = dueno1;
        this.dueno2 = dueno2;
    }

    // 1. Agregar canción (sin duplicados por artista y año)
    public void agregarCancion(Cancion cancion) {
        // Verificar si ya existe (mismo artista y año)
        for (Cancion c : canciones) {
            if (c.mismaVersion(cancion.getArtista(), cancion.getAnio())) {
                System.out.println("Error: Ya tienes una canción de " + 
                                 cancion.getArtista() + " del año " + cancion.getAnio());
                return;
            }
        }
        canciones.add(cancion);
        System.out.println("Canción agregada: " + cancion);
    }

    // 2. Eliminar canción
    public void eliminarCancion(String titulo, String artista, int anio) {
        for (int i = 0; i < canciones.size(); i++) {
            Cancion c = canciones.get(i);
            if (c.getTitulo().equalsIgnoreCase(titulo) && 
                c.getArtista().equalsIgnoreCase(artista) && 
                c.getAnio() == anio) {
                canciones.remove(i);
                System.out.println("Canción eliminada: " + titulo);
                return;
            }
        }
        System.out.println("Canción no encontrada");
    }

    // 3. Ver datos de una canción
    public void verCancion(String titulo, String artista, int anio) {
        for (Cancion c : canciones) {
            if (c.getTitulo().equalsIgnoreCase(titulo) && 
                c.getArtista().equalsIgnoreCase(artista) && 
                c.getAnio() == anio) {
                System.out.println("\n=== DATOS DE LA CANCIÓN ===");
                System.out.println("Título: " + c.getTitulo());
                System.out.println("Artista: " + c.getArtista());
                System.out.println("Compositor: " + c.getCompositor());
                System.out.println("Año: " + c.getAnio());
                System.out.println("Precio: $" + c.getPrecio());
                System.out.println("Género: " + c.getGeneroMusical());
                System.out.println("Formato: " + c.getFormato());
                return;
            }
        }
        System.out.println("Canción no encontrada");
    }

    // 4. Corregir datos
    public void corregirCancion(String titulo, String artista, int anio, 
                               String nuevoTitulo, String nuevoGenero, 
                               double nuevoPrecio, String nuevoFormato) {
        for (Cancion c : canciones) {
            if (c.getTitulo().equalsIgnoreCase(titulo) && 
                c.getArtista().equalsIgnoreCase(artista) && 
                c.getAnio() == anio) {
                c.setTitulo(nuevoTitulo);
                c.setGeneroMusical(nuevoGenero);
                c.setPrecio(nuevoPrecio);
                c.setFormato(nuevoFormato);
                System.out.println("Datos actualizados");
                return;
            }
        }
        System.out.println("Canción no encontrada");
    }

    // 5. Verificar si ya tienen una canción (para comprar)
    public boolean yaTienen(String artista, int anio) {
        for (Cancion c : canciones) {
            if (c.mismaVersion(artista, anio)) {
                return true;
            }
        }
        return false;
    }

    // 6. Valor total de la colección
    public double valorTotal() {
        double total = 0;
        for (Cancion c : canciones) {
            total += c.getPrecio();
        }
        return total;
    }

    // 7. Cuántos y cuáles artistas tienen
    public void verArtistas() {
        HashSet<String> artistas = new HashSet<>();
        for (Cancion c : canciones) {
            artistas.add(c.getArtista());
        }
        
        System.out.println("\n=== ARTISTAS EN LA COLECCIÓN ===");
        System.out.println("Total de artistas: " + artistas.size());
        System.out.println("Lista de artistas:");
        for (String artista : artistas) {
            System.out.println("  - " + artista);
        }
    }

    // 8. Canciones por género
    public void cancionesPorGenero(String genero) {
        System.out.println("\n=== CANCIONES DE " + genero.toUpperCase() + " ===");
        int contador = 0;
        for (Cancion c : canciones) {
            if (c.getGeneroMusical().equalsIgnoreCase(genero)) {
                System.out.println("  - " + c);
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("  No hay canciones de este género");
        } else {
            System.out.println("Total: " + contador + " canciones");
        }
    }

    // 9. Géneros que tienen
    public void verGeneros() {
        HashSet<String> generos = new HashSet<>();
        for (Cancion c : canciones) {
            generos.add(c.getGeneroMusical());
        }
        
        System.out.println("\n=== GÉNEROS MUSICALES ===");
        System.out.println("Total de géneros: " + generos.size());
        System.out.println("Lista de géneros:");
        for (String genero : generos) {
            System.out.println("  - " + genero);
        }
    }

    // 10. Canciones de un artista específico
    public void cancionesDeArtista(String artista) {
        System.out.println("\n=== CANCIONES DE " + artista.toUpperCase() + " ===");
        int contador = 0;
        for (Cancion c : canciones) {
            if (c.getArtista().equalsIgnoreCase(artista)) {
                System.out.println("  - " + c);
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("  No hay canciones de este artista");
        } else {
            System.out.println("Total: " + contador + " canciones");
        }
    }

    // Mostrar todo el catálogo
    public void mostrarTodo() {
        System.out.println("\n=== CATÁLOGO DE " + dueno1 + " Y " + dueno2 + " ===");
        System.out.println("Total de canciones: " + canciones.size());
        System.out.println("Valor total: $" + valorTotal());
        
        if (canciones.isEmpty()) {
            System.out.println("El catálogo está vacío");
        } else {
            System.out.println("\nLISTA DE CANCIONES:");
            for (int i = 0; i < canciones.size(); i++) {
                System.out.println((i + 1) + ". " + canciones.get(i));
            }
        }
    }
}
