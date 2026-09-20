import java.util.List;

public class FuncionarioController {

    private final BancoDados bancoDados;

    public FuncionarioController() {

        bancoDados = BancoDados.getInstancia();
    }


    public void cadastrar(
            String nome,
            String cargo,
            String telefone,
            String email
    ) {

        validarDados(
                nome,
                cargo,
                telefone,
                email
        );

        bancoDados.cadastrarFuncionario(
                nome.trim(),
                cargo.trim(),
                telefone.trim(),
                email.trim()
        );
    }



    public List<Funcionario> listar() {

        return bancoDados.listarFuncionarios();
    }

    public Funcionario buscar(int id) {

        return bancoDados.buscarFuncionario(id);
    }



    public boolean atualizar(
            int id,
            String nome,
            String cargo,
            String telefone,
            String email
    ) {

        validarDados(
                nome,
                cargo,
                telefone,
                email
        );

        return bancoDados.atualizarFuncionario(
                id,
                nome.trim(),
                cargo.trim(),
                telefone.trim(),
                email.trim()
        );
    }



    public boolean excluir(int id) {

        return bancoDados.excluirFuncionario(id);
    }



    private void validarDados(
            String nome,
            String cargo,
            String telefone,
            String email
    ) {

        if (nome == null || nome.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "O nome não pode ficar vazio."
            );
        }

        if (cargo == null || cargo.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "O cargo não pode ficar vazio."
            );
        }

        if (telefone == null || telefone.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "O telefone não pode ficar vazio."
            );
        }

        if (email == null || email.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "O e-mail não pode ficar vazio."
            );
        }

        if (!email.contains("@")) {

            throw new IllegalArgumentException(
                    "Digite um e-mail válido."
            );
        }
    }
}