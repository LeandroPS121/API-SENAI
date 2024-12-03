# Bhaskara API

Uma API para calcular as raízes de uma equação quadrática utilizando a fórmula de Bhaskara, além de registrar usuários e manter um histórico de cálculos.

## Descrição

A Bhaskara API permite que os usuários se registrem e realizem cálculos de raízes quadráticas. A aplicação também armazena um histórico dos cálculos realizados por cada usuário, permitindo que eles acessem suas operações anteriores.

## Funcionalidades

- Registro de usuários com nome, email e senha.
- Cálculo das raízes de uma equação quadrática através da fórmula de Bhaskara.
- Armazenamento e recuperação do histórico de cálculos realizados por cada usuário.
- Recuperação do último cálculo realizado.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Security
- JPA (Java Persistence API)
- Maven

## Instalação

Para instalar e executar este projeto, siga os passos abaixo:

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu_usuario/seu_repositorio.git
   ```
2. Navegue até o diretório do projeto:


3. Compile e execute a aplicação;

## Endpoints da API
Aqui estão os endpoints disponíveis na API:

### Registrar Usuário

- **Método:** POST
- **URL:** `/api/usuarios`
- **Descrição:** Registra um novo usuário.
  
#### Parâmetros:
- `nome`: Nome do usuário.
- `email`: Email do usuário.
- `senha`: Senha do usuário.

#### Respostas:
- **201 Created:** Usuário registrado com sucesso.
- **400 Bad Request:** Email já cadastrado.

---

### Calcular Bhaskara

- **Método:** POST
- **URL:** `/api/calcular-bhaskara`
- **Descrição:** Calcula as raízes da equação quadrática.

#### Parâmetros:
- `a`: Coeficiente da variável quadrática.
- `b`: Coeficiente da variável linear.
- `c`: Termo constante.

#### Respostas:
- **200 OK:** Raízes calculadas com sucesso.
- **400 Bad Request:** Erros como "O coeficiente 'a' não pode ser zero" ou "Não existem raízes reais".

---

### Obter Último Cálculo

- **Método:** GET
- **URL:** `/api/calcular-bhaskara`
- **Descrição:** Recupera o último cálculo realizado.

#### Respostas:
- **200 OK:** Último cálculo realizado.
- **404 Not Found:** Nenhum cálculo realizado ainda.

---