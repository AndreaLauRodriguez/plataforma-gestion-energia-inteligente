import bateria.Bateria;
import observer.ObservadorBateria;

public class RegistroAuditoria implements ObservadorBateria {
    @Override
    public void actualizar(Bateria bateria, String mensaje) {
        System.out.println("[AUDITORÍA CENTRAL] Registro exitoso -> " + mensaje);
    }
}
