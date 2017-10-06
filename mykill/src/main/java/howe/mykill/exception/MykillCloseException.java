package howe.mykill.exception;

/**
 * 秒杀关闭异常，当秒杀结束时用户还要进行秒杀就会出现这个异常
 */
public class MykillCloseException extends MykillException{
    public MykillCloseException(String message) {
        super(message);
    }

    public MykillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
