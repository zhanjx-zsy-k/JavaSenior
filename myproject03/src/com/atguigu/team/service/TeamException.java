package com.atguigu.team.service;

/**
 * 
 * @Description 自定义异常类
 * @author k Email:907140412@qq.com
 * @version
 * @date 2021年4月12日上午2:14:58
 *
 */
public class TeamException extends Exception {
	static final long serialVersionUID = -3387519222319948L;

	public TeamException() {

	}

	public TeamException(String msg) {
		super(msg);
	}
}
