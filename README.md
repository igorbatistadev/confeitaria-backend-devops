# confeitaria-backend-devops
Projeto desenvolvido para disciplina de DevOps

## Pré-requisitos

- Docker e Docker Compose instalados
- VS Code (opcional, para usar DevContainer)

## Como rodar

### Opção 1: DevContainer (Recomendado para desenvolvimento)

O DevContainer oferece um ambiente de desenvolvimento completo e isolado, com todas as dependências configuradas.

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/igorbatistadev/confeitaria-backend-devops.git
   cd confeitaria-backend-devops
   ```

2. **Abra o projeto no VS Code:**
   - Abra o VS Code na pasta do projeto
   - Instale a extensão "Dev Containers" (se ainda não tiver)
   - Quando solicitado, clique em "Reopen in Container" ou use o comando:
     - `Ctrl+Shift+P` (ou `Cmd+Shift+P` no Mac)
     - Digite: `Dev Containers: Reopen in Container`

3. **Aguarde o build inicial:**
   - O VS Code irá construir os containers automaticamente
   - A aplicação será iniciada automaticamente com hot reload

4. **Pronto!** A aplicação estará rodando em `http://localhost:8080`

O DevContainer inclui:
- Java 21 (Eclipse Temurin)
- Maven 3.9.5
- PostgreSQL 15
- Extensões do VS Code para Java/Spring Boot
- Hot reload automático (alterações no código são refletidas automaticamente)

### Opção 2: Ambiente de Desenvolvimento (Docker Compose)

Para rodar localmente com Docker Compose em modo desenvolvimento:

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/igorbatistadev/confeitaria-backend-devops.git
   cd confeitaria-backend-devops
   ```

2. **Inicie os containers:**
   ```bash
   docker compose up --build
   ```

3. **A aplicação estará disponível em:** `http://localhost:8080`

**Características do ambiente de desenvolvimento:**
- Hot reload ativado (alterações no código são refletidas automaticamente)
- Volumes montados para desenvolvimento
- Maven com dependências em cache para builds mais rápidos

**Para parar os containers:**
```bash
docker compose down
```

### Opção 3: Ambiente de Produção

Para rodar em modo produção (imagem otimizada, sem hot reload):

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/igorbatistadev/confeitaria-backend-devops.git
   cd confeitaria-backend-devops
   ```

2. **Inicie os containers em modo produção:**
   ```bash
   docker compose --profile prod up --build -d
   ```

3. **A aplicação estará disponível em:** `http://localhost:8080`

**Características do ambiente de produção:**
- Imagem otimizada (apenas JRE, sem Maven)
- Sem volumes montados
- Build completo do JAR antes do deploy
- Melhor performance e menor tamanho da imagem

**Para parar os containers:**
```bash
docker compose --profile prod down
```

**Para buildar apenas a imagem de produção:**
```bash
docker build -t confeitaria-backend:prod --target prod .
```

**Para testar a imagem de produção isoladamente:**
```bash
docker run --rm -p 8080:8080 confeitaria-backend:prod
```
*Nota: A imagem isolada não terá acesso ao banco de dados. Use o docker-compose para ambiente completo.*

## Estrutura do Dockerfile

O projeto utiliza um Dockerfile multi-stage unificado na raiz com os seguintes targets:

- **`base`**: Baixa dependências do Maven (cache)
- **`build`**: Compila e empacota o JAR
- **`prod`**: Imagem de produção otimizada (JRE apenas)
- **`dev`**: Ambiente de desenvolvimento com Maven para hot reload

## Serviços Disponíveis

- **Aplicação Spring Boot**: `http://localhost:8080`
- **PostgreSQL**: `localhost:5432`
  - Database: `confeitariadb`
  - Usuário: `postgres`
  - Senha: `root`

## Comandos Úteis

**Ver logs da aplicação:**
```bash
docker compose logs app -f
```

**Ver logs em produção:**
```bash
docker compose --profile prod logs app-prod -f
```

**Acessar o banco de dados:**
```bash
docker compose exec postgres psql -U postgres -d confeitariadb
```

**Reconstruir apenas a aplicação:**
```bash
docker compose build app
```

**Reconstruir em produção:**
```bash
docker compose --profile prod build app-prod
```
