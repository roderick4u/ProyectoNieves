public class DronTransporte extends Vehiculo implements IConectable {

    public DronTransporte(String id) {
        super(id);
    }

    @Override
    public void patronMovimiento() {
        System.out.println("Dron [" + getId() + "]: Despegando verticalmente y siguiendo ruta aérea mediante rotores.");
    }

    @Override
    public void sincronizarGPS() {
        System.out.println("Dron [" + getId() + "]: Sincronizando con satélites en órbita baja... Conexión establecida.");
    }
}