package Task_one.CustomExceptions;

public class FileEmptyException extends Exception{
    public FileEmptyException(String message) {
        super(message);
    }
}
