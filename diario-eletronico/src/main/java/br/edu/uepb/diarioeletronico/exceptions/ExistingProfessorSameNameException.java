package br.edu.uepb.diarioeletronico.exceptions;

public class ExistingProfessorSameNameException extends Exception {
    public ExistingProfessorSameNameException(String message) {
        super(message);
    }
}
