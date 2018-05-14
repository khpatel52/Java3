public class QueueUnderflowException extends QueueException
{
    public QueueUnderflowException()
    {
         super("Stack Underflow");
    }

    public QueueUnderflowException(String msg)
    {
        super(msg);
    }
}
