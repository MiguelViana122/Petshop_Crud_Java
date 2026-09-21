package cadastro;
import java.util.List;
public class ClienteController {

    private final BancoDados bancoDados;

    public ClienteController() {

        bancoDados = BancoDados.getInstancia();
    }

    public void cadastrar(String nome, String telefone, String email) {

        bancoDados.cadastrarCliente(nome, telefone, email);
    }

    public List<Cliente> listar() {

        return bancoDados.listarClientes();
    }

    public Cliente buscar(int id) {

        return bancoDados.buscarCliente(id);
    }

    public boolean atualizar(int id, String nome, String telefone, String email) {

        return bancoDados.atualizarCliente(id, nome, telefone, email);
    }

    public boolean excluir(int id) {

        return bancoDados.excluirCliente(id);
    }
}
