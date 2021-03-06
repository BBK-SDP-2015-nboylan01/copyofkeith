package reflection;

//import java.lang.reflect.Method;
import java.util.Scanner;

public class MyClass {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			System.out.print("Pretty: ");
			String cl = sc.next();
			try {
				Class<?> c = Class.forName(cl);
				Object obj = c.newInstance();
				System.out.println(obj);
//				System.out.println(c);
//				Method[] m = c.getDeclaredMethods();
//				for (Method meth : m)
//					System.out.println(meth);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				System.err.println("oh no, it has all gone wrong [" + e + "]");
				// e.printStackTrace();
			}
		}
	}
}