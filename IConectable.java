/**
 * Interfaz que define el comportamiento de conexión para las unidades de transporte.
 * Representa un "contrato" que cualquier clase puede decidir cumplir, 
 * independientemente de su posición en la jerarquía de herencia.
 */
public interface IConectable {

    /**
     * Al ser un método en una interfaz, es implícitamente public y abstract.
     * Define la capacidad de la unidad para sincronizar su ubicación vía satélite.
     */
    void sincronizarGPS();
}