package br.edu.uepb.diarioeletronico.controller;

import br.edu.uepb.diarioeletronico.domain.Turma;
import br.edu.uepb.diarioeletronico.dto.TurmaDTO;
import br.edu.uepb.diarioeletronico.dto.GenericResponseErrorDTO;
import br.edu.uepb.diarioeletronico.exceptions.ExistingTurmaSameNameException;
import br.edu.uepb.diarioeletronico.mapper.TurmaMapper;
import br.edu.uepb.diarioeletronico.services.TurmaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/turmas", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
@Api(value = "Turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @Autowired
    private TurmaMapper turmaMapper;

    @PostMapping
    @ApiOperation(value = "Cria uma nova turma")
    public ResponseEntity<?> createTurma(@RequestBody TurmaDTO turmaDTO) {
        try {
            Turma turma = turmaMapper.convertFromTurmaDTO(turmaDTO);
            return new ResponseEntity<>(turmaService.createTurma(turma), HttpStatus.CREATED);
        } catch (ExistingTurmaSameNameException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
    }

    @GetMapping
    @ApiOperation(value = "Busca uma lista de todas as turmas")
    public List<TurmaDTO> getTurmas() {
        List<Turma> turmas = turmaService.listAllTurmas();
        return turmas.stream().map(turmaMapper::convertToTurmaDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca uma turma pelo seu identificador")
    public ResponseEntity<?> getTurmaById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(turmaMapper.convertToTurmaDTO(turmaService.findById(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza uma turma a partir do seu identificador")
    public TurmaDTO updateTurma(@PathVariable("id") Long id, @RequestBody TurmaDTO turmaDTO) {
        Turma turma = turmaMapper.convertFromTurmaDTO(turmaDTO);
        return turmaMapper.convertToTurmaDTO(turmaService.updateTurma(id, turma));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui uma turma a partir do seu identificador")
    public void deleteTurma(@PathVariable Long id) {
        turmaService.deleteTurma(id);
    }
}
