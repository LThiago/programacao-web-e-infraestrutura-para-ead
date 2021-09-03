package br.edu.uepb.diarioeletronico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.uepb.diarioeletronico.domain.Turma;
import br.edu.uepb.diarioeletronico.exceptions.ExistingTurmaSameNameException;
import br.edu.uepb.diarioeletronico.repository.TurmaRepository;
import javassist.NotFoundException;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma createTurma(Turma turma) throws ExistingTurmaSameNameException {
        if (turmaRepository.findByNome(turma.getNome()).isPresent())
            throw new ExistingTurmaSameNameException("Já existe um turma com esse nome!");
        return turmaRepository.save(turma);
    }

    public Turma updateTurma(Long id, Turma turma) {
        turma.setId(id);
        return turmaRepository.save(turma);
    }

    public List<Turma> listAllTurmas() {
        return turmaRepository.findAll();
    }

    public Turma findById(Long id) throws NotFoundException {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não existe um turma com esse identificador!"));
    }

    public void deleteTurma(Long id) {
        Turma turmaToDelete = turmaRepository.findById(id).get();
        turmaRepository.delete(turmaToDelete);
    }
}
