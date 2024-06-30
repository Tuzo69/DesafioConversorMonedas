import java.util.HashMap;

public class MapearOpcion {
    public static String[] mapeaOpcion(int opcion) {
        HashMap<Integer, String[]> miHashMap = new HashMap<>();

        String[] cambio1 = { "USD", "ARS" };
        String[] cambio2 = { "ARS", "USD" };
        String[] cambio3 = { "USD", "MXN" };
        String[] cambio4 = { "MXN", "USD" };
        String[] cambio5 = { "USD", "COP" };
        String[] cambio6 = { "COP", "USD" };

        miHashMap.put(1, cambio1);
        miHashMap.put(2, cambio2);
        miHashMap.put(3, cambio3);
        miHashMap.put(4, cambio4);
        miHashMap.put(5, cambio5);
        miHashMap.put(6, cambio6);

        return miHashMap.get(opcion);
    }
}
