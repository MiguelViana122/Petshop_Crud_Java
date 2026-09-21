import java.util.List;

// CONTROLLER (GRASP): recebe os pedidos da tela e repassa ao BancoDados.
// As regras de validação ficam na própria entidade (Information Expert).
public class FuncionarioController {

    private final BancoDados bancoDados;

    public FuncionarioController() {

        bancoDados = BancoDados.getInstancia();
    }

    public void cadastrar(String nome, String cargo, String telefone, String email) {

        bancoDados.cadastrarFuncionario(nome, cargo, telefone, email);
    }

    public List<Funcionario> listar() {

        return bancoDados.listarFuncionarios();
    }

    public Funcionario buscar(int id) {

        return bancoDados.buscarFuncionario(id);
    }

    public boolean atualizar(int id, String nome, String cargo, String telefone, String email) {

        return bancoDados.atualizarFuncionario(id, nome, cargo, telefone, email);
    }

    public boolean excluir(int id) {

        return bancoDados.excluirFuncionario(id);
    }
}
