import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Usuario extends Pessoa {
    private String email;
    private String senha;
    private transient LocalDateTime dataCadastro;
    private transient LocalDateTime dataAtualizacao;
    private List<Pedido> pedidos = new ArrayList<>();

    public Usuario(String nome, String email, String senha, String endereco, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    @Override
    public void validarDados() {
        if (nome == null || email == null || senha == null) {
            throw new IllegalArgumentException("Dados inválidos");
        }
    }

    @Override
    public String getTipo() {
        return "Cliente";
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
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
}

