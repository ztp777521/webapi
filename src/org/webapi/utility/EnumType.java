package org.webapi.utility;

/**
 * 枚举类型
 * 
 * @author liujx
 * 
 */

public class EnumType {
	
	/**
	 * hibernate 查询条件
	 */
	public enum Type {
		LT, // <
		LE, // <=
		GT, // >
		GE, // >=
		EQ, // =
		LK, // like
		IN	// in
	}

	
}