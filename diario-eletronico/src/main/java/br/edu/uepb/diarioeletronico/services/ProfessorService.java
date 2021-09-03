package br.edu.uepb.diarioeletronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.uepb.diarioeletronico.domain.Professor;
import br.edu.uepb.diarioeletronico.exceptions.ExistingProfessorSameNameException;
import br.edu.uepb.diarioeletronico.repository.ProfessorRepository;
import javassist.NotFoundException;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public Professor createProfessor(Professor professor) throws ExistingProfessorSameNameException {
        if (professorRepository.findByNome(professor.getNome()).isPresent())
            throw new ExistingProfessorSameNameException("Já existe um professor com esse nome!");
        return professorRepository.save(professor);
    }

    public Professor updateProfessor(Long id, Professor professor) {
        professor.setId(id);
        return professorRepository.save(professor);
    }

    public List<Professor> listAllProfessores() {
        return professorRepository.findAll();
    }

    public Professor findById(Long id) throws NotFoundException {
        return professorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não existe um professor com esse identificador!"));
    }

    public void deleteProfessor(Long id) {
        Professor professorToDelete = professorRepository.findById(id).get();
        professorRepository.delete(professorToDelete);
    }
}
