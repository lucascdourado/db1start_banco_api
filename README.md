# DB1 Start: Banco API
- Feito Por: Lucas Dourado
- Projeto de conta corrente usando Spring Tool Suite (JPA e API Rest) 

## Atividades desenvolvidas no exercício

* [x] Entidades mapeadas com anotações do Spring Data JPA.
* [x] Criação repositórios para cada entidade.
* [x] Criação serviços para cada entidade.
* [x] Criação de classes de teste para fazer operações de inserção, consulta e deleção.
* [x] Criação de controllers para endpoints de uma API Rest.
* [x] Criação de classes DTO para requisições e respostas da API Rest.
* [x] Criação de classes Adapter para cada DTO.

## Endpoints da API Rest implementada

* [x] Criar
* [x] Buscar
* [x] Deletar
* [x] Atualizar
* [x] Operações de depositar, sacar, ativar/desativar uma conta.

```
/api

  /agencia
    /criar
    /buscartodas
    /buscarporid/{id}
    /buscarpornumero/{numero}
    /apagartodas
    /apagarporid/{id}
    /atualizar/{id}
    
  /cidade
    /criar
    /buscartodas
    /buscarporid/{id}
    /buscarpornome/{nome}
    /apagartodas
    /apagarporid/{id}
    /atualizar/{id}
    
  /cliente
    /criar
    /buscartodos
    /buscarporid/{id}
    /apagartodos
    /apagarporid/{id}
    /atualizar/{id}
    
  /conta
    /criar
    /buscartodas
    /buscartodasativas
    /buscartodasinativas
    /buscarporid/{id}
    /apagartodas
    /apagarporid/{id}
    /atualizar/{id}
    /depositar
    /sacar
    /ativar
    /desativar
    
  /estado
    /criar
    /buscartodos
    /buscarporid/{id}
    /buscarpornome/{nome}
    /apagartodos
    /apagarporid/{id}
    /atualizar/{id}
    
```

## Consultas implementadas
* [x] Todas as agências de uma dada cidade.
* [x] Todas as cidades de um dado estado.
* [x] Todas as contas ativas.
* [x] Todas as contas inativas.

## Operações implementadas
* [x] Criar estado, cidade, agência, cliente, conta.
* [x] Depósito em uma conta.
* [x] Saque em uma conta.
* [x] Ativar uma conta.
* [x] Desativar uma conta.


Repositório inicial: https://github.com/lucascdourado/db1startjava/tree/master/cidades-api
