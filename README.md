# Teste Prático Java - Iniflex

Este projeto foi desenvolvido como parte de um teste técnico solicitado pela empresa **Iniflex**, com o objetivo de avaliar conhecimentos em programação Java, organização de código e lógica.

A proposta consiste em manipular uma lista de funcionários, aplicando regras específicas como remoção de dados, agrupamentos, cálculos e formatação de informações.

---

## Tecnologias utilizadas

* Java 8+
* API de Datas (`LocalDate`)
* `BigDecimal` para cálculos monetários
* Collections (`List`, `Map`)
* Streams (para manipulação de dados)

---

## Estrutura do projeto

O projeto foi organizado de forma simples e direta:

```
src/
 ├── Pessoa.java
 ├── Funcionario.java
 └── Principal.java
```

### Pessoa.java

Classe base contendo:

* nome
* data de nascimento

Foi criada para representar uma pessoa genérica e servir como base para herança.

---

### Funcionario.java

Classe que herda de Pessoa e adiciona:

* salário
* função

Aqui foi aplicada herança para reaproveitar os atributos da classe Pessoa.

---

### Principal.java

Classe responsável por executar todas as regras do teste.

Contém:

* criação da lista de funcionários
* manipulação dos dados
* impressão das informações
* aplicação das regras solicitadas

---

## Funcionalidades implementadas

* Inserção dos funcionários conforme tabela fornecida
* Remoção do funcionário "João"
* Impressão com formatação de data (dd/MM/yyyy)
* Formatação de valores monetários (pt-BR)
* Aplicação de aumento salarial de 10%
* Agrupamento por função utilizando Map
* Listagem de funcionários por função
* Filtro de aniversariantes (meses 10 e 12)
* Identificação do funcionário mais velho
* Ordenação alfabética
* Soma total dos salários
* Cálculo de salários mínimos por funcionário

---

## Observações

Durante o desenvolvimento, optei por:

* Utilizar `BigDecimal` para evitar problemas com precisão em valores monetários
* Utilizar `Streams` para deixar algumas operações mais limpas e legíveis
* Manter o código simples, direto e bem comentado para facilitar entendimento

---

##  Como executar

1. Importar o projeto em uma IDE (IntelliJ, Eclipse ou similar)
2. Executar a classe `Principal`
3. O resultado será exibido no console

---

## Autor

Desenvolvido por **Thiago Torres**

Desenvolvedor e professor Front-end com forte interesse em desenvolvimento de software e evolução constante na área.
