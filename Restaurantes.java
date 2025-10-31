import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Restaurantes extends Pessoa {
    private String cnpj;
    private ArrayList<Prato> pratos;
    private List<Pedido> pedidos = new ArrayList<>();
    private transient LocalDateTime dataCadastro;
    private transient LocalDateTime dataAtualizacao;
    private String senha;

    public Restaurantes(String nome, String endereco, String telefone, String cnpj, String senha) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.senha = senha;
        this.pratos = new ArrayList<>();
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    @Override
    public void validarDados() {
        if (nome == null || cnpj == null) {
            throw new IllegalArgumentException("Dados inválidos");
        }
    }

    @Override
    public String getTipo() {
        return "Restaurante";
    }

    public void cadastrarRestaurante(String nome, String endereco, String telefone, String cnpj) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }

    public void cadastrarPrato(Prato prato) {
        pratos.add(prato);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }

    public void receberPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
