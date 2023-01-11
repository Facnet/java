package Task_one.CustomExceptions;

public class FileNameEmptyException extends Exception{
    public FileNameEmptyException(String message) {
        super(message);
    }
}
