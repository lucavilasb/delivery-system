import java.time.LocalDateTime;

public class Pedido {
    private Prato prato;
    private Usuario cliente;
    private Restaurantes restaurante;
    private LocalDateTime dataPedido;
    private LocalDateTime dataEntrega;
    private String status;
    private int tempoEstimadoEntrega;

    public Pedido(Prato prato, Usuario cliente, Restaurantes restaurante) {
        this.prato = prato;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.dataPedido = LocalDateTime.now();
        this.status = "Pendente";
        this.tempoEstimadoEntrega = prato.getTempoEstimadoEntrega();
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Restaurantes getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurantes restaurante) {
        this.restaurante = restaurante;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTempoEstimadoEntrega() {
        return tempoEstimadoEntrega;
    }

    @Override
    public String toString() {
        return "Pedido: " + prato.getNome() +
               "\nRestaurante: " + restaurante.getNome() +
               "\nStatus: " + status +
               "\nData do Pedido: " + dataPedido +
               (dataEntrega != null ? "\nData de Entrega: " + dataEntrega : "") +
               "\nTempo Estimado: " + tempoEstimadoEntrega + " minutos";
    }
} 
