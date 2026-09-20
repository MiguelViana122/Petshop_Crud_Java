import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ClienteController clienteController = new ClienteController();
        PetController petController = new PetController();
        FuncionarioController funcionarioController = new FuncionarioController();

        int opcao;

        do {

            System.out.println("\n==============================");
            System.out.println("        PET SHOP");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Atualizar cliente");
            System.out.println("4 - Excluir cliente");
            System.out.println("------------------------------");
            System.out.println("5 - Cadastrar pet");
            System.out.println("6 - Listar pets");
            System.out.println("7 - Atualizar pet");
            System.out.println("8 - Excluir pet");
            System.out.println("------------------------------");
            System.out.println("9 - Cadastrar funcionário");
            System.out.println("10 - Listar funcionários");
            System.out.println("11 - Atualizar funcionário");
            System.out.println("12 - Excluir funcionário");
            System.out.println("------------------------------");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1 -> {

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    try {

                        clienteController.cadastrar(
                                nome,
                                telefone,
                                email
                        );

                        System.out.println(
                                "Cliente cadastrado com sucesso!"
                        );

                    } catch (IllegalArgumentException erro) {

                        System.out.println(
                                "Erro: " + erro.getMessage()
                        );
                    }
                }

                case 2 -> {

                    System.out.println("\nCLIENTES CADASTRADOS");

                    for (Cliente cliente : clienteController.listar()) {

                        System.out.println(
                                "ID: " + cliente.getId()
                                        + " | Nome: " + cliente.getNome()
                                        + " | Telefone: " + cliente.getTelefone()
                                        + " | Email: " + cliente.getEmail()
                        );
                    }
                }

                case 3 -> {

                    System.out.print("ID do cliente: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Novo telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Novo e-mail: ");
                    String email = scanner.nextLine();

                    try {

                        boolean atualizado =
                                clienteController.atualizar(
                                        id,
                                        nome,
                                        telefone,
                                        email
                                );

                        if (atualizado) {

                            System.out.println(
                                    "Cliente atualizado!"
                            );

                        } else {

                            System.out.println(
                                    "Cliente não encontrado."
                            );
                        }

                    } catch (IllegalArgumentException erro) {

                        System.out.println(
                                "Erro: " + erro.getMessage()
                        );
                    }
                }

                case 4 -> {

                    System.out.print("ID do cliente: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    boolean excluido =
                            clienteController.excluir(id);

                    if (excluido) {

                        System.out.println(
                                "Cliente excluído!"
                        );

                    } else {

                        System.out.println(
                                "Cliente não encontrado."
                        );
                    }
                }

                case 5 -> {

                    System.out.print("Nome do pet: ");
                    String nome = scanner.nextLine();

                    System.out.print("Espécie: ");
                    String especie = scanner.nextLine();

                    System.out.print("Raça: ");
                    String raca = scanner.nextLine();

                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();

                    try {

                        petController.cadastrar(
                                nome,
                                especie,
                                raca,
                                idade
                        );

                        System.out.println(
                                "Pet cadastrado com sucesso!"
                        );

                    } catch (IllegalArgumentException erro) {

                        System.out.println(
                                "Erro: " + erro.getMessage()
                        );
                    }
                }

                case 6 -> {

                    System.out.println("\nPETS CADASTRADOS");

                    for (Pet pet : petController.listar()) {

                        System.out.println(
                                "ID: " + pet.getId()
                                        + " | Nome: " + pet.getNome()
                                        + " | Espécie: " + pet.getEspecie()
                                        + " | Raça: " + pet.getRaca()
                                        + " | Idade: " + pet.getIdade()
                        );
                    }
                }

                case 7 -> {

                    System.out.print("ID do pet: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Nova espécie: ");
                    String especie = scanner.nextLine();

                    System.out.print("Nova raça: ");
                    String raca = scanner.nextLine();

                    System.out.print("Nova idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();

                    try {

                        boolean atualizado =
                                petController.atualizar(
                                        id,
                                        nome,
                                        especie,
                                        raca,
                                        idade
                                );

                        if (atualizado) {

                            System.out.println(
                                    "Pet atualizado!"
                            );

                        } else {

                            System.out.println(
                                    "Pet não encontrado."
                            );
                        }

                    } catch (IllegalArgumentException erro) {

                        System.out.println(
                                "Erro: " + erro.getMessage()
                        );
                    }
                }

                case 8 -> {

                    System.out.print("ID do pet: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    boolean excluido =
                            petController.excluir(id);

                    if (excluido) {

                        System.out.println(
                                "Pet excluído!"
                        );

                    } else {

                        System.out.println(
                                "Pet não encontrado."
                        );
                    }
                }

                case 9 -> {

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("E-mail: ");
                    String email = scanner.nextLine();

                    try {

                        funcionarioController.cadastrar(
                                nome,
                                cargo,
                                telefone,
                                email
                        );

                        System.out.println(
                                "Funcionário cadastrado com sucesso!"
                        );

                    } catch (IllegalArgumentException erro) {

                        System.out.println(
                                "Erro: " + erro.getMessage()
                        );
                    }
                }

                case 10 -> {

                    System.out.println("\nFUNCIONÁRIOS CADASTRADOS");

                    for (Funcionario funcionario : funcionarioController.listar()) {

                        System.out.println(
                                "ID: " + funcionario.getId()
                                        + " | Nome: " + funcionario.getNome()
                                        + " | Cargo: " + funcionario.getCargo()
                                        + " | Telefone: " + funcionario.getTelefone()
                                        + " | Email: " + funcionario.getEmail()
                        );
                    }
                }

                case 11 -> {

                    System.out.print("ID do funcionário: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Novo cargo: ");
                    String cargo = scanner.nextLine();

                    System.out.print("Novo telefone: ");
                    String telefone = scanner.nextLine();

                    System.out.print("Novo e-mail: ");
                    String email = scanner.nextLine();

                    try {

                        boolean atualizado =
                                funcionarioController.atualizar(
                                        id,
                                        nome,
                                        cargo,
                                        telefone,
                                        email
                                );

                        if (atualizado) {

                            System.out.println(
                                    "Funcionário atualizado!"
                            );

                        } else {

                            System.out.println(
                                    "Funcionário não encontrado."
                            );
                        }

                    } catch (IllegalArgumentException erro) {

                        System.out.println(
                                "Erro: " + erro.getMessage()
                        );
                    }
                }

                case 12 -> {

                    System.out.print("ID do funcionário: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    boolean excluido =
                            funcionarioController.excluir(id);

                    if (excluido) {

                        System.out.println(
                                "Funcionário excluído!"
                        );

                    } else {

                        System.out.println(
                                "Funcionário não encontrado."
                        );
                    }
                }

                case 0 ->

                        System.out.println(
                                "Encerrando sistema..."
                        );

                default ->

                        System.out.println(
                                "Opção inválida."
                        );
            }

        } while (opcao != 0);

        scanner.close();
    }
}