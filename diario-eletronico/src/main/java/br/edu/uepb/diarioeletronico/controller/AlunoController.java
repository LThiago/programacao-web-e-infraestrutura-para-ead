package br.edu.uepb.diarioeletronico.controller;

import br.edu.uepb.diarioeletronico.domain.Aluno;
import br.edu.uepb.diarioeletronico.dto.AlunoDTO;
import br.edu.uepb.diarioeletronico.dto.GenericResponseErrorDTO;
import br.edu.uepb.diarioeletronico.exceptions.ExistingAlunoSameNameException;
import br.edu.uepb.diarioeletronico.mapper.AlunoMapper;
import br.edu.uepb.diarioeletronico.services.AlunoService;
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
@RequestMapping(value = "/alunos", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=UTF-8")
@Api(value = "Aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoMapper alunoMapper;

    @PostMapping
    @ApiOperation(value = "Cria um novo aluno")
    public ResponseEntity<?> createAluno(@RequestBody AlunoDTO alunoDTO) {
        try {
            Aluno aluno = alunoMapper.convertFromAlunoDTO(alunoDTO);
            return new ResponseEntity<>(alunoService.createAluno(aluno), HttpStatus.CREATED);
        } catch (ExistingAlunoSameNameException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
    }

    @GetMapping
    @ApiOperation(value = "Busca uma lista de todos os alunos")
    public List<AlunoDTO> getAlunos() {
        List<Aluno> alunos = alunoService.listAllAlunos();
        return alunos.stream().map(alunoMapper::convertToAlunoDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca um aluno pelo seu identificador")
    public ResponseEntity<?> getAlunoById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(alunoMapper.convertToAlunoDTO(alunoService.findById(id)), HttpStatus.OK);
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body(new GenericResponseErrorDTO(e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Atualiza um aluno a partir do seu identificador")
    public AlunoDTO updateAluno(@PathVariable("id") Long id, @RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = alunoMapper.convertFromAlunoDTO(alunoDTO);
        return alunoMapper.convertToAlunoDTO(alunoService.updateAluno(id, aluno));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Exclui um aluno a partir do seu identificador")
    public void deleteAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
    }
}
