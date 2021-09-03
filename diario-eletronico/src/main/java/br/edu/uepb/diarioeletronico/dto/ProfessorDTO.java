package br.edu.uepb.diarioeletronico.dto;

import lombok.Data;

@Data
public class ProfessorDTO {
    private Long id;
    private String matricula;
    private String nome;
    private String email;
    private String formacao;
}
