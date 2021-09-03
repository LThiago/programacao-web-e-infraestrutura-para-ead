package br.edu.uepb.diarioeletronico.exceptions;

public class ExistingTurmaSameNameException extends Exception {
    public ExistingTurmaSameNameException(String message) {
        super(message);
    }
}
