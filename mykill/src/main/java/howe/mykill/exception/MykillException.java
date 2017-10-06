package howe.mykill.exception;

/**
 * 秒杀相关的所有业务异常
 */
public class MykillException extends RuntimeException {
    public MykillException(String message) {
        super(message);
    }

    public MykillException(String message, Throwable cause) {
        super(message, cause);
    }
}
