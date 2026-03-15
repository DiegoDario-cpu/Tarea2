import java.util.ArrayList;
import java.util.HashMap;


public class CatalogoMelodias {
    private final ArrayList<Cancion> canciones; // Cambiado a Cancion

    public CatalogoMelodias() {
        canciones = new ArrayList<>();
    }

    public boolean agregarMelodia(Cancion cancion) {
        if (cancion != null) {
            canciones.add(cancion);
            return true;
        }
        return false;
    }

    public String obtenerTodas() {
        if (canciones.isEmpty()) return "El catálogo está vacío.";
        StringBuilder sb = new StringBuilder();
        for (Cancion c : canciones) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }

    public HashMap<String, Cancion> obtenerMelodiasPorGenero() {
        HashMap<String, Cancion> mapa = new HashMap<>();
        for (Cancion c : canciones) {
            mapa.put(c.getGeneroMusical(), c);
        }
        return mapa;
    }

	public HashMap<String, Cancion> getGeneroMusical() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getGeneroMusical'");
	}
}