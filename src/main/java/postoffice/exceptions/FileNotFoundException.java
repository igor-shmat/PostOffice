package postoffice.exceptions;

public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(String massage) {
        super(massage);
    }
}
