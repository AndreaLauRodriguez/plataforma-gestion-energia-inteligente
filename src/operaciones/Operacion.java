import excepciones.LimiteReservaExcedidoException;


public interface Operacion {
    void ejecutar() throws LimiteReservaExcedidoException;
    void deshacer();
}



