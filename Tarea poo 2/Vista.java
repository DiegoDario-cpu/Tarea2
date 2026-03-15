import java.util.Scanner;

public class Vista{
    private Scanner sc = new Scanner(System.in);

    public void exitoInsertar(boolean bandera){
        String cadena = bandera ? "Canción insertada exitosamente." : "Error al insertar la canción.";
        System.out.println(cadena);
    }

    public void mostrarTodasLasMelodias(String cadenaMelodias){
        System.out.println("\n=== LISTA DE CANCIONES ===");
        System.out.println(cadenaMelodias);
    }

    public int mostrarMenu(){
        System.out.println("\n--- MENÚ PRINCIPAL ---");
        System.out.println("1. Ingresar una melodía");
        System.out.println("2. Mostrar todas las melodías");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public Cancion capturaMelodia() {
        sc.nextLine(); // Limpiar buffer
        System.out.print("Título: "); String t = sc.nextLine();
        System.out.print("Artista: "); String a = sc.nextLine();
        System.out.print("Compositor: "); String c = sc.nextLine();
        System.out.print("Año: "); int an = sc.nextInt();
        System.out.print("Precio: "); double p = sc.nextDouble();
        sc.nextLine(); // Limpiar buffer
        System.out.print("Género: "); String g = sc.nextLine();
        System.out.print("Formato: "); String f = sc.nextLine();
        
        return new Cancion(t, a, c, an, p, g, f);
    }


    /* 
    public void mostrarHashSet(HashSet<Cancion> canciones){
        System.out.println("\n=== CANCIONES EN HASHSET ===");
        for (Cancion c : canciones) {
            System.out.println(c);
        }
    }*/
}