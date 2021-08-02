package br.edu.uepb.controleacademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uepb.controleacademico.domain.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
