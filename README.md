### API para gerenciamento de Entregadores

## Instruções para colocar em operação

# Requisitos
- Java 17
- PostgreSQL
  - Database: entregadores
  - Username: postgres
  - Password: postgres

# Instalação
- Clone este projeto
- Importe para o inteliJ
- Atualize as bibliotecas com o Maven
- Inicialize

# Acesso
- Abra o um gerenciador de API, como o Postman

# Utilização

Para incluir um Entregador
	
	- URI: http://localhost:8080/entregador
	
	- Método: POST
	
	- Formulário JSON: nome, cpf, carga
	
Para listar todos os Entregadores
	
	- URI: http://localhost:8080/entregadores
	
	- Método: GET
	
Para mostrar apenas um Entregador
	
	- URI: http://localhost:8080/entregador/{id}
	
	- Método: GET
	
Para excluir um Entregador
	
	- URI: http://localhost:8080/entregador/{id}
	
	- Método: DELETE

Para alterar um Entregador
	
	- URI: http://localhost:8080/entregador/{id}
	
	- Método: PUT
	
	- Formulário JSON: nome, cpf, carga
