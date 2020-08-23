package id.akademi.amanifo.exceptions;

public class AuthorizationException extends RuntimeException
{
    private static final long serialVersionUID = 5029009692642503411L;

    public AuthorizationException(String message)
    {
        super(message);
    }
}
