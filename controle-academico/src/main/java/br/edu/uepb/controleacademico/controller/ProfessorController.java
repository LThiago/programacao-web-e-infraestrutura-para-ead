package br.edu.uepb.controleacademico.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.uepb.controleacademico.domain.Professor;
import br.edu.uepb.controleacademico.repository.ProfessorRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/professores")
@Api(value = "Professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    @ApiOperation(value = "Busca uma lista de todos os professores")
    public List<Professor> getProfessores() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca um professor pelo seu identificador")
    public Optional<Professor> getProfessorById(@PathVariable Long id) {
        return professorRepository.findById(id);
    }

    @PostMapping
    @ApiOperation(value = "Cria um novo professor")
    public Professor createProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um professor a partir do seu identificador")
    public Professor updateProfessor(@PathVariable("id") Long id, @RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui um professor a partir do seu identificador")
    public void deleteProfessor(@PathVariable Long id) {
        professorRepository.delete(professorRepository.findById(id).get());
    }
}
