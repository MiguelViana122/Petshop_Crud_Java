import java.util.ArrayList;
import java.util.List;

public class BancoDados {

    private static BancoDados instancia;

    private final ArrayList<Cliente> clientes;
    private final ArrayList<Pet> pets;
    private final ArrayList<Funcionario> funcionarios;
    private final ArrayList<DadosObserver> observers;

    private int proximoId;

    private BancoDados() {
        clientes = new ArrayList<>();
        funcionarios = new ArrayList<>();
        pets = new ArrayList<>();
        observers = new ArrayList<>();

        proximoId = 1;
    }

    public static BancoDados getInstancia() {

        if (instancia == null) {
            instancia = new BancoDados();
        }

        return instancia;
    }


// CLIENTE


    public Cliente cadastrarCliente(
            String nome,
            String telefone,
            String email
    ) {

        Cliente cliente = new Cliente(
                proximoId,
                nome,
                telefone,
                email
        );

        clientes.add(cliente);

        proximoId++;

        notificarObservers();

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


    public boolean atualizarCliente(
            int id,
            String nome,
            String telefone,
            String email
    ) {

        Cliente cliente = buscarCliente(id);

        if (cliente == null) {
            return false;
        }

        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);

        notificarObservers();

        return true;
    }


    public boolean excluirCliente(int id) {

        Cliente cliente = buscarCliente(id);

        if (cliente == null) {
            return false;
        }

        clientes.remove(cliente);

        notificarObservers();

        return true;
    }


// PET


    public Pet cadastrarPet(
            String nome,
            String especie,
            String raca,
            int idade
    ) {

        Pet pet = new Pet(
                proximoId,
                nome,
                especie,
                raca,
                idade
        );

        pets.add(pet);

        proximoId++;

        notificarObservers();

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



    public boolean atualizarPet(
            int id,
            String nome,
            String especie,
            String raca,
            int idade
    ) {

        Pet pet = buscarPet(id);

        if (pet == null) {
            return false;
        }

        pet.setNome(nome);
        pet.setEspecie(especie);
        pet.setRaca(raca);
        pet.setIdade(idade);

        notificarObservers();

        return true;
    }



    public boolean excluirPet(int id) {

        Pet pet = buscarPet(id);

        if (pet == null) {
            return false;
        }

        pets.remove(pet);

        notificarObservers();

        return true;
    }


    // FUNCIONARIO


    public Funcionario cadastrarFuncionario(String nome, String cargo, String telefone, String email) {

        Funcionario funcionario = new Funcionario(
                proximoId,
                nome,
                cargo,
                telefone,
                email
        );

        funcionarios.add(funcionario);
        proximoId++;

        notificarObservers();

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



    public boolean atualizarFuncionario(
            int id,
            String nome,
            String cargo,
            String telefone,
            String email) {

        Funcionario funcionario = buscarFuncionario(id);

        if (funcionario == null) {
            return false;
        }

        funcionario.setNome(nome);
        funcionario.setCargo(cargo);
        funcionario.setTelefone(telefone);
        funcionario.setEmail(email);

        notificarObservers();

        return true;
    }



    public boolean excluirFuncionario(int id) {

        Funcionario funcionario = buscarFuncionario(id);

        if (funcionario == null) {
            return false;
        }

        funcionarios.remove(funcionario);

        notificarObservers();

        return true;
    }


    //OBSERVER


    public void adicionarObserver(DadosObserver observer) {

        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removerObserver(DadosObserver observer) {
        observers.remove(observer);
    }

    private void notificarObservers() {

        for (DadosObserver observer : observers) {
            observer.dadosAlterados();
        }
    }
}