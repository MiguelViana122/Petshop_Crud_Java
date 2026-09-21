package cadastro;
import java.util.List;

public class PetController {

    private final BancoDados bancoDados;

    public PetController() {

        bancoDados = BancoDados.getInstancia();
    }

    public void cadastrar(int donoId, String nome, String especie, String raca, int idade) {

        if (bancoDados.buscarCliente(donoId) == null) {

            throw new IllegalArgumentException(
                    "Cliente (dono) não encontrado. Cadastre o cliente antes."
            );
        }

        bancoDados.cadastrarPet(donoId, nome, especie, raca, idade);
    }

    public List<Pet> listar() {

        return bancoDados.listarPets();
    }

    public Pet buscar(int id) {

        return bancoDados.buscarPet(id);
    }

    public boolean atualizar(int id, String nome, String especie, String raca, int idade) {

        return bancoDados.atualizarPet(id, nome, especie, raca, idade);
    }

    public boolean excluir(int id) {

        return bancoDados.excluirPet(id);
    }
}
