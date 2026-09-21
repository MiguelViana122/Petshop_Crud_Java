import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final ClienteController clienteController = new ClienteController();
    private static final PetController petController = new PetController();
    private static final FuncionarioController funcionarioController = new FuncionarioController();

    public static void main(String[] args) {

        // OBSERVER (GoF): registra o monitor para ser avisado a cada mudança nos dados.
        BancoDados.getInstancia().adicionarObserver(new DadosMonitor());

        int opcao;

        do {

            System.out.println("\n==============================");
            System.out.println("        PET SHOP");
            System.out.println("==============================");
            System.out.println(" 1 - Cadastrar cliente");
            System.out.println(" 2 - Listar clientes");
            System.out.println(" 3 - Buscar cliente por ID");
            System.out.println(" 4 - Atualizar cliente");
            System.out.println(" 5 - Excluir cliente");
            System.out.println("------------------------------");
            System.out.println(" 6 - Cadastrar pet");
            System.out.println(" 7 - Listar pets");
            System.out.println(" 8 - Buscar pet por ID");
            System.out.println(" 9 - Atualizar pet");
            System.out.println("10 - Excluir pet");
            System.out.println("------------------------------");
            System.out.println("11 - Cadastrar funcionário");
            System.out.println("12 - Listar funcionários");
            System.out.println("13 - Buscar funcionário por ID");
            System.out.println("14 - Atualizar funcionário");
            System.out.println("15 - Excluir funcionário");
            System.out.println("------------------------------");
            System.out.println(" 0 - Sair");

            opcao = lerInt("Escolha: ");

            switch (opcao) {

                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> buscarCliente();
                case 4 -> atualizarCliente();
                case 5 -> excluirCliente();

                case 6 -> cadastrarPet();
                case 7 -> listarPets();
                case 8 -> buscarPet();
                case 9 -> atualizarPet();
                case 10 -> excluirPet();

                case 11 -> cadastrarFuncionario();
                case 12 -> listarFuncionarios();
                case 13 -> buscarFuncionario();
                case 14 -> atualizarFuncionario();
                case 15 -> excluirFuncionario();

                case 0 -> System.out.println("Encerrando sistema...");

                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }


    // ---------- Leitura segura do teclado ----------

    // Repete a pergunta até o usuário digitar um número inteiro (não quebra com letras).
    private static int lerInt(String mensagem) {

        while (true) {

            System.out.print(mensagem);

            try {
                return Integer.parseInt(scanner.nextLine().trim());

            } catch (NumberFormatException erro) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static String lerTexto(String mensagem) {

        System.out.print(mensagem);
        return scanner.nextLine();
    }

    // Na atualização: Enter em branco mantém o valor atual (não precisa redigitar).
    private static String lerOuManter(String rotulo, String atual) {

        String digitado = lerTexto(rotulo + " [" + atual + "]: ");

        return digitado.trim().isEmpty() ? atual : digitado;
    }

    private static int lerIntOuManter(String rotulo, int atual) {

        while (true) {

            String digitado = lerTexto(rotulo + " [" + atual + "]: ").trim();

            if (digitado.isEmpty()) {
                return atual;
            }

            try {
                return Integer.parseInt(digitado);

            } catch (NumberFormatException erro) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }


    // ---------- Formatação ----------

    private static String descrever(Cliente c) {

        return "ID: " + c.getId()
                + " | Nome: " + c.getNome()
                + " | Telefone: " + c.getTelefone()
                + " | Email: " + c.getEmail();
    }

    private static String descrever(Pet p) {

        Cliente dono = clienteController.buscar(p.getDonoId());
        String nomeDono = dono != null ? dono.getNome() : "?";

        return "ID: " + p.getId()
                + " | Nome: " + p.getNome()
                + " | Espécie: " + p.getEspecie()
                + " | Raça: " + p.getRaca()
                + " | Idade: " + p.getIdade()
                + " | Dono: " + nomeDono + " (ID " + p.getDonoId() + ")";
    }

    private static String descrever(Funcionario f) {

        return "ID: " + f.getId()
                + " | Nome: " + f.getNome()
                + " | Cargo: " + f.getCargo()
                + " | Telefone: " + f.getTelefone()
                + " | Email: " + f.getEmail();
    }


    // ---------- CLIENTE ----------

    private static void cadastrarCliente() {

        String nome = lerTexto("Nome: ");
        String telefone = lerTexto("Telefone: ");
        String email = lerTexto("E-mail: ");

        try {
            clienteController.cadastrar(nome, telefone, email);
            System.out.println("Cliente cadastrado com sucesso!");

        } catch (IllegalArgumentException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    private static void listarClientes() {

        System.out.println("\nCLIENTES CADASTRADOS");

        List<Cliente> lista = clienteController.listar();

        if (lista.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        }

        for (Cliente cliente : lista) {
            System.out.println(descrever(cliente));
        }
    }

    private static void buscarCliente() {

        Cliente cliente = clienteController.buscar(lerInt("ID do cliente: "));

        System.out.println(cliente != null ? descrever(cliente) : "Cliente não encontrado.");
    }

    private static void atualizarCliente() {

        Cliente atual = clienteController.buscar(lerInt("ID do cliente: "));

        if (atual == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("(Enter em branco mantém o valor atual)");

        String nome = lerOuManter("Novo nome", atual.getNome());
        String telefone = lerOuManter("Novo telefone", atual.getTelefone());
        String email = lerOuManter("Novo e-mail", atual.getEmail());

        try {
            clienteController.atualizar(atual.getId(), nome, telefone, email);
            System.out.println("Cliente atualizado!");

        } catch (IllegalArgumentException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    private static void excluirCliente() {

        try {
            boolean excluido = clienteController.excluir(lerInt("ID do cliente: "));

            System.out.println(excluido ? "Cliente excluído!" : "Cliente não encontrado.");

        } catch (IllegalStateException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }


    // ---------- PET ----------

    private static void cadastrarPet() {

        int donoId = lerInt("ID do dono (cliente): ");

        if (clienteController.buscar(donoId) == null) {
            System.out.println("Cliente (dono) não encontrado. Cadastre o cliente antes.");
            return;
        }

        String nome = lerTexto("Nome do pet: ");
        String especie = lerTexto("Espécie: ");
        String raca = lerTexto("Raça: ");
        int idade = lerInt("Idade: ");

        try {
            petController.cadastrar(donoId, nome, especie, raca, idade);
            System.out.println("Pet cadastrado com sucesso!");

        } catch (IllegalArgumentException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    private static void listarPets() {

        System.out.println("\nPETS CADASTRADOS");

        List<Pet> lista = petController.listar();

        if (lista.isEmpty()) {
            System.out.println("Nenhum pet cadastrado.");
        }

        for (Pet pet : lista) {
            System.out.println(descrever(pet));
        }
    }

    private static void buscarPet() {

        Pet pet = petController.buscar(lerInt("ID do pet: "));

        System.out.println(pet != null ? descrever(pet) : "Pet não encontrado.");
    }

    private static void atualizarPet() {

        Pet atual = petController.buscar(lerInt("ID do pet: "));

        if (atual == null) {
            System.out.println("Pet não encontrado.");
            return;
        }

        System.out.println("(Enter em branco mantém o valor atual)");

        String nome = lerOuManter("Novo nome", atual.getNome());
        String especie = lerOuManter("Nova espécie", atual.getEspecie());
        String raca = lerOuManter("Nova raça", atual.getRaca());
        int idade = lerIntOuManter("Nova idade", atual.getIdade());

        try {
            petController.atualizar(atual.getId(), nome, especie, raca, idade);
            System.out.println("Pet atualizado!");

        } catch (IllegalArgumentException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    private static void excluirPet() {

        boolean excluido = petController.excluir(lerInt("ID do pet: "));

        System.out.println(excluido ? "Pet excluído!" : "Pet não encontrado.");
    }


    // ---------- FUNCIONÁRIO ----------

    private static void cadastrarFuncionario() {

        String nome = lerTexto("Nome: ");
        String cargo = lerTexto("Cargo: ");
        String telefone = lerTexto("Telefone: ");
        String email = lerTexto("E-mail: ");

        try {
            funcionarioController.cadastrar(nome, cargo, telefone, email);
            System.out.println("Funcionário cadastrado com sucesso!");

        } catch (IllegalArgumentException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    private static void listarFuncionarios() {

        System.out.println("\nFUNCIONÁRIOS CADASTRADOS");

        List<Funcionario> lista = funcionarioController.listar();

        if (lista.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        }

        for (Funcionario funcionario : lista) {
            System.out.println(descrever(funcionario));
        }
    }

    private static void buscarFuncionario() {

        Funcionario funcionario = funcionarioController.buscar(lerInt("ID do funcionário: "));

        System.out.println(funcionario != null ? descrever(funcionario) : "Funcionário não encontrado.");
    }

    private static void atualizarFuncionario() {

        Funcionario atual = funcionarioController.buscar(lerInt("ID do funcionário: "));

        if (atual == null) {
            System.out.println("Funcionário não encontrado.");
            return;
        }

        System.out.println("(Enter em branco mantém o valor atual)");

        String nome = lerOuManter("Novo nome", atual.getNome());
        String cargo = lerOuManter("Novo cargo", atual.getCargo());
        String telefone = lerOuManter("Novo telefone", atual.getTelefone());
        String email = lerOuManter("Novo e-mail", atual.getEmail());

        try {
            funcionarioController.atualizar(atual.getId(), nome, cargo, telefone, email);
            System.out.println("Funcionário atualizado!");

        } catch (IllegalArgumentException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    private static void excluirFuncionario() {

        boolean excluido = funcionarioController.excluir(lerInt("ID do funcionário: "));

        System.out.println(excluido ? "Funcionário excluído!" : "Funcionário não encontrado.");
    }
}
