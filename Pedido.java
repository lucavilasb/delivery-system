import java.time.LocalDateTime;

public class Pedido {
    private Pratos prato;
    private Usuario cliente;
    private Restaurantes restaurante;
    private LocalDateTime dataPedido;
    private LocalDateTime dataEntrega;
    private String status;
    private int tempoEstimadoEntrega;
    private double total;

    public Pedido(Pratos prato, Usuario cliente, Restaurantes restaurante) {
        this.prato = prato;
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.dataPedido = LocalDateTime.now();
        this.status = "Pendente";
        this.tempoEstimadoEntrega = prato.getTempoEstimadoEntrega();
        this.total = prato.getPreco();
    }

    public Pratos getPrato() {
        return prato;
    }

    public void setPrato(Pratos prato) {
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pedido: " + prato.getNome() +
               "\nRestaurante: " + restaurante.getNome() +
               "\nStatus: " + status +
               "\nValor Total: R$" + String.format("%.2f", total) +
               "\nData do Pedido: " + dataPedido +
               (dataEntrega != null ? "\nData de Entrega: " + dataEntrega : "") +
               "\nTempo Estimado: " + tempoEstimadoEntrega + " minutos";
    }
}