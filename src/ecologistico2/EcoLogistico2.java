package ecologistico2;

import java.util.List;
import java.util.Optional;

/**
 * ejercicio 1 – CRUDya
 * ejercicio 2 – Lambdaya
 * ejercicio 3 – Streamsya
 * ejercicio 4 – Ordenamientoya
 * ejercicio 5 – Integracionya    
 * ejercicio 6 – Reportes y estadisticasya
 */
public class EcoLogistico2 {

    public static void main(String[] args) {

        CentroControl centro = new CentroControl();

        separador("EJERCICIO 1 – CRUD: Crear vehiculos (CREATE)");

        Vehiculo d1 = new DronTransporte("DRON-001");
        Vehiculo d2 = new DronTransporte("DRON-002");
        Vehiculo c1 = new CamionAutonomo("CAM-001");
        Vehiculo c2 = new CamionAutonomo("CAM-002");
        Vehiculo m1 = new MotoElectrica("MOTO-001");

        centro.crearVehiculo(d1);
        centro.crearVehiculo(d2);
        centro.crearVehiculo(c1);
        centro.crearVehiculo(c2);
        centro.crearVehiculo(m1);

        // Intento de ID duplicado
        centro.crearVehiculo(new DronTransporte("DRON-001"));

        separador("CRUD: Listar todos (READ)");
        centro.listarVehiculos();

        separador("CRUD: Buscar por ID (READ)");
        Optional<Vehiculo> encontrado = centro.buscarVehiculo("CAM-001");
        if (encontrado.isPresent()) {
            System.out.println("Vehiculo encontrado: " + encontrado.get());
        } else {
            System.out.println("Vehiculo no encontrado.");
        }

        Optional<Vehiculo> noExiste = centro.buscarVehiculo("XYZ-999");
        System.out.println("Busqueda XYZ-999: " + (noExiste.isPresent() ? noExiste.get() : "No encontrado"));

        separador("CRUD: Modificar vehiculo (UPDATE)");
        centro.modificarVehiculo("DRON-002", "DRON-002-MOD");
        centro.listarVehiculos();

        separador("CRUD: Eliminar vehiculo (DELETE)");
        centro.eliminarVehiculo("CAM-002");
        centro.eliminarVehiculo("NO-EXISTE");
        centro.listarVehiculos();

        // -------------------------------------------------------
        separador("EJERCICIO 2 – Lambda: mostrarInfoConLambda()");
        centro.mostrarInfoConLambda();

        // -------------------------------------------------------
        separador("EJERCICIO 3 – Streams");

        System.out.println(">> Vehiculos conectables (IConectable):");
        List<Vehiculo> conectables = centro.filtrarConectables();
        conectables.forEach(v -> System.out.println("   " + v));

        System.out.println("\n>> Lista de IDs:");
        System.out.println("   " + centro.obtenerListaIds());

        System.out.println("\n>> Total de vehiculos: " + centro.contarVehiculos());

        System.out.println("\n>> Buscar por tipo 'DronTransporte':");
        centro.buscarPorTipo("DronTransporte").forEach(v -> System.out.println("   " + v));

        // -------------------------------------------------------
        separador("EJERCICIO 4 – Ordenamiento");

        System.out.println(">> Ordenados por ID:");
        centro.ordenarPorId().forEach(v -> System.out.println("   " + v));

        System.out.println("\n>> Ordenados por Tipo:");
        centro.ordenarPorTipo().forEach(v -> System.out.println("   " + v));

        // -------------------------------------------------------
        separador("EJERCICIO 5 – Integracion: monitorearFlota()");
        centro.monitorearFlota();

        // -------------------------------------------------------
        separador("EJERCICIO 6 – Reporte general y busqueda avanzada");
        centro.generarReporte();

        System.out.println(">> Busqueda avanzada con 'dron':");
        centro.busquedaAvanzada("dron").forEach(v -> System.out.println("   " + v));

        System.out.println("\n>> Busqueda avanzada con 'moto':");
        centro.busquedaAvanzada("moto").forEach(v -> System.out.println("   " + v));
    }

    /** un separador visual con titulo para mejorar como se lee. */
    private static void separador(String titulo) {
        System.out.println("\n==========================================");
        System.out.println("  " + titulo);
        System.out.println("==========================================");
    }
}
