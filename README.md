# Sistema de Gestão de Envios para Transportadoras
Este sistema é um back-end desenvolvido em Java para gerenciar o envio de objetos em uma transportadora.
Ele permite o gerenciamento de remetentes, destinatários e objetos, utilizando uma API mocada para cálculo de frete através do CEP.

## Requisitos
- Git
- Java 17
- Docker

## Como Executar o Projeto Localmente

1. Clone o repositório do projeto do GitHub:
   ```bash
   git clone https://github.com/brenodarosdev/LogiSmart.git
   ```

2. Acesse o diretório do projeto:
   ```bash
   cd LogiSmart
   ```

3. Configure as variáveis de ambiente para o banco de dados. Defina-as no seu terminal ou em um arquivo .env no diretório do projeto:
    ```bash
    POSTGRES_DB=logismart_dev_db
    POSTGRES_USER=user
    POSTGRES_PASSWORD=password
    ```

4. Inicie os containers no Docker:
   ```bash
   docker compose up -d
   ```

5. Compile e construa o projeto:
   ```bash
   ./mvnw clean install
   ```
   
6. Execute o projeto:
   ```bash
    ./mvnw spring-boot:run
   ```

7. Acesse a documentação da API gerada pelo [Swagger](http://localhost:8080/logismart/api/public/swagger-ui) em:
   ```bash
   http://localhost:8080/logismart/api/public/swagger-ui
   ```