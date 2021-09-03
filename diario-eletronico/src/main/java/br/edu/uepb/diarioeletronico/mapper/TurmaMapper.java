package br.edu.uepb.diarioeletronico.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.uepb.diarioeletronico.domain.Turma;
import br.edu.uepb.diarioeletronico.dto.TurmaDTO;

public class TurmaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public TurmaDTO convertToTurmaDTO(Turma turma) {
        TurmaDTO turmaDTO = modelMapper.map(turma, TurmaDTO.class);

        return turmaDTO;
    }

    public Turma convertFromTurmaDTO(TurmaDTO turmaDTO) {
        Turma turma = modelMapper.map(turmaDTO, Turma.class);

        return turma;
    }
}
