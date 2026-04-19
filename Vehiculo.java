/**
 * Clase abstracta que define la identidad base de cualquier unidad de transporte.
 * Implementa el concepto de abstraccion al ocultar los detalles de movimiento
 * y centralizar la gestion de identidad.
 */
public abstract class Vehiculo {

    // Atributo privado para encapsulamiento
    private String id;

    // Constructor para inicializar el identificador
    public Vehiculo(String id) {
        this.id = id;
    }

    /**
     * Metodo concreto que permite a todas las subclases reutilizar 
     * la logica de obtencion del ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo abstracto que obliga a las subclases (Dron, Camion, etc.)
     * a definir su propia logica de desplazamiento.
     */
    public abstract void patronMovimiento();
}
