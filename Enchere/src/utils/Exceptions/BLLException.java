package utils.Exceptions;

public class BLLException extends Exception
{

	private static final long serialVersionUID = -4236641206410577433L;

	public BLLException()
    {
    }

    public BLLException(String message)
    {
        super(message);
    }

    public BLLException(String message, Throwable cause)
    {
        super(message, cause);
    }

    @Override
    public String getMessage()
    {
        return super.getMessage();
    }
}
