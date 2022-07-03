package com.mky.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UtilAopDeclarations {
	
	
	/*
	 * 
	 * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)
          throws-pattern?)
          
      */
	
	@Pointcut("execution(* com.mky.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {};
	
	//Create a pointcut for getter methods
	@Pointcut("execution(* com.mky.aopdemo.dao.*.get*(..))")
	public void getter() {};
	
	//Create a pointcut for setter methods
	@Pointcut("execution(* com.mky.aopdemo.dao.*.set*(..))")
	public void setter() {};

	//create a pointcut include package exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {};
}
