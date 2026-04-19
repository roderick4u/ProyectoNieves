public class CamionAutonomo extends Vehiculo {

    public CamionAutonomo(String id) {
        super(id);
    }

    @Override
    public void patronMovimiento() {
        System.out.println("Camión [" + getId() + "]: Desplazamiento terrestre mediante sensores LIDAR y radar en carretera.");
    }
}