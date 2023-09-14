# Projeto Cadastro de sistemas

---

---

## O que este reposit�rio cont�m

1. CRUD de Projetos com algumas especificidades requeridas
2. Alguns testes unit�rios com JUNIT5
4. Swagger API REST

---

## Qual o objetivo deste reposit�rio

1. Processo seletivo para a empresa an�nima
2. Criar um cadastro de "sistemas"
3. Documentar o projeto com o Swagger.

---

## O que � necess�rio para startar o projeto

1. Java na vers�o 12
2. Banco de dados Postgresql (foi usado a vers�o 12)
3. Criar uma base de dados com o nome `cadastro_projetos`

---

## Modelo do diagrama usado

![Diagrama](cadastroportifolio/docs/UML.png "Diagrama")

---

### Arquivo para importa��o de endpoints do Postman, fa�a a importa��o do arquivo:

[![Download arquivo cole��es endpoints](https://img.shields.io/badge/Download-Arquivo-brightgreen)](cadastroportifolio/docs/Cadastro-Portifolio.postman_collection.json)

### Com a aplica��o startada acessar a URL do Swagger para manipula��o de endpoints
```
http://localhost:8080/swagger-ui.html#/
```

## Endpoits de consultas de sistemas cadastrados


### Cadastrar Projetos.
```

http://localhost:8080/projetos/cadastrar

```

### Buscar Projetos por id. Deve ser passado o par�metro id com o id do projeto a ser buscado
```

http://localhost:8080/projetos/buscar/{id}

```

### Atualizar Projetos. Deve ser passado o par�metro id com o id do projeto a ser alterado
```

http://localhost:8080/projetos/atualizar/{id}

```

### Excluir Projetos. Deve ser passado o par�metro id com o id do projeto a ser deletado
```

http://localhost:8080/projetos/deletar/{id}

```

---

### Json para cadastro de projeto
```json
{
  "nome": "Projeto de PIX 2.0",
  "dataInicio": "2023-09-11T00:00:00",
  "dataPrevisaoFim": "2023-09-11T00:00:00",
  "dataFim": "2050-09-11T00:00:00",
  "descricao": "Este � um projeto para movimenta��es financeiras no Brasil",
  "orcamento": 1000000.00,
  "risco": 1,
  "gerente": {
    "id" : 3
  }
}
```


