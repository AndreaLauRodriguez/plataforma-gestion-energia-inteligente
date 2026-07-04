import bateria.Bateria;
import excepciones.ValorInvalidoException;

public class OperacionCarga implements Operacion {
    private final Bateria bateria;
    private final double kwh;

    public OperacionCarga(Bateria bateria, double kwh) {
        if (kwh <= 0) {
            throw new ValorInvalidoException("El valor de carga debe ser estrictamente mayor a 0 kWh.");
        }
        this.bateria = bateria;
        this.kwh = kwh;
    }

    @Override
    public void ejecutar() {
        bateria.cargar(kwh);
    }

    @Override
    public void deshacer() {
        try {
            bateria.consumir(kwh); 
        } catch (LimiteReservaExcedidoException e) {
        
        }
    }
}
