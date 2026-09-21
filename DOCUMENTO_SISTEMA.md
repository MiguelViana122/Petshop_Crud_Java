# Sistema de Cadastro para Petshop

Equipe: **[NOME DA EQUIPE]** — [Integrante 1], [Integrante 2], [Integrante 3]
Disciplina: Projeto e Arquitetura de Sistemas — UNIFOR

## 1. Propósito

Sistema de console em Java que organiza os cadastros básicos de um petshop: clientes, os pets de cada cliente e os funcionários. Substitui anotações em papel por um cadastro único, consistente e fácil de consultar.

## 2. Principais funcionalidades

- **Clientes:** cadastrar, listar, buscar por ID, atualizar e excluir (nome, telefone, e-mail).
- **Pets:** cadastrar, listar, buscar por ID, atualizar e excluir (nome, espécie, raça, idade). Cada pet é ligado ao seu dono, um cliente já cadastrado.
- **Funcionários:** cadastrar, listar, buscar por ID, atualizar e excluir (nome, cargo, telefone, e-mail).
- **Validações:** campos obrigatórios, e-mail e telefone em formato válido, idade entre 0 e 100.
- **Integridade:** não é possível cadastrar um pet sem dono existente, nem excluir um cliente que ainda tem pets.
- **Avisos automáticos:** a cada mudança nos dados o sistema exibe uma mensagem (por exemplo, "[Observer] Pet cadastrado.").
- **Entrada segura:** texto digitado onde se espera um número não derruba o programa.

## 3. Principais usuários

- **Atendente/recepcionista:** cadastra clientes e pets, consulta dados na hora do atendimento.
- **Gerente/administrador:** mantém o cadastro de funcionários e revisa os demais cadastros.

[Ajustar conforme a visão da equipe.]

## 4. Arquitetura e padrões de projeto

Camadas simples: `Main` (menu) → Controllers → `BancoDados` (dados em memória) → entidades (`Cliente`, `Pet`, `Funcionario`).

| Padrão | Tipo | Como aparece |
|---|---|---|
| Singleton | GoF | Existe uma só instância de `BancoDados`, compartilhada pelos controllers. |
| Observer | GoF | `BancoDados` notifica o `DadosMonitor` a cada cadastro, atualização ou exclusão. |
| Controller | GRASP | Um controller por cadastro recebe os pedidos do menu. |
| Information Expert | GRASP | Cada entidade valida os próprios dados. |
| Creator | GRASP | `BancoDados` cria as entidades que guarda. |

Os cinco padrões valem para os três cadastros.

## 5. Limitações atuais

Dados apenas em memória; `BancoDados` concentra os três cadastros; menu em uma única classe.

## 6. Prints

[Inserir prints das telas: menu, cadastro, listagem, erro de validação, Observer disparando.]
