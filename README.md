# Petshop — Sistema de Cadastro (console)

Disciplina: Projeto e Arquitetura de Sistemas — UNIFOR (Prof. Américo Sampaio)

Equipe:João Miguel Viana Silva (2410555) Pedro Átila Gomes Câmara (2516271) Natan Wendel do Nascimento Lopes (2510510)

## Como executar

Requer Java 14 ou superior (usa `switch` com `->`).

```bash
javac -encoding UTF-8 -d out src/cadastro/*.java
java -cp out Main
```

## Cadastros (CRUD completo)

| Cadastro | Criar | Listar / Buscar por ID | Atualizar | Excluir |
|---|---|---|---|---|
| Cliente | opção 1 | 2 / 3 | 4 | 5 |
| Pet | opção 6 | 7 / 8 | 9 | 10 |
| Funcionário | opção 11 | 12 / 13 | 14 | 15 |

Regras do sistema:
- Todo pet pertence a um cliente (dono). O cadastro do pet exige um ID de cliente existente.
- Um cliente que ainda tem pets não pode ser excluído.
- Na atualização, Enter em branco mantém o valor atual.
- Os dados ficam só em memória (perdem-se ao fechar o programa).

## Padrões de projeto aplicados

| Padrão | Tipo | Onde |
|---|---|---|
| Singleton | GoF | `BancoDados.java` (`getInstancia`) |
| Observer | GoF | `DadosObserver`, `DadosMonitor`, `BancoDados` (`notificarObservers`), registrado em `Main.main` |
| Controller | GRASP | `ClienteController`, `PetController`, `FuncionarioController` |
| Information Expert | GRASP | `Cliente`, `Pet`, `Funcionario` (método `atualizar` valida os próprios dados) |
| Creator | GRASP | `BancoDados` (cria `Cliente`, `Pet` e `Funcionario` porque os guarda) |

Aplicação por cadastro: os dois GoF e os três GRASP valem para Cliente, Pet e Funcionário (o Observer avisa uma mensagem própria para cada um).

### Explicação dos Padrões

- **Singleton:** só existe um `BancoDados`. Se cada controller criasse o seu, cada um teria listas diferentes.
- **Observer:** o `BancoDados` avisa quem estiver "ouvindo" sempre que algo muda. O `DadosMonitor` ouve e imprime `[Observer] Pet cadastrado.`
- **Controller:** a tela (`Main`) fala com os controllers, não com a lista de dados diretamente.
- **Information Expert:** quem tem os dados sabe se eles são válidos, então a validação está na própria entidade.
- **Creator:** quem guarda os objetos é quem os cria.

