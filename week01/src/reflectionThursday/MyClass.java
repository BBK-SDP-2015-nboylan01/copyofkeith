package reflectionThursday;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MyClass {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Pretty: ");
			String cl = sc.next();
			try {
				Class<?> c = Class.forName(cl);
				// Object obj = c.newInstance(); // just uses the default
				// constructor to create an instance of the class
				Constructor<?> cons = null;
				try {
					cons = c.getConstructor(new Class[] { String.class, String.class });
					// get the constructor that takes two strings as it's formal
					// parameters
				} catch (NoSuchMethodException | SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Object obj = null;
				try {
					obj = cons.newInstance(new Object[] { "John Pretty Boy", "abc123" });
					// create the instance
				} catch (IllegalArgumentException | InvocationTargetException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(obj);
				// System.out.println(c);
				// Method[] m = c.getDeclaredMethods();
				// for (Method meth : m)
				// System.out.println(meth);
				// get setName method
				Method m = null;
				try {
					m = c.getMethod("setName", new Class[] { String.class });
					// get the method for setName
				} catch (NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					m.invoke(obj, new Object[] { "James Even Prettier Boy" });
					// change the name
				} catch (IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(obj);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				System.err.println("oh no, it has all gone wrong [" + e + "]");
				// e.printStackTrace();
			}
		}
	}
}