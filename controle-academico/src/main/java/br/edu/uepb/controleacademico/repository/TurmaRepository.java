package br.edu.uepb.controleacademico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uepb.controleacademico.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
