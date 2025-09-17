# confeitaria-backend-devops
Projeto desenvolvido para disciplina de DevOps


## Como rodar

Para rodar o projeto, siga os passos abaixo:

1. Clone o repositório:
   ```bash
   git clone https://github.com/igorbatistadev/confeitaria-backend-devops.git

    cd confeitaria-backend-devops
    ```

2. Certifique-se de ter o Docker e o Docker Compose instalados na sua máquina.

3. Construa e inicie os containers:
   ```bash
   docker-compose up --build -d
   ```

4. Pronto, aplicação está rodando em `http://localhost:8080`.


## Para buildar para produção

1. Execute o comando abaixo para buildar a imagem Docker:
   ```bash
   docker build -t confeitaria:1.0.0 -f ./infra/dockers/Dockerfile .
   ```
