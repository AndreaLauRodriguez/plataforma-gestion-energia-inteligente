import excepciones.LimiteReservaExcedidoException;
import java.util.ArrayList;
import java.util.List;


public class Rutina implements Operacion {
    private final List<Operacion> operaciones = new ArrayList<>();

    public void agregarOperacion(Operacion op) {
        this.operaciones.add(op);
    }

    public void vaciar() {
        this.operaciones.clear();
    }

    @Override
    public void ejecutar() throws LimiteReservaExcedidoException {
        List<Operacion> ejecutadasConExito = new ArrayList<>();
        
        try {
            for (Operacion op : operaciones) {
                op.ejecutar();
                ejecutadasConExito.add(op); 
            }
        } catch (LimiteReservaExcedidoException e) {
            
            for (int i = ejecutadasConExito.size() - 1; i >= 0; i--) {
                ejecutadasConExito.get(i).deshacer();
            }
            throw e; 
        }
    }

    @Override
    public void deshacer() {
      
        for (int i = operaciones.size() - 1; i >= 0; i--) {
            operaciones.get(i).deshacer();
        }
    }
}