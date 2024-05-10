[![Finalizado](https://img.shields.io/badge/Status-Conclu%C3%ADdo-brightgreen)](https://github.com/imetropoledigital/trabalho-final-matheus-costa-vidal)

<h1 align="center">Projeto de Arquitetura Hexagonal em Java</h1>

<p align='center'> 
    <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>  
    <img src="https://img.shields.io/badge/Arquitetura_Hexagonal-F2F4F9?style=for-the-badge&"/>
    <img src="https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white"/>
</p>    

## Introdução 🏛️
Este projeto foi desenvolvido como parte de um estudo sobre a arquitetura hexagonal (também conhecida como arquitetura de portas e adaptadores) em Java. A arquitetura hexagonal é um estilo arquitetural que visa separar as preocupações do negócio (core) das implementações técnicas, promovendo assim um código mais limpo, desacoplado e testável.

O intuito deste projeto não é abordar a complexidade do domínio de negócio, mas sim fornecer um exemplo prático de como a arquitetura hexagonal pode ser implementada em uma aplicação Java, mesmo em um contexto simples de CRUD (Create, Read, Update, Delete).

## Arquitetura Hexagonal ⬡
A arquitetura hexagonal é baseada no princípio de que as regras de negócio devem ser independentes de qualquer detalhe de implementação externo, como frameworks, banco de dados ou interfaces do usuário. Uma Arquitetura Hexagonal divide as classes de um sistema em dois grupos principais:
- Classes de domínio, isto é, diretamente relacionadas com o negócio do sistema. 
- Classes relacionadas com infraestrutura, tecnologias e responsáveis pela integração com sistemas externos (tais como bancos de dados).

### Portas 🚪
As portas representam as interfaces que permitem a comunicação entre as camadas da arquitetura hexagonal. Elas definem os contratos através dos quais as diferentes partes do sistema podem interagir entre si, sem se preocupar com os detalhes de implementação interna.
### Adaptadores 🛠️
Os adaptadores são as implementações concretas das portas definidas nas camadas de domínio e infraestrutura. Eles traduzem as operações definidas nas portas em chamadas concretas aos sistemas externos ou tecnologias específicas.
- As portas e adaptadores são elementos-chave da arquitetura hexagonal, protegem o domínio da aplicação, permitindo uma separação clara entre as diferentes partes do sistema e facilitando a substituição ou a extensão de componentes sem afetar o restante do sistema. Isso torna o código mais modular, flexível e fácil de manter e evoluir ao longo do tempo.

## Estrutura do Projeto 📂
A estrutura do projeto segue os princípios da arquitetura hexagonal:

- `application:` Contém o domínio da aplicação, representados pelos modelos e portas;
- `ports:` Aqui estão definidas as interfaces que representam os contratos entre as camadas. Por exemplo, ProductRepository define a interface para operações de persistência de produto e ProductService define o contrato para operações de serviços do produto;
- `adapters:` Contém as implementações concretas das portas definidas na camada de portas. Por exemplo, ProductRepositoryImpl implementa ProductRepository utilizando tecnologias de persistência específicas;
- `producer:` Nesta camada, estão as interfaces de entrada/saída da aplicação. Por exemplo, ProductController expõe os serviços de produto como endpoints REST.

## Execução do Projeto 🚀
Para executar o projeto, você precisa configurar um ambiente Java e garantir que todas as dependências estejam instaladas corretamente. Em seguida, você pode compilar e implantar o projeto como uma aplicação Java padrão.

## Conclusão 🎓
Este projeto oferece uma visão prática de como a arquitetura hexagonal pode ser implementada em uma aplicação Java, mesmo em um contexto simples de CRUD. A separação clara de responsabilidades e a independência de detalhes de implementação externos facilitam a manutenção, o teste e a evolução da aplicação ao longo do tempo.

Referências: 
- Curso 'Arquitetura Hexagonal' do [Full Cycle](https://fullcycle.com.br/)
- [O que é uma Arquitetura Hexagonal?](https://engsoftmoderna.info/artigos/arquitetura-hexagonal.html)
- [Desvendando a Arquitetura Hexagonal](https://medium.com/tableless/desvendando-a-arquitetura-hexagonal-52c56f8824c)
