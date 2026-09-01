# PecaAi - Sistema de Gestão para Restaurantes e Bares

O **PecaAi** é uma aplicação backend construída em Java 21 e Spring Boot 3 para a gestão completa de estabelecimentos de alimentação (restaurantes e bares), permitindo o controle de cardápio, solicitações de atendimento e gerenciamento de pedidos em tempo real.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem**: Java 21
* **Framework Principal**: Spring Boot 3
* **Persistência de Dados**: Spring Data JPA / Hibernate
* **Banco de Dados**: PostgreSQL
* **Gerenciador de Dependências**: Maven
* **Padrão de Versionamento**: Conventional Commits

---

## 🏗️ Arquitetura e Organização do Código

A aplicação adota uma arquitetura REST estruturada em camadas bem definidas:

```text
com.edu.ifce.pecaai/
├── controllers/          # Endpoints REST e manipulação de requisições HTTP
├── dtos/                 # Data Transfer Objects com Java Records
├── services/             # Camada de regras de negócio e validações
├── repositories/         # Mapeamento do Spring Data JPA / PostgreSQL
└── entities/             # Entidades de domínio mapeadas com JPA