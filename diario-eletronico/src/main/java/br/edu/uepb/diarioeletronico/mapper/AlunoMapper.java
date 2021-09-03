package br.edu.uepb.diarioeletronico.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.uepb.diarioeletronico.domain.Aluno;
import br.edu.uepb.diarioeletronico.dto.AlunoDTO;

public class AlunoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public AlunoDTO convertToAlunoDTO(Aluno aluno) {
        AlunoDTO alunoDTO = modelMapper.map(aluno, AlunoDTO.class);

        return alunoDTO;
    }

    public Aluno convertFromAlunoDTO(AlunoDTO alunoDTO) {
        Aluno aluno = modelMapper.map(alunoDTO, Aluno.class);

        return aluno;
    }

}