# CRUD da classe Pessoa

#### Documentação em Swagger. Desenvolvido utilizando Spring Boot.

## Modelos

### Pessoa

| Atributo | Tipo   | Validações                |
|----------|--------|---------------------------|
| Id       | Long   | @Generated(Identity)       |
| Nome     | String | @Not Null                  |
| Idade    | Int    | @Not Null, @min(18) @max(120) |
| Email    | String | @Email                     |

## Rotas

| Rota                | Método     | Body Parameters    | Path Variables |
|---------------------|------------|--------------------|----------------|
| /api/listar         | **GET**    | -                  |                |
| /api/listar/{id}    | **GET**    | -                  | id             |
| /api/cadastrar      | **POST**   | email, idade, nome |                |
| /api/apagar/{id}    | **DELETE** | -                  | id             |
| /api/atualizar/{id} | **PUT**    | email, idade, nome | id             |
