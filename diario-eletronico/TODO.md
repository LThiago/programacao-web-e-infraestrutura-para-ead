# TODO list

## Parte 1

Crie uma aplicação Spring Boot com as rotas básicas para um CRUD de professores, alunos e turmas, com a seguinte lógica de mapeamento: Um professor dá aula em várias turmas, e um aluno está em várias turmas.

Crie uma rota para vincular um aluno a um professor. Um possível design sugerido pode ser: (Você também pode enviar os dados pelo corpo da requisição)

    PUT turmas/{turmaId}/matricularAluno/{alunoId}

Configure um banco de dados em memória para armazenar seus dados.

Utilize o link abaixo para conhecer sobre o mapeamento com banco de dados e veja qual é o mais adequado para se utilizar.

[https://www.baeldung.com/jpa-many-to-many](https://www.baeldung.com/jpa-many-to-many)

## Parte 2

Adicione o projeto Spring Security, promovendo autenticação com JWT Token à sua aplicação, conforme tutorial passado em aula.

Faça com que um usuário tenha o papel de professor ou de aluno (pode-se usar ENUM ou herança, conforme a sua escolha), e que a rota de cadastro seja aberta.

## Parte 3

Considerando o link abaixo, sobre a proteção do domínio da aplicação, evolua o projeto desenvolvido nas atividades anteriores, incluindo os seguintes requisitos:

- CRUD de projetos (Um projeto precisa ter, no mínimo: nome e descrição), que está vinculado a um professor (um professor pode ter somente um projeto) e a vários alunos (um aluno só pode pertencer a um projeto).
- O projeto só pode ser criado por um professor (terá o papel de coordenador)
- O professor pode vincular alunos ao seu projeto e atribuir um papel (por exemplo: estágio, júnior, pleno, sênior, master, etc.)
- O projeto deve listar todos os seu integrantes juntamente com sua função
- Um usuário pode se cadastrar como aluno ou professor
- Um usuário pode visualizar quaisquer projetos e seu detalhamento

Inclua os DTOs que achar necessário. O projeto pode ser feito em equipe de até 3 pessoas.
Deverá ser submetido o link do código do GitHub com a contribuição de todos da equipe.

Bônus (2,0 pontos): submissão do link da aplicação no heroku, azure, ou na plataforma de cloud da sua preferência.

[https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku)

[https://spring.io/guides/gs/spring-boot-for-azure/](https://spring.io/guides/gs/spring-boot-for-azure/)
