<h1 align="center">Financr API</h1>

## Descrição do Projeto
<p align="center">O projeto propõe uma solução de back-end utilizando a linguagem Java, Spring Boot, PostgresSQL e Docker visando auxiliar no controle de finanças pessoais.</p>


### Features

#### Contas
- [x] Cadastro de uma conta
- [x] Listar toda as contas
- [x] Atualizar dados de uma conta
- [x] Deletar uma conta
- [x] Transferência de saldo entre contas
- [x] Listar saldo total entre todas as contas

#### Despesas
- [x] Cadastro de uma despesa
- [x] Listar todas as despesas por período
- [x] Listar todas as despesas por tipo de despesa
- [x] Atualizar dados de uma despesa
- [x] Deletar uma despesa
- [x] Listar saldo total entre todas as despesas


#### Receitas
- [x] Cadastro de uma receita
- [x] Listar todas as receitas por período
- [x] Listar todas as receitas por tipo de receita
- [x] Atualizar dados de uma receita
- [x] Deletar uma receita
- [x] Listar saldo total entre todas as receitas

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Git](https://git-scm.com), [Java JDK 11 no minimo](https://www.oracle.com/java/technologies/downloads/). 
Além disto é bom ter um editor para trabalhar com o código como [Intellij](https://www.jetbrains.com/pt-br/idea/download/)

### 🎲 Rodando o Back End (servidor)

```bash
# Clone este repositório
$ git clone https://github.com/santosclaudinei/desafiopubfuture.git

# Acesse a pasta do projeto no terminal/cmd
$ cd desafiopubfuture

# Verificar se todas as dependências foram instaladas
$ abrir o arquivo pom.xml

# Criação do container com o banco de banco de dados
$ docker-compose up

# Execute a aplicação
$ Executar o arquivo DesafioPublicaApplication.java 

# O servidor inciará na porta:8080 
- É possível usar o swagger-ui para realizar testes e verificar documentação <http://localhost:8080/swagger-ui/index.html>
```

### 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- [Java](https://expo.io/)
- [Spring Boot](https://start.spring.io/)
- [PostgreSql](https://www.jetbrains.com/datagrip/download/)
- [Docker](https://www.docker.com/get-started)

## Licença

Não se aplica.

### Autor

<sub><b>Claudinei Santos</b></sub>

Foi uma experiênica engrandecedora, poís ao longo de duas semanas tive que estudar bastante e isso me proporcionou grande aprendizado que vou levar comigo como bagagem.

[![Linkedin Badge](https://img.shields.io/badge/-Claudinei-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/claudinei-santos-ti/)](https://www.linkedin.com/in/claudinei-santos-ti/)
[![Gmail Badge](https://img.shields.io/badge/-santos.devclaudinei@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:santos.devclaudinei@gmail.com)](mailto:santos.devclaudinei@gmail.com)

