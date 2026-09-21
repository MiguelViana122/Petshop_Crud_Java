public class Pet {

    private final int id;
    private final int donoId;
    private String nome;
    private String especie;
    private String raca;
    private int idade;

    public Pet(int id, int donoId, String nome, String especie, String raca, int idade) {
        this.id = id;
        this.donoId = donoId;
        atualizar(nome, especie, raca, idade);
    }

    // Information Expert: o próprio Pet sabe quais dados são válidos.
    // Valida tudo ANTES de alterar, para nunca ficar meio atualizado.
    public void atualizar(String nome, String especie, String raca, int idade) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ficar vazio.");
        }

        if (especie == null || especie.trim().isEmpty()) {
            throw new IllegalArgumentException("A espécie não pode ficar vazia.");
        }

        if (raca == null || raca.trim().isEmpty()) {
            throw new IllegalArgumentException("A raça não pode ficar vazia.");
        }

        if (idade < 0 || idade > 100) {
            throw new IllegalArgumentException("A idade deve estar entre 0 e 100.");
        }

        this.nome = nome.trim();
        this.especie = especie.trim();
        this.raca = raca.trim();
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public int getDonoId() {
        return donoId;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", donoId=" + donoId +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                '}';
    }
}
