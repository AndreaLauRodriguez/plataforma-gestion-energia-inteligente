
import excepciones.LimiteReservaExcedidoException;
import observer.ObservadorBateria;
import java.util.ArrayList;
import java.util.List;

public class Bateria {
    private final String id;
    private double nivelEnergia;
    private final List<ObservadorBateria> observadores = new ArrayList<>();

    public Bateria(String id, double nivelInicial) {
        this.id = id;
        this.nivelEnergia = nivelInicial;
    }

    public String getId() { return id; }
    public double getNivelEnergia() { return nivelEnergia; }

    public void cargar(double kwh) {
        this.nivelEnergia += kwh;
        this.notificarAObservadores("Se han cargado " + kwh + " kWh en su batería " + id);
    }

    public void consumir(double kwh) throws LimiteReservaExcedidoException {
       
        if (this.nivelEnergia - kwh < -5000) {
            throw new LimiteReservaExcedidoException(
                "Operación rechazada para " + id + ". Excede el límite de reserva permitido (-5000 kWh)."
            );
        }
        this.nivelEnergia -= kwh;
        this.notificarAObservadores("Se han consumido " + kwh + " kWh en su batería " + id);
    }

    
    public void agregarObservador(ObservadorBateria obs) {
        this.observadores.add(obs);
    }

    public void quitarObservador(ObservadorBateria obs) {
        this.observadores.remove(obs);
    }

    private void notificarAObservadores(String mensaje) {
        for (ObservadorBateria obs : this.observadores) {
            obs.actualizar(this, mensaje);
        }
    }
}
