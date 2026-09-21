public class Cliente {

    private final int id;
    private String nome;
    private String telefone;
    private String email;

    public Cliente(int id, String nome, String telefone, String email) {
        this.id = id;
        atualizar(nome, telefone, email);
    }

    // Information Expert: o próprio Cliente sabe quais dados são válidos.
    // Valida tudo ANTES de alterar, para nunca ficar meio atualizado.
    public void atualizar(String nome, String telefone, String email) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ficar vazio.");
        }

        if (telefone == null || telefone.replaceAll("\\D", "").length() < 8) {
            throw new IllegalArgumentException("Digite um telefone válido (mínimo 8 dígitos).");
        }

        if (email == null || !email.trim().matches("[^@\\s]+@[^@\\s]+\\.[^@\\s]+")) {
            throw new IllegalArgumentException("Digite um e-mail válido (ex.: nome@dominio.com).");
        }

        this.nome = nome.trim();
        this.telefone = telefone.trim();
        this.email = email.trim();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
