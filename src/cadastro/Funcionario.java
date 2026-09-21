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

    // Information Expert: o próprio Funcionario sabe quais dados são válidos.
    // Valida tudo ANTES de alterar, para nunca ficar meio atualizado.
    public void atualizar(String nome, String cargo, String telefone, String email) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ficar vazio.");
        }

        if (cargo == null || cargo.trim().isEmpty()) {
            throw new IllegalArgumentException("O cargo não pode ficar vazio.");
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

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
