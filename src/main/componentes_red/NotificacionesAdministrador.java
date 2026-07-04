import bateria.Bateria;
import observer.ObservadorBateria;

public class NotificacionesAdministrador implements ObservadorBateria {
    @Override
    public void actualizar(Bateria bateria, String mensaje) {
        System.out.println("[SMS ADMIN] Alerta para Técnico: " + mensaje);
    }
}