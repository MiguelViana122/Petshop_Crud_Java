import java.util.ArrayList;
import java.util.List;

public class BancoDados {

    // SINGLETON (GoF): só existe uma instância de BancoDados no programa.
    private static BancoDados instancia;

    private final ArrayList<Cliente> clientes;
    private final ArrayList<Pet> pets;
    private final ArrayList<Funcionario> funcionarios;
    private final ArrayList<DadosObserver> observers;

    // Um contador de ID para cada cadastro (Cliente 1, Pet 1, Funcionário 1...)
    private int proximoIdCliente;
    private int proximoIdPet;
    private int proximoIdFuncionario;

    private BancoDados() {
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        pets = new ArrayList<>();
        observers = new ArrayList<>();

        proximoIdCliente = 1;
        proximoIdPet = 1;
        proximoIdFuncionario = 1;
    }

    public static BancoDados getInstancia() {

        if (instancia == null) {
            instancia = new BancoDados();
        }

        return instancia;
    }


// CLIENTE


    // CREATOR (GRASP): BancoDados guarda os clientes, então é ele quem os cria.
    public Cliente cadastrarCliente(String nome, String telefone, String email) {

        Cliente cliente = new Cliente(proximoIdCliente, nome, telefone, email);

        clientes.add(cliente);
        proximoIdCliente++;

        notificarObservers("Cliente", "cadastrado");

        return cliente;
    }

    public List<Cliente> listarClientes() {

        // Retorna uma cópia da lista para evitar
        // alterações externas diretamente na lista original.
        return new ArrayList<>(clientes);
    }

    public Cliente buscarCliente(int id) {

        for (Cliente cliente : clientes) {

            if (cliente.getId() == id) {
                return cliente;
            }
        }

        return null;
    }

    public boolean atualizarCliente(int id, String nome, String telefone, String email) {

        Cliente cliente = buscarCliente(id);

        if (cliente == null) {
            return false;
        }

        cliente.atualizar(nome, telefone, email);

        notificarObservers("Cliente", "atualizado");

        return true;
    }

    public boolean excluirCliente(int id) {

        Cliente cliente = buscarCliente(id);

        if (cliente == null) {
            return false;
        }

        // Regra de integridade: não deixa pets "órfãos" sem dono.
        for (Pet pet : pets) {

            if (pet.getDonoId() == id) {
                throw new IllegalStateException(
                        "Este cliente possui pets cadastrados. Exclua os pets primeiro."
                );
            }
        }

        clientes.remove(cliente);

        notificarObservers("Cliente", "excluído");

        return true;
    }


// PET


    public Pet cadastrarPet(int donoId, String nome, String especie, String raca, int idade) {

        Pet pet = new Pet(proximoIdPet, donoId, nome, especie, raca, idade);

        pets.add(pet);
        proximoIdPet++;

        notificarObservers("Pet", "cadastrado");

        return pet;
    }

    public List<Pet> listarPets() {

        return new ArrayList<>(pets);
    }

    public Pet buscarPet(int id) {

        for (Pet pet : pets) {

            if (pet.getId() == id) {
                return pet;
            }
        }

        return null;
    }

    public boolean atualizarPet(int id, String nome, String especie, String raca, int idade) {

        Pet pet = buscarPet(id);

        if (pet == null) {
            return false;
        }

        pet.atualizar(nome, especie, raca, idade);

        notificarObservers("Pet", "atualizado");

        return true;
    }

    public boolean excluirPet(int id) {

        Pet pet = buscarPet(id);

        if (pet == null) {
            return false;
        }

        pets.remove(pet);

        notificarObservers("Pet", "excluído");

        return true;
    }


// FUNCIONARIO


    public Funcionario cadastrarFuncionario(String nome, String cargo, String telefone, String email) {

        Funcionario funcionario = new Funcionario(proximoIdFuncionario, nome, cargo, telefone, email);

        funcionarios.add(funcionario);
        proximoIdFuncionario++;

        notificarObservers("Funcionário", "cadastrado");

        return funcionario;
    }

    public List<Funcionario> listarFuncionarios() {
        return new ArrayList<>(funcionarios);
    }

    public Funcionario buscarFuncionario(int id) {

        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }

        return null;
    }

    public boolean atualizarFuncionario(int id, String nome, String cargo, String telefone, String email) {

        Funcionario funcionario = buscarFuncionario(id);

        if (funcionario == null) {
            return false;
        }

        funcionario.atualizar(nome, cargo, telefone, email);

        notificarObservers("Funcionário", "atualizado");

        return true;
    }

    public boolean excluirFuncionario(int id) {

        Funcionario funcionario = buscarFuncionario(id);

        if (funcionario == null) {
            return false;
        }

        funcionarios.remove(funcionario);

        notificarObservers("Funcionário", "excluído");

        return true;
    }


// OBSERVER (GoF): BancoDados é o "observado". Quem quiser ser avisado
// das mudanças se registra aqui (o Main registra o DadosMonitor).


    public void adicionarObserver(DadosObserver observer) {

        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removerObserver(DadosObserver observer) {
        observers.remove(observer);
    }

    private void notificarObservers(String entidade, String acao) {

        for (DadosObserver observer : observers) {
            observer.dadosAlterados(entidade, acao);
        }
    }
}
