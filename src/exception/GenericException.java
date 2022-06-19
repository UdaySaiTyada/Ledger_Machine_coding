package exception;

public class GenericException extends Exception
{
    String message;

    public GenericException(String message)
    {
        System.out.println(message);
        this.message = message;
    }
}
