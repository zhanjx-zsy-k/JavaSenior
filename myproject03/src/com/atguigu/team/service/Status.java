package com.atguigu.team.service;

/**
 * @author k Email:907140412@qq.com
 * @Description 表示员工状态
 * @date 2021年4月12日上午1:23:17
 */
//public class Status {
//	private final String NAME;
//
//	private Status(String name) {
//		this.NAME = name;
//	}
//
//	public static final Status FREE = new Status("FREE");
//	public static final Status BUSY = new Status("BUSY");
//	public static final Status VOCATION = new Status("VOCATION");
//
//	public String getNAME() {
//		return NAME;
//	}
//
//	@Override
//	public String toString() {
//		return NAME;
//	}
//}
public enum Status {
    FREE, BUSY, VOCATION;


}