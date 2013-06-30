package org.webapi.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 计算积分的切面
 * 
 * @author liujx
 * 
 */
@Aspect
public class ScoreAop {

	/**
	 * 切入点 返回值必须void
	 */
	@Pointcut("execution (* thinker.webapi.service.*.save(..))")
	public void pointcut() {
	}

	@AfterReturning(pointcut = "pointcut()", argNames = "info", returning = "info")
	public void after(JoinPoint infos, String info) {
//		System.out.println("after invocation.");
//		System.out.println("returnVal : " + info);
//		System.out.println("ArgName : " + infos.getArgs()[0]);
//		System.out.println("ArgName : " + infos.getArgs()[1]);
	}

}
