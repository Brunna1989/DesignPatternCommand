# Sistema Bancário com Design Pattern (comportamentais): Command

## Resumo

Este projeto implementa um sistema bancário simples utilizando o padrão de design Command. O objetivo é permitir operações de depósito e saque em uma conta, mantendo um histórico das operações realizadas.

## Estrutura do Projeto

### Módulo `model`

Contém a definição da classe `Conta`, que representa uma conta bancária.

### Módulo `command`

Contém as implementações das classes `Deposito` e `Saque`, que são os comandos que podem ser executados no sistema.

### Módulo `service`

A classe `ServicoBanco` é responsável por gerenciar as operações bancárias. Ela utiliza o padrão Command para processar depósitos e saques, mantendo um histórico das operações realizadas.

### Módulo `view`

A classe `Main` na pasta `view` representa a aplicação principal. Ela instancia uma conta, um serviço bancário e realiza operações de depósito e saque, exibindo o extrato e o saldo.

## Como Executar o Projeto

1. Clone o repositório.
2. Abra o terminal na pasta do projeto.
3. Execute o comando `./gradlew run` para compilar e executar a aplicação.

## Observações

- O sistema permite depósitos e saques, mantendo um histórico de operações.
- Não há validação de saldo antes de saques, permitindo operações mesmo em saldo negativo.
- O histórico de operações é consultado para exibir o extrato da conta.
