package cn.learning.design.pattern.singleton;

import sun.java2d.pipe.ValidatePipe;

import javax.naming.NameNotFoundException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by wsj-hit on 2019/11/23
 */
public class Singleton02 {
	/*
		单例的设计模式
		普通单例--懒汉
	 */
	//volatile在指令重排的时候起作用
	private static volatile Singleton02 singleton02;
	
	private Singleton02() {
	}
	
	/**
	 * 有线程安全问题
	 * @return
	 */
	public static Singleton02 getInstance_bak() {
		if (singleton02 == null) {
			try {
				Thread.sleep(1L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			singleton02 = new Singleton02();
		}
		return singleton02;
	}
	public static Singleton02 getInstance() {
		if (singleton02 == null) {
			synchronized (""){
				if (singleton02 == null) {
					try {
						Thread.sleep(1L);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					singleton02 = new Singleton02();
				}
			}
		}
		return singleton02;
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(() -> System.out.println(Singleton02.getInstance().hashCode())).start();
		}
	}
}
