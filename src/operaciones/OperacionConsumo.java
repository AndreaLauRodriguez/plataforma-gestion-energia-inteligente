import bateria.Bateria;
import excepciones.LimiteReservaExcedidoException;
import excepciones.ValorInvalidoException;

public class OperacionConsumo implements Operacion {
    private final Bateria bateria;
    private final double kwh;

    public OperacionConsumo(Bateria bateria, double kwh) {
        if (kwh <= 0) {
            throw new ValorInvalidoException("El valor de consumo debe ser estrictamente mayor a 0 kWh.");
        }
        this.bateria = bateria;
        this.kwh = kwh;
    }

    @Override
    public void ejecutar() throws LimiteReservaExcedidoException {
        bateria.consumir(kwh);
    }

    @Override
    public void deshacer() {
        bateria.cargar(kwh);
    }
}
