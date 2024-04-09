package simonemanca.u5springweb.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(int id) {
        super("Elemento con id " + id + " non trovato!");
    }
}

