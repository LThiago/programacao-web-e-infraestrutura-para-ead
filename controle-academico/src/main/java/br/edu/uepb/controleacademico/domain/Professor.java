package br.edu.uepb.controleacademico.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "professores")
@Table(name = "professores")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "formacao", nullable = false)
    private String formacao;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    // @Column(name = "matricula", nullable = false, unique = true)
    // private String matricula;

    public Professor(String nome, String email, String formacao) {
        this.nome = nome;
        this.email = email;
        this.formacao = formacao;

        // TODO - Encontrar uma forma de implementar isso corretamente.
        // this.matricula = UUID.randomUUID().toString();
    }
}
