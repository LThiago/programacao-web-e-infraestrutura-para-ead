package br.edu.uepb.diarioeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uepb.diarioeletronico.domain.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
