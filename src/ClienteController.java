import java.util.List;

public class ClienteController {

    private final BancoDados bancoDados;

    public ClienteController() {

        bancoDados = BancoDados.getInstancia();
    }



    public void cadastrar(
            String nome,
            String telefone,
            String email
    ) {

        validarDados(
                nome,
                telefone,
                email
        );

        bancoDados.cadastrarCliente(
                nome.trim(),
                telefone.trim(),
                email.trim()
        );
    }



    public List<Cliente> listar() {

        return bancoDados.listarClientes();
    }

    public Cliente buscar(int id) {

        return bancoDados.buscarCliente(id);
    }



    public boolean atualizar(
            int id,
            String nome,
            String telefone,
            String email
    ) {

        validarDados(
                nome,
                telefone,
                email
        );

        return bancoDados.atualizarCliente(
                id,
                nome.trim(),
                telefone.trim(),
                email.trim()
        );
    }



    public boolean excluir(int id) {

        return bancoDados.excluirCliente(id);
    }



    private void validarDados(
            String nome,
            String telefone,
            String email
    ) {

        if (nome == null || nome.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "O nome não pode ficar vazio."
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