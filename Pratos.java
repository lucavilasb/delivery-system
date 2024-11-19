public class Pratos {
    private String nome;
    private double preco;
    private String descricao;
    private int tempoEstimadoEntrega;

    public Pratos(String nome, double preco, String descricao, int tempoEstimadoEntrega) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.tempoEstimadoEntrega = tempoEstimadoEntrega;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTempoEstimadoEntrega() {
        return tempoEstimadoEntrega;
    }

    public void setTempoEstimadoEntrega(int tempoEstimadoEntrega) {
        this.tempoEstimadoEntrega = tempoEstimadoEntrega;
    }
}
