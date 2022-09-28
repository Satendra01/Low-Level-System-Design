package com.DesignPatterns.Singleton;
class Singleton{
	private static volatile Singleton instance;
	String value;
	private  Singleton(String value) {
		super();
		this.value = value;
	}
	public static Singleton  getInstance(String value)
	{
		Singleton result=instance;
		if(result!=null)
			return result;
		synchronized(Singleton.class) {
			if(instance==null)
			{
				instance=new Singleton(value);
			}
			return instance;
		}
	}
	
}
public class Test {
	public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Singleton singleton = null;
			try {
				singleton = Singleton.getInstance("FOO");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}
