# DesafioPubFuture
Desafio da instituição Proway para a Pública Future.

# Requisitos

Para este projeto você vai precisar:

- Java 17+
- Banco de Dados MySQL 5.7+
- Maven 3.8.4+

# Start do Projeto

Comece configurando seu arquivo application.properties:

- spring.datasource.url e flyway.url : url de conexão com seu banco de dados
- spring.datasource.username e flyway.user : usuário de conexão com seu banco de dados
- spring.datasource.password e flyway.password : senha de conexão com seu banco de dados
- flyway.schemas : schema para aplicação no seu banco de dados

Após a configuração dessas chaves você ter no seu banco de dados o schema criado conforme informado na chave flyway.schemas.

Para rodar a aplicação, basta abrir o projeto na sua ferramenta de desenvolvimento (Eclipse, NetBeans,...), abrir o arquivo PubApplication.java e rodar como um Java Application. 

Quando você iniciar a aplicação a estrutura de banco de dados será automaticamente criada pelo Flyway. 