package cn.learning.design.pattern.singleton;

/**
 * Created by wsj-hit on 2019/11/23
 */
public class Singleton01 {
	/*
		单例的设计模式
		普通单例--饿汉式 开始时创建对象
	 */
	private static Singleton01 singleton01 = new Singleton01();
	private Singleton01(){}
	public static Singleton01 getInstance(){
		return singleton01;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println(Singleton01.getInstance().hashCode());
		}
	}
}
