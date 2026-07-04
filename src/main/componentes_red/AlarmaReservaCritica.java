import bateria.Bateria;
import observer.ObservadorBateria;

public class AlarmaReservaCritica implements ObservadorBateria {
    @Override
    public void actualizar(Bateria bateria, String mensaje) {
        if (bateria.getNivelEnergia() < 0) {
            System.err.println("[ALERTA CRÍTICA] Batería " + bateria.getId() 
                + " operando en zona de Overdraft. Nivel: " + bateria.getNivelEnergia() + " kWh");
        }
    }
}