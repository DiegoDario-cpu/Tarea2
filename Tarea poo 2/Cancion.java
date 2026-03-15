public class Cancion {
    private String titulo;
    private String artista;
    private String compositor;
    private int anio;
    private double precio;
    private String generoMusical;
    private String formato;

    // Constructor actualizado para recibir todos los atributos
    public Cancion(String titulo, String artista, String compositor, int anio, double precio, String generoMusical, String formato) {
        this.titulo = titulo;
        this.artista = artista;
        this.compositor = compositor;
        this.anio = anio;
        this.precio = precio;
        this.generoMusical = generoMusical;
        this.formato = formato;
    }
    
    // Getters y Setters se mantienen igual...
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getArtista() { return artista; }
    public void setArtista(String artista) { this.artista = artista; }
    public String getCompositor() { return compositor; }
    public void setCompositor(String compositor) { this.compositor = compositor; }
    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public String getGeneroMusical() { return generoMusical; }
    public void setGeneroMusical(String generoMusical) { this.generoMusical = generoMusical; }
    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }

    public boolean mismaVersion(String artista, int anio) {
        return this.artista.equalsIgnoreCase(artista) && this.anio == anio;
    }

    @Override
    public String toString() {
        return "---------------------------\n" +
               "Canción: " + titulo + 
               "\n  Artista: " + artista + 
               "\n  Compositor: " + compositor + 
               "\n  Año: " + anio + 
               "\n  Género: " + generoMusical + 
               "\n  Precio: $" + String.format("%.2f", precio) + 
               "\n  Formato: " + formato;
    }
}