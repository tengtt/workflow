package org.seckill.exception;

/**
 * 运行期异常，spring声明式事物只接收运行期异常回滚策略
 *
 * Created by teng on 2016/5/18.
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
