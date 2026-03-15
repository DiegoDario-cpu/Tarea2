import java.util.HashMap;

public class Controlador {
    private CatalogoMelodias modelo;
    private final Vista vista;

    public Controlador(CatalogoMelodias modelo, Vista vista){
        this.modelo = modelo;
        this.vista = vista;
    }

    public void insertarNuevaMelodia(){
        Cancion cancion = vista.capturaMelodia();
        boolean exito = modelo.agregarMelodia(cancion);
        vista.exitoInsertar(exito);
    }

    public void mostrarMelodias(){
        String lista = modelo.obtenerTodas();
        vista.mostrarTodasLasMelodias(lista);
    }

    public void iniciar(){
        int opcion;
        do { 
            opcion = vista.mostrarMenu();
            switch (opcion){
                case 1:
                    insertarNuevaMelodia();
                    break;
                case 2:
                    mostrarMelodias();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema... ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    public HashMap<String, Cancion> getGeneroMelodias() {
        return modelo.getGeneroMusical();
    }

    // Método Main para ejecutar el programa
    public static void main(String[] args) {
        Vista v = new Vista();
        CatalogoMelodias m = new CatalogoMelodias();
        Controlador c = new Controlador(m, v);
        c.iniciar();
    }
}