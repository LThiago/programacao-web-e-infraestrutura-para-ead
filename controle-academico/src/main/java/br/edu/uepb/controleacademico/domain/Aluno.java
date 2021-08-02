// package br.edu.uepb.controleacademico.domain;

// import java.util.UUID;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.Table;

// import lombok.Data;
// import lombok.NoArgsConstructor;

// @NoArgsConstructor
// @Data
// @Entity(name = "alunos")
// @Table(name = "alunos")
// public class Aluno {

// @Id
// @GeneratedValue(strategy = GenerationType.AUTO)
// private Long id;

// @Column(name = "matricula", nullable = false, unique = true)
// private String matricula;

// @Column(name = "nome", nullable = false, unique = true)
// private String nome;

// @Column(name = "email", nullable = false, unique = true)
// private String email;

// public Aluno(String nome, String email) {
// this.matricula = UUID.randomUUID().toString();
// this.nome = nome;
// this.email = email;
// }
// }
