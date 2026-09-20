import java.util.List;

public class PetController {

    private final BancoDados bancoDados;

    public PetController() {

        bancoDados = BancoDados.getInstancia();
    }

    public void cadastrar(
            String nome,
            String especie,
            String raca,
            int idade
    ) {

        validarDados(
                nome,
                especie,
                raca,
                idade
        );

        bancoDados.cadastrarPet(
                nome.trim(),
                especie.trim(),
                raca.trim(),
                idade
        );
    }

    public List<Pet> listar() {

        return bancoDados.listarPets();
    }

    public Pet buscar(int id) {

        return bancoDados.buscarPet(id);
    }

    public boolean atualizar(
            int id,
            String nome,
            String especie,
            String raca,
            int idade
    ) {

        validarDados(
                nome,
                especie,
                raca,
                idade
        );

        return bancoDados.atualizarPet(
                id,
                nome.trim(),
                especie.trim(),
                raca.trim(),
                idade
        );
    }

    public boolean excluir(int id) {

        return bancoDados.excluirPet(id);
    }

    private void validarDados(
            String nome,
            String especie,
            String raca,
            int idade
    ) {

        if (nome == null || nome.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "O nome não pode ficar vazio."
            );
        }

        if (especie == null || especie.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "A espécie não pode ficar vazia."
            );
        }

        if (raca == null || raca.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "A raça não pode ficar vazia."
            );
        }

        if (idade < 0) {

            throw new IllegalArgumentException(
                    "A idade não pode ser negativa."
            );
        }
    }
}