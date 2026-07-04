public class ControladorOperaciones {
    
    
    public void ejecutarInmediato(Operacion op) throws LimiteReservaExcedidoException {
        op.ejecutar();
    }
    
    public void ejecutarRutina(Rutina rutina) throws LimiteReservaExcedidoException {
        try {
            rutina.ejecutar();
        } finally {
            rutina.vaciar(); 
        }
    }
}