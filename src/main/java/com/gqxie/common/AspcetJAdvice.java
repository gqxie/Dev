package com.gqxie.common;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 测试after,before,around,throwing,returning Advice.
 *
 * @author Admin
 */
@Aspect
public class AspcetJAdvice
{
    Logger logger = Logger.getLogger(AspcetJAdvice.class);

    /**
     * Pointcut
     * 定义Pointcut，Pointcut的名称为aspectjMethod()，此方法没有返回值和参数
     * 该方法就是一个标识，不进行调用
     */
    @Pointcut("execution(* find*(..))")
    private void aspectjMethod()
    {
    }

    ;

    /**
     * Before
     * 在核心业务执行前执行，不能阻止核心业务的调用。
     *
     * @param joinPoint
     */
    @Before("aspectjMethod()")
    public void beforeAdvice(JoinPoint joinPoint)
    {
        logger.info("-----beforeAdvice().invoke-----");
        logger.info(" 此处意在执行核心业务逻辑前，做一些安全性的判断等等");
        logger.info(" 可通过joinPoint来获取所需要的内容");
        logger.info("-----End of beforeAdvice()------");
    }

    /**
     * After
     * 核心业务逻辑退出后（包括正常执行结束和异常退出），执行此Advice
     *
     * @param joinPoint
     */
    @After(value = "aspectjMethod()")
    public void afterAdvice(JoinPoint joinPoint)
    {
        logger.info("-----afterAdvice().invoke-----");
        logger.info(" 此处意在执行核心业务逻辑之后，做一些日志记录操作等等");
        logger.info(" 可通过joinPoint来获取所需要的内容");
        logger.info("-----End of afterAdvice()------");
    }

    /**
     * Around
     * 手动控制调用核心业务逻辑，以及调用前和调用后的处理,
     * <p>
     * 注意：当核心业务抛异常后，立即退出，转向AfterAdvice
     * 执行完AfterAdvice，再转到ThrowingAdvice
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around(value = "aspectjMethod()")
    public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable
    {
        logger.info("-----aroundAdvice().invoke-----");
        logger.info(" 此处可以做类似于Before Advice的事情");

        //调用核心逻辑
        Object retVal = pjp.proceed();
        logger.info(" 此处可以做类似于After Advice的事情");
        logger.info("-----End of aroundAdvice()------");
        return retVal;
    }

    /**
     * AfterReturning
     * 核心业务逻辑调用正常退出后，不管是否有返回值，正常退出后，均执行此Advice
     *
     * @param joinPoint
     */
    @AfterReturning(value = "aspectjMethod()", returning = "retVal")
    public void afterReturningAdvice(JoinPoint joinPoint, String retVal)
    {
        logger.info("-----afterReturningAdvice().invoke-----");
        logger.info("Return Value: " + retVal);
        logger.info(" 此处可以对返回值做进一步处理");
        logger.info(" 可通过joinPoint来获取所需要的内容");
        logger.info("-----End of afterReturningAdvice()------");
    }

    /**
     * 核心业务逻辑调用异常退出后，执行此Advice，处理错误信息
     * <p>
     * 注意：执行顺序在Around Advice之后
     *
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "aspectjMethod()", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex)
    {
        logger.info("-----afterThrowingAdvice().invoke-----");
        logger.info(" 错误信息：" + ex.getMessage());
        logger.info(" 此处意在执行核心业务逻辑出错时，捕获异常，并可做一些日志记录操作等等");
        logger.info(" 可通过joinPoint来获取所需要的内容");
        logger.info("-----End of afterThrowingAdvice()------");
    }
}
