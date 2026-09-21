package cadastro;
public class Funcionario {

    private final int id;
    private String nome;
    private String cargo;
    private String telefone;
    private String email;

    public Funcionario(int id, String nome, String cargo, String telefone, String email) {
        this.id = id;
        atualizar(nome, cargo, telefone, email);
    }


    public void atualizar(String nome, String cargo, String telefone, String email) {

        if (nome == null || !nome.trim().matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
            throw new IllegalArgumentException("O nome não pode ficar vazio e deve conter apenas letras.");
        }

        if (cargo == null || !cargo.trim().matches("^[a-zA-ZÀ-ÿ\\s]+$")) {
            throw new IllegalArgumentException("O cargo não pode ficar vazio e deve conter apenas letras.");
        }

        if (telefone == null || telefone.replaceAll("\\D", "").length() < 8) {
            throw new IllegalArgumentException("Digite um telefone válido (mínimo 8 dígitos).");
        }

        if (email == null || !email.trim().matches("[^@\\s]+@[^@\\s]+\\.[^@\\s]+")) {
            throw new IllegalArgumentException("Digite um e-mail válido (ex.: nome@dominio.com).");
        }

        this.nome = nome.trim();
        this.cargo = cargo.trim();
        this.telefone = telefone.trim();
        this.email = email.trim();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }


}
