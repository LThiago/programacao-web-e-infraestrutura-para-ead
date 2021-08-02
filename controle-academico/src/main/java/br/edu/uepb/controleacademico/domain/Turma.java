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
// @Entity(name = "turmas")
// @Table(name = "turmas")
// public class Turma {

// @Id
// @GeneratedValue(strategy = GenerationType.AUTO)
// private Long id;

// @Column(name = "codigo", nullable = false, unique = true)
// private String codigo;

// @Column(name = "nome", nullable = false, unique = true)
// private String nome;

// public Turma(String nome, String email) {
// this.codigo = UUID.randomUUID().toString();
// this.nome = nome;
// }
// }
