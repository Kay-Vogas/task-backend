# 🚀 Projeto de Gestão de Tarefas (Task Manager)

Um simples projeto Full-Stack de um "To-Do List" (Lista de Tarefas) com o objetivo de demonstrar a integração entre um backend RESTful e um frontend reativo.

O projeto consiste em um backend feito em **Spring Boot (Java)** que gerencia os dados e um frontend consumidor feito em **JavaScript puro (Vanilla JS)**, HTML e CSS.

## ✨ Funcionalidades Principais

* **CRUD Completo:** Criar, Ler, Atualizar e Deletar tarefas.
* **Priorização:** As tarefas podem ser definidas com prioridades (`BAIXA`, `MEDIA`, `ALTA`, `URGENTE`).
* **Ordenação Automática:** A lista de tarefas é sempre exibida ordenada pela prioridade (da mais alta para a mais baixa).
* **Edição em Modal:** A atualização das tarefas é feita através de um modal de edição limpo.
* **Status Toggle:** Marque tarefas como "Concluídas" ou "Pendentes" com um único clique, sem precisar abrir o modal.
* **Interface Reativa:** O frontend reage às mudanças (criar, editar, deletar) e atualiza a lista em tempo real.

## 🛠️ Tecnologias Utilizadas

### Backend
* **Java 17** (ou superior)
* **Spring Boot** (para a API RESTful)
* **Spring Data JPA** (para persistência de dados)
* **H2 Database** (banco de dados em memória para fácil execução)
* **Maven** (gerenciador de dependências)

### Frontend
* **HTML5** (estrutura semântica)
* **CSS3** (estilização moderna com Flexbox)
* **JavaScript (Vanilla JS)** (para lógica e manipulação do DOM)
* **Fetch API** (para comunicação HTTP com o backend)

---

## 🚀 Como Executar a Aplicação

Para executar o projeto, você precisa rodar o **Backend** e o **Frontend** separadamente.

### 1. Executando o Backend (Spring Boot)

1.  **Clone o repositório** (ou tenha a pasta do backend pronta).
2.  **Abra o projeto** em sua IDE Java favorita (ex: IntelliJ IDEA ou Eclipse).
3.  **Aguarde o Maven** baixar todas as dependências do projeto (pode levar alguns minutos na primeira vez).
4.  **Execute a Aplicação:** Encontre a classe principal `TarefasBackendApplication.java` (ou similar) e execute-a.
5.  **Pronto!** O servidor backend estará rodando em `http://localhost:8080`.

> **Nota sobre o Banco de Dados:** O projeto está configurado para usar o H2 (banco em memória). Você pode acessar o console do H2 em `http://localhost:8080/h2-console` e usar a URL JDBC `jdbc:h2:mem:testdb` para visualizar as tabelas.

### 2. Executando o Frontend (Vanilla JS)

1.  **Abra a pasta** que contém os arquivos `index.html`, `app.js` e `style.css` no **Visual Studio Code**.
2.  **Instale a extensão "Live Server"** no VS Code (ela é essencial para evitar problemas de CORS com arquivos locais).
3.  **Inicie o servidor:** Clique com o botão direito no arquivo `index.html` e selecione **"Open with Live Server"**.
4.  **Pronto!** Seu navegador abrirá automaticamente no endereço `http://127.0.0.1:5500` e a aplicação estará funcionando.

> **Nota sobre o CORS:** O backend (`TaskController.java`) já está configurado com `@CrossOrigin(origins = "http://127.0.0.1:5500")` para permitir a comunicação com o frontend servido pelo Live Server.

---

## 📈 Diagramas do Sistema

Abaixo estão os diagramas que modelam a arquitetura e o comportamento da aplicação, escritos em sintaxe Mermaid.

### Diagrama de Caso de Uso

Este diagrama mostra as interações do usuário com as principais funcionalidades do sistema.

```mermaid
graph TD
    A(Usuário) --> C[Criar Tarefa]
    A --> R[Ver Lista de Tarefas]
    A --> U[Atualizar Tarefa]
    A --> D[Deletar Tarefa]
    A --> T[Concluir/Desmarcar Tarefa]

    R --> O(Ordenar por Prioridade)
    U --> M(Abrir Modal de Edição)

    style A fill:#f9f,stroke:#333,stroke-width:2px
    style C fill:#ccf,stroke:#333
    style R fill:#ccf,stroke:#333
    style U fill:#ccf,stroke:#333
    style D fill:#ccf,stroke:#333
    style T fill:#ccf,stroke:#333
