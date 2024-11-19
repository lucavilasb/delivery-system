import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Restaurantes> restaurantes = new ArrayList<>();
    private static Usuario usuarioLogado = null;
    private static Restaurantes restauranteLogado = null;
    private static Entregas sistemaEntregas = new Entregas();

    public static void main(String[] args) {
        boolean executando = true;
        while (executando) {
            executando = menuPrincipal();
        }
        scanner.close();
        System.out.println("Obrigado pela preferência, volte sempre.");
    }

    private static boolean menuPrincipal() {
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1. Login Cliente");
        System.out.println("2. Login Restaurante");
        System.out.println("3. Cadastrar Cliente");
        System.out.println("4. Cadastrar Restaurante");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                loginCliente();
                break;
            case 2:
                loginRestaurante();
                break;
            case 3:
                cadastrarCliente();
                break;
            case 4:
                cadastrarRestaurante();
                break;
            case 5:
                return false;
            default:
                System.out.println("Opção inválida!");
        }
        return true;
    }

    private static void menuCliente() {
        if (usuarioLogado == null) {
            System.out.println("É necessário fazer login primeiro!");
            return;
        }

        boolean executando = true;
        while (executando) {
            System.out.println("\n=== Menu Cliente ===");
            System.out.println("1. Fazer Pedido");
            System.out.println("2. Ver Meus Pedidos");
            System.out.println("3. Ver Restaurantes");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    fazerPedido();
                    break;
                case 2:
                    verMeusPedidos();
                    break;
                case 3:
                    verRestaurantes();
                    break;
                case 4:
                    executando = false;
                    usuarioLogado = null;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuRestaurante() {
        if (restauranteLogado == null) {
            System.out.println("É necessário fazer login primeiro!");
            return;
        }

        boolean executando = true;
        while (executando) {
            System.out.println("\n=== Menu Restaurante ===");
            System.out.println("1. Cadastrar Prato");
            System.out.println("2. Ver Pedidos");
            System.out.println("3. Atualizar Status Pedido");
            System.out.println("4. Ver Pedidos em Andamento");
            System.out.println("5. Ver Pedidos Atrasados");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarPrato();
                    break;
                case 2:
                    verPedidos();
                    break;
                case 3:
                    atualizarStatusPedido();
                    break;
                case 4:
                    verPedidosEmAndamento();
                    break;
                case 5:
                    verPedidosAtrasados();
                    break;
                case 6:
                    executando = false;
                    restauranteLogado = null;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void loginCliente() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                System.out.println("Login realizado com sucesso!");
                menuCliente();
                return;
            }
        }
        System.out.println("Email ou senha incorretos!");
    }

    private static void loginRestaurante() {
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Restaurantes restaurante : restaurantes) {
            if (restaurante.getCnpj().equals(cnpj) && restaurante.getSenha().equals(senha)) {
                restauranteLogado = restaurante;
                System.out.println("Login realizado com sucesso!");
                menuRestaurante();
                return;
            }
        }
        System.out.println("CNPJ ou senha incorretos!");
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Usuario novoUsuario = new Usuario(nome, email, senha, endereco, telefone);
        usuarios.add(novoUsuario);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void cadastrarRestaurante() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("CNPJ: ");
        String cnpj = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Restaurantes rest : restaurantes) {
            if (rest.getCnpj().equals(cnpj)) {
                System.out.println("Já existe um restaurante cadastrado com este CNPJ!");
                return;
            }
        }

        if (nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || cnpj.isEmpty()) {
            System.out.println("Todos os campos são obrigatórios!");
            return;
        }

        try {
            Restaurantes novoRestaurante = new Restaurantes(nome, endereco, telefone, cnpj, senha);
            restaurantes.add(novoRestaurante);
            System.out.println("Restaurante cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar restaurante: " + e.getMessage());
        }
    }

    private static void cadastrarPrato() {
        System.out.print("Nome do prato: ");
        String nome = scanner.nextLine();
        System.out.print("Preço do prato: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Descrição do prato: ");
        String descricao = scanner.nextLine();
        System.out.print("Tempo estimado de entrega (minutos): ");
        int tempoEstimadoEntrega = scanner.nextInt();
        scanner.nextLine();

        Pratos novoPrato = new Pratos(nome, preco, descricao, tempoEstimadoEntrega);
        restauranteLogado.cadastrarPrato(novoPrato);
        System.out.println("Prato cadastrado com sucesso!");
    }

    private static void fazerPedido() {
        if (usuarioLogado == null) {
            System.out.println("É necessário fazer login primeiro!");
            return;
        }

        System.out.println("=== Restaurantes Disponíveis ===");
        for (int i = 0; i < restaurantes.size(); i++) {
            Restaurantes restaurante = restaurantes.get(i);
            System.out.println((i + 1) + ". " + restaurante.getNome());
        }

        System.out.print("Escolha um restaurante: ");
        int escolhaRestaurante = scanner.nextInt();
        scanner.nextLine();

        if (escolhaRestaurante < 1 || escolhaRestaurante > restaurantes.size()) {
            System.out.println("Restaurante inválido.");
            return;
        }

        Restaurantes restauranteEscolhido = restaurantes.get(escolhaRestaurante - 1);

        System.out.println("=== Pratos Disponíveis ===");
        ArrayList<Pratos> pratos = restauranteEscolhido.getPratos();
        for (int i = 0; i < pratos.size(); i++) {
            Pratos prato = pratos.get(i);
            System.out.println((i + 1) + ". " + prato.getNome() + " - R$" + prato.getPreco());
        }

        System.out.print("Escolha um prato: ");
        int escolhaPrato = scanner.nextInt();
        scanner.nextLine();

        if (escolhaPrato < 1 || escolhaPrato > pratos.size()) {
            System.out.println("Prato inválido.");
            return;
        }

        Pratos pratoEscolhido = pratos.get(escolhaPrato - 1);
        
        Pedido novoPedido = new Pedido(pratoEscolhido, usuarioLogado, restauranteEscolhido);
        usuarioLogado.adicionarPedido(novoPedido);
        restauranteEscolhido.adicionarPedido(novoPedido);
        System.out.println("Pedido realizado com sucesso!");
    }

    private static void verMeusPedidos() {
        if (usuarioLogado == null) {
            System.out.println("É necessário fazer login primeiro!");
            return;
        }
        
        List<Pedido> pedidos = usuarioLogado.getPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("Você ainda não tem pedidos!");
            return;
        }
        
        System.out.println("\n=== Seus Pedidos ===");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.toString());
        }
    }

    private static void verPedidos() {
        if (restauranteLogado == null) {
            System.out.println("É necessário fazer login primeiro!");
            return;
        }
        
        List<Pedido> pedidos = restauranteLogado.getPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos para este restaurante!");
            return;
        }
        
        System.out.println("\n=== Pedidos do Restaurante ===");
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.toString());
        }
    }

    private static void verRestaurantes() {
        System.out.println("\n=== Restaurantes Disponíveis ===");
        if (restaurantes.isEmpty()) {
            System.out.println("Não há restaurantes cadastrados.");
            return;
        }
        
        for (Restaurantes restaurante : restaurantes) {
            System.out.println("\nNome: " + restaurante.getNome());
            System.out.println("Endereço: " + restaurante.getEndereco());
            System.out.println("Telefone: " + restaurante.getTelefone());
            System.out.println("--- Cardápio ---");
            ArrayList<Pratos> pratos = restaurante.getPratos();
            if (pratos.isEmpty()) {
                System.out.println("Nenhum prato cadastrado.");
            } else {
                for (Pratos prato : pratos) {
                    System.out.println(prato.getNome() + " - R$" + prato.getPreco());
                }
            }
        }
    }

    private static void atualizarStatusPedido() {
        if (restauranteLogado == null) {
            System.out.println("É necessário fazer login primeiro!");
            return;
        }
        
        List<Pedido> pedidos = restauranteLogado.getPedidos();
        if (pedidos.isEmpty()) {
            System.out.println("Não há pedidos para atualizar!");
            return;
        }
        
        System.out.println("\n=== Atualizar Status do Pedido ===");
        for (int i = 0; i < pedidos.size(); i++) {
            Pedido pedido = pedidos.get(i);
            System.out.println((i + 1) + ". " + pedido.getPrato().getNome() + " - Status: " + pedido.getStatus());
        }
        
        System.out.print("Escolha o número do pedido: ");
        int escolha = scanner.nextInt();
        scanner.nextLine();
        
        if (escolha < 1 || escolha > pedidos.size()) {
            System.out.println("Pedido inválido!");
            return;
        }
        
        System.out.println("\nNovo status:");
        System.out.println("1. Em Preparo");
        System.out.println("2. Em Entrega");
        System.out.println("3. Entregue");
        System.out.print("Escolha: ");
        
        int statusEscolha = scanner.nextInt();
        scanner.nextLine();
        
        String novoStatus = "Pendente";
        switch (statusEscolha) {
            case 1: 
                novoStatus = "Em Preparo"; 
                break;
            case 2: 
                novoStatus = "Em Entrega"; 
                sistemaEntregas.adicionarPedido(pedidos.get(escolha - 1));
                break;
            case 3: 
                novoStatus = "Entregue"; 
                sistemaEntregas.marcarComoEntregue(pedidos.get(escolha - 1));
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }
        
        pedidos.get(escolha - 1).setStatus(novoStatus);
        System.out.println("Status atualizado com sucesso!");
    }

    private static void verPedidosEmAndamento() {
        ArrayList<Pedido> pedidosEmAndamento = sistemaEntregas.listarPedidosEmAndamento();
        if (pedidosEmAndamento.isEmpty()) {
            System.out.println("Não há pedidos em andamento!");
            return;
        }
        
        System.out.println("\n=== Pedidos em Andamento ===");
        for (Pedido pedido : pedidosEmAndamento) {
            System.out.println(pedido.toString());
        }
    }

    private static void verPedidosAtrasados() {
        ArrayList<Pedido> pedidosAtrasados = sistemaEntregas.listarPedidosAtrasados();
        if (pedidosAtrasados.isEmpty()) {
            System.out.println("Não há pedidos atrasados!");
            return;
        }
        
        System.out.println("\n=== Pedidos Atrasados ===");
        for (Pedido pedido : pedidosAtrasados) {
            System.out.println(pedido.toString());
        }
    }
}