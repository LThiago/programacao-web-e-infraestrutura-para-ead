package br.edu.uepb.diarioeletronico.exceptions;

public class ExistingAlunoSameNameException extends Exception {
    public ExistingAlunoSameNameException(String message) {
        super(message);
    }
}
