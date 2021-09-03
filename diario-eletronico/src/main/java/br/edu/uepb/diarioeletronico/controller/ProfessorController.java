package br.edu.uepb.diarioeletronico.controller;

import br.edu.uepb.diarioeletronico.domain.Professor;
import br.edu.uepb.diarioeletronico.dto.ProfessorDTO;
import br.edu.uepb.diarioeletronico.dto.GenericResponseErrorDTO;
import br.edu.uepb.diarioeletronico.exceptions.ExistingProfessorSameNameException;
import br.edu.uepb.diarioeletronico.mapper.ProfessorMapper;
import br.edu.uepb.diarioeletronico.services.ProfessorService;
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
@RequestMapping(value = "/professores", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
@Api(value = "Professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private ProfessorMapper professorMapper;

    @PostMapping
    @ApiOperation(value = "Cria um novo professor")
    public ResponseEntity<?> createProfessor(@RequestBody ProfessorDTO professorDTO) {
        try {
            Professor professor = professorMapper.convertFromProfessorDTO(professorDTO);
            return new ResponseEntity<>(professorService.createProfessor(professor), HttpStatus.CREATED);
        } catch (ExistingProfessorSameNameException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
    }

    @GetMapping
    @ApiOperation(value = "Busca uma lista de todos os professores")
    public List<ProfessorDTO> getProfessors() {
        List<Professor> professores = professorService.listAllProfessores();
        return professores.stream().map(professorMapper::convertToProfessorDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca um professor pelo seu identificador")
    public ResponseEntity<?> getProfessorById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(professorMapper.convertToProfessorDTO(professorService.findById(id)),
                    HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um professor a partir do seu identificador")
    public ProfessorDTO updateProfessor(@PathVariable("id") Long id, @RequestBody ProfessorDTO professorDTO) {
        Professor professor = professorMapper.convertFromProfessorDTO(professorDTO);
        return professorMapper.convertToProfessorDTO(professorService.updateProfessor(id, professor));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui um professor a partir do seu identificador")
    public void deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
    }
}
