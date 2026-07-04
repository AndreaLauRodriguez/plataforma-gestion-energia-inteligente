import excepciones.LimiteReservaExcedidoException;

/**
 * Interfaz Componente: Unifica operaciones simples y compuestas (Rutinas)
 */
public interface Operacion {
    void ejecutar() throws LimiteReservaExcedidoException;
    void deshacer();
}



