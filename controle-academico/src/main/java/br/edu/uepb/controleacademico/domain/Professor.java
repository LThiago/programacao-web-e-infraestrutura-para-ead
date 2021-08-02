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

    // @Column(name = "cadastro", unique = true)
    // private String cadastro;

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    public Professor(String nome, String email) {
        // this.cadastro = UUID.randomUUID().toString();
        this.nome = nome;
        this.email = email;
    }
}
