package br.edu.uepb.diarioeletronico.controller;

import br.edu.uepb.diarioeletronico.domain.Turma;
import br.edu.uepb.diarioeletronico.repository.TurmaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/turmas")
@Api(value = "Turma")
public class TurmaController {

    @Autowired
    private TurmaRepository turmaRepository;

    @PostMapping
    @ApiOperation(value = "Cria uma nova turma")
    public Turma createTurma(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @GetMapping
    @ApiOperation(value = "Busca uma lista de todas as turmas")
    public List<Turma> getTurmas() {
        return turmaRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca uma turma pelo seu identificador")
    public Optional<Turma> getTurmaById(@PathVariable Long id) {
        return turmaRepository.findById(id);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza uma turma a partir do seu identificador")
    public Turma updateTurma(@PathVariable("id") Long id, @RequestBody Turma turma) {
        return turmaRepository.save(turma);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui uma turma a partir do seu identificador")
    public void deleteTurma(@PathVariable Long id) {
        turmaRepository.delete(turmaRepository.findById(id).get());
    }
}
