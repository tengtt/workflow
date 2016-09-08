package org.seckill.exception;

/**
 * Created by teng on 2016/5/18.
 */
public class SeckCloseException extends SeckillException {
    public SeckCloseException(String message) {
        super(message);
    }

    public SeckCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
