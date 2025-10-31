import java.util.ArrayList;
import java.time.LocalDateTime;

public class Entregas {
    private ArrayList<Pedido> pedidosEmAndamento;
    private ArrayList<Pedido> pedidosEntregues;

    public Entregas() {
        this.pedidosEmAndamento = new ArrayList<>();
        this.pedidosEntregues = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidosEmAndamento.add(pedido);
    }

    public ArrayList<Pedido> listarPedidosEmAndamento() {
        return pedidosEmAndamento;
    }

    public ArrayList<Pedido> listarPedidosEntregues() {
        return pedidosEntregues;
    }

    public void marcarComoEntregue(Pedido pedido) {
        if (pedidosEmAndamento.contains(pedido)) {
            pedidosEmAndamento.remove(pedido);
            pedidosEntregues.add(pedido);
            pedido.setDataEntrega(LocalDateTime.now());
        }
    }

    public boolean verificarAtraso(Pedido pedido) {
        if (pedido.getDataEntrega() == null) {
            LocalDateTime agora = LocalDateTime.now();
            LocalDateTime previsaoEntrega = pedido.getDataPedido().plusMinutes(pedido.getTempoEstimadoEntrega());
            return agora.isAfter(previsaoEntrega);
        }
        return false;
    }

    public ArrayList<Pedido> listarPedidosAtrasados() {
        ArrayList<Pedido> pedidosAtrasados = new ArrayList<>();
        for (Pedido pedido : pedidosEmAndamento) {
            if (verificarAtraso(pedido)) {
                pedidosAtrasados.add(pedido);
            }
        }
        return pedidosAtrasados;
    }
}



