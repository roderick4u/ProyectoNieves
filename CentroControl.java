import java.util.ArrayList;

/**
 * Clase que representa el núcleo de gestión de la ciudad inteligente.
 * Utiliza composición para mantener la lista de vehículos.
 */
public class CentroControl {
    
    // Composición: El Centro de Control "tiene" una colección de vehículos
    private ArrayList<Vehiculo> listaVehiculos;

    public CentroControl() {
        this.listaVehiculos = new ArrayList<>();
    }

    /**
     * Agregación: Permite añadir unidades externas (Drones, Camiones, etc.) 
     * a la flota de la ciudad.
     * @param v Cualquier objeto que extienda de la clase Vehiculo.
     */
    public void registrarUnidad(Vehiculo v) {
        listaVehiculos.add(v);
        System.out.println("Sistema: Unidad " + v.getId() + " registrada exitosamente.");
    }

    /**
     * Polimorfismo: Recorre la colección y ejecuta el comportamiento 
     * específico de cada vehículo sin conocer su clase concreta.
     */
    public void monitorearFlota() {
        System.out.println("\n--- Iniciando Monitoreo de Flota ---");
        for (Vehiculo v : listaVehiculos) {
            // Se llama al método abstracto definido en la clase padre,
            // pero se ejecuta la versión sobreescrita en la subclase.
            v.patronMovimiento();
            
            // Verificación opcional de comportamiento adicional (IConectable)
            if (v instanceof IConectable) {
                ((IConectable) v).sincronizarGPS();
            }
        }
        System.out.println("--- Fin del Reporte ---\n");
    }
}