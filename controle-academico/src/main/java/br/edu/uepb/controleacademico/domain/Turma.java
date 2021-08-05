package br.edu.uepb.controleacademico.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name = "turmas")
@Table(name = "turmas")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "disciplina", nullable = false)
    private String disciplina;

    @Column(name = "sala", nullable = false)
    private String sala;

    @ManyToMany
    Set<Aluno> alunos;

    // @OneToMany
    // Set<Professor> professor;

    public Turma(String disciplina, String sala) {
        this.disciplina = disciplina;
        this.sala = sala;
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }
}
