package br.edu.uepb.diarioeletronico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.uepb.diarioeletronico.domain.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

}
