package org.seckill.exception;

import org.seckill.dto.SeckillExecution;

/**
 * 重复秒杀异常(runtime error)
 */
public class RepeatKillException extends SeckillException
{
    public RepeatKillException(String message)
    {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
